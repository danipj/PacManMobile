
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.TimerTask;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

///BUGS:
//quando rotaciona a img do pacman, ele desloca alguns pixels na tela causando colisão indesejada
//fantasma rosa parou de funcionar depois do som
//TO DO:
//fantasmas perseguirem -> conseguido mas não podia ficar assim, abortado
//bolinhas distribuídas igualmente
//quando comidas todas as bolinhas, aumenta velocidade
//pontuação, frutinhas
public class PacCanvas extends GameCanvas implements Runnable{

    private boolean jogar;
    private long delay;     //  tempo de execução da thread
    private int width;
    private int height;
    private Random randomizador = new Random();
    public Image image = null;
    private pacDesign gamed;
    private Personagem player;
    private boolean parado = false;
    private boolean direita = false;
    private boolean esquerda = false;
    private boolean cima = false;
    private boolean baixo = false;
    private LayerManager layerm;          
    private Ponto[] p;
    private Ponto[]P;
    private Fantasma verm;
    private Fantasma verd;
    private Fantasma pink;
    private Fantasma orng;
    private TiledLayer mapa;
    private boolean firstRun = true;
    private int tempo =200;
    private  sommClass s1;
  
    public PacCanvas() throws IOException{
        super(true);      
        delay = 20;        
        width = getWidth();
        height = getHeight();
        gamed = new pacDesign();
        layerm = new LayerManager();
        mapa = gamed.getFinalMapa();
        player = new Personagem(gamed.getPctest1());
        player.setPosition(width/2,240);
        p =  new Ponto[300];
        P = new Ponto[4];
        P[0]= new Ponto(gamed.getPontaoo(),10,10);

        P[1]= new Ponto(gamed.getPontaoo(),mapa.getWidth()-30,10);
   
        P[2]= new Ponto(gamed.getPontaoo(),10,mapa.getHeight()-20);
     
        P[3]= new Ponto(gamed.getPontaoo(),mapa.getWidth()-20,mapa.getHeight()-20);
       
        verm = new Fantasma(gamed.getRed(),116,140);
        verd = new Fantasma(gamed.getAzul(),116,140);
        pink = new Fantasma(gamed.getRosa(),116,140);
        orng = new Fantasma(gamed.getOrange(),116,140);
        layerm.append(mapa);
        layerm.append(player.getSprite());
        layerm.append(verm.getSprite());
        layerm.append(verd.getSprite());
        layerm.append(pink.getSprite());
        layerm.append(orng.getSprite());
        this.setFullScreenMode(true);
         s1 =new sommClass("/10a7c1_Pacman_Waka_Waka_Sound_Effect.wav");
         s1.start();
     
    }
    
    public void start() {
        jogar = true;
        Thread t = new Thread(this);
        
        t.start();
    }

    public void stop() {
        jogar = false;
    }

