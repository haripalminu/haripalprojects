/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Enterprise.InsuranceEnterprise;
import Business.Exchange.Exchange;
import Business.SmallBusiness.SmallBusiness;

/**
 *
 * @author Haripal
 */
public class UserAccount {
    private String userName;
    private String password;
    private Person person;
    private Role role;
    private InsuranceEnterprise insuranceEnterprise;
    private Exchange exchangeEnterprise;
    private Customer customer;
    private SmallBusiness smallBusiness;
    private Enterprise enterprise;

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    

    public SmallBusiness getSmallBusiness() {
        return smallBusiness;
    }

    public void setSmallBusiness(SmallBusiness smallBusiness) {
        this.smallBusiness = smallBusiness;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Exchange getExchangeEnterprise() {
        return exchangeEnterprise;
    }

    public void setExchangeEnterprise(Exchange exchangeEnterprise) {
        this.exchangeEnterprise = exchangeEnterprise;
    }

    public InsuranceEnterprise getInsuranceEnterprise() {
        return insuranceEnterprise;
    }

    public void setInsuranceEnterprise(InsuranceEnterprise insuranceEnterprise) {
        this.insuranceEnterprise = insuranceEnterprise;
    }
    private boolean status;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

   
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    @Override
   public String toString(){
       return this.userName;
   } 
    
}
