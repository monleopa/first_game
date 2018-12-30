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
public class Enemy extends Sprite implements Chung{
    
    private STT stt;
    
    public Enemy(int x, int y) {
        super(x, y);
        khoitaoEnemy();
    }

    private void khoitaoEnemy() {
        loadImg("images/enemy.png");
        w = image.getWidth(null);
        h = image.getHeight(null);
        int ran = (int) (Math.random()*4 + 1);
        switch(ran){
            case 1:
                stt = STT.UP;
                break;
            case 2:
                stt = STT.DOWN;
                break;
            case 3:
                stt = STT.LEFT;
                break;
            case 4:
                stt = STT.RIGHT;
                break;
        }
    }
    
    public void move(){
        if(x <= 0)          stt = STT.RIGHT;
        if(x >= WIDTH - w)   stt = STT.LEFT;
        if(y <= 0)          stt = STT.DOWN;
        if(y >= HEIGHT - h)  stt = STT.UP;  
        
        switch(stt){
            case UP:
                y -= ENEMY_SPEED;
                break;
            case DOWN:
                y += ENEMY_SPEED;
                break;
            case LEFT:
                x -= ENEMY_SPEED;
                break;
            case RIGHT:
                x += ENEMY_SPEED;
                break;
        }
    }
    
    
}
