/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass.otherItems;

import MainClass.GamePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sagor Ahamed
 */
public class LoadingWindow{
    JFrame frame;
    JPanel panel;
    
    Color menuBackgroundColor;
    Color buttonColor;
    JLabel loadingImage;
    //JTextField Thanks;
    Timer time;
    int counter = 0;
    
    public LoadingWindow() {
        frame = new JFrame();
        panel=new JPanel();
        Color buttonColor=new Color(255,255,255);
        menuBackgroundColor=new Color(255,255,255);
        
        frame.setSize(1280, 720);
        frame.setResizable(false);
        
        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);
        
        
        
        loadingImage = new JLabel();
        loadingImage.setIcon(new ImageIcon("resources\\images\\others\\loading.gif"));
        loadingImage.setBounds(320,470,685,180);
        loadingImage.setLayout(null);
        
         time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                counter++;
                if(counter == 5){
            GamePanel gamePanel = new GamePanel();
             frame.dispose(); 
              time.stop();
           
                }
            }
        });
         time.start();

        panel.add(loadingImage);
        frame.add(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
