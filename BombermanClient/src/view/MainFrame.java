package view;

import control.BombermanClient;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import network.client.ClientApplicationInterface;
import control.ServerProxyStub;
import control.ServerProxyStub;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import model.AllActionListener;


public class MainFrame extends JFrame{
    Container container;
    JPanel login, map, messages;
    public MainFrame(ServerProxyStub s){

        this.setTitle("Bombermann");
        this.setSize(600, 450);
        this.setVisible(true);
        
        container = getContentPane();
        
        login = new JPanel();
        map = new JPanel();
        messages = new JPanel();
        
        TextField loginfeld = new TextField("", 20);
        TextArea messagefield = new TextArea();
        
        login.add(loginfeld);
        
        
        BombermanClient bc = new BombermanClient();
        
        map.setLayout(new GridLayout(bc.FieldAmount, bc.FieldAmount,2,2));
        for (int f=0; f<bc.FieldAmount*bc.FieldAmount; f++) {
            JLabel field = new JLabel();
            field.setBackground(Color.lightGray);
            field.setOpaque(true);
            map.add(field);
        }

        JButton logbutton = new JButton("login");
        AllActionListener.LoginAction(logbutton, loginfeld, messagefield);
      
        login.add(logbutton);
        
        messages.add(messagefield);
        
        container.add(login, BorderLayout.NORTH);
        container.add(map, BorderLayout.CENTER);
        container.add(messages, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
