package model;

import control.BombermanClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.TextField;


public class AllActionListener {
    
    public static JButton LoginAction(JButton logbutton,TextField loginfeld, TextArea messagefield){
        logbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ 
                
                String loginname = loginfeld.getText();
                BombermanClient.LogButtonClick(loginname);
                messagefield.setText(messagefield.getText()+loginname+" logged in \n");
                
            }
        });
        
        return logbutton;
    }
}
