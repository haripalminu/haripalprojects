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
public class SeniorAndEmployeeAndFamily extends Condition {

     public SeniorAndEmployeeAndFamily()
    {
        conditionName = "SeniorAndEmployeeAndFamily";
    }

    @Override
    public boolean execute(Person person) {
        int age = person.getAge();
        if( (age > 60) && (person.isEmployeeStatus())&&(person.getDependents().getDependents().size()>0))
        {return true;} 
            else
               {return false;}
               
    }
    
}
