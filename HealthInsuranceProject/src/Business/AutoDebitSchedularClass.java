/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Exchange.Exchange;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Haripal
 */
public class AutoDebitSchedularClass extends TimerTask {
    
    
     @Override
    public void run() {
         
        
     
    }

    public void start() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, 5 *  1000 , 60 * 30 * 1000);
    }

    

}