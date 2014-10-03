/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Enterprise.InsuranceEnterprise;
import Business.Exchange.Exchange;
import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class EnterpriseDirectory {
    ArrayList<Enterprise> enterpriseDirectory;
    
    public EnterpriseDirectory()
    {
       enterpriseDirectory = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    public Enterprise newEnterprise(String name)
    {
         Enterprise enterprise = null;
        if(name.equals(Enterprise.Type.Exchange.toString()))
        {
            enterprise =new Exchange(name);
        }
        else if(name.equals(Enterprise.Type.Insurance.toString()))
        {
            enterprise = new InsuranceEnterprise(name);
        }
        enterpriseDirectory.add(enterprise);
        return enterprise;
    }
}
