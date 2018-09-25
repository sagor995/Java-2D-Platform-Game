/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass.featuresList;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Sagor Ahamed
 */
public class Coin {
    int x;
    int y;
    Image image;
    public boolean visiable =true;
    
    public Coin(int startX, int startY) {
        x = startX;
        y = startY;
        ImageIcon coinImage = new ImageIcon("resources\\images\\others\\coin1.gif");
        image = coinImage.getImage();
    }
    
    public Rectangle getBounds(){
    
        return new Rectangle(x, y, 30,30);
    }
    
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public boolean getVisible(){
        return visiable;
    }
    
    public Image getImage(){
        return image;
    }
    
    public void move(int dx, int left){ //dx is the actual move ment of user
        
        if(dx == 1 && !((left + dx) < 150))
        x = x - dx;  
    }
    
    
}
