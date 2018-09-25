/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass.menuItems;

import MainClass.GameMenu;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/**
 *
 * @author Sagor Ahamed
 */
public class controlKeys{
    JFrame frame;
    JPanel panel;
    JButton backButton;
    
    Color menuBackgroundColor;
    Color buttonColor;
    JLabel controlMainImage;
    
    public controlKeys() {
        frame = new JFrame();
        panel=new JPanel();
        buttonColor=new Color(50,183,255);
        
        
        backButton=new JButton();
        menuBackgroundColor=new Color(0,0,0);
        
        
        
        frame.setSize(1280, 720);
        frame.setResizable(false);
        
        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);
        
        controlMainImage = new JLabel();
        
        backButton.setBounds(1000,570,200,80);
        backButton.setBackground(buttonColor);
        backButton.setIcon(new ImageIcon("resources\\images\\menu\\back.png"));
        
        controlMainImage.setIcon(new ImageIcon("resources\\images\\others\\key2.png"));
        controlMainImage.setBounds(200,50,890,500);

        backButton.addActionListener(new controlKeys.backListener());
        
        panel.add(backButton);
        panel.add(controlMainImage);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    
    private class backListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
        GameMenu mn=new GameMenu();
        frame.setVisible(false);
        }
    }
    
    
}
