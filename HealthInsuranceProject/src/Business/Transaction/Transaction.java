/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Transaction;

import Business.Customer;
import Business.Enterprise.InsuranceEnterprise;
import Business.PaymentPlan.PaymentPlan;

/**
 *
 * @author Haripal
 */
public class Transaction {
    
    private int transactionId;
    private PaymentPlan paymentPlan;
    private double amount;
    private String paidDate;
    private Customer customer;
    private InsuranceEnterprise insuranceEnterprise;

    public InsuranceEnterprise getInsuranceEnterprise() {
        return insuranceEnterprise;
    }

    public void setInsuranceEnterprise(InsuranceEnterprise insuranceEnterprise) {
        this.insuranceEnterprise = insuranceEnterprise;
    }
   

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }
    private static int i = 0;
    
    public Transaction()
    {
        transactionId = ++i;
       
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentPlan getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
   public String toString(){
       return this.getPaidDate();
   }  
    
}
