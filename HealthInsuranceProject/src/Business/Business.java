        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Exchange.Exchange;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Haripal
 */
public class Business extends Enterprise {
    
   // private static Business business = null;
   

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    EnterpriseDirectory enterpriseDirectory;

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

   
    
    private CustomerDirectory customerDirectory;
    
   public Business()
    {
        super(Enterprise.Type.Business.toString());
    
      enterpriseDirectory = new EnterpriseDirectory();
       
    }


   

    
////    public static Business getInstanceOfBusiness()
////    {
////        if(business == null)
////        {
////            business = new Business();
////        }
////        return business;
////    }
    
    public ArrayList<Offer> getCustomerOffers(UserAccount userAccount)
    {
        ArrayList<Offer> oList = new ArrayList<Offer>();
        if(userAccount.getExchangeEnterprise().getOffers().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No Offers for You");
            
        }
        else
        {
        for(Offer o :userAccount.getExchangeEnterprise().getOffers() )
        {
            if(o.getMarket().getCondition().execute(userAccount.getPerson()) == true)
            {
                
                oList.add(o);
            }
            
        }
        
    }
        return oList;
}

}