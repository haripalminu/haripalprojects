/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;


import Business.AccountsOrganization;
import Business.CustomerDirectory;
import Business.Exchange.Exchange;
import Business.InsuranceEcoSystem.MarketingOrganization;
import Business.InsuranceEcoSystem.Organization;
import Business.Offer;
import Business.Offers;

import Business.PlanCatalouge;
import Business.SmallBusiness.SmallBusinessDirectory;
import Business.TreasuryOrganization;
import java.util.ArrayList;


/**
 *
 * @author Haripal
 */
public class InsuranceEnterprise extends Enterprise {
    
    private String insuranceName;
    private Offers offers;
    private PlanCatalouge planCatalouge;
    private String status;
    ArrayList<Exchange> exchangeEnterprises;
    AccountsOrganization accountsOrganization;
    TreasuryOrganization     treasuryOrganization;

    public AccountsOrganization getAccountsOrganization() {
        return accountsOrganization;
    }

    public TreasuryOrganization getTreasuryOrganization() {
        return treasuryOrganization;
    }

    public MarketingOrganization getMarketingOrganization() {
        return marketingOrganization;
    }


    public String getStatus() {
        return status;
    }

    public ArrayList<Exchange> getExchangeEnterprises() {
        return exchangeEnterprises;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public PlanCatalouge getPlanCatalouge() {
        return planCatalouge;
    }

    public Offers getOffers() {
        return offers;
    }
    

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }
    MarketingOrganization marketingOrganization;
    CustomerDirectory customerDirectory;

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }
    public InsuranceEnterprise(String name) {
        super(name);
        
        marketingOrganization = (MarketingOrganization)this.getOrganizationDirectory().newOrganization(Organization.MARKETING_ORGANIZATION);
        accountsOrganization = (AccountsOrganization)this.getOrganizationDirectory().newOrganization(Organization.ACCOUNTS_ORGANIZATION);
        treasuryOrganization = (TreasuryOrganization)this.getOrganizationDirectory().newOrganization(Organization.TREASURY_ORGANIZATION);
        customerDirectory = new CustomerDirectory();
        offers = new Offers();
        planCatalouge = new PlanCatalouge();
        exchangeEnterprises = new ArrayList<Exchange>();
//        smallBusinessDirectory = new SmallBusinessDirectory();
    }

    
    

   

  @Override
   public String toString(){
       return this.getInsuranceName();
   }  
    
    
}
