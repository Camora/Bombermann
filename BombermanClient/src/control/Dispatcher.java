package control;

//import bomberman.protocol.message.server.PlayerJoined;
import network.Message;

public class Dispatcher  {

	public void dispatchMessage(String message) {
			PlayerJoinedHandler handler = new PlayerJoinedHandler();
			handler.playerJoined(message);
	}

}
