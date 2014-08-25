/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.valik.frame;

import com.valik.HttpClient;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Валик
 */
public class ChatRightPanel extends JPanel{
    
    private JTextField fieldOfUserName;
    private JTextField fieldOfUserLastName;
    
    private ChatRightPanel() {
        this.setSize(500, 500);
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        
        this.add(Box.createVerticalStrut(35));
        
        fieldOfUserName = new JTextField(15);
        fieldOfUserName.setText("Unknown name");
        fieldOfUserName.setMaximumSize(new Dimension(240, 20));
        this.add(fieldOfUserName);
        
        this.add(Box.createVerticalStrut(15));
        
        fieldOfUserLastName = new JTextField(15);
        fieldOfUserLastName.setText("Unknown lastname");
        fieldOfUserLastName.setMaximumSize(new Dimension(240, 20));
        this.add(fieldOfUserLastName);
        
        this.add(Box.createVerticalStrut(170));
        
        JButton sendButton = new JButton("Send message");
        this.add(sendButton);
        sendButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("" + MessageIOPanel.getInstance().getSentMessage() + " " + getUserName());
                String textFromServer = HttpClient.getInstnce().sendData("http://localhost:8080/hello", getUserName() + ";" + getUserLastName() + ";" + MessageIOPanel.getInstance().getSentMessage());
                MessageIOPanel.getInstance().setListMessage(textFromServer);
            }
        });        
    }
    

    public String getUserName() {
        return fieldOfUserName.getText();
    }

    public String getUserLastName() {
        return fieldOfUserLastName.getText();
    }
    
    private static ChatRightPanel self = new ChatRightPanel();
    public static ChatRightPanel getInstance() {
        return self;
    }    
}
