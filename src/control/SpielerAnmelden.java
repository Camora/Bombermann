package control;

//import bomberman.protocol.message.client.JoinGame;
import control.ServerProxy;

public class SpielerAnmelden {
	ServerProxy serverProxy;
	
	public SpielerAnmelden(ServerProxy serverProxy) {
		this.serverProxy = serverProxy;
	}
	
	public void spielerAnmelden(String name) {
		MessageDummy.message = name;
		serverProxy.send(name);
	}
}
