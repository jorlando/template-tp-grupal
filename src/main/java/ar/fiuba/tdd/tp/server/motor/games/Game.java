package ar.fiuba.tdd.tp.server.motor.games;


import ar.fiuba.tdd.tp.server.motor.commands.GameCommand;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected List<GameCommand> commands = new ArrayList<GameCommand>();

    abstract boolean isGameOver();

    abstract String getGameOverMessage();

    /* template method : */
    public String processInput(String input) {

        for (GameCommand command : commands) {
            if (input.equals(command.getIdentifier())) {
                String response = command.execute();
                if (isGameOver()) {
                    response = getGameOverMessage();
                }
                return response;
            }
        }
        return "Invalid command";
    }
}
