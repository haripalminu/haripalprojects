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
public class Offers {
    
    ArrayList<Offer> offers;
    
    public Offers()
    {
        offers =  new ArrayList<Offer>(); 
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }
    
    
    public Offer newOffer()
    {
        Offer offer = new Offer();
        offers.add(offer);
        return offer;
    }
    
}
