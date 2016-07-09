package org.leanpoker.player;

import com.doublebellybuster.Constants;
import com.doublebellybuster.Util;
import com.doublebellybuster.model.GameState;
import com.doublebellybuster.strategy.IStrategy;
import com.doublebellybuster.strategy.PushAllInStrategy;
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
        logger.info("doGet MegaLog!!!!");
        resp.getWriter().print("Java player is running");
    }

    private static IStrategy strategy = new PushAllInStrategy();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String gameState = req.getParameter("game_state");
        String reply;
        System.out.println("Just log test!!!!");
        try {
            if ("check".equals(action)) {
                logger.info("Received check request");
                reply = "OK";
            } else if ("bet_request".equals(action)) {
                reply = Integer.toString(strategy.betRequest(Util.parse(gameState, GameState.class)));
            } else if ("showdown".equals(action)) {
                reply = "OK";
            } else if ("version".equals(action)) {
                reply = Constants.VERSION;
            } else {
                reply = "provide action";
            }

            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.println(reply);
            outputStream.flush();
        } catch (Exception e) {
            logger.error("Unexpected error [action=" + action + "]:", e);
        }
    }
}
