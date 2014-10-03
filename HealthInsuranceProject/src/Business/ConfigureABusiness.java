/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Conditions.Junior;
import Business.Conditions.Senior;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InsuranceEnterprise;
import Business.Exchange.Exchange;

/**
 *
 * @author Haripal
 */
public class ConfigureABusiness {
    public static Business initializeBusiness()
    {
        Business business = new Business();          
        EnterpriseDirectory enterpriseDirectory = business.getEnterpriseDirectory();
        Exchange exchangeEnterprise =(Exchange) enterpriseDirectory.newEnterprise(Enterprise.Type.Exchange.toString());
        exchangeEnterprise.setState("Massachusetts");
        
        exchangeEnterprise.setExchangeName("MassExchange");
        InsuranceEnterprise insuranceEnterprise =(InsuranceEnterprise) enterpriseDirectory.newEnterprise(Enterprise.Type.Insurance.toString());
        Employee businessAdminEmployee = exchangeEnterprise.getEmployeeDirectory().newEmployee();
        UserAccount businessAdminUserAccount = business.getUserAccountDirectory().newUserAccount();
        
        Employee accountsEmployee = exchangeEnterprise.getAccountsOrganization().getEmployeeDirectory().newEmployee();
        UserAccount accountsEmployeeUserAccount = exchangeEnterprise.getAccountsOrganization().getUserAccountDirectory().newUserAccount();
        accountsEmployee.setFirstName("ramesh");
        accountsEmployee.setLastName("Yamala");
        accountsEmployee.setAge(30);
        accountsEmployee.setEmployeeId(1);
        accountsEmployee.setDepartment("Accounts");
        accountsEmployeeUserAccount.setPerson(accountsEmployee);
        accountsEmployeeUserAccount.setExchangeEnterprise(exchangeEnterprise);
        AccountsEmployeeRole accountsEmployeeRole = new AccountsEmployeeRole();
        accountsEmployeeUserAccount.setRole(accountsEmployeeRole);
        accountsEmployeeUserAccount.setStatus(true);
        accountsEmployeeUserAccount.setUserName("ac");
        accountsEmployeeUserAccount.setPassword("ac");
        
        Employee accountsEmployee1 = exchangeEnterprise.getAccountsOrganization().getEmployeeDirectory().newEmployee();
        UserAccount accountsEmployeeUserAccount1 = exchangeEnterprise.getAccountsOrganization().getUserAccountDirectory().newUserAccount();
        accountsEmployee1.setFirstName("ramesh1");
        accountsEmployee1.setLastName("Yamala1");
        accountsEmployee1.setAge(30);
        accountsEmployee1.setEmployeeId(2);
        accountsEmployee1.setDepartment("Accounts");
        accountsEmployeeUserAccount1.setPerson(accountsEmployee);
        accountsEmployeeUserAccount1.setExchangeEnterprise(exchangeEnterprise);
        
        accountsEmployeeUserAccount1.setRole(accountsEmployeeRole);
        accountsEmployeeUserAccount1.setStatus(true);
        accountsEmployeeUserAccount1.setUserName("ac1");
        accountsEmployeeUserAccount1.setPassword("a");
        
        Employee treasuryEmployee = exchangeEnterprise.getTreasuryOrganization().getEmployeeDirectory().newEmployee();
        UserAccount treasuryEmployeeUserAccount = exchangeEnterprise.getTreasuryOrganization().getUserAccountDirectory().newUserAccount();
        treasuryEmployee.setFirstName("Farah");
        treasuryEmployee.setLastName("Sheik");
        treasuryEmployee.setAge(30);
        treasuryEmployee.setEmployeeId(1);
        treasuryEmployee.setDepartment("Treasury");
        treasuryEmployeeUserAccount.setPerson(accountsEmployee);
        treasuryEmployeeUserAccount.setExchangeEnterprise(exchangeEnterprise);
        TreasuraryEmployeeRole treasuraryEmployeeRole = new TreasuraryEmployeeRole();
        treasuryEmployeeUserAccount.setRole(treasuraryEmployeeRole);
        treasuryEmployeeUserAccount.setStatus(true);
        treasuryEmployeeUserAccount.setUserName("t");
        treasuryEmployeeUserAccount.setPassword("t");
        
        businessAdminEmployee.setFirstName("Jaya");
        businessAdminEmployee.setLastName("Putta");
        businessAdminEmployee.setAge(23);
        businessAdminEmployee.setDepartment("Administration");
        businessAdminUserAccount.setUserName("business");
        businessAdminUserAccount.setPassword("business");
        BusinessAdminRole businessadminRole = new BusinessAdminRole();
        businessAdminUserAccount.setRole(businessadminRole);
        businessAdminUserAccount.setPerson(businessAdminEmployee);
        businessAdminUserAccount.setStatus(true);
        
        
        Employee exchangeAdminEmployee = exchangeEnterprise.getEmployeeDirectory().newEmployee();
        UserAccount exchangeAdminUserAccount = business.getUserAccountDirectory().newUserAccount();
        UserAccount customerAdminUserAccount = exchangeEnterprise.getUserAccountDirectory().newUserAccount();
        UserAccount customerAdminUserAccount1 = exchangeEnterprise.getUserAccountDirectory().newUserAccount();
        exchangeAdminEmployee.setFirstName("Bharath");
        exchangeAdminEmployee.setLastName("Nalluri");
        exchangeAdminEmployee.setAge(23);
        exchangeAdminEmployee.setDepartment("Administration");
        exchangeAdminUserAccount.setUserName("admin");
        exchangeAdminUserAccount.setPassword("admin");
        AdminRole adminRole = new AdminRole();
        exchangeAdminUserAccount.setRole(adminRole);
        exchangeAdminUserAccount.setPerson(exchangeAdminEmployee);
        exchangeAdminUserAccount.setStatus(true);
        exchangeAdminUserAccount.setInsuranceEnterprise(null);
        exchangeAdminUserAccount.setExchangeEnterprise(exchangeEnterprise);
        exchangeAdminUserAccount.setEnterprise(exchangeEnterprise);
        
        insuranceEnterprise.setInsuranceName("United Health Group");
        insuranceEnterprise.setStatus("Registered");
        
        Customer customer = exchangeEnterprise.getCustomerDirectory().newCustomer();
        customer.setFirstName("Prasad");
        customer.setLastName("Katta");
        customer.setAge(62);
        customer.setType("Normal");
        customerAdminUserAccount.setUserName("c");
        customerAdminUserAccount.setPassword("c");
        customerAdminUserAccount.setPerson(customer);
        customerAdminUserAccount.setStatus(true);
        CustomerRole customerRole = new CustomerRole();
        customerAdminUserAccount.setRole(customerRole);
        customerAdminUserAccount.setCustomer(customer);
        customerAdminUserAccount.setExchangeEnterprise(exchangeEnterprise);
        
        Customer customer1 = exchangeEnterprise.getCustomerDirectory().newCustomer();
        customer1.setFirstName("Pra");
        customer1.setLastName("Katt");
        customer1.setAge(16);
        customer1.setType("Normal");
        customer.setIncome(10000);
        customerAdminUserAccount1.setUserName("c1");
        customerAdminUserAccount1.setPassword("c1");
        customerAdminUserAccount1.setPerson(customer1);
        customerAdminUserAccount1.setStatus(true);
        customerAdminUserAccount1.setExchangeEnterprise(exchangeEnterprise);
        customerAdminUserAccount1.setCustomer(customer1);
        
        customerAdminUserAccount1.setRole(customerRole);
        
        Employee insuranceEnterpriseEmployee = insuranceEnterprise.getEmployeeDirectory().newEmployee();
        insuranceEnterpriseEmployee.setFirstName("Harish");
        insuranceEnterpriseEmployee.setLastName("Pokuri");
        insuranceEnterpriseEmployee.setAge(23);
        insuranceEnterpriseEmployee.setDepartment("Administration");
        
        
        Employee insuranceEnterpriseEmployee1 = insuranceEnterprise.getEmployeeDirectory().newEmployee();
        insuranceEnterpriseEmployee1.setFirstName("Vinni");
        insuranceEnterpriseEmployee1.setLastName("Pinamaneni");
        insuranceEnterpriseEmployee1.setAge(23);
        insuranceEnterpriseEmployee1.setDepartment("Administration");
        
        UserAccount insuranceAdminUserAccount = business.getUserAccountDirectory().newUserAccount();
        insuranceAdminUserAccount.setUserName("e");
        insuranceAdminUserAccount.setPassword("e");
        InsuranceAdminRole insuranceadminRole = new InsuranceAdminRole();
        insuranceAdminUserAccount.setRole(insuranceadminRole);
        insuranceAdminUserAccount.setPerson(insuranceEnterpriseEmployee);
        insuranceAdminUserAccount.setStatus(true);
        insuranceAdminUserAccount.setInsuranceEnterprise(insuranceEnterprise);
        Markets markets = exchangeEnterprise.getMarkets();
        Market jMarket = markets.newMarket();
        Market sMarket = markets.newMarket();
        Junior junior = new Junior();
        Senior senior = new Senior();
        jMarket.setCondition(junior);
        jMarket.setMarketName("Junior");
        sMarket.setCondition(senior);
        sMarket.setMarketName("Senior");
        
        Offer offer = insuranceEnterprise.getOffers().newOffer();
        Offer offer2 = insuranceEnterprise.getOffers().newOffer() ;
        
        Plan plan = insuranceEnterprise.getPlanCatalouge().newPlan();
        plan.setInsuranceEnterprise(insuranceEnterprise);
        plan.setPlanName("Premium555");
        plan.setType("Individual");
        
        offer.setPlan(plan);
        offer.setMarket(jMarket);
        offer.setOfferName("Premium555Junior");
        offer.setPremium(250);
        offer.getDeductable().setAmount(10);
        offer.getCoPay().setPercentage(20);
        offer.getDoctorVisit().setLimit(30);
        
        offer.setStatus("Waiting For Approval");
        offer.setInsuranceEnterprise(insuranceEnterprise);
        
        
        offer2.setPlan(plan);
        offer2.setMarket(sMarket);
        offer2.setOfferName("Premium555Senior");
        offer2.setPremium(250);
        offer2.getDeductable().setAmount(10);
        offer2.getCoPay().setPercentage(20);
        offer2.getDoctorVisit().setLimit(30);
        offer2.setStatus("Waiting For Approval");
        offer2.setInsuranceEnterprise(insuranceEnterprise);
//        insuranceEnterprise.getOffers().add(offer);
//        insuranceEnterprise.getOffers().add(offer2);
        
        return business;
    }
    
}