    public void run() {
        
        Graphics g = getGraphics();       
        sommClass s = new sommClass("/c8643f_Pacman_Opening_Song_Sound_Effect.wav");
        s.start();
        try {
            drawScreen(g);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        s.toca();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        s.stop();
        while (jogar == true) {
            input();
            try {
                updatePhysics();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            updateMovement();
            try {
                drawScreen(g); 
        
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            try {
                    Thread.sleep(delay);
            } catch (InterruptedException ie) {
            }
        }

    }
    
    private void updateMovement(){
        ///pacman andando
        if(!parado){
        
        s1.toca();
        
        }
        if (esquerda){
            player.setPosition(player.getX()-2, player.getY());
        }
        else{
            if (direita){
                player.setPosition(player.getX()+2, player.getY());
            }
            else{
                if (cima){
                    player.setPosition(player.getX(), player.getY()-2);
                }
                else{
                    if (baixo){
                        player.setPosition(player.getX(), player.getY()+2);
                    }
                }
            }
        }
        ////sair da tela e voltar
        if (player.getX() > width-10){   
            player.setPosition(10, player.getY());
        }
        if (player.getX() < 0){
            player.setPosition(width-10, player.getY());
        }
        /////fantasmas andando
 
        if (verm.getSaiu()){ ////se ja saiu pode andar pelo mapa
            if(verm.getDirecao()==2) //se estiver andando pra direita
 //       if (player.getX()>verm.getX()) //se o pacman estiver mais pra frente, vai pra direita
            verm.setPosition(verm.getX()+1,verm.getY());
      
           if(verm.getDirecao()==4) //se estiver andando pra esquerda
 //              if (player.getX()<verm.getX()) //se o pacman estiver mais pra trás, anda
            verm.setPosition(verm.getX()-1,verm.getY());
     
           
         if(verm.getDirecao()==1) //se estiver indo pra cima
  //           if(player.getY()<verm.getY()) //se pacman estiver pra cima, vai pra cima
            verm.setPosition(verm.getX(),verm.getY()-1);
           
         if(verm.getDirecao()==3) //se estiver indo pra baixo
  //           if(player.getY()>verm.getY()) //se pacman estiver pra baixo, vai pra baixo
            verm.setPosition(verm.getX(),verm.getY()+1);
        }
        
        if (verd.getSaiu()){ ////se ja saiu pode andar pelo mapa
            if(verd.getDirecao()==2) //se estiver andando pra direita
 //       if (player.getX()>verd.getX()) //se o pacman estiver mais pra frente, vai pra direita
            verd.setPosition(verd.getX()+1,verd.getY());
       
           if(verd.getDirecao()==4) //se estiver andando pra esquerda
 //              if (player.getX()<verd.getX()) //se o pacman estiver mais pra trás, anda
            verd.setPosition(verd.getX()-1,verd.getY());
      
           
         if(verd.getDirecao()==1) //se estiver indo pra cima
 //            if(player.getY()<verd.getY()) //se pacman estiver pra cima, vai pra cima
            verd.setPosition(verd.getX(),verd.getY()-1);
             
         if(verd.getDirecao()==3) //se estiver indo pra baixo
  //           if(player.getY()>verd.getY()) //se pacman estiver pra baixo, vai pra baixo
            verd.setPosition(verd.getX(),verd.getY()+1);
            
        }
       if (pink.getSaiu()){ ////se ja saiu pode andar pelo mapa
            if(pink.getDirecao()==2) //se estiver andando pra direita
//        if (player.getX()>pink.getX()) //se o pacman estiver mais pra frente, vai pra direita
            pink.setPosition(pink.getX()+1,pink.getY());
        
           if(pink.getDirecao()==4) //se estiver andando pra esquerda
 //              if (player.getX()<pink.getX()) //se o pacman estiver mais pra trás, anda
            pink.setPosition(pink.getX()-1,pink.getY());
       
           
         if(pink.getDirecao()==1) //se estiver indo pra cima
 //            if(player.getY()<pink.getY()) //se pacman estiver pra cima, vai pra cima
            pink.setPosition(pink.getX(),pink.getY()-1);
             
         if(pink.getDirecao()==3) //se estiver indo pra baixo
//             if(player.getY()>pink.getY()) //se pacman estiver pra baixo, vai pra baixo
            pink.setPosition(pink.getX(),pink.getY()+1);
             
       }
        if (orng.getSaiu()){ ////se ja saiu pode andar pelo mapa
            if(orng.getDirecao()==2) //se estiver andando pra direita
 //       if (player.getX()>orng.getX()) //se o pacman estiver mais pra frente, vai pra direita
            orng.setPosition(orng.getX()+1,orng.getY());
        
           if(orng.getDirecao()==4) //se estiver andando pra esquerda
//               if (player.getX()<orng.getX()) //se o pacman estiver mais pra trás, anda
            orng.setPosition(orng.getX()-1,orng.getY());
        
           
         if(orng.getDirecao()==1) //se estiver indo pra cima
 //            if(player.getY()<orng.getY()) //se pacman estiver pra cima, vai pra cima
            orng.setPosition(orng.getX(),orng.getY()-1);
             
         if(orng.getDirecao()==3) //se estiver indo pra baixo
 //            if(player.getY()>orng.getY()) //se pacman estiver pra baixo, vai pra baixo
            orng.setPosition(orng.getX(),orng.getY()+1);
        }
        ///pra quando o fantasma morre e tem que sair da "casinha"
        if (!verm.getSaiu())
            verm.setPosition(verm.getX(), verm.getY()-1);
         if (!orng.getSaiu())
            orng.setPosition(orng.getX(), orng.getY()-1);
          if (!pink.getSaiu())
            pink.setPosition(pink.getX(), pink.getY()-1);
           if (!verd.getSaiu())
            verd.setPosition(verd.getX(), verd.getY()-1);
           
           if (verm.getY()<122 && !verm.getSaiu()){ //dá uma direção ao fantasma
               verm.setSaiu(true);
               int d=0;
               while(d==0)
                d=randomizador.nextInt(5);
            verm.setDirecao(d);
           }
           if (verd.getY()<122 && !verd.getSaiu()){
               int d=0;
               verd.setSaiu(true);
               while(d==0)
                d=randomizador.nextInt(5);
            verd.setDirecao(d);
           }
           if (pink.getY()<122 && !pink.getSaiu()){
               int d=0;
               pink.setSaiu(true);
               while(d==0)
                d=randomizador.nextInt(5);
           pink.setDirecao(d);
           }
           if (orng.getY()<122 && !orng.getSaiu()){
               int d=0;
               orng.setSaiu(true);
               while(d==0)
                d=randomizador.nextInt(5);
            orng.setDirecao(d);
           }
           
          /* ////////perseguir
           if (player.getX()-verm.getX()<30)
               verm.setDirecao(2);   //se pacman ta menos de 30px a direita, vai pra direita
           else
               if (verm.getX()-player.getX()<30)
                   verm.setDirecao(4);
           else
               if (verm.getY()-player.getY()<30)
                   verm.setDirecao(1); //mais pra cima
           else
               if (player.getY()-verm.getY()<30)
                   verm.setDirecao(3);
           
           
              if (player.getX()-verd.getX()<30)
               verd.setDirecao(2);   //se pacman ta menos de 30px a direita, vai pra direita
           else
               if (verd.getX()-player.getX()<30)
                   verd.setDirecao(4);
           else
               if (verd.getY()-player.getY()<30)
                   verd.setDirecao(1); //mais pra cima
           else
               if (player.getY()-verd.getY()<30)
                   verd.setDirecao(3);
              
              
                 if (player.getX()-pink.getX()<30)
               pink.setDirecao(2);   //se pacman ta menos de 30px a direita, vai pra direita
           else
               if (pink.getX()-player.getX()<30)
                   pink.setDirecao(4);
           else
               if (pink.getY()-player.getY()<30)
                   pink.setDirecao(1); //mais pra cima
           else
               if (player.getY()-pink.getY()<30)
                   pink.setDirecao(3);
                 
                 
                    if (player.getX()-orng.getX()<30)
               orng.setDirecao(2);   //se pacman ta menos de 30px a direita, vai pra direita
           else
               if (orng.getX()-player.getX()<30)
                   orng.setDirecao(4);
           else
               if (orng.getY()-player.getY()<30)
                   orng.setDirecao(1); //mais pra cima
           else
               if (player.getY()-orng.getY()<30)
                   orng.setDirecao(3);*/
    }
    
    private void updatePhysics() throws IOException{   
        ///////////////PM ANDANDO 
        if (colisao(player,null, mapa)){
            if (cima){
                player.setPosition(player.getX(), player.getY()+2);
                parado = true;
                cima = false;
            }
            else{
                if (direita){
                    player.setPosition(player.getX()-2, player.getY());
                    parado = true;
                    direita = false;
                }
                else{
                    if (esquerda){
                        player.setPosition(player.getX()+2, player.getY());
                        parado = true;
                        esquerda = false;
                    }
                    else{
                        if (baixo){
                            player.setPosition(player.getX(), player.getY()-2);
                            parado = true;
                            baixo = false;
                        }
                    }
                }
            }
        }
        ///////////////////////////QUANDO O PM COME AS BOLINHAS
        for(int i=0;i<p.length;i++) 
          if (p[i]!=null && colisao(player,p[i],null)){
    
          layerm.remove(p[i].getSprite());
          p[i]=null;
          }
        //////////////////QUANDO COMER PONTAO
        for(int i=0;i<P.length;i++) 
          if (colisao(player,P[i],null) && !P[i].getComido()){
          
          layerm.remove(P[i].getSprite());
         // P[i]=null;
          P[i].setComido();
          verm.setFugindo(true);
          int vermX = verm.getX();
          int vermY= verm.getY();
          layerm.remove(verm.getSprite());
             verm.setSprite(new Sprite(gamed.getFoge()));
             verm.setPosition(vermX, vermY);
             layerm.append(verm.getSprite());
         verd.setFugindo(true);
         int verdX = verd.getX();
          int verdY= verd.getY();
         layerm.remove(verd.getSprite());
             
             verd.setSprite(new Sprite(gamed.getFoge()));
             verd.setPosition(verdX,verdY);
             layerm.append(verd.getSprite());
         pink.setFugindo(true);
         int pinkX = pink.getX();
          int pinkY= pink.getY();
         layerm.remove(pink.getSprite());
             pink.setSprite(new Sprite(gamed.getFoge()));
             pink.setPosition(pinkX,pinkY);
             layerm.append(pink.getSprite());
         orng.setFugindo(true);
         int orngX = orng.getX();
          int orngY= orng.getY();
         layerm.remove(orng.getSprite());
             orng.setSprite(new Sprite(gamed.getFoge()));
             orng.setPosition(orngX,orngY);
             layerm.append(orng.getSprite());
         tempo=0;
          }
        ///FANTASMAS 1 = cima, 2 = direita, 3 = baixo, 4 = esquerda
        //troca a direção
        if (colisao(verm,null, mapa)){
              int dir=verm.getDirecao();
              if (dir==1){
                  verm.setPosition(verm.getX(),verm.getY()+5 );
            while (dir==1 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verm.setDirecao(dir);
            }
            else{
                 if (dir==2){
                      verm.setPosition(verm.getX()-5,verm.getY() );
            while (dir==2 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verm.setDirecao(dir);
                }
                else{
                     if (dir==3){
                          verm.setPosition(verm.getX(),verm.getY()-5 );
            while (dir==3 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verm.setDirecao(dir);
                    }
                    else{
                         if (dir==4){
                              verm.setPosition(verm.getX()+5,verm.getY() );
            while (dir==4 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verm.setDirecao(dir);
                    }
                     }
                }
            }
        }
        if (colisao(verd,null, mapa)){
              int dir=verd.getDirecao();
              if (dir==1){
                   verd.setPosition(verd.getX(),verd.getY()+5 );
            while (dir==1 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verd.setDirecao(dir);
            }
            else{
                 if (dir==2){
                     verd.setPosition(verd.getX()-5,verd.getY() );
            while (dir==2 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verd.setDirecao(dir);
                }
                else{
                     if (dir==3){
                         verd.setPosition(verd.getX(),verd.getY()-5 );
            while (dir==3 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verd.setDirecao(dir);
                    }
                    else{
                         if (dir==4){
                             verd.setPosition(verd.getX()+5,verd.getY() );
            while (dir==4 || dir==0)              
                dir = randomizador.nextInt(5);
            
                verd.setDirecao(dir);
                    }
                     }
                }}}
        if (colisao(pink,null, mapa)){
              int dir=pink.getDirecao();
              if (dir==1){
                  pink.setPosition(pink.getX(),pink.getY()+5 );
            while (dir==1 || dir==0)              
                dir = randomizador.nextInt(5);
            
                pink.setDirecao(dir);
            }
            else{
                 if (dir==2){
                     pink.setPosition(pink.getX()-5,pink.getY() );
            while (dir==2 || dir==0)              
                dir = randomizador.nextInt(5);
            
                pink.setDirecao(dir);
                }
                else{
                     if (dir==3){
                         pink.setPosition(pink.getX(),pink.getY()-5 );
            while (dir==3 || dir==0)              
                dir = randomizador.nextInt(5);
            
                pink.setDirecao(dir);
                    }
                    else{
                         if (dir==4){
                             pink.setPosition(pink.getX()+5,pink.getY());
            while (dir==4 || dir==0)              
                dir = randomizador.nextInt(5);
            
                pink.setDirecao(dir);
                    }
                     }
                }}}
        if (colisao(orng,null, mapa)){
              int dir=orng.getDirecao();
              if (dir==1){
                  orng.setPosition(orng.getX(),orng.getY()+5 );
            while (dir==1 || dir==0)              
                dir = randomizador.nextInt(5);
            
                orng.setDirecao(dir);
            }
            else{
                 if (dir==2){
                     orng.setPosition(orng.getX()-5,orng.getY() );
                     
            while (dir==2 || dir==0)              
                dir = randomizador.nextInt(5);
            
                orng.setDirecao(dir);
                }
                else{
                     if (dir==3){
                         orng.setPosition(orng.getX(),orng.getY()-5 );
            while (dir==3 || dir==0)              
                dir = randomizador.nextInt(5);
            
                orng.setDirecao(dir);
                    }
                    else{
                         if (dir==4){
                             orng.setPosition(orng.getX()+5,orng.getY() );
            while (dir==4 || dir==0)              
                dir = randomizador.nextInt(5);
            
                orng.setDirecao(dir);
                    }
                     }
                }}}
        //////// pacman morreu/comeu fantasma
        if (colisao(player,verm,null))
            if( !verm.getFugindo()){
            firstRun=true;
             sommClass s = new sommClass("/2b0d44_Pacman_Dies_Sound_Effect.wav");
        s.start();
  
        s.toca();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        s.stop();
            for (int i=0;i<P.length;i++)
                layerm.remove(P[i].getSprite());
            }
            else{
                
            verm.setSaiu(false);
           verm.setFugindo(false);
           
           layerm.remove(verm.getSprite());
            verm.setSprite(gamed.getRed());verm.setPosition(116,140);
            layerm.append(verm.getSprite());
           }
        if (colisao(player,verd,null))
        
        if( !verd.getFugindo()){
            firstRun=true;
        sommClass s = new sommClass("/2b0d44_Pacman_Dies_Sound_Effect.wav");
        s.start();
  
        s.toca();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        s.stop();
        for (int i=0;i<P.length;i++)
                layerm.remove(P[i].getSprite());}
            else{
          
            verd.setSaiu(false);
            verd.setFugindo(false);
            
            layerm.remove(verd.getSprite());
             verd.setSprite(gamed.getAzul());verd.setPosition(116,140);
             layerm.append(verd.getSprite());
            }
        if (colisao(player,pink,null)){
            if( !pink.getFugindo())
            firstRun=true;
            sommClass s = new sommClass("/2b0d44_Pacman_Dies_Sound_Effect.wav");
        s.start();
  
        s.toca();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        s.stop();
        for (int i=0;i<P.length;i++)
                layerm.remove(P[i].getSprite());}
            else{
               
            pink.setSaiu(false);
            pink.setFugindo(false);
           
            layerm.remove(pink.getSprite());
             pink.setSprite(gamed.getRosa()); pink.setPosition(116,140);
             layerm.append(pink.getSprite());
            }
        if (colisao(player,orng,null))
           if( !orng.getFugindo()){
            firstRun=true;
           sommClass s = new sommClass("/2b0d44_Pacman_Dies_Sound_Effect.wav");
        s.start();
  
        s.toca();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        s.stop();
           for (int i=0;i<P.length;i++)
                layerm.remove(P[i].getSprite());}
            else{
          
            orng.setSaiu(false);
            orng.setFugindo(false);
            
            layerm.remove(orng.getSprite());
             orng.setSprite(gamed.getOrange());orng.setPosition(116,140);
             layerm.append(orng.getSprite());
            }
        
      
    }
    
    private boolean colisao(Entidade ent1, Entidade ent2, TiledLayer layer) {
        if (ent1 == null){
            if (ent2.getSprite().collidesWith(layer, true)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (ent2 == null){
                if (ent1.getSprite().collidesWith(layer, true)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                if (layer == null){
                    if (ent1.getSprite().collidesWith(ent2.getSprite(), true)){
                        return true;
                    }
                    else{                        
                        return false;
                    }             
                }
            }
        }
        return false;
    }
    private void drawScreen(Graphics g) throws IOException {       
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, getWidth(), getHeight());
       /* g.setColor(250, 0, 0);
        g.drawLine(0, 0, 100, getHeight() / 2);*/
        //g.setColor(255,255,255);
      //  g.drawString("W:"+width+" H:"+height, width/2, 10, 0);
        
        layerm.paint(g, 0, 0);
        
    if (tempo>200){
        if(verm.getFugindo()){
          verm.setFugindo(false);
          int vermX = verm.getX();
          int vermY= verm.getY();
          layerm.remove(verm.getSprite());
            verm.setSprite(gamed.getRed());
            verm.setPosition(vermX, vermY);
        layerm.append(verm.getSprite());
        }
        
        if(verd.getFugindo()){
            verd.setFugindo(false);
            int verdX = verd.getX();
          int verdY= verd.getY();
        layerm.remove(verd.getSprite());
            verd.setSprite(gamed.getAzul());
            verd.setPosition(verdX, verdY);
            layerm.append(verd.getSprite());
        }
        if(pink.getFugindo()){
        pink.setFugindo(false);
        int pinkX = pink.getX();
          int pinkY= pink.getY();
        layerm.remove(pink.getSprite());
            pink.setSprite(gamed.getRosa());
            pink.setPosition(pinkX,pinkY);
            layerm.append(pink.getSprite());
        }
        
        if(orng.getFugindo()){
            orng.setFugindo(false);
            int orngX = orng.getX();
          int orngY= orng.getY();
        layerm.remove(orng.getSprite());
            orng.setSprite(gamed.getOrange());
            orng.setPosition(orngX, orngY);
            layerm.append(orng.getSprite());
        }
      }
  
      
       int indPonto=0;
        Ponto aux;
        if (firstRun){ 
            P[0]= new Ponto(gamed.getPontaoo(),10,10);

        P[1]= new Ponto(gamed.getPontaoo(),mapa.getWidth()-30,10);
   
        P[2]= new Ponto(gamed.getPontaoo(),10,mapa.getHeight()-20);
     
        P[3]= new Ponto(gamed.getPontaoo(),mapa.getWidth()-20,mapa.getHeight()-20);
            for(int i=0;i<p.length;i++)
                if (p[i]!=null){
                layerm.remove(p[i].getSprite());
            p[i] = null;}
            for (int i=0; i<P.length;i++){
            layerm.append(P[i].getSprite()); 
            }
                        verm.setPosition(116,140);
                        verd.setPosition(116,140);
                        orng.setPosition(116,140);
                        pink.setPosition(116,140);
                         verm.setSaiu(false);
                        verd.setSaiu(false);
                        orng.setSaiu(false);
                        pink.setSaiu(false);
                        player.setPosition(width/2, 240);
                        parado=true;
                        cima = false;
                        esquerda=false;
                        direita=false;
            for (int i = 18; i < mapa.getWidth()+1; i += 20){  //linhas
                for (int iy = 18; iy<mapa.getHeight()+1;iy+=19){  //colunas
                        layerm.remove(mapa);
                        layerm.remove(player.getSprite());
                        layerm.remove(verm.getSprite());
                        layerm.remove(verd.getSprite());
                        layerm.remove(pink.getSprite());
                        layerm.remove(orng.getSprite());
                        aux = new Ponto(gamed.getPontinhoX(),i,iy);
                      
                        p[indPonto] = aux;
                        
                        if (!colisao(aux,null, mapa))
                        {
                        layerm.append(aux.getSprite());
                        layerm.append(mapa);
                        layerm.append(player.getSprite());
                        layerm.append(verm.getSprite());
                        layerm.append(verd.getSprite());
                        layerm.append(pink.getSprite());
                        layerm.append(orng.getSprite());
                         }
                        indPonto++;
                } 
            firstRun = false;
            }
        }
          
      
            
        layerm.paint(g, 0, 0);
        flushGraphics();
        tempo++;
    }

    private void input() {

        int keyState = getKeyStates();
        if ((keyState & LEFT_PRESSED) != 0) {
                if (!esquerda){
                    player.getSprite().setTransform(Sprite.TRANS_MIRROR);
                    player.setPosition(player.getX()-1, player.getY());
                    
                    parado = false;
                    direita = false;
                    esquerda = true;
                    cima = false;
                    baixo = false;
                }               
        }
        if ((keyState & RIGHT_PRESSED) != 0) {
                if (!direita){
                    player.getSprite().setTransform(Sprite.TRANS_NONE);
                    player.setPosition(player.getX()+1, player.getY());
                    
                    parado = false;
                    direita = true;
                    esquerda = false;
                    cima = false;
                    baixo = false;                
                }   
        }

        if ((keyState & UP_PRESSED) != 0) {
                if (!cima){
                  //  player.getSprite().setTransform(Sprite.TRANS_MIRROR_ROT90);
                  //  if(!colisao(player,null,mapa))
                    player.setPosition(player.getX(), player.getY()-1);
                 //   else
                   //     player.setPosition(player.getX()+2, player.getY()-1);
                    
                    parado = false;
                    direita = false;
                    esquerda = false;
                    cima = true;
                    baixo = false;
                }
        }

        if ((keyState & DOWN_PRESSED) != 0) {
                if (!baixo){
               //     player.getSprite().setTransform(Sprite.TRANS_MIRROR_ROT270);
               //     if (!colisao(player,null,mapa))
                    player.setPosition(player.getX(), player.getY()+1);
                 //   else
                   //     player.setPosition(player.getX()+2, player.getY()+1);
                    
                    parado = false;
                    direita = false;
                    esquerda = false;
                    cima = false;
                    baixo = true;
                } 
        }
     

    }
    
   
}
