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
public class BusinessAdminWorkArea extends WorkArea {
    public BusinessAdminWorkArea()
    {
       workQueue = new WorkQueue();
    }
    @Override
    public JPanel  createView(JPanel upc,UserAccount userAccount,Enterprise enterprise,Business business) {
        JPanel jPanel = new UserInterface.BusinessAdmin.BusinessAdminWorkAreaJPanel(upc,userAccount,enterprise,business);
        return jPanel;
    }
    
}
