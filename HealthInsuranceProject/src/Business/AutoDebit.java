/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Haripal
 */
public class AutoDebit {
    private String cardNumber;
    private String expDate;
    private int cvv;
    private boolean autoDebitStatus;

    public boolean isAutoDebitStatus() {
        return autoDebitStatus;
    }

    public void setAutoDebitStatus(boolean autoDebitStatus) {
        this.autoDebitStatus = autoDebitStatus;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    
    
    
    
}
