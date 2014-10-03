/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class MasterOrderCatalog {
    
    ArrayList<Order> masterOrderCatalog;
    
    public MasterOrderCatalog()
    {
        masterOrderCatalog = new ArrayList<Order>();
    }

    public ArrayList<Order> getMasterOrderCatalog() {
        return masterOrderCatalog;
    }
    public Order newOrder()
    {
        Order order = new Order();
        masterOrderCatalog.add(order);
        return order;
    }
    
}
