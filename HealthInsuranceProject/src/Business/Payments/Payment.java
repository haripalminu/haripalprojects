/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Payments;

/**
 *
 * @author Haripal
 */
public class Payment {
    
    private String month;
    private int monthlyPayment;
    private int remainingAmount;

    public int getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    
    
    
}
