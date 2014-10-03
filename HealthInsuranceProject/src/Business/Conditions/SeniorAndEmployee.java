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
public class SeniorAndEmployee extends Condition{
    public SeniorAndEmployee()
    {
        conditionName = "SeniorAndEmployee";
    }

    @Override
    public boolean execute(Person person) {
        int age = person.getAge();
        if( (age > 60) && (person.isEmployeeStatus()))
        {return true;} 
            else
               {return false;}
               
    }
    
}
