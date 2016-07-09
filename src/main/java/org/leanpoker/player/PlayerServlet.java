package org.leanpoker.player;

import com.doublebellybuster.Util;
import com.doublebellybuster.model.GameState;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class PlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Java player is running");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String gameState = req.getParameter("game_state");
        String reply;
        if ("check".equals(action)) {
            reply = "OK";
        } else if ("bet_request".equals(action)) {
            reply = Util.parse(gameState, GameState.class).toString(); // TODO
        } else if ("showdown".equals(action)) {
            reply = Util.parse(gameState, GameState.class).toString(); // TODO
        } else if ("version".equals(action)) {
            reply = "DoubleBellyBusters-0.0.1";
        } else {
            reply =  "provide action";
        }

        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println(reply);
        outputStream.flush();
    }
}
