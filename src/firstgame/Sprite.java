/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
 *
 * @author Mon
 */
public class Sprite {
    protected int x,y,w,h;
    protected Image image;
    protected boolean vsb;
    
    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        vsb = true;
    }
    
    public void loadImg(String fileName){
        ImageIcon img = new ImageIcon(fileName);
        image = img.getImage();
    }
    
    public void getImageDimention() {
        w = image.getWidth(null);
        h = image.getHeight(null);
    }
    
    public boolean isVisible() {
        return vsb;
    }

    public void setVsb(boolean vsb) {
        this.vsb = vsb;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public Rectangle getBound(){        // Lấy hình chữ nhật bao quanh nhân vật
        return new Rectangle(x,y,w,h);
    }
}
