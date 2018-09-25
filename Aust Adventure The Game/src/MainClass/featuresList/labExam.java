package MainClass.featuresList;

import MainClass.Player;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Sagor Ahamed
 */
public class labExam {
    Image image1;
    int x, y, h, w;
    public boolean labIsAvailable = true; 

    public labExam(int startX, int startY, String loaction) {
            x = startX;
            y = startY;
            ImageIcon labQuestionImage = new ImageIcon(loaction);
            image1 = labQuestionImage.getImage();
            
    }
    
    public Rectangle getBounds(){
    
        return new Rectangle(x, y, 135,233);
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public boolean Available(){
        return labIsAvailable;
    }
    
    public Image getImage(){
        return image1;
    }
    
    public void move(int dx, int left){ //dx is the actual move ment of user

        if(dx == 1 && !((left + dx) < 150))
        x = x - dx;  
    }
    
    
}
