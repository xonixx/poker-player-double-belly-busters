package org.leanpoker.player;

import com.doublebellybuster.Util;
import com.doublebellybuster.model.GameState;
import com.doublebellybuster.strategy.IStrategy;
import com.doublebellybuster.strategy.PushAllInStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class PlayerServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(PlayerServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Java player is running");
    }

    private static IStrategy strategy= new PushAllInStrategy();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String gameState = req.getParameter("game_state");
        String reply;
        if ("check".equals(action)) {
            logger.info("Received check request");
            reply = "OK";
        } else if ("bet_request".equals(action)) {
            reply = Integer.toString(strategy.betRequest(Util.parse(gameState, GameState.class)));
        } else if ("showdown".equals(action)) {
            reply = "OK";
        } else if ("version".equals(action)) {
            reply = "DoubleBellyBusters-0.0.1";
        } else {
            reply = "provide action";
        }

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println(reply);
        outputStream.flush();
    }
}
