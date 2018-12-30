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
public interface Chung {
    public enum STT {UP,DOWN,LEFT,RIGHT};
    public final int WIDTH = 800;
    public final int HEIGHT = 600;
    public int ENEMY_SPEED = 3;     // tốc độ enemy
    public final int DELAY = 10;
}
