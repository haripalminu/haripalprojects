/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Haripal
 */
public class DoctorVisit  extends Option{
    
    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    
    @Override
    public boolean execute(Person person) {
       if(person.getAge() < 17 || !(person.isMaritalStatus()))
        {return true;}
        else
               {return false;}
    }
    
    
    
    
}
