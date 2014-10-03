/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class CustomerDirectory {
    
    ArrayList<Customer> customerDirectory;

    public CustomerDirectory()
    {
        customerDirectory = new ArrayList<Customer>();
    }
    
    public Customer newCustomer()
    {
        Customer c = new Customer();
        customerDirectory.add(c);
        return c;
    }

    public ArrayList<Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(ArrayList<Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
    
}
