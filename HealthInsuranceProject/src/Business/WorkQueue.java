/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class WorkQueue {
    ArrayList<WorkRequest> workQueue;
    
    public WorkQueue()
    {
        workQueue = new ArrayList<WorkRequest>();
    }

    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }
    public WorkRequest newWorkRequest()
    {
        WorkRequest workRequest = new WorkRequest();
        workQueue.add(workRequest);
        return workRequest;
    }
    
}
