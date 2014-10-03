/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.InsuranceEcoSystem.Organization;
import Business.Invoice.InvoiceCatalog;

/**
 *
 * @author Haripal
 */
public class AccountsOrganization extends Organization {
    InvoiceCatalog invoiceCatalog;

    public InvoiceCatalog getInvoiceCatalog() {
        return invoiceCatalog;
    }
    
    
     public AccountsOrganization(String organizationName) {
        super(organizationName);
        invoiceCatalog = new InvoiceCatalog();
    }
}
