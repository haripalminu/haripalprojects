/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PaymentPlan;

import Business.Invoice.Invoice;
import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class PaymentSchedule {
    
    ArrayList<PaymentPlan> paymentSchedule;
    private Invoice invoice;
    private double amountPaid;
    private double unpaidAmount;

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(double unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    public PaymentSchedule()
    {
        paymentSchedule = new ArrayList<PaymentPlan>();
    }

    public ArrayList<PaymentPlan> getPaymentSchedule() {
        return paymentSchedule;
    }
    public PaymentPlan newPaymentPlan()
    {
        PaymentPlan paymentPlan = new PaymentPlan();
        paymentSchedule.add(paymentPlan);
        return paymentPlan;
    }
    
    public double getPaidAmount()
    {
        double paidAmount = 0.0;
        for(PaymentPlan pp: paymentSchedule)
        {
            if(pp.getStatus().equals("Paid")
                    )
            {
            double tempPaidAmount = pp.getInstallment();
            paidAmount =   tempPaidAmount +paidAmount;
                    }
        }
        return paidAmount;
    }
    public double getDueAmount()
    {
        double paidAmount = 0.0;
        for(PaymentPlan pp: paymentSchedule)
        {
            if(pp.getStatus().equals("Not Paid") 
                    || pp.getStatus().equals("PartiallyPaid"))
            {
            double tempPaidAmount = pp.getInstallment();
            paidAmount =   tempPaidAmount +paidAmount;
                    }
        }
        return paidAmount;
    }
}
