/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass;

import MainClass.featuresList.ExamQuestion;
import MainClass.featuresList.Canteen;
import MainClass.featuresList.Questions;
import MainClass.menuItems.UserName;
import static MainClass.GamePanel.as;
import MainClass.featuresList.labExam;
import static MainClass.menuItems.UserName.playerName;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import sun.audio.AudioPlayer;

/**
 *
 * @author Sagor Ahamed
 */
public class Player {
    //these variable are not static so we can access them from another method
    int x,mouseX,mouseY; // how much you moved relative to your starting point
    int nx2, nx,dy;
    int left; //controls the character actual physical position on the screen
    int dx; //changing x coordinate
    int y;
    int h,w;
    Image image2;
    Questions questions;
    public static float energy = 100;
    //for puase logo
    public static boolean gamePause = false;
   static boolean menuMode2 = false;
   public static boolean sirIsWalking;
   public static int labSir = 0;
   
   //for date
   String dates;
 
    //player 1
    ImageIcon player1RightMove = new ImageIcon("resources\\images\\players\\player1r.gif");
    ImageIcon player1Right = new ImageIcon("resources\\images\\players\\player1r.png");
    ImageIcon player1LeftMove = new ImageIcon("resources\\images\\players\\player1l.gif");
    ImageIcon player1Left = new ImageIcon("resources\\images\\players\\player1l.png");
    ImageIcon player1Up = new ImageIcon("resources\\images\\players\\player1u.png");
    
    
    //player 2
    ImageIcon player2RightMove = new ImageIcon("resources\\images\\players\\player2r.gif");
    ImageIcon player2Right = new ImageIcon("resources\\images\\players\\player2r.png");
    ImageIcon player2LeftMove = new ImageIcon("resources\\images\\players\\player2l.gif");
    ImageIcon player2Left = new ImageIcon("resources\\images\\players\\player2l.png");
    ImageIcon player2Up = new ImageIcon("resources\\images\\players\\player2u.png");
    
    //player 3
    ImageIcon player3RightMove = new ImageIcon("resources\\images\\players\\player3r.gif");
    ImageIcon player3Right = new ImageIcon("resources\\images\\players\\player3r.png");
    ImageIcon player3LeftMove = new ImageIcon("resources\\images\\players\\player3l.gif");
    ImageIcon player3Left = new ImageIcon("resources\\images\\players\\player3l.png");
    ImageIcon player3Up = new ImageIcon("resources\\images\\players\\player3u.png");
    
    //player 4
    ImageIcon player4RightMove = new ImageIcon("resources\\images\\players\\player4r.gif");
    ImageIcon player4Right = new ImageIcon("resources\\images\\players\\player4r.png");
    ImageIcon player4LeftMove = new ImageIcon("resources\\images\\players\\player4l.gif");
    ImageIcon player4Left = new ImageIcon("resources\\images\\players\\player4l.png");
    ImageIcon player4Up = new ImageIcon("resources\\images\\players\\player4u.png");
    
    ExamQuestion examQuestion;
    Canteen canteenlogo;
    
    GameMusic  pauseMusic = new GameMusic("resources\\music\\playerSelects.wav");
    
    public static boolean soundStop=false;
    
    public Player() {
        if (UserName.playerSelected1 == true) {
            image2 = player1Right.getImage();
        }else if (UserName.playerSelected2 == true) {
            image2 = player2Right.getImage();
        }else if (UserName.playerSelected3 == true) {
            image2 = player3Right.getImage();
        }else if (UserName.playerSelected4 == true) {
            image2 = player4Right.getImage();
        }
        
        left = 150;
        x = 75;
        nx2 = 1265;// our bg is 700 long so it will be bit less
        nx = 0;
        y = 430;
        h = player2Up.getIconHeight();
        w = player2Up.getIconWidth();
        canteenlogo = new Canteen(580, 200);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(left, y, 51,222);
    }
    
    public void move(){
        
        
        
        if(dx!= -1){ //if player is not moving to left
            if ((left+dx) <= 150) { //control the actual image location of the character
                left += dx;
            }else{  //below var move the bg if you are at 150
        x +=dx; // for player
        nx2 +=dx; // for bg
        nx +=dx;
        
        sirIsWalking =true;
            }
        }else{
            if ((left+dx) > 0) {
                 left += dx;
            }
        }
    }

    public int getX(){
        return  x;
    }
    public int getY(){
        return  y;
    }
    public int getdx(){
        return dx;
    }
    public int getleft(){
        return left;
    }
     public int mouseX(){
        return  mouseX;
    }
    public int mouseY(){
        return  mouseY;
    }
    
    public Image getImage(){
        return image2;
    }
            
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
                if ((key == KeyEvent.VK_A) || (key ==KeyEvent.VK_LEFT))
                { dx = -1;
                    if (UserName.playerSelected1 == true) {
                        image2 = player1LeftMove.getImage();
                    }else if (UserName.playerSelected2 == true) {
                         image2 = player2LeftMove.getImage();
                      }else if (UserName.playerSelected3 == true) {
                             image2 = player3LeftMove.getImage();
                     }else if (UserName.playerSelected4 == true) {
                        image2 = player4LeftMove.getImage();
                      }
                
                        
                }
 
                if ((key == KeyEvent.VK_D)  || (key ==KeyEvent.VK_RIGHT))
                { 
 
                    dx = 1 ;
                    
                    if (UserName.playerSelected1 == true) {
                        image2 = player1RightMove.getImage();
                    }else if (UserName.playerSelected2 == true) {
                         image2 = player2RightMove.getImage();
                      }else if (UserName.playerSelected3 == true) {
                             image2 = player3RightMove.getImage();
                     }else if (UserName.playerSelected4 == true) {
                        image2 = player4RightMove.getImage();
                      }
                
                    
                    
                       // cgpa += 0.01;
                      energy -=0.05;
                      if (energy <=0) {
                        energy = 0;
                        dx = 0;
                    }
                     
                       
                }
                
                
                
