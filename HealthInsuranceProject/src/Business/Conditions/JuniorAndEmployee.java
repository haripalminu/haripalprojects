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
public class JuniorAndEmployee extends Condition {
    
    public JuniorAndEmployee()
    {
        conditionName = "JuniorAndEmployee";
    }

    @Override
    public boolean execute(Person person) {
        int age = person.getAge();
        if((age < 17 || age < 60) && (person.isEmployeeStatus()))
        {return true;} 
            else
               {return false;}
               
    }
    
}
