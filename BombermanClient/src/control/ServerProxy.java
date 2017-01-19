package control;

import network.Message;
import network.client.ClientApplicationInterface;

/**
 * Diese Klasse repr�sentiert den Server auf der Client-Seite und zwar auf Ebene Netzwerkschicht.
 * Sie definiert die Schnittstelle, welche die Netzwerkschicht der Bomberman-Client-Komponente anbietet.
 * Sie ist abstrakt und muss innerhalb der Netzwerkschicht durch Ableitung implementiert werden.
 * Die Bomberman-Client-Komponente muss beim Start ein Objekt von dieser Implementationsklasse
 * erzeugen.
 * 
 * @author Andres Scheidegger
 *
 */
public abstract class ServerProxy {
  /**
   * Referenz auf dasjenige Objekt innerhalb der Bomberman-Client-Komponente, welches vom Server
   * empfangene Nachrichten verarbeitet (Empf�ngerobjekt).
   */
  protected final ClientApplicationInterface clientApplication;
  
  /**
   * Konstruktor. Initialisiert das neue ServerProxy-Objekt mit der Referenz auf das Empf�ngerobjekt.
   * @param clientApplication Das Empf�ngerobjekt des Bomberman-Clients f�r Nachrichten.
   */
  public ServerProxy(ClientApplicationInterface clientApplication){
    this.clientApplication = clientApplication;
  }
  
  /**
   * Sendet ein Nachrichtenobjekt an den Server. Diese Methode muss innerhalb der Netzwerkschicht
   * implementiert werden.
   * @param message Das Nachrichtenobjekt, welches an den Server gesendet werden soll.
   */
  public abstract void send(String message);
}
