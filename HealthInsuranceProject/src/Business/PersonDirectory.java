/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class PersonDirectory {
    ArrayList<Person> personDirectory;
    
    public PersonDirectory()
    {
        personDirectory = new ArrayList<Person> ();
    }

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }
    public Person newPerson()
    {
        Person person =new Person();
        personDirectory.add(person);
        return person;
    }
    
}
