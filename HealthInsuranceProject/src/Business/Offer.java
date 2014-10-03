/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.InsuranceEnterprise;
import Business.PaymentPlan.PaymentPlan;
import Business.Transaction.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class Offer  {
    
    private int offerId;
    private static int offerCounter;
    private int term;
    private double premium;

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    private Market market;
    private String status;
    private Plan plan;
    private InsuranceEnterprise insuranceEnterprise;
    ArrayList<Customer> customerList;

    public InsuranceEnterprise getInsuranceEnterprise() {
        return insuranceEnterprise;
    }

    public void setInsuranceEnterprise(InsuranceEnterprise insuranceEnterprise) {
        this.insuranceEnterprise = insuranceEnterprise;
    }
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
    private String offerName;

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }
    private ArrayList<Disease> diseasesList;
    private Deductable deductable;
    private CoPay coPay;
    private DoctorVisit doctorVisit;

    public Deductable  getDeductable() {
        return deductable;
    }

    public void setDeductable(Deductable deductable) {
        this.deductable = deductable;
    }

    public CoPay getCoPay() {
        return coPay;
    }

    public void setCoPay(CoPay coPay) {
        this.coPay = coPay;
    }

    public DoctorVisit getDoctorVisit() {
        return doctorVisit;
    }

    public void setDoctorVisit(DoctorVisit doctorVisit) {
        this.doctorVisit = doctorVisit;
    }

    

    public Market getMarket() {
        return market;
    }

    public ArrayList<Disease> getDiseasesList() {
        return diseasesList;
    }
    
    
    public Offer()
    {
        offerId = ++offerCounter;
        coPay = new CoPay();
        deductable = new Deductable();
        doctorVisit =new DoctorVisit();
        customerList = new ArrayList<Customer> ();
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }
    
   @Override
   public String toString(){
       return this.getOfferName();
   } 
    
    public double getSalesByPlans()
    {
        double d = 0.0;
        for(Customer c: customerList)
        {
            for(PaymentPlan pp : c.getPaymentSchedule().getPaymentSchedule())
            {
                for(Transaction t : pp.getTransactionHistory().getTransactionHistory())
                {
                    double  temp = t.getAmount();
                    d = d+ temp;
                            
                }
            }
        }
        return d;
    }
    
}
