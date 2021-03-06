/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InsuranceAdmin;

import Business.Business;
import Business.Enterprise.InsuranceEnterprise;
import Business.Exchange.Exchange;
import Business.Market;
import Business.Markets;
import Business.Offer;
import Business.Offers;
import Business.Plan;
import Business.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Haripal
 */
public class AddOffersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddOffersJPanel
     */
    JPanel UserProcessContainer;
    Business business;
    Offers offers;
    UserAccount userAccount;
    Markets markets;
    InsuranceEnterprise insuranceEnterprise;
    public AddOffersJPanel(JPanel UserProcessConatiner,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessConatiner;
        this.userAccount = userAccount;
        //business = Business.getInstanceOfBusiness();
         marketjComboBox.removeAllItems();
        for(Exchange ee :userAccount.getInsuranceEnterprise().getExchangeEnterprises())
        {
            for(Market m : ee.getMarkets().getMarkets())
            {
                 marketjComboBox.addItem(m);
            }
        }
       
        
        insuranceEnterprise = userAccount.getInsuranceEnterprise();
        if(insuranceEnterprise.getPlanCatalouge().getPlanCatalouge().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No Plans added");
            return;
        }
       
//        for(Market m : markets.getMarkets())
//        {
//            marketjComboBox.addItem(m);
//        }
//        
        planjComboBox.removeAllItems();
        for(Plan p : insuranceEnterprise.getPlanCatalouge().getPlanCatalouge())
        {
            planjComboBox.addItem(p);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addtoOfferListjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();
        marketjComboBox = new javax.swing.JComboBox();
        offerNamejTextField = new javax.swing.JTextField();
        premiumjTextField = new javax.swing.JTextField();
        doctorVisitjTextField = new javax.swing.JTextField();
        copayjTextField = new javax.swing.JTextField();
        deductablejTextField = new javax.swing.JTextField();
        planjComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Add Offers");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 32, -1, -1));

        jLabel2.setText("Offer Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 96, -1, -1));

        jLabel3.setText("Market");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 147, -1, -1));

        jLabel4.setText("Premium");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 196, -1, -1));

        jLabel5.setText("Doctor Visit");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 96, -1, -1));

        jLabel6.setText("Co-Pay");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 147, -1, -1));

        jLabel7.setText("Deductable");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 196, -1, -1));

        addtoOfferListjButton.setText("Add to Offer List");
        addtoOfferListjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoOfferListjButtonActionPerformed(evt);
            }
        });
        add(addtoOfferListjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 304, -1, -1));

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 304, -1, -1));

        marketjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marketjComboBoxActionPerformed(evt);
            }
        });
        add(marketjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 144, 95, -1));

        offerNamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerNamejTextFieldActionPerformed(evt);
            }
        });
        add(offerNamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 93, 95, -1));
        add(premiumjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 193, 95, -1));
        add(doctorVisitjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 93, 93, -1));
        add(copayjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 144, 93, -1));
        add(deductablejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 193, 93, -1));

        add(planjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 242, 95, -1));

        jLabel8.setText("Plan");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 248, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
        
    }//GEN-LAST:event_backjButtonActionPerformed

    private void offerNamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerNamejTextFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_offerNamejTextFieldActionPerformed

    private void addtoOfferListjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoOfferListjButtonActionPerformed
        // TODO add your handling code here:
        if(offerNamejTextField.getText().length() == 0 || 
                premiumjTextField.getText().length() == 0)
        {
             JOptionPane.showMessageDialog(null, "One of the feilds is null");
        }
        else
        {
            try {
            Integer.parseInt(premiumjTextField.getText());
            Integer.parseInt(doctorVisitjTextField.getText());
            Integer.parseInt(deductablejTextField.getText());
            Integer.parseInt(copayjTextField.getText());
            
             
         } catch (NumberFormatException e) {
           
            JOptionPane.showMessageDialog(null, " Must be a number");
            return;
        }
           // Offer offer = new Offer();
            Offer offer = userAccount.getInsuranceEnterprise().getOffers().newOffer();
            offer.setOfferName(offerNamejTextField.getText());
            offer.setPremium(Integer.parseInt(premiumjTextField.getText()));
            Market selectedMarket = (Market) marketjComboBox.getSelectedItem();
            offer.setMarket(selectedMarket);
            offer.getDeductable().setAmount(Double.parseDouble(deductablejTextField.getText()));
            offer.getCoPay().setPercentage(Integer.parseInt(copayjTextField.getText()));
            offer.getDoctorVisit().setLimit(Integer.parseInt(doctorVisitjTextField.getText()));
            Plan selectedPlan = (Plan) planjComboBox.getSelectedItem();
            offer.setPlan(selectedPlan);
            offer.setStatus("Yet to Approve");
            offer.setInsuranceEnterprise(selectedPlan.getInsuranceEnterprise());
           // userAccount.getInsuranceEnterprise().getOffers().add(offer);
            
            JOptionPane.showMessageDialog(null,"Offer Added");
        }
    }//GEN-LAST:event_addtoOfferListjButtonActionPerformed

    private void marketjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marketjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marketjComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoOfferListjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JTextField copayjTextField;
    private javax.swing.JTextField deductablejTextField;
    private javax.swing.JTextField doctorVisitjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox marketjComboBox;
    private javax.swing.JTextField offerNamejTextField;
    private javax.swing.JComboBox planjComboBox;
    private javax.swing.JTextField premiumjTextField;
    // End of variables declaration//GEN-END:variables
}
