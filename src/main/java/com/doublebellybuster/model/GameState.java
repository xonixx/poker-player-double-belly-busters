package com.doublebellybuster.model;

import java.util.List;
import java.util.Objects;

public class GameState implements IGameState {
    private String tournament_id;
    private String game_id;
    private int round;
    private int bet_index;
    private int small_blind;
    private int current_buy_in;
    private int pot;
    private int minimum_raise;
    private int dealer;
    private int orbits;
    private int in_action;

    private List<Player> players;
    private List<Card> community_cards;

    private static String OUR_NAME = "Double Belly Busters";

    public String getTournament_id() {
        return tournament_id;
    }

    public String getGame_id() {
        return game_id;
    }

    public int getRound() {
        return round;
    }

    public int getBet_index() {
        return bet_index;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getSmall_blind() {
        return small_blind;
    }

    public int getCurrent_buy_in() {
        return current_buy_in;
    }

    public int getPot() {
        return pot;
    }

    public int getMinimum_raise() {
        return minimum_raise;
    }

    public int getDealer() {
        return dealer;
    }

    public int getOrbits() {
        return orbits;
    }

    public int getIn_action() {
        return in_action;
    }

    public List<Card> getCommunity_cards() {
        return community_cards;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "tournament_id='" + tournament_id + '\'' +
                ", game_id='" + game_id + '\'' +
                ", round=" + round +
                ", bet_index=" + bet_index +
                ", small_blind=" + small_blind +
                ", current_buy_in=" + current_buy_in +
                ", pot=" + pot +
                ", minimum_raise=" + minimum_raise +
                ", dealer=" + dealer +
                ", orbits=" + orbits +
                ", in_action=" + in_action +
                ", players=" + players +
                ", community_cards=" + community_cards +
                '}';
    }

    @Override
    public int getLastBet() {
        return 0;
    }

    @Override
    public IPlayer getMyPlayer() {
        for(int i = 0; i < this.players.size(); i++) {
            Player p = this.players.get(i);
            if (Objects.equals(p.getName(), OUR_NAME)){
                return p;
            }
        }
        return null;
    }
}