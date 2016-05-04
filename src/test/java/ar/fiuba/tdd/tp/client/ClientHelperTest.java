package ar.fiuba.tdd.tp.client;

import ar.fiuba.tdd.tp.client.config.GameStates;
import ar.fiuba.tdd.tp.client.network.ClientNetworkFacade;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jorlando on 04/05/16.
 */

public class ClientHelperTest {

    @Test
    public void testClientHelperConstructor() {
        ClientHelper client = new ClientHelper();
        assertEquals(client.getGameState(), GameStates.WAITING);
        assertEquals(client.getNetwork(), null);
    }

    @Test
    public void testIsConnectedInitial() {
        ClientHelper client = new ClientHelper();
        assertEquals(client.isConnected(), false);
    }

    @Test
    public void testSetGameState() {
        ClientHelper client = new ClientHelper();
        client.setGameState(GameStates.ENDED);
        assertEquals(client.getGameState(), GameStates.ENDED);
    }

    @Test
    public void testSetNetwork() {
        ClientNetworkFacade clientNetworkFacade = new ClientNetworkFacade();
        ClientHelper client = new ClientHelper();
        client.setNetwork(clientNetworkFacade);
        assertEquals(client.getNetwork(), clientNetworkFacade);
        assertEquals(client.getGameState(), GameStates.RUNNING);
    }
}
