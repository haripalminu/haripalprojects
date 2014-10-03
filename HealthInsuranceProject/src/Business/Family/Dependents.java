/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Family;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class Dependents {
    
    ArrayList<Dependent> dependents;
    
    public Dependents()
    {
        dependents = new ArrayList<Dependent>();
    }

    public ArrayList<Dependent> getDependents() {
        return dependents;
    }
    
    public Dependent newDependent()
    {
        Dependent dependent = new Dependent();
        dependents.add(dependent);
        return dependent;
    }
    
}
