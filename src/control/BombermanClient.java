package control;


public class BombermanClient {

    public static void main(String[] args) {
        ClientApplication c = new ClientApplication();
        ServerProxyStub s = new ServerProxyStub(c);
        MainFrame gui = new MainFrame(s);
        gui.setTitle("Bombermann");
        gui.setSize(600, 450);
        gui.setVisible(true);
    }
    
}
