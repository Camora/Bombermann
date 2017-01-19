package control;

//import bomberman.protocol.message.server.PlayerJoined;

public class PlayerJoinedHandler {

	public void playerJoined(String name) {
		System.out.println(name + " joined at " + "(x"/*InitialX Achse*/ + "/" + "y)"/*InitialY Achse*/);
	}
}
