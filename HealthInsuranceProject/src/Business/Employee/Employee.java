/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Address;
import Business.Person;

/**
 *
 * @author Haripal
 */
public class Employee extends Person {
    private int employeeId;
    
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
   
    private String department;
    private static int employeeCounter;

   public Employee()
   {
       employeeId = ++employeeCounter;
       address = new Address();
   }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static int getEmployeeCounter() {
        return employeeCounter;
    }

    public static void setEmployeeCounter(int employeeCounter) {
        Employee.employeeCounter = employeeCounter;
    }
    
    @Override
   public String toString(){
       return Employee.super.getLastName();
   } 
}
