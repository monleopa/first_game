/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mon
 */
public class MainGame extends JPanel implements ActionListener{     // Nhận action từ người dùng

    private Timer timer;
    private int DELAY = 10;     // khoảng thời gian nghỉ giữa các vòng lặp (ms)
    private Box box;
//    private Enemy enemy;
    private ArrayList <Coin> coin;
    private ArrayList <Enemy> enemy;
    private boolean inGame;
    private int score;
    
    public MainGame(){
        inGame = true;
        score = 0;
        setFocusable(true);;
        box = new Box(50,50);
        setFocusable(true);
        setBackground(Color.lightGray);
        setDoubleBuffered(true);
        enemy = new ArrayList <Enemy>();
        coin = new ArrayList <Coin> ();
        inEnemy();
        inCoin();
        MyAdapter adapter = new MyAdapter(box);
        addKeyListener(adapter);
        timer = new Timer(DELAY, this);
        timer.start();      // khởi động timer, dùng timer như 1 thread
    }
    
        // tạo ra enemy random
    private void inEnemy() {    
        int inX = (int) (Math.random()*(Chung.WIDTH - 50));
        int inY = (int) (Math.random()*(Chung.HEIGHT - 50));
        Enemy enemy2 = new Enemy(inX,inY);
        enemy.add(enemy2);
    }
    
    // tạo ra eat random
    private void inCoin(){
        int inX = (int) (Math.random()*(Chung.WIDTH - 50));
        int inY = (int) (Math.random()*(Chung.HEIGHT - 50));
        Coin coin2 = new Coin(inX,inY);
        coin.add(coin2);
    }
    
    protected void paintComponent(Graphics g){      // vẽ ảnh lên màn hình
        super.paintComponent(g);
        if(inGame){
            drawOject(g);
        }
        else{
            drawGameOver(g);
        }
        
    }
    
    private void drawOject(Graphics g){
        g.drawImage(box.getImage(), box.getX(), box.getY(), this);
        for(Enemy enemy2 : enemy){
            g.drawImage(enemy2.getImage(), enemy2.getX(), enemy2.getY(), this);
        }
        
        for(Coin coin2 : coin){
            g.drawImage(coin2.getImage(), coin2.getX(), coin2.getY(), this);
        }
        
        Font font = new Font("Arial",Font.BOLD,12);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Your Score: " + score, 5, 15);
    }
    
    private void drawGameOver(Graphics g) {
        Font font = new Font("Arial",Font.BOLD,25);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString("GAME OVER!", 250, 200);
        g.drawString("Your Score: " + score, 270, 250);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    //
        box.move();
        inGame();
        checkCollision();
        updateYou();
        updateEnemy();
        repaint();
    }
    
    private void inGame() {
        if(!inGame){
            timer.stop();
        }
    }

    private void updateYou() {
        box.move();
    }


    private void updateEnemy() {
        for (int i = 0; i < enemy.size(); i++) {
            Enemy enemy2 = enemy.get(i);
            if(enemy2.isVisible()){
                enemy2.move();
            }
        }
    }
    
    public void checkCollision(){
        Rectangle boxBound = box.getBound();
        for(Enemy enemy2 : enemy){
            Rectangle enemyBound = enemy2.getBound();
            if(boxBound.intersects(enemyBound)) {
                inGame  = false;
            }
        }   
        
//        for (int i = 0; i<coin.size(); i++) {
//            Coin coin2 = coin.get(i);
//            Rectangle coinBound = coin2.getBound();
//            if(boxBound.intersects(coinBound)) {
//                score++;
//                
//            }
//        }

        for(Coin coin2 : coin){
            Rectangle coinBound = coin2.getBound();
            if(boxBound.intersects(coinBound)) {
                score++;
                coin.remove(coin2);
                inEnemy();
                inCoin();
            }
        }
        
    }
    
}
