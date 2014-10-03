/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Conditions;

import Business.Person;

/**
 *
 * @author Haripal
 */
public class Junior extends Condition {
    
    public Junior()
    {
        conditionName = "Junior";
    }

    @Override
    public boolean execute(Person person) {
        int age = person.getAge();
        if(age < 17 || age < 60)
        {return true;} 
            else
               {return false;}
               
    }
    
    
    
}
