package org.StrategyGame;

/**
 * Represents any modification or action that should happen. The data necessary for proper execution should be passed in
 * to the constructor when the org.StrategyGame.Command is created.
 * Note that it only will make those changes on a call to {@code execute()}, NOT when the org.StrategyGame.Command is instantiated.
 */
public interface Command {

    /**
     * Performs the action that the org.StrategyGame.Command represents.
     */
    public void execute();

    /**
     * Undoes the action performed in the call to {@code execute()}. Specifically, for each modification that
     * {@code execute()} does, there should be a corresponding piece of code in {@code undo()} that does the opposite.
     * This should only be called after {@code execute()} has already been called.
     */
    public void undo();
}
