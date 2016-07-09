package com.doublebellybuster.model;

import java.util.List;

/**
 * Created by sviridenich on 7/9/16.
 */
public interface IPlayer {
    int getAbsoluteStack();

    List<Card> getHoleCards();
}
