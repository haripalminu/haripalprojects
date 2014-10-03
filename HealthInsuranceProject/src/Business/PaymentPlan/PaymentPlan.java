/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PaymentPlan;

import Business.Invoice.Invoice;
import Business.Transaction.TransactionHistory;


/**
 *
 * @author Haripal
 */
public class PaymentPlan {
    private int paymentId;
    private String Date;
    private String status;
    private String type;
    private double installment;
    private Invoice invoice;
    private TransactionHistory transactionHistory;
    
    public PaymentPlan()
    {
        transactionHistory = new TransactionHistory();
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    

    public double getInstallment() {
        return installment;
    }

    public void setInstallment(double installment) {
        this.installment = installment;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
   @Override
   public String toString(){
       return this.getDate();
   } 
     
    
    
}
