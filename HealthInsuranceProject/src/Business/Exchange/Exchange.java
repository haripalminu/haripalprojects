/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Exchange;

import Business.AccountsOrganization;
import Business.Customer;
import Business.CustomerDirectory;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InsuranceEnterprise;
import Business.InsuranceEcoSystem.MarketingOrganization;
import Business.InsuranceEcoSystem.Organization;
import Business.Invoice.InvoiceCatalog;
import Business.Markets;
import Business.Offer;
import Business.Order.MasterOrderCatalog;
import Business.PaymentPlan.PaymentPlan;
import Business.PlanCatalouge;
import Business.Transaction.Transaction;
import Business.Transaction.TransactionHistory;
import Business.TreasuryOrganization;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Haripal
 */
public class Exchange extends Enterprise {
    
    MarketingOrganization marketingOrganization;
    AccountsOrganization accountsOrganization;
    TreasuryOrganization treasuryOrganization;
    CustomerDirectory customerDirectory;
    InvoiceCatalog invoiceCatalog;
    MasterOrderCatalog masterOrderCatalog;
    private ArrayList<Offer> offers;
    private String exchangeName;
    private PlanCatalouge planCatalogue;
    private Markets markets;
    Calendar cal3 = Calendar.getInstance();
    Date date = cal3.getTime();
    private double exchangeRevenue;
    private TransactionHistory transactionHistory;
    

    

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public double getExchangeRevenue() {
        return exchangeRevenue;
    }

    public void setExchangeRevenue(double exchangeRevenue) {
        this.exchangeRevenue = exchangeRevenue;
    }
    

    public Markets getMarkets() {
        return markets;
    }
    ArrayList<InsuranceEnterprise> insuranceIssuers;

    public ArrayList<InsuranceEnterprise> getInsuranceIssuers() {
        return insuranceIssuers;
    }
    
    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public TreasuryOrganization getTreasuryOrganization() {
        return treasuryOrganization;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }
    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }
    public Exchange(String name) {
        super(name);
        
        marketingOrganization = (MarketingOrganization)this.getOrganizationDirectory().newOrganization(Organization.MARKETING_ORGANIZATION);
        accountsOrganization = (AccountsOrganization)this.getOrganizationDirectory().newOrganization(Organization.ACCOUNTS_ORGANIZATION);
        treasuryOrganization = (TreasuryOrganization)this.getOrganizationDirectory().newOrganization(Organization.TREASURY_ORGANIZATION);
        customerDirectory = new CustomerDirectory();
        invoiceCatalog = new InvoiceCatalog();
        offers = new ArrayList<Offer>();
        masterOrderCatalog = new MasterOrderCatalog();
        planCatalogue = new PlanCatalouge();
        insuranceIssuers  = new ArrayList<InsuranceEnterprise>();
        markets = new Markets();
        transactionHistory = new TransactionHistory();
    }

    public PlanCatalouge getPlanCatalogue() {
        return planCatalogue;
    }

    public InvoiceCatalog getInvoiceCatalog() {
        return invoiceCatalog;
    }

    public MarketingOrganization getMarketingOrganization() {
        return marketingOrganization;
    }

    public AccountsOrganization getAccountsOrganization() {
        return accountsOrganization;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public void scheduledPayments() throws ParseException
    {
        for(Customer c : customerDirectory.getCustomerDirectory())
        {
            if(c.getAutoDebit().isAutoDebitStatus())
            {
                for(PaymentPlan pp : c.getPaymentSchedule().getPaymentSchedule())
                {
                     
            //MM/dd/yyyy HH:mm:ss
            Date date1 = new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(pp.getDate());
                       if(date.compareTo(date1)== 0)
                       {
                           SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
                           String dateNow = formatter.format(cal3.getTime());
                           Transaction t = pp.getTransactionHistory().newTransaction();
                           t.setPaymentPlan(pp);
                           t.setTransactionId(1);
                           t.setPaidDate(dateNow);
                           t.setAmount(pp.getInstallment());
                       }
        
                }
            }
        }
    }
    
   @Override
   public String toString(){
       return this.getExchangeName();
   }  

   
   
}
