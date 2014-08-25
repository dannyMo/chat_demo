/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.valik.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Валик
 */
public class MainWindow extends JFrame {
    private MainWindow() {
        this.setSize(new Dimension(600, 400));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));
        this.add(MessageIOPanel.getInstance(), BorderLayout.CENTER);
        this.add(ChatRightPanel.getInstance(), BorderLayout.EAST);
        this.validate();
        
    }
    private static MainWindow self = new MainWindow();
    public static MainWindow getInstnce() {
        return self;
    }
    
}