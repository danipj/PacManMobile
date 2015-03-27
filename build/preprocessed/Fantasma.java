
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u11158
 */
public class Fantasma extends Entidade{
    private boolean fugindo;
    private boolean saiu;
    private int direcao;
    public Fantasma(Sprite spr, int x, int y){     
       this.setSprite(spr);
       this.setPosition(x, y);
       this.saiu = false;
       this.fugindo=false;
       
    }
    public int getDirecao(){
    return direcao;
    }
    
    public void setDirecao(int d){
    this.direcao = d;
    }
    
    public boolean getSaiu(){
    return this.saiu;}
    
    public void setSaiu(boolean s){
    this.saiu = s;
    }
    
    public void setFugindo(boolean v){
    fugindo = v;
    }
    
    public boolean getFugindo(){
    return fugindo;
    }
}
