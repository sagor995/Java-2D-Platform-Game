package MainClass;

import MainClass.featuresList.ExamQuestion;
import MainClass.featuresList.labQuiz;
import MainClass.featuresList.Canteen;
import MainClass.featuresList.labExam;
import MainClass.featuresList.Questions;
import MainClass.featuresList.Coin;
import MainClass.featuresList.Emos;
import MainClass.featuresList.CanteenFood2;
import MainClass.menuItems.UserName;
import MainClass.menuItems.highScores;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Sagor Ahamed
 */
public class GamePanel implements ActionListener {

    JFrame frame;
    JPanel panel;

    Player player;
    highScores hScores;
    Image image;
    static Timer time;
    public static Timer time2;
    int v = 448;
    Thread animator;
    ExamQuestion examQuestion = new ExamQuestion();
    public static int point =0; //for coin collect counting
    int counter = 0;
    boolean canteenAppear = false;
    boolean allTimecanteenAppear = false;
    static boolean menuMode = false;

    //after game end cantten will not open
    boolean canteenOpen = false;

    //Exam Question object
    Questions questions;
    Questions questions2;
    Questions questions3;
    Questions questions4;
    Questions questions5;
    labExam labSir;

    CanteenFood2 canteenFood;

    //Canteen logo
    Canteen canteenlogo;
    Canteen canteenAllTimeAppear;

    Emos emoIcon, emoCorrect, emoWrong;

    public static boolean gameOverClose=false;
    
    Random rn = new Random();
    static ArrayList coins;
public static float tScore;
    //logo for game pause and game over
    Image gamePause = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\paused.png");
    Image gameOver = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\gameover.gif");
    Image gameWin = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\congrats3.gif");
    Image semester1_1 = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\semester1.gif");

    
    Image sound_on = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\Sound-on.png");
    Image sound_off = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\Sound-off.png");
    
    //logo for time, coin, c/a,credit,energy
    Image creditShow = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\credit.png");
    Image coinShow = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\coin1.gif");
    Image energyShow = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\energy1.png");
    Image timeShow = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\time.png");
    Image caShow = Toolkit.getDefaultToolkit().getImage("resources\\images\\others\\ca.png");

    //Music
    static String audioFilePath3 = "resources\\music\\quesCol.wav";
    static GameMusic backgroundMusic = new GameMusic("resources\\music\\level1.wav");

    GameMusic coinCollect, quesCollision, gangnamMusic;

    static InputStream in;
    static AudioStream as;

