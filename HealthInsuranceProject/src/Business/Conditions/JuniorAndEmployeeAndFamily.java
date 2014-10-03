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
public class JuniorAndEmployeeAndFamily extends Condition {

    public JuniorAndEmployeeAndFamily()
    {
        conditionName = "SeniorAndEmployeeAndFamily";
    }

    @Override
    public boolean execute(Person person) {
        int age = person.getAge();
        if( (age < 17 || age < 60) && (person.isEmployeeStatus())&&(person.getDependents().getDependents().size()>0))
        {return true;} 
            else
               {return false;}
               
    }
    
}
