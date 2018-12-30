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
public class Coin extends Sprite{
    
    public Coin(int x, int y) {
        super(x, y);
        khoitaoCoin();
    }
    
    private void khoitaoCoin(){
        loadImg("images/coin.png");
        w = image.getWidth(null);
        h = image.getHeight(null);
    }
    
}
