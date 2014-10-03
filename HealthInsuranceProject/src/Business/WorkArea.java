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
public abstract class WorkArea {
    
    WorkQueue workQueue;

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    
    
    public abstract JPanel createView(JPanel upc,UserAccount userAccount,Enterprise e,Business business);
    
}
