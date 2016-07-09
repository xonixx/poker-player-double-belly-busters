package com.doublebellybuster.model;

import com.doublebellybuster.Constants;

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
        int bet = 0;
        if (players != null && players.size() > 0) {
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                if (Constants.NAME.equals(player.getName())) {
                    return bet;
                } else if (player.getBet() >= 0) {
                    bet = player.getBet();
                }
            }
        }
        return bet;
    }

    @Override
    public IPlayer getMyPlayer() {
        for(int i = 0; i < this.players.size(); i++) {
            Player p = this.players.get(i);
            if (Objects.equals(p.getName(), Constants.NAME)){
                return p;
            }
        }
        return null;
    }

    @Override
    public int getAffectiveStack() {
        int abs_stack = this.getMyPlayer().getAbsoluteStack();
        int bb = 2 * this.small_blind;
        return  abs_stack / bb + 1;
    }

    @Override
    public Position getPosition() {
        int selfPosition = this.in_action;

        if (selfPosition >= 0 && selfPosition < 2)
            return Position.BLIND;
        else if (selfPosition >= 2 && selfPosition < 4)
            return Position.EARLY;
        else if (selfPosition >= 4 && selfPosition < 6)
            return Position.MIDDLE;
        else
            return Position.LATE;
    }
}
