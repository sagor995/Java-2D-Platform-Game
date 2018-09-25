/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass.otherItems;

import MainClass.GameMusic;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sagor Ahamed
 */
public class IntroWindow{
    JFrame frame;
    JPanel panel;
    
    Color menuBackgroundColor;
    Color buttonColor;
    JLabel IntroImage;
    JButton skipButton=new JButton();
    //JTextField Thanks;
    Timer time;
    int counter = 0;
    String first="resources\\images\\story\\first.png";
    /*
    String second="resources\\images\\story\\second.png";
    String third="resources\\images\\story\\third.png";
    String four="resources\\images\\story\\fourth.png";
    String five="resources\\images\\story\\five.png";
    String six="resources\\images\\story\\six.png";
    String seven="resources\\images\\story\\seven.png";
      */     
    GameMusic  introMusic;
    
    public IntroWindow() {
        frame = new JFrame();
        panel=new JPanel();
        Color buttonColor=new Color(255,255,255);
        menuBackgroundColor=new Color(251,215,72);
        
        frame.setSize(1280, 720);
        frame.setResizable(false);
        
        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);
        introMusic =new GameMusic("resources\\music\\welcome.wav");
        
   
        IntroImage = new JLabel();
        IntroImage.setIcon(new ImageIcon(first));
        IntroImage.setBounds(0,0,1280,720);
        IntroImage.setLayout(null);
        introMusic.play();
         time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              
                counter++;
            
                if(counter == 3){
                    LoadingWindow loadingWindow = new LoadingWindow();
                    frame.dispose();
                     time.stop();
                }
                
                /*
                if(counter == 3){
                    IntroImage.setIcon(new ImageIcon(second));
                }else if(counter == 7){
                    IntroImage.setIcon(new ImageIcon(third));
                }else if(counter == 12){
                    IntroImage.setIcon(new ImageIcon(four));
                }else if(counter == 17){
                    IntroImage.setIcon(new ImageIcon(five));
                }else if(counter == 24){
                    IntroImage.setIcon(new ImageIcon(six));
                }else if(counter == 31){
                    IntroImage.setIcon(new ImageIcon(seven));
                }else if (counter==35) {                 
                    LoadingWindowAnother loadingWindowAnother = new LoadingWindowAnother();
                     frame.dispose();
                     time.stop();
                }
                
                */
            }
        });
         time.start();
         
         skipButton.setBounds(1050,590,152,63);
        skipButton.setBackground(buttonColor);
       skipButton.setIcon(new ImageIcon("resources\\images\\others\\skip.gif"));
       skipButton.setOpaque(false);
        skipButton.setContentAreaFilled(false);
        skipButton.setBorderPainted(false);
       
       skipButton.addActionListener(new IntroWindow.skipListener());
       
        panel.add(IntroImage);
        panel.add(skipButton);
        frame.add(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private class skipListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
         new LoadingWindow();
           frame.dispose();
           time.stop();
           introMusic.stop();
        }
    
    
    }
    
}
