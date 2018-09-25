package MainClass.featuresList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import MainClass.GameMusic;
import MainClass.GamePanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sagor Ahamed
 */
public class labQuiz4{
   
    JFrame frame;
    JPanel panel;
    JButton submitButton;
    //JButton optionsButton=new JButton("About");
    JButton nextButton;
    //JLabel Question, Answer;
    JLabel Status, status1,status2,status3;
    JButton borderButton;
    JLabel labScoreShow;
    JLabel labQuiz4Banner=new JLabel();
    JTextField ansField;
    
    
    Color menuBackgroundColor;
    Color buttonColor;
    JLabel questionShow;
    private final String[] Question, CorrectAnswer;
    private final String dialog;
    private String answer;
    private final String correctAns = "resources\\images\\others\\lCorrect.png";
    private final String wrongAns = "resources\\images\\others\\lWrong.png";

  //  String nextQuiz="resources\\images\\others\\next1.png";
    private final String empty = "";
    int ChoiceIndex;
    
    Random random;
    File file;
    Scanner scanner;
    
    String audioFilePath4 = "resources\\music\\CorrectAns.wav";
    String audioFilePath5 = "resources\\music\\WrongAns.wav";
    GameMusic correctMusic, wrongMusic;
    int correct1=0, wrong1=0;
   boolean nextReady = false;
  int fileCounter=0;
    
    public labQuiz4() throws FileNotFoundException{
        
        frame = new JFrame();
        panel=new JPanel();
        buttonColor=new Color(242,117,0);
        
        
        submitButton=new JButton();
       nextButton=new JButton();
        menuBackgroundColor=new Color(250,204,47);
        
        Question = new String[4];
        CorrectAnswer = new String[4];
        
        
        random=new Random();

        questionShow = new JLabel();
        Font font1 = new Font("Times New Roman", Font.BOLD, 22);
        questionShow.setFont(font1);
        questionShow.setBounds(30,180,800,50);

        ansField = new JTextField();
        
        file = new File("resources\\labQuiz\\lab4.txt");
        this.scanner= new Scanner(file);
        
         for(int i=0;i<4;i++){
            Question[i]=scanner.nextLine();
            CorrectAnswer[i]=scanner.nextLine();
        }
        
         setChoiceIndex();
         
        dialog=Question[ChoiceIndex];
        
        questionShow.setText(dialog);
        
       ansField.setBounds(50,250,400,50);
      ansField.setFont(font1);
      ansField.setToolTipText("Enter the correct answer...");
      ansField.setSelectedTextColor(Color.GREEN);
        ansField.setForeground(new Color(0,0,0));
        ansField.setText("");
        ansField.setBounds(34,270,400,50);
        ansField.setBackground(Color.WHITE);
      
        frame.setSize(900,500);
        frame.setResizable(false);
        
        panel.setLayout(null);
        panel.setBackground(menuBackgroundColor);
        
        
        Status = new JLabel();
        status1 = new JLabel();
        status2 = new JLabel();
        status3 = new JLabel();
        
        labScoreShow = new JLabel();
        
      
        
        
        submitButton.setBounds(450,270, 131, 40);
        submitButton.setOpaque(false);
        submitButton.setContentAreaFilled(false);
        submitButton.setBorderPainted(false);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.setIcon(new ImageIcon("resources\\images\\others\\submit1.png"));
         submitButton.addActionListener(new labQuiz4.submitListener());
         
       nextButton.setBounds(720,410,137,41);
        nextButton.setOpaque(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setBorderPainted(false);
       nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       nextButton.setIcon(new ImageIcon("resources\\images\\others\\next1.png"));
        nextButton.addActionListener(new labQuiz4.nextListener());
        
        
        labQuiz4Banner.setIcon(new ImageIcon("resources\\images\\background\\labQuiz.png"));
        labQuiz4Banner.setBounds(250,0,800,159);

        
        Status.setIcon(new ImageIcon("resources\\images\\others\\sImage.png"));
        Status.setBounds(30, 380, 50,50);
        
        status1.setIcon(new ImageIcon(empty));
        status1.setBounds(145, 380, 50,50);
        status2.setIcon(new ImageIcon(empty));
        status2.setBounds(235, 380, 50,50);
        status3.setIcon(new ImageIcon(empty));
        status3.setBounds(330, 380, 50,50);
       
        
        labScoreShow.setBounds(700,20,200,50);
        labScoreShow.setFont(font1);
        labScoreShow.setText("Lab Score: "+labQuiz.labScore);

        
        
        
        
        panel.add(questionShow);
        panel.add(ansField);
        panel.add(submitButton);
        panel.add(nextButton);
        panel.add(labScoreShow);
        panel.add(Status);
        panel.add(status1);
         panel.add(status2);
          panel.add(status3);
      
      //  panel.add(Question);
      //  panel.add(Answer);
        panel.add(labQuiz4Banner);
        frame.add(panel);
        
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void setChoiceIndex() {
        ChoiceIndex = (Math.abs(random.nextInt()))%4;
    }
    
    private class submitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            answer=ansField.getText();
            answer.toLowerCase();
           if(answer!=null){
            //Do action if OK is pressed
            if(answer.equals(CorrectAnswer[ChoiceIndex])){
                correctMusic = new GameMusic(audioFilePath4);
    
                     correctMusic.play();
                correct1++;
                
            }
            else{
                 wrongMusic = new GameMusic(audioFilePath5);
                   wrongMusic.play();
                   
                wrong1++;
                            
            }
        
        }
            if (wrong1==1) {
                
                status1.setIcon(new ImageIcon(wrongAns));
                if (correct1==1) {
                    labQuiz.labScore+=.250;
                    status2.setIcon(new ImageIcon(correctAns));
                    nextReady=true;
                    wrong1=0;
                     GamePanel.gameOverClose=true;
                    correct1=0;
//                    status1.setIcon(new ImageIcon(empty));
//                 status2.setIcon(new ImageIcon(empty));
//                 status3.setIcon(new ImageIcon(empty));
                }
            }else if (wrong1==2) {
                status2.setIcon(new ImageIcon(wrongAns));
                if (correct1==1) {
                    labQuiz.labScore+=.125;
                    status3.setIcon(new ImageIcon(correctAns));
                    nextReady=true;
                    wrong1=0;
                     GamePanel.gameOverClose=true;
                    correct1=0;

                }
            }else if (wrong1==3) {
                status3.setIcon(new ImageIcon(wrongAns)); 
                 GamePanel.gameOverClose=true;
                frame.dispose();
            }else if (correct1==1) {
                labQuiz.labScore+=.375;
                 status1.setIcon(new ImageIcon(correctAns));
                 nextReady=true; 
                 wrong1=0;
                 GamePanel.gameOverClose=true;
                 correct1=0;
            }
     
           
        }
    }
    
    private class nextListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (nextReady==true) {
                GamePanel.gameOverClose=true;
                    frame.dispose();
            }
        }
    }
    
    
}
