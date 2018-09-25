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
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sagor Ahamed
 */
public class highScores{
    JFrame frame;
    JPanel panel;
    //JButton startButton;
    //JButton optionsButton=new JButton("About");
    JButton backButton;
    
    JLabel userName=new JLabel();
    //JTextField jTextField;
    
    Color menuBackgroundColor;
    Color buttonColor;
    JLabel highScoreImage,playerCredit, date;
    JLabel name,name2,name3,name4,name5, score,score2, score3,score4,score5, day, day2,day3,day4,day5;
   // JLabel n,s;
    //variables
    float scores[];
    String names[], dates[];
    int scoreCount, nameCount, dateCount;
    File scoresFile, namesFile, datesFile;
    Scanner scanScores, scanNames, scanDates;
    //PrintWriter writeScores, writeNames, writeDates;
    
    //static String playerSelected;
    
    public highScores() throws FileNotFoundException {
        frame = new JFrame();
        panel=new JPanel();

        // assing var
        scores = new float[100];
        
        names = new String[100];
        
        dates = new String[100];
        
        loadRecords();
        
        
        buttonColor=new Color(1,125,1);
        
        
        backButton=new JButton();

        menuBackgroundColor=new Color(255,246,0);
        
        
        
        frame.setSize(1280, 720);
        frame.setResizable(false);
        
        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);
        
        highScoreImage = new JLabel();
        playerCredit = new JLabel();
        date = new JLabel();
        
        name = new JLabel();
        name2 = new JLabel();
        name3 = new JLabel();
        name4 = new JLabel();
        name5 = new JLabel();
        
        score = new JLabel();
        score2 = new JLabel();
        score3 = new JLabel();
        score4 = new JLabel();
        score5 = new JLabel();
        
        day = new JLabel();
        day2 = new JLabel();
        day3 = new JLabel();
        day4 = new JLabel();
        day5 = new JLabel();
        
        
        
        
        backButton.setBounds(1000,570,200,80);
        backButton.setBackground(buttonColor);
        backButton.setIcon(new ImageIcon("resources\\images\\menu\\back.png"));

        //title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        highScoreImage.setIcon(new ImageIcon("resources\\images\\others\\highscores.png"));
        highScoreImage.setBounds(400,5,800,159);
        
        userName.setIcon(new ImageIcon("resources\\images\\others\\name.png"));
        userName.setBounds(200,180,100,32);
        
        playerCredit.setIcon(new ImageIcon("resources\\images\\others\\scores.png"));
        playerCredit.setBounds(550,180,118,32);
        
        date.setIcon(new ImageIcon("resources\\images\\others\\Date.png"));
        date.setBounds(900,180,118,32);
        
        // all Name Show
        
        Font font1 = new Font("Super Mario Bros.", Font.BOLD, 30);
        name.setFont(font1);
        name.setText("1. "+names[0]);
        name.setBounds(150,240,350,40);
        name2.setFont(font1);
        name2.setText("2. "+names[1]);
        name2.setBounds(150,290,350,40);
        name3.setFont(font1);
        name3.setText("3. "+names[2]);
        name3.setBounds(150,340,350,40);
        name4.setFont(font1);
        name4.setText("4. "+names[3]);
        name4.setBounds(150,390,350,40);
        name5.setFont(font1);
        name5.setText("5. "+names[4]);
        name5.setBounds(150,440,350,40);
        
         score.setFont(font1);
        score.setText(" "+scores[0]);
        score.setBounds(570,240,150,40);
        score2.setFont(font1);
        score2.setText(" "+scores[1]);
        score2.setBounds(570,290,150,40);
        score3.setFont(font1);
        score3.setText(" "+scores[2]);
        score3.setBounds(570,340,150,40);
        score4.setFont(font1);
        score4.setText(" "+scores[3]);
        score4.setBounds(570,390,150,40);
        score5.setFont(font1);
        score5.setText(" "+scores[4]);
        score5.setBounds(570,440,150,40);
        
        day.setFont(font1);
        day.setText(" "+dates[0]);
        day.setBounds(870,240,250,40);
         day2.setFont(font1);
        day2.setText(" "+dates[1]);
        day2.setBounds(870,290,250,40);
         day3.setFont(font1);
        day3.setText(" "+dates[2]);
        day3.setBounds(870,340,250,40);
         day4.setFont(font1);
        day4.setText(" "+dates[3]);
        day4.setBounds(870,390,250,40);
         day5.setFont(font1);
        day5.setText(" "+dates[4]);
        day5.setBounds(870,440,250,40);
        
        
        backButton.addActionListener(new highScores.backListener());
        
        
        panel.add(userName);
        panel.add(highScoreImage);
        panel.add(playerCredit);
        panel.add(backButton);
        panel.add(date);
        
        panel.add(name);panel.add(name2);panel.add(name3);panel.add(name4);panel.add(name5);
        
        panel.add(score);panel.add(score2);panel.add(score3);panel.add(score4);panel.add(score5);
        
        panel.add(day); panel.add(day2); panel.add(day3);panel.add(day4);panel.add(day5);
        
        frame.add(panel);
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    
   
        private void loadRecords() throws FileNotFoundException{
        
         scoresFile = new File("resources\\extra\\highscore.txt");
        namesFile = new File("resources\\extra\\names.txt");
        datesFile = new File("resources\\extra\\dates.txt");
        scanScores = new Scanner(scoresFile);//for reading from file
        scanNames = new Scanner(namesFile);
        scanDates = new Scanner(datesFile);
        scoreCount=0;
        nameCount=0;
        dateCount=0;
        
        while(scanScores.hasNext()){
            scores[scoreCount] = scanScores.nextFloat();
            scoreCount++;
        }
        
        while(scanNames.hasNext()){
            names[nameCount] = scanNames.nextLine();
            nameCount++;
        }
        
        while(scanDates.hasNext()){
            dates[dateCount] = scanDates.nextLine();
            dateCount++;
        }
       
        
        sortRecords();
        
    }

    void sortRecords(){
  
       int j;
     boolean flag = true;   // set flag to true to begin first pass
     float temp;   //holding variable

     while ( flag )
     {
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0;  j < scores.length -1;  j++ )
            {
                   if ( scores[ j ] < scores[j+1] )   // change to > for ascending sort
                   {
                           temp = scores[ j ];                //swap elements
                          scores[ j ] = scores[ j+1 ];
                           scores[ j+1 ] = temp;
                          flag = true;              //shows a swap occurred  
                  } 
            } 
      } 
    }
 

    private class backListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
        GameMenu mn=new GameMenu();
        frame.setVisible(false);
        }
    }
    
    
}
