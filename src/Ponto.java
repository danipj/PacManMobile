
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u11161
 */
public class Ponto extends Entidade{
    private boolean comido;
    public Ponto(Sprite spr, int x, int y){
        this.setSprite(spr);
        this.setPosition(x, y);
        this.comido = false;
    }
    public void setComido(){
    this.comido=true;
    }
    public boolean getComido(){
    
    return this.comido;}
}
