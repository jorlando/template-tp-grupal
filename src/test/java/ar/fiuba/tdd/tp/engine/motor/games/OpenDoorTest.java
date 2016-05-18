package ar.fiuba.tdd.tp.engine.motor.games;

import ar.fiuba.tdd.tp.engine.motor.games.OpenDoor;
import ar.fiuba.tdd.tp.engine.motor.games.OpenDoor2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OpenDoorTest {

    @Test
    public void wonPickKeyAndOpenDoor() {

        OpenDoor game = new OpenDoor();

        game.processInput("pick key");

        assertEquals(game.processInput("open door"),"YOU WIN THE GAME");

    }

    @Test
    public void wonOpenBoxPickKeyAndOpenDoor() {

        OpenDoor game = new OpenDoor2();

        game.processInput("open box");
        game.processInput("pick key");

        assertEquals(game.processInput("open door"),"YOU WIN THE GAME");

    }

}