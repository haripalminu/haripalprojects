/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Enterprise.InsuranceEnterprise;
import Business.Transaction.Transaction;
import java.util.Date;



/**
 *
 * @author Haripal
 */
public class WorkRequest {
    
    
    private int requestId;
    UserAccount sender;
    UserAccount receiver;
    private String status;
    private Date creationDate;
    private static int requestCounter;
    private String type;
    private Offer offer;
    private Employee employee;
    private InsuranceEnterprise insuranceEnterprise;
    private Plan plan;
    private Transaction transaction ;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public InsuranceEnterprise getInsuranceEnterprise() {
        return insuranceEnterprise;
    }

    public void setInsuranceEnterprise(InsuranceEnterprise insuranceEnterprise) {
        this.insuranceEnterprise = insuranceEnterprise;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public WorkRequest()
    {
        requestId = ++requestCounter;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    public UserAccount getSender() {
        return receiver;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

   
    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    

   
   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    @Override
     public String toString(){
       return this.getStatus();
   } 
    
    
}
