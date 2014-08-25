/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.valik.frame;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Валик
 */
public class MessageIOPanel extends JPanel {
    
    private JTextArea textAreaForSendingMessage;
    private JTextArea textAreaforListMessages;
    
    private MessageIOPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        textAreaforListMessages = new JTextArea(15, 25);
        textAreaforListMessages.setLineWrap(true);
        textAreaforListMessages.setWrapStyleWord(true);
        //textAreaforListMessages.setEditable(false);
        this.add(new JScrollPane(textAreaforListMessages));
        
        textAreaForSendingMessage = new JTextArea(5, 25);
        textAreaforListMessages.setLineWrap(true);
        textAreaforListMessages.setWrapStyleWord(true);
        this.add(new JScrollPane(textAreaForSendingMessage));
        
    }
    
    public String getSentMessage() {
        return textAreaForSendingMessage.getText();
    }
    
    public void setListMessage(String listOfMessage) {
        textAreaforListMessages.setText(listOfMessage);
    }    
    
    private static MessageIOPanel self = new MessageIOPanel();
    public static MessageIOPanel getInstance() {
        return self;
    }
}
