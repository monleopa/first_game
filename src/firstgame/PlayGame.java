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

import java.awt.Image;
import javax.swing.JFrame;

public class PlayGame extends JFrame{
    public PlayGame(){
        setTitle("MyFirstGame");
        add(new MainGame());
        setSize(800,600);      
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new PlayGame();
    }
}
