/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Family;

import Business.Person;

/**
 *
 * @author Haripal
 */
public class Dependent extends Person{
    private Person person;
    private String relation;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    
    
    
}
