package ar.fiuba.tdd.tp.engine.motor.games;

import ar.fiuba.tdd.tp.engine.motor.*;
import ar.fiuba.tdd.tp.engine.motor.commands.*;
import ar.fiuba.tdd.tp.engine.motor.entities.*;

public class PickStick extends Game {

    private static String helpMessage = "You have to pick that stick over there.";
    private Stick stick;
    private Player player;

    public PickStick() {

        Stage room = new Stage("Room 1");

        this.player = new Player();
        this.player.setlocation(room);

        this.stick = new Stick(room, this.player.getInventory());

        room.addEntity(this.stick);

        this.commands.add(new LookAround(this.player));
        this.commands.add(new Pick(this.stick, room));
        includeWhatCanIdoWithCommand();
    }

    public static String getHelp() {
        return helpMessage;
    }

    @Override
    public boolean isGameOver() {
        return this.player.getInventory().containsEntity(this.stick);
    }

    @Override
    public String getGameOverMessage() {
        return "You won the game!";
    }
}