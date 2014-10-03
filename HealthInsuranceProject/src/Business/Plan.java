/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.InsuranceEnterprise;

/**
 *
 * @author Haripal
 */
public class Plan {
    
    private String planId;
    private static int planCounter;
    private String planName;
    private InsuranceEnterprise insuranceEnterprise;
    private int initialPrice;
    private double fee;
    private int noOfPersonsCovered;
    private int coverage;
    private String Status;
    private String type;
    private int offeredDiscount;
    private String paymentStatus;

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getOfferedDiscount() {
        return offeredDiscount;
    }

    public void setOfferedDiscount(int offeredDiscount) {
        this.offeredDiscount = offeredDiscount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getNoOfPersonsCovered() {
        return noOfPersonsCovered;
    }

    public void setNoOfPersonsCovered(int noOfPersonsCovered) {
        this.noOfPersonsCovered = noOfPersonsCovered;
    }

    public int getCoverage() {
        return coverage;
    }

    public void setCoverage(int coverage) {
        this.coverage = coverage;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    

    public int getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(int initialPrice) {
        this.initialPrice = initialPrice;
    }

    public InsuranceEnterprise getInsuranceEnterprise() {
        return insuranceEnterprise;
    }

    public void setInsuranceEnterprise(InsuranceEnterprise insuranceEnterprise) {
        this.insuranceEnterprise = insuranceEnterprise;
    }
    
    
    public Plan()
    {
        this.planId = "Insurance"+ ++planCounter;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
    
     @Override
   public String toString(){
       return this.getPlanName();
   } 
}
