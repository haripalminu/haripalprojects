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
public class FamilyAndSmallBusiness extends Condition {
    
    public FamilyAndSmallBusiness()
    {
        conditionName = "FamilyAndSmallBusiness";
    }

    @Override
    public boolean execute(Person person) {
        int age = person.getAge();
        if(person.isEmployeeStatus() && person.getDependents().getDependents().size() > 0)
        {return true;} 
            else
               {return false;}
               
    }
    
}
