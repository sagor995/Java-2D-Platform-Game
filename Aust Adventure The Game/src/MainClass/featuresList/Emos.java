package MainClass.featuresList;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Sagor Ahamed
 */
public class Emos {
    Image image;
    int x, y;

    public Emos(int startX, int startY, String loaction) {
            x = startX;
            y = startY;
            ImageIcon questionImage = new ImageIcon(loaction);
            image = questionImage.getImage();
            
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Image getImage(){
        return image;
    }
    
}
