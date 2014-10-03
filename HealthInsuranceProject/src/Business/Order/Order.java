/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Customer;
import Business.Offer;
import Business.Person;

/**
 *
 * @author Haripal
 */
public class Order {
   private Offer offer;
   private Person person;
   private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
   
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
    

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
   
  @Override
   public String toString(){
       return this.getOffer().getOfferName();
   }  
    
}
