
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u11158
 */
public class Entidade {
    private Sprite texture;
    private int positionX;
    private int positionY;
    
    public Sprite getSprite(){
        return this.texture;
    }
    public void setSprite(Sprite spr){
        this.texture = new Sprite(spr);
    }    
    public void setPosition(int x, int y){
        this.texture.setPosition(x, y);
    }
    public int getX(){
        return this.texture.getX();
    }   
    public int getY(){
        return this.texture.getY();
    }   
}
