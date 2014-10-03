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
public class Family extends Condition {
    public Family()
    {
        conditionName = "Family";
    }

    @Override
    public boolean execute(Person person) {
        int age = person.getAge();
        if( person.getDependents().getDependents().size() > 0)
        {return true;} 
            else
               {return false;}
               
    }
    
}
