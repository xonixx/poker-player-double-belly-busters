package com.doublebellybuster;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.*;
import sun.misc.JarFilter;

import java.io.File;
import java.io.IOException;

public class Launch {
    static String[] modules = {
    };

    public static void main(String[] args) throws Exception {
        String rootFolder = ".";

        Server server = new Server();

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);

        WebAppContext root = new WebAppContext(join(rootFolder, "src/main/webapp"), "/");
        root.setConfigurations(new Configuration[]{
                new WebInfConfiguration(),// default
                new WebXmlConfiguration(),// default
        });

        WebAppClassLoader rootClassLoader = new WebAppClassLoader(root);

        for (String moduleName : modules) {
            rootClassLoader.addClassPath(join(join(rootFolder, moduleName), "build/classes"));
        }

        addAllDependentJars(rootClassLoader, rootFolder);

        root.setClassLoader(rootClassLoader);

        HandlerList handlerList = new HandlerList();
        handlerList.addHandler(root);

        server.setHandler(handlerList);

        server.start();
    }

    private static void addAllDependentJars(WebAppClassLoader rootClassLoader, String rootFolder) throws IOException {
        final File libDir = new File(join(rootFolder, "build/libs"));

        final File[] jars = libDir.listFiles(new JarFilter());

        jar_loop:
        for (File jar : jars) {
            for (String moduleName : modules) {
                if (jar.getName().startsWith(moduleName)) {
                    // don't add this
                    continue jar_loop;
                }
            }

            System.out.println("Loading: " + jar.getName());
            rootClassLoader.addClassPath(jar.getAbsolutePath());
        }
    }

    private static String join(String rootFolder, final String child) {
        return new File(rootFolder, child).getAbsolutePath();
    }
}
