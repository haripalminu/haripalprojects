/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Invoice;

import Business.Order.Order;

/**
 *
 * @author Haripal
 */
public class Invoice {
    
    private int invoiceId;
    private Order order;
    private double price;
    private double otherAmount;
    private double subsidy;

    public double getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(double otherAmount) {
        this.otherAmount = otherAmount;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
