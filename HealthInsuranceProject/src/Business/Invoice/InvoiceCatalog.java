/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Invoice;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class InvoiceCatalog {
    
    ArrayList<Invoice> invoiceCatalog;
    
    public InvoiceCatalog()
    {
        invoiceCatalog = new ArrayList<Invoice>();
    }

    public ArrayList<Invoice> getInvoiceCatalog() {
        return invoiceCatalog;
    }
    public Invoice newInvoice()
    {
        Invoice invoice = new Invoice();
        invoiceCatalog.add(invoice);
        return invoice;
    }
    
}
