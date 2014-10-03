/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.InsuranceEcoSystem;

import Business.Employee.EmployeeDirectory;
import Business.SmallBusiness.SmallBusinessDirectory;
import Business.UserAccountDirectory;
import Business.WorkQueue;


/**
 *
 * @author Haripal
 */
public class Organization {
    
    private String organizationName;
    private WorkQueue sendingQueue;
    private WorkQueue receivingQueue;
    private UserAccountDirectory userAccountDirectory;
    private SmallBusinessDirectory smallBusinessDirectory;

    public SmallBusinessDirectory getSmallBusinessDirectory() {
        return smallBusinessDirectory;
    }

    public WorkQueue getSendingQueue() {
        return sendingQueue;
    }

    public void setSendingQueue(WorkQueue sendingQueue) {
        this.sendingQueue = sendingQueue;
    }

    public WorkQueue getReceivingQueue() {
        return receivingQueue;
    }

    public void setReceivingQueue(WorkQueue receivingQueue) {
        this.receivingQueue = receivingQueue;
    }
    private EmployeeDirectory employeeDirectory;
    public static String ADMIN_ORGANIZATION = "Admin";
    public static String MARKETING_ORGANIZATION = "Marketing";
    public static String ACCOUNTS_ORGANIZATION = "Accounts";
    public static String TREASURY_ORGANIZATION = "Treasury";

   
    
    public Organization(String organizationName)
    {
        this.organizationName = organizationName;
        userAccountDirectory = new UserAccountDirectory();
        employeeDirectory = new EmployeeDirectory();
        receivingQueue = new WorkQueue();
        sendingQueue = new WorkQueue();
        smallBusinessDirectory = new SmallBusinessDirectory();
        
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
   

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
}
