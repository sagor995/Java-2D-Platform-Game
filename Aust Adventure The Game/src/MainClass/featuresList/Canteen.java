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
public class Canteen {

    public int x, y;
    public int p, q;
    Image image, image2;
    public static boolean canteenLogovisiable = false;
    public static boolean allTimecanteenLogovisiable = false;

    public Canteen(int startX, int startY) {
        x = startX;
        y = startY;
        ImageIcon canteenImage = new ImageIcon("resources\\images\\canteenFoods\\canteenlogo2.png");
        image = canteenImage.getImage();
    }

    public Canteen() {
        p = 950;
        q = 15;
        ImageIcon allTimecanteenImage = new ImageIcon("resources\\images\\canteenFoods\\canteen1.png");
        image2 = allTimecanteenImage.getImage();
    }

    public int canteenX() {
        return x;
    }

    public int canteenY() {
        return y;
    }

    public int allTimecanteenX() {
        return p;
    }

    public int allTimecanteenY() {
        return q;
    }

    public boolean allTimecanteenVisible() {
        return allTimecanteenLogovisiable;
    }

    public boolean canteenVisible() {
        return canteenLogovisiable;
    }

    public Image allTimegetImage() {
        return image2;
    }

    public Image getImage() {
        return image;
    }

}
