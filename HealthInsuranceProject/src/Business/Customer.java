/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Exchange.Exchange;
import Business.Invoice.Invoice;
import Business.PaymentPlan.PaymentSchedule;
import Business.Payments.PaymentHistory;

/**
 *
 * @author Haripal
 */
public class Customer extends Person {
    
    private int customerId;
    private String type;
    private Address address;
    private Exchange exchange;
    private PaymentHistory paymentHistory;
    private PaymentSchedule paymentSchedule;
    private boolean smallBusinessStatus;
    private Invoice invoice;
    private AutoDebit autoDebit;

    public AutoDebit getAutoDebit() {
        return autoDebit;
    }

    public boolean isSmallBusinessStatus() {
        return smallBusinessStatus;
    }

    public void setSmallBusinessStatus(boolean smallBusinessStatus) {
        this.smallBusinessStatus = smallBusinessStatus;
    }
    

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }
    

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public Address getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private static int customerCounter;

    public Customer() {
        customerId = ++customerCounter;
        address = new Address();
        paymentHistory = new PaymentHistory();
        paymentSchedule = new PaymentSchedule();
        invoice = new Invoice();
        autoDebit = new AutoDebit();
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    @Override
   public String toString(){
       return Customer.super.getLastName();
   } 
    
}
