/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

/**
 *
 * @author sergio
 */
public class sommClass implements Runnable{
    
    private boolean isPlay; // game loop roda se isPaly é verdadeiro
    private boolean isSom;
    private Player player;
    private VolumeControl vc;

    
    public sommClass(String som){
        isSom = false;  
        try {
                InputStream in = getClass().getResourceAsStream(som);
                player = Manager.createPlayer(in, "audio/x-wav");
                player.prefetch();
                } catch (IOException ioe) { }
                  catch (MediaException me) { }
          

    }
    
    public void start() {
        isPlay = true;
        Thread t = new Thread(this);
        t.start();
    }

    public void stop() {
        isPlay = false;
    }

    public void toca() {
        isSom = true;
    }
    
    public void run() {
        
        while (isPlay == true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            try {
              if (isSom){
                player.start();
                isSom = false;
              }
            } catch (MediaException ex) {
                ex.printStackTrace();
            }
            
        }

    }
    
    

    
    
}
