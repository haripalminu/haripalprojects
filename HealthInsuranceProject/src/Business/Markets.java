/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class Markets {
    
    ArrayList<Market> markets;
    
    public Markets()
    {
        markets = new ArrayList<Market>();
    }

    public ArrayList<Market> getMarkets() {
        return markets;
    }
    public Market newMarket()
    {
         Market market = new Market();
        
        markets.add(market);
        return market;
    }
    
}
