package com.doublebellybuster.controllers;


import com.doublebellybuster.DoubleBellyBusterProps;
import com.doublebellybuster.Util;
import com.doublebellybuster.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PokerController {

    private DoubleBellyBusterProps doubleBellyBusters;

    @Autowired
    public PokerController(DoubleBellyBusterProps doubleBellyBusters) {
        this.doubleBellyBusters = doubleBellyBusters;
    }

    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    String home() {
        return "<h2>Double Belly Busters!</h2>" +
                "Bot: <a href='/bot'>/bot</a>";
    }

    @RequestMapping("/bot")
    @ResponseBody
    public String botLogic(
            @RequestParam(value = "action", required = false) String action,
            @RequestParam(value = "game_state", required = false) String gameState) {

        if ("check".equals(action)) {
            return "OK";
        } else if ("bet_request".equals(action)) {
            return Util.parse(gameState, GameState.class).toString(); // TODO
        } else if ("showdown".equals(action)) {
            return Util.parse(gameState, GameState.class).toString(); // TODO
        } else if ("version".equals(action)) {
            return doubleBellyBusters.getVersion();
        }

        return "provide action";
    }
}
