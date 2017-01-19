package control;

import network.Message;
import network.client.ClientApplicationInterface;
/**
 * Die Klasse ServerProxyStub ist von ServerProxy abgeleitet und dient dazu den Client
 * isoliert von der Netzwerkschicht testen zu k�nnen. Hierzu muss der Client ein Objekt
 * von dieser Klasse erzeugen. Er kann dann die send-Methode aufrufen. Damit kann das 
 * Senden einer Meldung an den Server simuliert werden. Die Meldung wird lediglich auf
 * der Konsole ausgegeben. Die send-Methode kann den Testbed�rfnissen entsprechend
 * angepasst werden. Insbesondere k�nnen aus der send-Methode heraus Antworten vom 
 * Server simuliert werden. Hierzu steht die Methode deliverResponseMessageToClient
 * zur Verf�gung. Diese liefert eine beliebige Meldung an den Client aus und ben�tzt
 * daf�r einen separaten Thread, so wie dies auch mit der richtigen Netzwerkschicht
 * der Fall sein wird.
 * 
 * @author Andres Scheidegger
 *
 */
public class ServerProxyStub extends ServerProxy {

  /**
   * Konstruktor. Muss vom Client aufgerufen werden.
   * @param clientApplication Eine Referenz auf ein Objekt des Clients, welches das
   *                          Interface ClientApplicationInterface implementiert.
   */
  public ServerProxyStub(ClientApplicationInterface clientApplication) {
    super(clientApplication);
  }

  /**
   * Kann vom Client aufgerufen werden, um den Versand einer Meldung zu simulieren. 
   * Kann den Testbed�rfnissen entsprechend angepasst werden.
   * @see network.client.ServerProxy#send(network.Message)
   */
  public void send(Message message) {
    System.out.println(message);
    // Hier kommt die Antwort. Z.B.:
    // PlayerJoined playerJoinedMessage = new PlayerJoined("Donald Duck", 0, 0);
    // deliverResponseMessageToClient(playerJoinedMessage);
  }

  /**
   * Simuliert den Empfang einer Meldeung vom Server �ber das Netzwerk.
   * @param responseMessage Das Meldungsobjekt, welches an den Client ausgeliefert
   *                        werden soll.
   */
  private void deliverResponseMessageToClient(Message responseMessage) {
    Thread responseThread = new Thread() {
      @Override
      public void run() {
        clientApplication.handleMessage(responseMessage);
      }
    };
    responseThread.start();
  }

    @Override
    public void send(String message) {
        //System.out.println(message);
    }
}
