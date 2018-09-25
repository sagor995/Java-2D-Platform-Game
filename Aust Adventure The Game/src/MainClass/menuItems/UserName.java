/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass.menuItems;

import MainClass.GameMenu;
import MainClass.GameMusic;
import MainClass.otherItems.IntroWindow;
import MainClass.otherItems.LoadingWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sagor Ahamed
 */
public class UserName {

    JFrame frame;
    JPanel panel;
    JButton startButton;
    //JButton optionsButton=new JButton("About");
    JButton backButton;
    JButton player1, player2, player3, player4, borderButton;

    JLabel userName = new JLabel();
    JLabel playerSelect = new JLabel();
    JTextField jTextField;

    Color menuBackgroundColor;
    Color buttonColor;
    public static String playerName;
    public static boolean playerSelected1 = false;
    public static boolean playerSelected2 = false;
    public static boolean playerSelected3 = false;
    public static boolean playerSelected4 = false;
    //static String playerSelected;

    GameMusic selectMusic = new GameMusic("resources\\music\\playerSelects.wav");

    public UserName() {
        frame = new JFrame();
        panel = new JPanel();
        buttonColor = new Color(242, 117, 0);

        startButton = new JButton();
        backButton = new JButton();

        player1 = new JButton();
        player2 = new JButton();
        player3 = new JButton();
        player4 = new JButton();

        borderButton = new JButton();
        borderButton.setIcon(new ImageIcon("resources\\images\\players\\selected.png"));

        menuBackgroundColor = new Color(50, 183, 255);

        jTextField = new JTextField();

        frame.setSize(1280, 720);
        frame.setResizable(false);

        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);

        startButton.setBounds(300, 580, 200, 80);
        startButton.setBackground(buttonColor);
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startButton.setIcon(new ImageIcon("resources\\images\\menu\\start2.png"));

        backButton.setBounds(700, 580, 200, 80);
        backButton.setBackground(buttonColor);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setIcon(new ImageIcon("resources\\images\\menu\\back.png"));

        userName.setIcon(new ImageIcon("resources\\images\\background\\name1.png"));
        userName.setBounds(50, 20, 800, 159);

        playerSelect.setIcon(new ImageIcon("resources\\images\\background\\playerselect.png"));
        playerSelect.setBounds(50, 150, 800, 159);

        player1.setBounds(100, 290, 200, 250);
        player1.setOpaque(false);
        player1.setContentAreaFilled(false);
        player1.setBorderPainted(false);
        player1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //player1.setBackground(Color.WHITE);
        player1.setIcon(new ImageIcon("resources\\images\\players\\player1r.gif"));

        player2.setBounds(400, 290, 200, 250);
        // player2.setBackground(Color.WHITE);
        player2.setOpaque(false);
        player2.setContentAreaFilled(false);
        player2.setBorderPainted(false);
        player2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        player2.setIcon(new ImageIcon("resources\\images\\players\\player2r.gif"));

        player3.setBounds(700, 290, 200, 250);
        //  player3.setBackground(Color.WHITE);
        player3.setOpaque(false);
        player3.setContentAreaFilled(false);
        player3.setBorderPainted(false);
        player3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        player3.setIcon(new ImageIcon("resources\\images\\players\\player3r.gif"));

        player4.setBounds(1000, 290, 200, 250);
        // player4.setBackground(Color.WHITE);
        player4.setOpaque(false);
        player4.setContentAreaFilled(false);
        player4.setBorderPainted(false);
        player4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        player4.setIcon(new ImageIcon("resources\\images\\players\\player4r.gif"));

        Font font1 = new Font("BatmanForeverAlternate", Font.BOLD, 40);
        jTextField.setToolTipText("Enter a Player Name");
        jTextField.setSelectedTextColor(Color.GREEN);
        jTextField.setFont(font1);
        jTextField.setForeground(new Color(34, 226, 255));
        jTextField.setText(" ");
        jTextField.setBounds(780, 65, 400, 80);
        jTextField.setBackground(Color.WHITE);

        startButton.addActionListener(new UserName.startListener());
        backButton.addActionListener(new UserName.backListener());

        player1.addActionListener(new UserName.player1Listener());
        player2.addActionListener(new UserName.player2Listener());
        player3.addActionListener(new UserName.player3Listener());
        player4.addActionListener(new UserName.player4Listener());

        panel.add(jTextField);
        panel.add(startButton);
        panel.add(backButton);

        panel.add(player1);
        panel.add(player2);
        panel.add(player3);
        panel.add(player4);

        panel.add(userName);
        panel.add(playerSelect);
        frame.add(borderButton);
        frame.add(panel);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    //player listener
    private class player1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            borderButton.setBounds(90, 280, 220, 270);

            selectMusic.play();

            playerSelected1 = true;
            playerSelected2 = false;
            playerSelected3 = false;
            playerSelected4 = false;
        }
    }

    private class player2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            borderButton.setBounds(390, 280, 220, 270);

            selectMusic.play();

            playerSelected1 = false;
            playerSelected2 = true;
            playerSelected3 = false;
            playerSelected4 = false;
        }
    }

    private class player3Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            borderButton.setBounds(690, 280, 220, 270);

            selectMusic.play();

            playerSelected1 = false;
            playerSelected2 = false;
            playerSelected3 = true;
            playerSelected4 = false;
        }
    }

    private class player4Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            borderButton.setBounds(990, 280, 220, 270);

            selectMusic.play();

            playerSelected1 = false;
            playerSelected2 = false;
            playerSelected3 = false;
            playerSelected4 = true;
        }
    }

    private class startListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            playerName = jTextField.getText();

            if (playerName.length() > 10) {
                JOptionPane.showMessageDialog(null, "Please Enter Character Less Then 11");
            } else if (playerName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter Player Name");
            } else if ((playerSelected1 == true)
                    || (playerSelected2 == true)
                    || (playerSelected3 == true)
                    || (playerSelected4 == true)) {
                //LoadingWindow loadingWindow = new LoadingWindow();
                IntroWindow introWindow=new IntroWindow();
                frame.dispose();
                frame.setVisible(false);
            } else if ((playerSelected1 != true) || (playerSelected2 != true) || (playerSelected3 != true) || (playerSelected4 != true)) {
                JOptionPane.showMessageDialog(null, "Please select a player");
            }
        }
    }

    private class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            GameMenu mn = new GameMenu();
            frame.setVisible(false);
        }
    }

}
