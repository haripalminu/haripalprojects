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
public class TreasuraryEmployeeWorkArea extends WorkArea {
     public TreasuraryEmployeeWorkArea()
    {
       workQueue = new WorkQueue();
    }
    @Override
    public JPanel  createView(JPanel upc,UserAccount userAccount,Enterprise enterprise,Business business) {
        JPanel jPanel = new UserInterface.Treasurary.TreasuraryEmployeeWorkAreaJPanel(upc,userAccount,enterprise,business);
        return jPanel;
    }
    
}
