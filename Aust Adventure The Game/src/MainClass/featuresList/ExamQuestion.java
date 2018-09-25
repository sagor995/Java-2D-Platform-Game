package MainClass.featuresList;

import MainClass.GameMusic;
import MainClass.Player;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class ExamQuestion extends JPanel{
    
    private String[] Question, OptionA, OptionB, OptionC, OptionD, CorrectAnswer;
    public static float credit = (float) 0.0;
    private String answer;
    private int ChoiceIndex;
    private Random rn;
    private File file;
    private Scanner sc;
    private JFrame frame;
    private JPanel panel;
    private JRadioButton Option_A_Button, Option_B_Button, Option_C_Button, Option_D_Button;
    private JLabel dialog ,quesWinSideImage;
    private JButton SubimitButton, SkipButton;
    private ButtonGroup group;
    private Color color, buttonColor, radioColor;
    Player player;
    
    public static int correctAnsCount = 0;
    
    //emo detecting
    public static boolean correctAns = false;
    public static boolean wrongAns = false;
    
    //Music
        String audioFilePath4 = "resources\\music\\CorrectAns.wav";
    String audioFilePath5 = "resources\\music\\WrongAns.wav";
    GameMusic correctMusic, wrongMusic;
    
    public ExamQuestion() {
        
        
        
        Question = new String[4];
        OptionA = new String[4];
        OptionB = new String[4];
        OptionC = new String[4];
        OptionD = new String[4];
        CorrectAnswer = new String[4];
        
        rn=new Random();
     // jl.setIcon(new ImageIcon("resources\\images\\ques.jpg"));
     // jp.add(jl);
     //   add(jp);
    }

    
    public void setChoiceIndex() {
        ChoiceIndex = (Math.abs(rn.nextInt()))%4;
    }
    
   public void PhysicsExam() throws FileNotFoundException{
        
        file = new File("resources\\question\\Physics.txt");
        
        this.sc= new Scanner(file);
        
    }
    
    public void JavaExam() throws FileNotFoundException{
        
        file = new File("resources\\question\\java.txt");
        
        this.sc= new Scanner(file);
        
    }
    public void ChemistryExam() throws FileNotFoundException{
        
        file = new File("resources\\question\\Chemistry.txt");
        
        this.sc= new Scanner(file);
        
    }
    public void HumExam() throws FileNotFoundException{
        
        file = new File("resources\\question\\Hum.txt");
        
        this.sc= new Scanner(file);
        
    }
    public void CProgram() throws FileNotFoundException{
        
        file = new File("resources\\question\\C.txt");
        
        this.sc= new Scanner(file);
        
    }
    
    public void LabExam() throws FileNotFoundException{
        
        file = new File("resources\\question\\Lab.txt");
        
        this.sc= new Scanner(file);
        
    }

    public void showQuestion() throws FileNotFoundException{
        
        for(int i=0;i<4;i++){
            Question[i]=sc.nextLine();
            OptionA[i]=sc.nextLine();
            OptionB[i]=sc.nextLine();
            OptionC[i]=sc.nextLine();
            OptionD[i]=sc.nextLine();
            CorrectAnswer[i]=sc.nextLine();
        }
        
        setChoiceIndex();
        
        CreateQuestionFrame();
        
    }
    
    public void CreateQuestionFrame(){
        
        
        
        
        frame = new JFrame("Answer the question!");
        
        panel = new JPanel();
        quesWinSideImage = new JLabel();
        color = new Color(0,159,250);
        buttonColor = new Color(255,255,255);
        radioColor = new Color(255,255,255);
        
        
        Option_A_Button = new JRadioButton(OptionA[ChoiceIndex]);
        Option_A_Button.setBackground(radioColor);
        Option_B_Button = new JRadioButton(OptionB[ChoiceIndex]);
        Option_B_Button.setBackground(radioColor);
        Option_C_Button = new JRadioButton(OptionC[ChoiceIndex]);
        Option_C_Button.setBackground(radioColor);
        Option_D_Button = new JRadioButton(OptionD[ChoiceIndex]);
        Option_D_Button.setBackground(radioColor);
        
        SubimitButton = new JButton();
        SubimitButton.setBackground(buttonColor);
        
        SkipButton = new JButton();
        SkipButton.setBackground(buttonColor);
        
        quesWinSideImage.setIcon(new ImageIcon("resources\\images\\others\\queswin1.gif"));
        
         quesWinSideImage.setBounds(600, 80, 255, 330);
        panel.add(quesWinSideImage);
        
        
        Font font1 = new Font("SansSerif", Font.BOLD, 25);
        
        dialog = new JLabel(Question[ChoiceIndex]);
        dialog.setFont(font1);
        frame.setSize(900, 500);
        
        frame.setResizable(false);
        
       
        
        panel.setLayout(null);
        panel.setBackground(color);
        
        dialog.setBounds(30,0,800,50);
        panel.add(dialog);
        
        Font font2 = new Font("SansSerif", Font.BOLD, 15);
        
        Option_A_Button.setBounds(25, 80, 500, 50);
        Option_A_Button.setFont(font2);
        panel.add(Option_A_Button);
        Option_B_Button.setBounds(25, 150, 500, 50);
        Option_B_Button.setFont(font2);
        panel.add(Option_B_Button);
        Option_C_Button.setBounds(25, 220, 500, 50);
        Option_C_Button.setFont(font2);
        panel.add(Option_C_Button);
        Option_D_Button.setBounds(25, 290, 500, 50);
        Option_D_Button.setFont(font2);
        panel.add(Option_D_Button);
        
        SubimitButton.setBounds(25, 370, 131, 40);
        SubimitButton.setIcon(new ImageIcon("resources\\images\\others\\submit1.png"));
        SubimitButton.addActionListener(new OKListener());
        panel.add(SubimitButton);
        SkipButton.setBounds(395, 370, 131, 40);
        SkipButton.setIcon(new ImageIcon("resources\\images\\others\\skip1.png"));
        SkipButton.addActionListener(new CancelListener());
        panel.add(SkipButton);
        
        group = new ButtonGroup();
        group.add(Option_A_Button);
        group.add(Option_B_Button);
        group.add(Option_C_Button);
        group.add(Option_D_Button);
        group.add(SubimitButton);
        group.add(SkipButton);
        
        
        

        frame.setVisible(true);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
         frame.add(panel);

    }

    private class OKListener implements ActionListener{
        
        float addPoint = (float) .625;
        @Override
        public void actionPerformed(ActionEvent e) {
            
            // first time no button will be selected
            answer = null;
            //Do function if OK Button is pressed
            if(Option_A_Button.isSelected()){
                answer = "a";
            }
            else if(Option_B_Button.isSelected()){
                answer = "b";
            }
            else if(Option_C_Button.isSelected()){
                answer = "c";
            }
            else if(Option_D_Button.isSelected()){
                answer = "d";
            }
            else answer = null;
            
            if(answer!=null){
                //Do action if an answer is pressed
                if(answer.equals(CorrectAnswer[ChoiceIndex])){
                    //Do action if answer is correct
                    correctAns = true;
                    wrongAns =false;
                    correctMusic = new GameMusic(audioFilePath4);
    
                     correctMusic.play();
            correctAnsCount++;
            //energy will be loose
             player.energy =player.energy-8;
            credit += addPoint;
                    frame.setVisible(false);
                    
                }
                else{
                     wrongAns = true;
                     correctAns = false;
                    //Do action if answer is incorrect
                        wrongMusic = new GameMusic(audioFilePath5);
                   wrongMusic.play();
            player.energy =player.energy-8;
            frame.setVisible(false);
                }
                
               
        
            }
            else{
                //Do action if no answer is pressed
                JOptionPane.showMessageDialog(null, "You miss the exam");
            frame.setVisible(false);
            }
        }
        
    }
    
    private class CancelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "You miss the exam");
            frame.setVisible(false);
            
        }
    }
    


     
}
