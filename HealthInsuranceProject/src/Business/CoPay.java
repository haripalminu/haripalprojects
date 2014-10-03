/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Haripal
 */
public class CoPay extends Option {
   private int percentage;

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
   
   
    @Override
    public boolean execute(Person person) {
       if(person.getAge() < 17 || !(person.isMaritalStatus()))
        {return true;}
        else
               {return false;}
    }
    
    
    
    
    
    
}
