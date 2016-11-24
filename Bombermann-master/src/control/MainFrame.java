package control;

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


public class MainFrame extends JFrame{
    Container container;
    JPanel login, map, messages;
    public MainFrame(){
        container = getContentPane();
        
        login = new JPanel();
        map = new JPanel();
        messages = new JPanel();
        
        Message m = new Message();

        JButton logbutton = new JButton("login");
        logbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ 
                
                ServerStub s = new ServerStub((message, connectionId) -> {
                });
                s.send(null, null); 
               
            }
        });
        
        login.add(new TextField());
        login.add(logbutton);
        
        messages.add(new TextArea());
        
        container.add(login, BorderLayout.NORTH);
        container.add(map, BorderLayout.CENTER);
        container.add(messages, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
