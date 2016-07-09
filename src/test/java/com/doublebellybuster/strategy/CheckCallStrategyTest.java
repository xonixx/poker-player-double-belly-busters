package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;
import junit.framework.TestCase;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Created by sviridenich on 7/8/16.
 */
public class CheckCallStrategyTest extends TestCase {

    public void testCallBetRequest() throws Exception {
        IStrategy strategy = new CheckCallStrategy();
        IGameState gameState = Mockito.mock(IGameState.class);
        when(gameState.getLastBet()).thenReturn(10);
        int betAmount = strategy.betRequest(gameState);
        assertEquals(betAmount, 10);
    }

    public void testCheckBetRequest() throws Exception {
        IStrategy strategy = new CheckCallStrategy();
        IGameState gameState = Mockito.mock(IGameState.class);
        when(gameState.getLastBet()).thenReturn(0);
        int betAmount = strategy.betRequest(gameState);
        assertEquals(betAmount, 0);
    }
}