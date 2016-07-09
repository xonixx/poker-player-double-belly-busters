package strategy;

/**
 * Created by sviridenich on 7/9/16.
 */
public class PushAllInStrategy implements IStrategy {
    @Override
    public int betRequest(IGameState gameState) {

        return gameState.getMyPlayer().getAbsoluteStack();
    }
}
