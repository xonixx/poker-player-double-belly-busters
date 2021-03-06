package org.leanpoker.player;

import com.doublebellybuster.Constants;
import com.doublebellybuster.Util;
import com.doublebellybuster.model.GameState;
import com.doublebellybuster.strategy.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class PlayerServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PlayerServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Java player is running");
    }

    private static IStrategy strategy = new AdvancedShortStackStrategy();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String gameState = req.getParameter("game_state");
        String reply;
        GameState gameStateObj = "".equals(gameState) || gameState == null ? null : Util.parse(gameState, GameState.class);
        System.out.println("REQ action="+action+", GS=" + gameStateObj);
        resp.setContentType("text/plain");
        try {
            if ("check".equals(action)) {
                logger.info("Received check request");
                reply = "OK";
            } else if ("bet_request".equals(action)) {
                reply = Integer.toString(strategy.betRequest(gameStateObj));
            } else if ("showdown".equals(action)) {
                reply = "OK";
            } else if ("version".equals(action)) {
                reply = Constants.VERSION;
            } else {
                reply = "provide action";
            }

            ServletOutputStream outputStream = resp.getOutputStream();
            System.out.println("REPLY: action=" + action + ", res=" + reply);
            outputStream.print(reply);
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            logger.error("Unexpected error [action=" + action + "]:", e);
        }
    }
}
