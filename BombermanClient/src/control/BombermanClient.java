package control;

import view.MainFrame;
import network.Message;
import network.client.ClientApplicationInterface;
import control.ServerProxy;
import control.ServerProxyStub;

public class BombermanClient implements ClientApplicationInterface {
	private ServerProxy serverProxy;
	private SpielerAnmelden spielerAnmeldenCtr;
        public static int FieldAmount = 5;//anzahl felder in höche und breite
        public static String[][] BombermanFeld = new String[FieldAmount][FieldAmount];

	
	public BombermanClient() {
		serverProxy = new ServerProxyStub(this);
		spielerAnmeldenCtr = new SpielerAnmelden(serverProxy);
	}

	@Override
	public void handleMessage(Message message) {
		System.out.println("Message: " + message);
	}
	
	public static void main(String[] args) {
                ClientApplication c = new ClientApplication();
                ServerProxyStub s = new ServerProxyStub(c);
                MainFrame gui = new MainFrame(s);
                
                BombermanFeldArray();
	}
        
        public static void BombermanFeldArray(){
            for(int i=0; i<FieldAmount;i++){
              for(int j=0; j<FieldAmount;j++){
                  BombermanFeld[i][j] = "O";
                }  
            }
        }
        
        public static void LogButtonClick(String name){
            BombermanClient application = new BombermanClient();
		// Die n�chste Zeile simuliert die Anmeldung des Benutzers
            application.spielerAnmeldenCtr.spielerAnmelden(name);
            
            Dispatcher d = new Dispatcher();
            d.dispatchMessage(name);
        }
}
