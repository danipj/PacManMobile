
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author sergio
 */
public class PacManMidlet extends MIDlet implements CommandListener {

    private Display display;
    private PacCanvas gameCanvas;
    private Command cmExit;
    
    public PacManMidlet() throws Exception{
        
            display = Display.getDisplay(this);

             // Create game canvas and exit command
            if ((gameCanvas = new PacCanvas()) != null)
            {
                cmExit = new Command("Exit", Command.EXIT, 1);
                gameCanvas.addCommand(cmExit);
                gameCanvas.setCommandListener(this);
            }
   

    }
    
    
    
    public void startApp() {
        if (gameCanvas != null)
        {
            display.setCurrent(gameCanvas);
            gameCanvas.start();
        }
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void exit() {
        System.gc();  // chama o grabage collector
        destroyApp(false);
        notifyDestroyed();
    }

    public void commandAction(Command c, Displayable d) {
        if (c==cmExit)
            exit();
        
    }
    
}


 
