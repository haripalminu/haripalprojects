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
public class PlanCatalouge {
    ArrayList<Plan> planCatalouge;
    
    public PlanCatalouge()
    {
        planCatalouge = new ArrayList<Plan>();
    }

    public ArrayList<Plan> getPlanCatalouge() {
        return planCatalouge;
    }
    
    public Plan newPlan()
    {
        Plan plan = new Plan();
        planCatalouge.add(plan);
        return plan;
    }
}
