/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InsuranceAdmin;

import Business.Enterprise.Enterprise;
import Business.Market;
import Business.Offer;
import Business.Offers;
import Business.Plan;
import Business.UserAccount;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Haripal
 */
public class ManageOffersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOffersJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    Offers offers;
    
    public ManageOffersJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
        offers = userAccount.getInsuranceEnterprise().getOffers();
        offerjComboBox.removeAllItems();
        for(Offer o : offers.getOffers())
        {
            offerjComboBox.addItem(o);
        }
        Refresh();
        
        offerjComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Refresh();
                    }
        }catch (Exception ex) {
                    ex.printStackTrace();
                }
        
    }
        } );
                }
    private void Refresh()
    {
        Offer selectedOffer = (Offer)offerjComboBox.getSelectedItem();
        offerNamejTextField.setText(selectedOffer.getOfferName());
       // jTextField.setText(selectedOffer.getMarket().getMarketName());
        premiumjTextField.setText(String.valueOf(selectedOffer.getPremium()));
        copayjTextField.setText(String.valueOf(selectedOffer.getCoPay().getPercentage()));
        doctorVisitjTextField.setText(String.valueOf(selectedOffer.getDoctorVisit().getLimit()));
        deductablejTextField.setText(String.valueOf(selectedOffer.getDeductable().getAmount()));
        planjTextField.setText(selectedOffer.getPlan().getPlanName());
       
        
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
        offerjComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addtoOfferListjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();
        offerNamejTextField = new javax.swing.JTextField();
        premiumjTextField = new javax.swing.JTextField();
        doctorVisitjTextField = new javax.swing.JTextField();
        copayjTextField = new javax.swing.JTextField();
        deductablejTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        planjTextField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Offer");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 36, -1, -1));

        add(offerjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 33, 126, -1));

        jLabel2.setText("Offer Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 84, -1, -1));

        jLabel4.setText("Premium");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 139, -1, -1));

        jLabel5.setText("Doctor Visit");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 84, -1, -1));

        jLabel6.setText("Co-Pay");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 135, -1, -1));

        jLabel7.setText("Deductable");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 184, -1, -1));

        addtoOfferListjButton.setText("Update");
        addtoOfferListjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoOfferListjButtonActionPerformed(evt);
            }
        });
        add(addtoOfferListjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 292, -1, -1));

        offerNamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerNamejTextFieldActionPerformed(evt);
            }
        });
        add(offerNamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 81, 90, -1));
        add(premiumjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 136, 90, -1));
        add(doctorVisitjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 81, 93, -1));
        add(copayjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 132, 93, -1));
        add(deductablejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 181, 93, -1));

        jLabel8.setText("Plan");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 190, -1, -1));
        add(planjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 187, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addtoOfferListjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoOfferListjButtonActionPerformed
        // TODO add your handling code here:
        
        
        
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
            Offer offer = (Offer) offerjComboBox.getSelectedItem();
            offer.setOfferName(offerNamejTextField.getText());
            offer.setPremium(Integer.parseInt(premiumjTextField.getText()));
            
            
            offer.getDeductable().setAmount(Double.parseDouble(deductablejTextField.getText()));
            offer.getCoPay().setPercentage(Integer.parseInt(copayjTextField.getText()));
            offer.getDoctorVisit().setLimit(Integer.parseInt(doctorVisitjTextField.getText()));
            
            
            offer.setStatus("Yet to Approve");
            
            // userAccount.getInsuranceEnterprise().getOffers().add(offer);

            JOptionPane.showMessageDialog(null,"Offer Updated");
        
    }//GEN-LAST:event_addtoOfferListjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);

    }//GEN-LAST:event_backjButtonActionPerformed

    private void offerNamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerNamejTextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_offerNamejTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoOfferListjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JTextField copayjTextField;
    private javax.swing.JTextField deductablejTextField;
    private javax.swing.JTextField doctorVisitjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField offerNamejTextField;
    private javax.swing.JComboBox offerjComboBox;
    private javax.swing.JTextField planjTextField;
    private javax.swing.JTextField premiumjTextField;
    // End of variables declaration//GEN-END:variables
}
