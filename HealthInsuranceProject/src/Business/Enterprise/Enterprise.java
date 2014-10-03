/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.InsuranceEcoSystem.Organization;
import Business.OrganizationDirectory;

/**
 *
 * @author Haripal
 */
public class Enterprise extends Organization {
    
    private String enterpriseName;
    private OrganizationDirectory organizationDirectory;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    public static enum Type
    {
        Exchange{ 

            

            @Override
            public String toString() {
                return "Exchange";
            }
        },
        Insurance{ 

            

            @Override
            public String toString() {
                return "Insurance";
            }
        },
        Business{ 

            

            @Override
            public String toString() {
                return "Business";
            }
        };
    }
    
    public Enterprise(String name)
    {
        super(Organization.ADMIN_ORGANIZATION);
        this.enterpriseName = name;
        organizationDirectory = new OrganizationDirectory();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    
    
}
