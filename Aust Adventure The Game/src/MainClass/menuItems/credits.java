/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass.menuItems;

import MainClass.GameMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sagor Ahamed
 */
public class credits{
    JFrame frame;
    JPanel panel;
    //JButton optionsButton=new JButton("About");
    JButton backButton;
    
    Color menuBackgroundColor;
    Color buttonColor;
    JLabel image1, image2, image3,text1,text2,text3,banner,Thanks,Thanks2,Thanks3,banner2;
    

    public credits() {
        frame = new JFrame();
        panel=new JPanel();
        Color buttonColor=new Color(255,255,255);
        
        
        backButton=new JButton();

        menuBackgroundColor=new Color(0,0,0);
        
        
        
        frame.setSize(1280, 720);
        frame.setResizable(false);
        
        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);
        
        Font font1 = new Font("BatmanForeverAlternate", Font.BOLD, 35);
       
        
        banner = new JLabel();
        banner.setText("Credits");
        banner.setForeground(Color.WHITE);
        banner.setFont(font1);
        banner.setBounds(500,10,300,100);
        banner.setLayout(null);
        Font font2 = new Font("BatmanForeverAlternate", Font.BOLD, 22);
        
        banner2 = new JLabel();
        banner2.setText("AUST CSE2100 SD LAB PROJECT");
        banner2.setForeground(Color.WHITE);
        banner2.setFont(font2);
        banner2.setBounds(340,50,600,100);
        banner2.setLayout(null);
        
        Thanks = new JLabel();
        Thanks.setText("Special Thanks To:");
        Thanks.setFont(font1);
        Thanks.setForeground(Color.WHITE);
        Thanks.setBounds(100,480,1200,100);
        Thanks.setLayout(null);
        
        Thanks2 = new JLabel();
        Thanks2.setText("Our honorable Sir, \"Mr. Sujan Sarkar\" ");
        Thanks2.setFont(font1);
        Thanks2.setForeground(Color.WHITE);
        Thanks2.setBounds(100,525,1200,100);
        Thanks2.setLayout(null);
        
        Thanks3 = new JLabel();
        Thanks3.setText("For this creative game idea.");
        Thanks3.setFont(font1);
        Thanks3.setForeground(Color.WHITE);
        Thanks3.setBounds(100,575,1200,100);
        Thanks3.setLayout(null);
        
        
         text1 = new JLabel();
        text1.setText("SAGOR AHAMED");
        text1.setFont(font2);
        text1.setForeground(Color.WHITE);
        text1.setBounds(120,110,350,100);
        text1.setLayout(null);
        
        text2 = new JLabel();
        text2.setText("NABIL AHMED");
        text2.setFont(font2);
        text2.setForeground(Color.WHITE);
        text2.setBounds(490,110,350,100);
        text2.setLayout(null);
        
        text3 = new JLabel();
        text3.setText("SHANJOY PAUL");
        text3.setForeground(Color.WHITE);
        text3.setFont(font2);
        text3.setBounds(825,110,350,100);
        text3.setLayout(null);
        
        
     image1 = new JLabel();
        image1.setIcon(new ImageIcon("resources\\images\\profiles\\Developer_1.1.jpg"));
        image1.setBounds(120,180,300,300);
        image1.setLayout(null);
        
        image2 = new JLabel();
        image2.setIcon(new ImageIcon("resources\\images\\profiles\\Developer_2.jpg"));
        image2.setBounds(470,180,300,300);
        image2.setLayout(null);
        
        image3 = new JLabel();
        image3.setIcon(new ImageIcon("resources\\images\\profiles\\Developer_3.jpg"));
        image3.setBounds(820,180,300,300);
        image3.setLayout(null);
        
        backButton.setBounds(1055,610,160,60);
        backButton.setBackground(buttonColor);
        backButton.setIcon(new ImageIcon("resources\\images\\menu\\back.png"));


     
        
        backButton.addActionListener(new credits.backListener());
        panel.add(banner2);
        panel.add(image1);
        panel.add(image2);
        panel.add(image3);
        panel.add(banner);
        panel.add(Thanks);
        panel.add(Thanks2);
        panel.add(Thanks3);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(backButton);
        
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