                if ((key == KeyEvent.VK_W) || (key ==KeyEvent.VK_UP)) {
                    
                    
                    dy = 1;
                    if (UserName.playerSelected1 == true) {
                        image2 = player1Up.getImage();
                    }else if (UserName.playerSelected2 == true) {
                         image2 = player2Up.getImage();
                      }else if (UserName.playerSelected3 == true) {
                             image2 = player3Up.getImage();
                     }else if (UserName.playerSelected4 == true) {
                        image2 = player4Up.getImage();
                      }
                }
                
                //to make game pause
                if (key == KeyEvent.VK_SPACE) {
                  AudioPlayer.player.stop(as);
                  soundStop=true;
               AudioPlayer.player.stop(as);
                    pauseMusic.play();
                    gamePause = true;
                }
                
                //To start the game from pause
                if (key == KeyEvent.VK_R) {
                soundStop=false;
                     AudioPlayer.player.start(as);
                    pauseMusic.play();
                    gamePause = false;
                    
                   GamePanel.time.start();
                   GamePanel.time2.start();
                 }
                
                
                if (key == KeyEvent.VK_ENTER) {
            
                        
                    if (GamePanel.menuMode == true) {
                    
                      // Menu mn = new Menu();
                        menuMode2 = true;
                        try {
//                             saveNames();
//                             saveScores();
//                             saveDates();
                                saveALL();
                        
                    } catch (Exception ex) {
                       ex.printStackTrace();
                    }    
                    }
                }
                
                if (key == KeyEvent.VK_Q) {
            soundStop=true;
               AudioPlayer.player.stop(as);      
              }
                
                if (key == KeyEvent.VK_E) {
             soundStop=false;
                     AudioPlayer.player.start(as);
              }
                
                
        }
 
//          private void saveScores() throws FileNotFoundException, UnsupportedEncodingException, IOException {
//
//            PrintWriter writer = new PrintWriter( new BufferedWriter(new FileWriter("resources\\extra\\highscore.txt", true)));
//             writer.println(ExamQuestion.credit);
//              writer.close();
//        }
//          private void saveNames() throws FileNotFoundException, UnsupportedEncodingException, IOException {
//            
//            PrintWriter writer = new PrintWriter( new BufferedWriter(new FileWriter("resources\\extra\\names.txt", true)));
//             writer.println(playerName);
//              writer.close();
//           
//        }
//          
//           private void saveDates() throws FileNotFoundException, UnsupportedEncodingException, IOException {
//            
//               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        dates = sdf.format(new Date());
//            PrintWriter writer = new PrintWriter( new BufferedWriter(new FileWriter("resources\\extra\\dates.txt", true)));
//             writer.println(dates);
//              writer.close();
//           
//        }
           private void saveALL() throws FileNotFoundException, UnsupportedEncodingException, IOException {
            
                PrintWriter writeScore = new PrintWriter( new BufferedWriter(new FileWriter("resources\\extra\\highscore.txt", true)));
             writeScore.println(GamePanel.tScore);
              writeScore.close();
                
            PrintWriter writerName = new PrintWriter( new BufferedWriter(new FileWriter("resources\\extra\\names.txt", true)));
            writerName.println(playerName);
             writerName.close();
               
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dates = sdf.format(new Date());
            PrintWriter writerDate = new PrintWriter( new BufferedWriter(new FileWriter("resources\\extra\\dates.txt", true)));
              writerDate.println(dates);
              writerDate.close();
           
        }
    
   
           
    public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
 
                if ((key == KeyEvent.VK_A) || (key ==KeyEvent.VK_LEFT))
                {dx = 0;
                    if (UserName.playerSelected1 == true) {
                        image2 = player1Left.getImage();
                    }else if (UserName.playerSelected2 == true) {
                         image2 = player2Left.getImage();
                      }else if (UserName.playerSelected3 == true) {
                          image2 = player3Left.getImage();
                     }else if (UserName.playerSelected4 == true) {
                       image2 = player4Left.getImage();
                      }
                
                
                }
 
                if ((key == KeyEvent.VK_D)  || (key ==KeyEvent.VK_RIGHT))
                        {dx = 0;
                        
    
                            
                            
                             if (UserName.playerSelected1 == true) {
                        image2 = player1Right.getImage();
                    }else if (UserName.playerSelected2 == true) {
                         image2 = player2Right.getImage();
                      }else if (UserName.playerSelected3 == true) {
                          image2 = player3Right.getImage();
                     }else if (UserName.playerSelected4 == true) {
                       image2 = player4Right.getImage();
                      }
                            
                }
                
                
                if ((key == KeyEvent.VK_W) || (key ==KeyEvent.VK_UP))
                {dy = 0;
                         if (UserName.playerSelected1 == true) {
                             image2 = player1RightMove.getImage();
                            image2 = player1Right.getImage();
                    }else if (UserName.playerSelected2 == true) {
                            image2 = player2RightMove.getImage();
                              image2 = player2Right.getImage();
                      }else if (UserName.playerSelected3 == true) {
                          image2 = player3RightMove.getImage();
                            image2 = player3Right.getImage();
                     }else if (UserName.playerSelected4 == true) {
                               image2 = player4RightMove.getImage();
                            image2 = player4Right.getImage();
                      }
                         
                            labSir=0;
                }
                
                //To pause the game
                
        }

    
    
}
