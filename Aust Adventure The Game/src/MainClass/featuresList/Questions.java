package MainClass.featuresList;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Sagor Ahamed
 */
public class Questions {
    Image image;
    int x, y, h, w;
    public boolean isAvailable = true; 

    public Questions(int startX, int startY, String loaction) {
            x = startX;
            y = startY;
            ImageIcon questionImage = new ImageIcon(loaction);
            image = questionImage.getImage();
            
    }
    
    public Rectangle getBounds(){
    
        return new Rectangle(x, y, 30,49);
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public boolean Available(){
        return isAvailable;
    }
    
    public Image getImage(){
        return image;
    }
    
    public void move(int dx, int left){ //dx is the actual move ment of user
        
        if(dx == 1 && !((left + dx) < 150))
        x = x - dx;  
    }
    
    
}
