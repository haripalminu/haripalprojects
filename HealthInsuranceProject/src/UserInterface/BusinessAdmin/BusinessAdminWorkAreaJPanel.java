/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BusinessAdmin;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.UserAccount;
import UserInterface.ExchangeAdmin.AddInsuranceIssuerJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Haripal
 */
public class BusinessAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BusinessAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    Business business;
    Enterprise enterprise;
    
    public BusinessAdminWorkAreaJPanel(JPanel userProcessContainer,UserAccount userAccount,Enterprise enterprise,Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
       this. business = business;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addInsuranceIssuerjButton = new javax.swing.JButton();
        AddUserAccountsjButton = new javax.swing.JButton();
        addExchangejButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addInsuranceIssuerjButton.setText("Add Insurance Issuer");
        addInsuranceIssuerjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInsuranceIssuerjButtonActionPerformed(evt);
            }
        });
        add(addInsuranceIssuerjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 93, 187, -1));

        AddUserAccountsjButton.setText("Add UserAccounts");
        AddUserAccountsjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserAccountsjButtonActionPerformed(evt);
            }
        });
        add(AddUserAccountsjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 169, 187, -1));

        addExchangejButton.setText("Add Exchange Enterprise");
        addExchangejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExchangejButtonActionPerformed(evt);
            }
        });
        add(addExchangejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 169, -1, -1));

        jLabel1.setText("Business Admin Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 24, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addInsuranceIssuerjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInsuranceIssuerjButtonActionPerformed
        // TODO add your handling code here:
        AddInsuranceIssuerJPanel addInsuranceIssuerJPanel  = new AddInsuranceIssuerJPanel(userProcessContainer,business);
        userProcessContainer.add("addInsuranceIssuer",addInsuranceIssuerJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_addInsuranceIssuerjButtonActionPerformed

    private void AddUserAccountsjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserAccountsjButtonActionPerformed
        // TODO add your handling code here:
        BusinessAdminUserAccountsJPanel businessAdminUserAccountsJPanel  = new BusinessAdminUserAccountsJPanel(userProcessContainer,business);
        userProcessContainer.add("BusinessUserAccounts",businessAdminUserAccountsJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_AddUserAccountsjButtonActionPerformed

    private void addExchangejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExchangejButtonActionPerformed
        // TODO add your handling code here:
        AddExchangeJPanel addExchangeJPanel  = new AddExchangeJPanel(userProcessContainer,business);
        userProcessContainer.add("Add Exchnage",addExchangeJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_addExchangejButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserAccountsjButton;
    private javax.swing.JButton addExchangejButton;
    private javax.swing.JButton addInsuranceIssuerjButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
