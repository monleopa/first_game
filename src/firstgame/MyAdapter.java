/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mon
 */
public class MyAdapter extends KeyAdapter{
    private Box box;
    public MyAdapter(Box box){
        this.box = box;
    }
    
    public void keyPressed(KeyEvent e){
        box.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e){
        box.keyReleased(e);
    }
}
