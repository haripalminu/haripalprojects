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
public class InsuranceAdminWorkArea extends WorkArea {
     public InsuranceAdminWorkArea()
    {
       workQueue = new WorkQueue();
    }
    @Override
    public JPanel  createView(JPanel upc,UserAccount userAccount,Enterprise e,Business business) {
       JPanel jPanel = new UserInterface.InsuranceAdmin.InsuranceAdminWorkAreaJPanel(upc,userAccount,e,business);
        return jPanel;
    }
    
}
