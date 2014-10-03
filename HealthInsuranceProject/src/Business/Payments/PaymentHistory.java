
package Business.Payments;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class PaymentHistory {
    
    ArrayList<Payment> paymentHistory;
    
    public PaymentHistory()
    {
        paymentHistory = new ArrayList<Payment>();
    }
    
    public Payment newPayment()
    {
        Payment payment = new Payment();
        paymentHistory.add(payment);
        return payment;
    }
    
}