    public GamePanel() {
        frame = new JFrame();
        panel = new MyRectangleJPanel();

        try {
            in = new FileInputStream("resources\\music\\level1.wav");
            as = new AudioStream(in);
            AudioPlayer.player.start(as);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        //level1.mp3.mid
        //Background Music
        player = new Player();
        frame.addKeyListener(new AL());
        frame.addMouseListener(new MouseClickedListener());
        //frame.setFocusable(true);

        frame.setSize(1280, 720);

        ImageIcon imageIcon = new ImageIcon("resources\\images\\background\\bg2.png");
        image = imageIcon.getImage();  // image var store my bg image
        time = new Timer(5, this);      //in every 5 mili sec its going to update our image
        time.start(); //this will run a method for action performed

        questions = new Questions(650, 330, "resources\\images\\others\\ques.gif");
        questions2 = new Questions(650, 330, "resources\\images\\others\\ques.gif");
        questions3 = new Questions(650, 330, "resources\\images\\others\\ques.gif");
        questions4 = new Questions(650, 330, "resources\\images\\others\\ques.gif");
        questions5 = new Questions(650, 330, "resources\\images\\others\\ques.gif");

        labSir = new labExam(650, 420, "resources\\images\\players\\labSir.png");
        
        
        //gangnamMusic = new GameMusic("resources\\music\\gangnam.wav");
        //Emos Declare
        emoIcon = new Emos(1130, 130, "resources\\images\\emos\\icon1.png");
        emoCorrect = new Emos(1130, 130, "resources\\images\\emos\\icon2.png");
        emoWrong = new Emos(1130, 130, "resources\\images\\emos\\icon3.png");

        //canteen logo
        canteenlogo = new Canteen(580, 200);
        canteenAllTimeAppear = new Canteen();

        coins = new ArrayList();

        time2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                counter++;
                if (counter % 15 == 0) {
                    show();
                    show();
                    show();
                    show();
                    show();

                }
                /*
               //gangnam music
                if (counter == 100) {
                    
            gangnamMusic.play();
                }
                 */
            }
        });
        time2.start();

        //  gangnamStyle = gangnamStyleIcon.getImage();
        frame.add(panel);

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static ArrayList getCoins() {
        return coins;
    }

    //coin show method
    public void show() {
        //(int) (Math.random() * 400 + 125),(int) (Math.random() * 210 + 140)
        Coin coinN = new Coin((int) (Math.random() * 300 + 300), (int) (Math.random() * 330 + 330));
        coins.add(coinN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            checkCollisions();
        } catch (NullPointerException et) {
            et.printStackTrace();
        }

        try {
            ArrayList coins = getCoins();
            for (int i = 0; i < coins.size(); i++) {
                Coin m = (Coin) coins.get(i);
                if (m.getVisible() == true) {
                    m.move(player.getdx(), player.getleft());
                } else {
                    coins.remove(i);
                }
            }
        } catch (NullPointerException es) {
        }

        System.out.println("x: " + player.x);
        // System.out.println("left: "+player.left);
        //System.out.println("y: "+player.y);
        //System.out.println("mouseX: " + player.mouseX);
        player.move();

        // 1st Question will be showed
        if (player.x > 400) {
            questions.move(player.getdx(), player.getleft());
        }
        // 2nd Question will be showed
        if (player.x > 1600) {
            questions2.move(player.getdx(), player.getleft());
        }
        // 3rd Question will be showed
        if (player.x > 3200) {
            questions3.move(player.getdx(), player.getleft());
        }
        // 4th Question will be showed
        if (player.x > 4800) {
            questions4.move(player.getdx(), player.getleft());
        }
        // 5th Question will be showed
        if (player.x > 6400) {
            questions5.move(player.getdx(), player.getleft());
        }

        if (player.x > 8000) {
            labSir.move(player.getdx(), player.getleft());
        }

        //Game Over player will be stoped 
        if (player.x > 8500 || counter == 250) {

            player.left = 40;
            player.dy = 0;
        }
        frame.validate(); // because you added panel after setVisible was called
        frame.repaint();
    }

    public void checkCollisions() {

        Rectangle q1 = questions.getBounds();
        Rectangle q2 = questions2.getBounds();
        Rectangle q3 = questions3.getBounds();
        Rectangle q4 = questions4.getBounds();
        Rectangle q5 = questions5.getBounds();

        Rectangle l1 = labSir.getBounds();

        Rectangle p1 = new Rectangle(((2 * player.left + 81) / 2) - 25, (2 * v + 30) / 2, 3, 8);
        Rectangle p2 = new Rectangle(player.left, v + 20, 51, 222);
        ArrayList coins = getCoins();
        try {
            for (int i = 0; i < coins.size(); i++) {
                Coin m = (Coin) coins.get(i);
                Rectangle m1 = m.getBounds();
                if (p2.intersects(m1)) {
                    coinCollect = new GameMusic("resources\\music\\Coins.wav");
                    coinCollect.play();
                    m.visiable = false;
                    point++;
                }
            }
        } catch (NullPointerException ef) {
        }

        //Lab Exam
        if (p1.intersects(l1) && labSir.Available()) {
            try {
                Thread.sleep(1000);            //Question Collision Music
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            quesCollision = new GameMusic(audioFilePath3);
            quesCollision.play();

            labSir.labIsAvailable = false;
            try {
                labQuiz labQuiz = new labQuiz();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(nchecking.class.getName()).log(Level.SEVERE, null, ex);

            }
            //After Collision player will stop
            player.dx = 0;
            player.dy = 0;

        }

        //1st Exam
        if (p1.intersects(q1) && questions.Available()) {
            try {
                Thread.sleep(1000);            //Question Collision Music
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            quesCollision = new GameMusic(audioFilePath3);
            quesCollision.play();

            questions.isAvailable = false;
            try {

                examQuestion.PhysicsExam();
                examQuestion.showQuestion();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            //After Collision player will stop
            player.dx = 0;
            player.dy = 0;

        }

        //2nd Exam
        if (p1.intersects(q2) && questions2.Available()) {

            //To Stop the player
            try {
                Thread.sleep(1000);            //Question Collision Music
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            quesCollision = new GameMusic(audioFilePath3);
            quesCollision.play();

            questions2.isAvailable = false;

            try {
                examQuestion.JavaExam();
                examQuestion.showQuestion();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            //After Collision player will stop
            player.dx = 0;
            player.dy = 0;
        }

        //3rd Exam
        if (p1.intersects(q3) && questions3.Available()) {
            try {
                Thread.sleep(1000);            //Question Collision Music
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            quesCollision = new GameMusic(audioFilePath3);
            quesCollision.play();

            questions3.isAvailable = false;
            try {
                examQuestion.HumExam();
                examQuestion.showQuestion();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            //After Collision player will stop
            player.dx = 0;
            player.dy = 0;
        }

        //4th Exam
        if (p1.intersects(q4) && questions4.Available()) {
            try {
                Thread.sleep(1000);            //Question Collision Music
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            quesCollision = new GameMusic(audioFilePath3);
            quesCollision.play();

            questions4.isAvailable = false;
            try {
                examQuestion.ChemistryExam();
                examQuestion.showQuestion();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            //After Collision player will stop
            player.dx = 0;
            player.dy = 0;
        }

        //5th Exam
        if (p1.intersects(q5) && questions5.Available()) {
            try {
                Thread.sleep(1000);            //Question Collision Music
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            quesCollision = new GameMusic(audioFilePath3);
            quesCollision.play();

            questions5.isAvailable = false;
            try {

                examQuestion.CProgram();
                examQuestion.showQuestion();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            //After Collision player will stop
            player.dx = 0;
            player.dy = 0;
        }

    }

    boolean k = false;

    class MyRectangleJPanel extends JPanel implements Runnable {

        public void paint(Graphics graphics) {

            
            
            
            if (player.dy == 1 && k == false) {
                k = true;
                animator = new Thread(this);
                animator.start();
            }
            super.paint(graphics);
            Graphics2D graphics2D = (Graphics2D) graphics; //Casts Graphics2d onto our Graphics

            if ((player.getX() - 1005) % 4200 == 0) {
                player.nx = 0;
            }
            if ((player.getX() - 3200) % 4200 == 0) {
                player.nx2 = 0; //length of actual bd 
            }
            graphics2D.drawImage(image, 1265 - player.nx2, 0, null); // Bg Draw
            //System.out.println(player.getX()); // to check the ending point
            if (player.getX() >= 1005) {
                graphics2D.drawImage(image, 1265 - player.nx, 0, null);
            }

            graphics2D.drawImage(player.getImage(), player.left, v, null); //draw player

            if (player.x > 400) {
                if (questions.Available() == true) {
                    graphics2D.drawImage(questions.getImage(), questions.getX(), questions.getY(), null);
                }
            }
            if (player.x > 1600) {
                if (questions2.Available() == true) {
                    graphics2D.drawImage(questions2.getImage(), questions2.getX(), questions2.getY(), null);
                }
            }
            if (player.x > 3200) {
                if (questions3.Available() == true) {
                    graphics2D.drawImage(questions3.getImage(), questions3.getX(), questions3.getY(), null);
                }
            }
            if (player.x > 4800) {
                if (questions4.Available() == true) {
                    graphics2D.drawImage(questions4.getImage(), questions4.getX(), questions4.getY(), null);
                }
            }
            if (player.x > 6400) {
                if (questions5.Available() == true) {
                    graphics2D.drawImage(questions5.getImage(), questions5.getX(), questions5.getY(), null);
                }
            }

            if (player.x >8000) {
                if (labSir.Available() == true) {
                    graphics2D.drawImage(labSir.getImage(), labSir.getX(), labSir.getY(), null);
                }
            }

           
            
            //emos
            if (examQuestion.correctAns == false && examQuestion.wrongAns == false) {
                graphics2D.drawImage(emoIcon.getImage(), emoIcon.getX(), emoIcon.getY(), null);
            } else if (examQuestion.correctAns == true && examQuestion.wrongAns == false) {

                graphics2D.drawImage(emoCorrect.getImage(), emoCorrect.getX(), emoCorrect.getY(), null);
            } else if (examQuestion.correctAns == false && examQuestion.wrongAns == true) {
                graphics2D.drawImage(emoWrong.getImage(), emoWrong.getX(), emoWrong.getY(), null);
            }

            //Canteen logo appear
            if (player.x >= 50) {
                canteenAllTimeAppear.allTimecanteenLogovisiable = true;
            }

            if (canteenAllTimeAppear.allTimecanteenVisible() == true) {
                graphics2D.drawImage(canteenAllTimeAppear.allTimegetImage(), canteenAllTimeAppear.allTimecanteenX(), canteenAllTimeAppear.allTimecanteenY(), null);
            }

            if (allTimecanteenAppear == true) {

                allTimecanteenAppear = false;

                canteenFood = new CanteenFood2();
                canteenFood.setVisible(true);
                //After Collision player will stop
                player.dx = 0;
                player.dy = 0;

            }

            if (player.energy <= 30 && player.energy >= 0) {
                canteenlogo.canteenLogovisiable = true;
                canteenOpen = true;
            } else {
                canteenlogo.canteenLogovisiable = false;
                canteenOpen = false;
            }

            if (gameOverClose==false) {
                if (canteenlogo.canteenVisible() == true) {
                graphics2D.drawImage(canteenlogo.getImage(), canteenlogo.canteenX(), canteenlogo.canteenY(), null);
            }
            }
            
            if (canteenAppear == true) {

                canteenAppear = false;

                canteenFood = new CanteenFood2();
                canteenFood.setVisible(true);

                //After Collision player will stop
                player.dx = 0;
                player.dy = 0;

            }

            //Canteen Work End
            ArrayList coins = getCoins();
            for (int i = 0; i < coins.size(); i++) {
                Coin m = (Coin) coins.get(i);
                graphics2D.drawImage(m.getImage(), m.getX(), m.getY(), null);
                if (player.x > 8200 || counter == 85) {
                    m.visiable = false;
                }
            }

            //Time, credit. C/A, Energy, Coin
            graphics2D.setColor(new Color(27, 156, 255));
            // graphics2D.setColor(new Color(0, 182, 255));
            graphics2D.setFont(new Font("BatmanForeverAlternate", Font.BOLD, 22));

            //Energy;
            graphics2D.drawImage(energyShow, 30, 135, null);
            graphics2D.setColor(new Color(236, 23, 8));
            graphics2D.fillRect(65, 140, 301, 34);//inside  Red
            graphics2D.setColor(new Color(0, 0, 0));
            graphics2D.drawRect(65, 140, 302, 35); //border
            graphics2D.setColor(new Color(19, 206, 6));
            graphics2D.fillRect(65, 140, (int) player.energy * 3, 34); // upeer red 

            //all font color
            graphics2D.setColor(Color.BLACK);

            //Coin
            graphics2D.drawImage(coinShow, 30, 10, null);
            graphics2D.drawString(" = " + point, 65, 31);

            //Counter Timer
            // graphics2D.drawImage(timeShow,955,15,null);
            //graphics2D.drawString(" = "+(int)counter+ " Sec",990, 40);
            graphics2D.drawImage(timeShow, 1135, 15, null);
            graphics2D.drawString(" = " + (int) counter + " ", 1170, 40);

            //C/A
            // graphics2D.drawImage(caShow, 950,70,null);
            // graphics2D.drawString(" = "+ExamQuestion.correctAnsCount+"/5" ,990, 100);
            graphics2D.drawImage(caShow, 1125, 70, null);
            graphics2D.drawString(" = " + ExamQuestion.correctAnsCount + "/5", 1155, 100);

            //CGPA 
            graphics2D.drawImage(creditShow, 30, 60, this);
            graphics2D.drawString(" = " + ExamQuestion.credit, 65, 95);

            //Question
            Font pfont = new Font("BatmanForeverAlternate", Font.PLAIN, 20);
            graphics2D.setFont(pfont);
            graphics2D.setColor(new Color(255, 255, 255));
            graphics2D.drawString("Player: " + UserName.playerName, 76, 165);

            //Energy Bar
            //  graphics2D.drawString("Energy: "+(int)player.energy+"%", 25, 90);
            //window colsing logic
            if (Player.menuMode2 == true) {
                gameOverClose=false;
                point = 0;
                ExamQuestion.credit = (float) 0.0;
                counter = 0;
                ExamQuestion.wrongAns = false;
                ExamQuestion.correctAns = false;
                ExamQuestion.correctAnsCount = 0;
                Player.energy = 100;
                Player.menuMode2 = false;
                GamePanel.menuMode=false;
                UserName.playerSelected1 = false;
                UserName.playerSelected2 = false;
                UserName.playerSelected3 = false;
                UserName.playerSelected4 = false;
                player.gamePause = false;
                UserName.playerName = null;
                frame.dispose();
                frame.setVisible(false);
                GameMenu mn = new GameMenu();
            }

            //Sound stop by control
            graphics2D.drawImage(sound_on, 1070, 135, null);
            if (player.soundStop==true) {
                 AudioPlayer.player.stop(as);
                  graphics2D.drawImage(sound_off, 1070, 135, null);
            }else{
             AudioPlayer.player.start(as);
              graphics2D.drawImage(sound_on, 1070, 135, null);
            }
            
            
            //Game Over
            if (counter == 250 || player.x > 8500 || gameOverClose==true) {
                gameOverClose=true;
                AudioPlayer.player.stop(as);

                Player.gamePause = false;
                menuMode = true;
                time2.stop();
                //float finalCGPA = ExamQuestion.credit/100;
                canteenOpen = false;
                
                 Font font1 = new Font("BatmanForeverAlternate", Font.BOLD, 40);
                //Total Score
               tScore = (ExamQuestion.credit + labQuiz.labScore);  
                
                 graphics2D.setFont(font1);
                 graphics2D.setColor(new Color(255,255,255));
                 
                 
                if (tScore>=3.0 && tScore <=4.0) {
                     //graphics2D.drawString("Game Over : ", 340, 230);
                graphics2D.drawImage(gameWin, 250, 170, null);
                graphics2D.drawString("CGPA: " + tScore, 550, 465);
                }else{
                graphics2D.drawImage(gameOver, 340, 230, null);
                graphics2D.drawString("CGPA: " + tScore, 470, 360);
                }
                

                // graphics2D.drawImage(gangnamStyle,870, 265, null);
                //graphics2D.setColor(Color.BLACK);
                //graphics2D.drawString("Press Enter" , 320, 520);
                menuMode = true;
                //gangnamMusic.play();
            
            } else {
                canteenOpen = true;
            }

            //After game start this icon will be shown
            if (counter <= 4) {
                graphics2D.drawImage(semester1_1, 350, 220, null);
            }
            //game pause icon appear condition
            if (player.gamePause == true) {
                time.stop();
                time2.stop();
                graphics2D.drawImage(gamePause, 450, 300, null);
            }
        }

        //here
        public void run() {
            long beforeTime, timeDiff, sleep;

            beforeTime = System.currentTimeMillis();
            while (done == false) {   // while we have'nt completed our jump
                cycle();
                timeDiff = System.currentTimeMillis() - beforeTime;
                sleep = 10 - timeDiff;
                if (sleep < 0) {
                    sleep = 2;
                }
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                beforeTime = System.currentTimeMillis();
            }
            done = false;
            h = false;
            k = false;
        }
        boolean h = false;
        boolean done = false;

        public void cycle() {
            if (h == false) {
                v--;
            }
            if (v == 350) {
                h = true;
            }
            if (h == true && v <= 448) {
                v++;
                if (v == 448) {
                    done = true;
                }

                if (UserName.playerSelected1 == true) {
                    player.image2 = player.player1RightMove.getImage();
                    player.image2 = player.player1Right.getImage();
                } else if (UserName.playerSelected2 == true) {
                    player.image2 = player.player2RightMove.getImage();
                    player.image2 = player.player2Right.getImage();
                } else if (UserName.playerSelected3 == true) {
                    player.image2 = player.player3RightMove.getImage();
                    player.image2 = player.player3Right.getImage();
                } else if (UserName.playerSelected4 == true) {
                    player.image2 = player.player4RightMove.getImage();
                    player.image2 = player.player4Right.getImage();
                }

            }
        }

    }

    private class MouseClickedListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            //player.mouseClicked(event);
            int p = e.getX();
            int q = e.getY();
            System.out.println("Mouse clicked at " + e.getX() + ", " + e.getY());
            if (canteenOpen == true && p > (canteenlogo.x) && p < (canteenlogo.x + 100) && q > (canteenlogo.y) && q < (canteenlogo.y + 26)) {
                canteenAppear = true;
                time2.stop();
            }
            if (canteenOpen == true && p > (canteenAllTimeAppear.p) && p < (canteenAllTimeAppear.p + 100) && q > (canteenAllTimeAppear.q) && q < (canteenAllTimeAppear.q + 100)) {
                allTimecanteenAppear = true;
                time2.stop();
            }

        }
    }

    private class AL extends KeyAdapter {
        //ActionListener

        public void keyReleased(KeyEvent k) {
            player.keyReleased(k);

        }

        public void keyPressed(KeyEvent k) {

            player.keyPressed(k);
        }

    }

}
