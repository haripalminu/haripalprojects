/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SmallBusiness;

import Business.Address;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.InsuranceEnterprise;

/**
 *
 * @author Haripal
 */
public class SmallBusiness  {
    
    private String companyName;
    private double amountPaid;
    private int noOfPersons;
    private double approvedDiscount;
    private Address address;
    private EmployeeDirectory employeeDirectory;
    private InsuranceEnterprise insuranceEnterprise;

    public void setInsuranceEnterprise(InsuranceEnterprise insuranceEnterprise) {
        this.insuranceEnterprise = insuranceEnterprise;
    }

    public InsuranceEnterprise getInsuranceEnterprise() {
        return insuranceEnterprise;
    }
    
    public SmallBusiness()
    {
        address = new Address();
        employeeDirectory = new EmployeeDirectory();
    }

    public Address getAddress() {
        return address;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }

    public double getApprovedDiscount() {
        return approvedDiscount;
    }

    public void setApprovedDiscount(double approvedDiscount) {
        this.approvedDiscount = approvedDiscount;
    }
    
   @Override
   public String toString(){
       return this.getCompanyName();
   }   
    
    
    
}
