package strategy;

import junit.framework.TestCase;
import org.mockito.Mockito;

/**
 * Created by sviridenich on 7/8/16.
 */
public class CheckFoldStrategyTest extends TestCase {

    public void testBetRequest() throws Exception {
        IStrategy strategy = new CheckFoldStrategy();
        IGameState mockedGameState = Mockito.mock(IGameState.class);
        int betAmount = strategy.betRequest(mockedGameState);
        assertEquals(betAmount, 0);
    }
}