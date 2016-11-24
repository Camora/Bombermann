package control;

import view.MainFrame;

public class BombermanClient {

    public static void main(String[] args) {
        MainFrame gui = new MainFrame();
        gui.setTitle("Bombermann");
        gui.setSize(600, 450);
        gui.setVisible(true);
    }
    
}
