/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.InsuranceEcoSystem.MarketingOrganization;
import Business.InsuranceEcoSystem.Organization;
import Business.AccountsOrganization;
import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class OrganizationDirectory {
    ArrayList<Organization> organizationDirectory;
    
    public OrganizationDirectory()
    {
        organizationDirectory = new ArrayList<Organization>();
    }
    
    public Organization newOrganization(String name)
    {
        Organization organization = null;
        
        if(name.equals(Organization.MARKETING_ORGANIZATION)){
            organization = new MarketingOrganization(name);
            
        }
        if(name.equals(Organization.ACCOUNTS_ORGANIZATION)){
            organization = new AccountsOrganization(name);
        }
        if(name.equals(Organization.TREASURY_ORGANIZATION)){
            organization = new TreasuryOrganization(name);
        }
        
        organizationDirectory.add(organization);
        return organization;
    }

    public ArrayList<Organization> getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(ArrayList<Organization> organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
}
