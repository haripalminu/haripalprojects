/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import javax.swing.JPanel;

/**
 *
 * @author Haripal
 */
public class AccountsEmployeeWorkArea extends WorkArea {
     public AccountsEmployeeWorkArea()
    {
       workQueue = new WorkQueue();
    }
    @Override
    public JPanel  createView(JPanel upc,UserAccount userAccount,Enterprise enterprise,Business business) {
        JPanel jPanel = new UserInterface.AccountsEmployee.AccountsAdminWorkAreaJPanel(upc,userAccount,enterprise,business);
        return jPanel;
    }
    
    
}
