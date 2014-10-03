/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Conditions.Condition;
import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class Market {
    
    private int marketId;
    private String marketName;
    private Condition condition;
    
    private static int marketCounter;
    
    public Market()
    {
       
        marketId = ++marketCounter;
        
    }
    
    
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    
    public int getMarketId() {
        return marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    

     @Override
   public String toString(){
       return this.getMarketName();
   } 
   

          
    
}
