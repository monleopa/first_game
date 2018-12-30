/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

/**
 *
 * @author Mon
 */

import static firstgame.Chung.HEIGHT;
import static firstgame.Chung.WIDTH;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Box extends Sprite{
    private int dx,dy;
    private Image image;
    private final int SPEED = 2;
    
    public Box(int x, int y){
        super(x,y);
        ImageIcon img = new ImageIcon("images/box.png");
        image = img.getImage();
        w = image.getWidth(null);
        h = image.getHeight(null);
        int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
        int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
    }
    
    public void move(){
        x += dx;
        y += dy;
         
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
    

    // Nhấn nút
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();       // Nhận diện nút ấn
        switch(key){
            case KeyEvent.VK_UP:
                dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                dy = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                dx = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                dx = SPEED;
                break;
        }
    }
    
    // nhả nút
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_UP:
                dy = 0;
                break;
            case KeyEvent.VK_DOWN:
                dy = 0;
                break;
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 0;
                break;
        }
    }
    
}
