/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import network.Message;
import network.client.ClientApplicationInterface;

/**
 *
 * @author vmadmin
 */
public class ClientApplication implements ClientApplicationInterface{

    @Override
    public void handleMessage(Message message) {
        System.out.println("Test" + message);
    }
    
}
