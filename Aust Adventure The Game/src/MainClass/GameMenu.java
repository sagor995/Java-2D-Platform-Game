/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass;

import MainClass.GameMusic;
import MainClass.menuItems.UserName;
import MainClass.menuItems.UserName;
import MainClass.menuItems.UserName;
import MainClass.menuItems.credits;
import MainClass.menuItems.highScores;
import MainClass.menuItems.controlKeys;
import MainClass.menuItems.controlKeys;
import MainClass.menuItems.controlKeys;
import MainClass.menuItems.credits;
import MainClass.menuItems.credits;
import MainClass.menuItems.highScores;
import MainClass.menuItems.highScores;
import java.awt.Color;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sagor Ahamed
 */
public class GameMenu {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton startButton = new JButton();
    JButton controlsButton = new JButton();
    JButton highScoreButton = new JButton();
    JButton creditButton = new JButton();
    JButton exitButton = new JButton();
    JLabel title = new JLabel();
    Color menuBackgroundColor = new Color(1, 125, 1);
    Color buttonColor = new Color(242, 117, 0);
    JLabel character, character2, character3;
    JButton sound_on,sound_off;

    GameMusic menuMusic;

    public GameMenu() {
        menuMusic = new GameMusic("resources\\music\\menuMusic.wav");
        frame.setSize(1280, 720);
        frame.setResizable(false);

        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);

        menuMusic.loop();

        character = new JLabel();
        character2 = new JLabel();
        character3 = new JLabel();
        
        sound_on=new JButton();
sound_on.setIcon(new ImageIcon("resources\\images\\others\\Sound-on.png"));
        sound_on.setOpaque(false);
      sound_on.setContentAreaFilled(false);
       sound_on.setBorderPainted(false);
        
      sound_on.setBounds(20, 630, 50,50);
 
        
        
        
        
        //Image gamePause = Toolkit.getDefaultToolkit().getImage("resources\\images\\background\\mainbg.png");
        title.setIcon(new ImageIcon("resources\\images\\background\\mainbg.png"));
        title.setBounds(50, 60, 800, 159);

        //1st character in main screen
        character2.setIcon(new ImageIcon("resources\\images\\players\\player1r.gif"));
        character2.setBounds(220, 300, 81, 225);

        character.setIcon(new ImageIcon("resources\\images\\players\\player.gif"));
        character.setBounds(420, 290, 81, 225);

        character3.setIcon(new ImageIcon("resources\\images\\players\\player4l.gif"));
        character3.setBounds(580, 300, 115, 225);

        startButton.setBounds(950, 90, 200, 80);
        startButton.setBackground(buttonColor);
        startButton.setIcon(new ImageIcon("resources\\images\\menu\\start2.png"));
        controlsButton.setBounds(950, 200, 200, 80);
        controlsButton.setBackground(buttonColor);
        controlsButton.setIcon(new ImageIcon("resources\\images\\menu\\controls.png"));
        highScoreButton.setBounds(950, 310, 200, 80);
        highScoreButton.setBackground(buttonColor);
        highScoreButton.setIcon(new ImageIcon("resources\\images\\menu\\highscore.png"));
        creditButton.setBounds(950, 420, 200, 80);
        creditButton.setBackground(buttonColor);
        creditButton.setIcon(new ImageIcon("resources\\images\\menu\\credits.png"));
        exitButton.setBounds(950, 530, 200, 80);
        exitButton.setBackground(buttonColor);
        exitButton.setIcon(new ImageIcon("resources\\images\\menu\\exit.png"));

        //

        
        startButton.addActionListener(new startListener());
        highScoreButton.addActionListener(new highScoreListener());
        controlsButton.addActionListener(new controlKeyListener());
        creditButton.addActionListener(new creditsListener());
        exitButton.addActionListener(new exitListener());

        sound_on.addActionListener(new onListener());

        panel.add(sound_on);
        panel.add(startButton);
        panel.add(controlsButton);
        panel.add(highScoreButton);
        panel.add(creditButton);

        panel.add(exitButton);
        panel.add(title);

        panel.add(character);
        panel.add(character3);
        panel.add(character2);
         panel.add(sound_on);    
        frame.add(panel);
       
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private class startListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (GameMusic.clip.isOpen()) {
                menuMusic.stop();
            }
            UserName userName = new UserName();

            frame.dispose();
        }

    }

    private class highScoreListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (GameMusic.clip.isOpen()) {
                menuMusic.stop();
            }
            try {
                highScores hScores = new highScores();
            } catch (FileNotFoundException ex) {

            }
            frame.dispose();
        }

    }

    private class controlKeyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (GameMusic.clip.isOpen()) {
                menuMusic.stop();
            }
            controlKeys cKeys = new controlKeys();

            frame.dispose();
        }

    }

    private class creditsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (GameMusic.clip.isOpen()) {
                menuMusic.stop();
            }
            credits c = new credits();

            frame.dispose();
        }

    }
    

 private class onListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
       
        if (GameMusic.clip.isOpen()) {
            if (sound_on.isEnabled()) {
                  menuMusic.stop();
            
                sound_on.setIcon(new ImageIcon("resources\\images\\others\\Sound-off.png"));
            }
            
              
                }
               
    }

      
        
   
   

    }
    

    private class exitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        try {
            new GameMenu();
        } catch (Exception ex) {
            Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
