/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Family.Dependents;
import Business.SmallBusiness.SmallBusiness;

/**
 *
 * @author Haripal
 */
public class Person {
    
     private String firstName;
    private String lastName;
    private int age;
    private String DOB;
    private SmallBusiness smallBusiness;
    private Dependents dependents;
    private int SSN;
    private double income;
    private boolean maritalStatus;
    private boolean employeeStatus;

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
    private int riskFactor = 0;

    public int getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(int riskFactor) {
        this.riskFactor = riskFactor;
    }
    

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public SmallBusiness getSmallBusiness() {
        return smallBusiness;
    }

    public void setSmallBusiness(SmallBusiness smallBusiness) {
        this.smallBusiness = smallBusiness;
    }

    public Dependents getDependents() {
        return dependents;
    }

    public void setDependents(Dependents dependents) {
        this.dependents = dependents;
    }
    
    public Person()
    {
        dependents = new Dependents();
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
