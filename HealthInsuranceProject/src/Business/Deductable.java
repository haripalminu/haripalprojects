/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Haripal
 */
public class Deductable extends Option {
    
    private boolean deductableIndicator;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public boolean execute(Person person)
    {
        if(person.getAge() < 17)
        {return true;}
        else
               {return false;}
        
    }
    
}
