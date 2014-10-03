/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.SmallBusiness.SmallBusiness;
import Business.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Haripal
 */
public class UpdateMaritalStatusAndEmploymentStatusJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateMaritalStatusAndEmploymentStatusJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    public UpdateMaritalStatusAndEmploymentStatusJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
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
        backjButton = new javax.swing.JButton();
        updatejButton = new javax.swing.JButton();
        mYesjRadioButton = new javax.swing.JRadioButton();
        mNojRadioButton = new javax.swing.JRadioButton();
        empYesjRadioButton = new javax.swing.JRadioButton();
        empNojRadioButton = new javax.swing.JRadioButton();
        companyjComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        compYesjRadioButton = new javax.swing.JRadioButton();
        compnojRadioButton = new javax.swing.JRadioButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Update Marital and Employment Status");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 25, -1, -1));

        jLabel2.setText("Marital Status");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 99, -1, -1));

        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 143, -1, -1));

        jLabel4.setText("Company");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 180, -1, -1));

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 273, -1, -1));

        updatejButton.setText("Update");
        updatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatejButtonActionPerformed(evt);
            }
        });
        add(updatejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 273, -1, -1));

        mYesjRadioButton.setText("Yes");
        add(mYesjRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 95, -1, -1));

        mNojRadioButton.setText("No");
        add(mNojRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 95, -1, -1));

        empYesjRadioButton.setText("Yes");
        empYesjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empYesjRadioButtonActionPerformed(evt);
            }
        });
        add(empYesjRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 139, -1, -1));

        empNojRadioButton.setText("No");
        empNojRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNojRadioButtonActionPerformed(evt);
            }
        });
        add(empNojRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 139, -1, -1));

        companyjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyjComboBoxActionPerformed(evt);
            }
        });
        add(companyjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 180, 117, -1));

        jLabel5.setText("Are you able to find your Company ?");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 222, -1, -1));

        compYesjRadioButton.setText("Yes");
        add(compYesjRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 218, -1, -1));

        compnojRadioButton.setText("No");
        compnojRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compnojRadioButtonActionPerformed(evt);
            }
        });
        add(compnojRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 218, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void empNojRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNojRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empNojRadioButtonActionPerformed

    private void companyjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyjComboBoxActionPerformed

    private void compnojRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compnojRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compnojRadioButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void updatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatejButtonActionPerformed
        // TODO add your handling code here:
        if((mYesjRadioButton.isSelected() &&
              mNojRadioButton.isSelected()) ||
                (empNojRadioButton.isSelected() &&
                empYesjRadioButton.isSelected()) ||
                (compYesjRadioButton.isSelected()&&
                compnojRadioButton.isSelected()))
        {
            JOptionPane.showMessageDialog(null, "Please Select All Options");
            return;
        }
        
        if(mYesjRadioButton.isSelected())
        {
            userAccount.getCustomer().setMaritalStatus(true);
        }
        if(empYesjRadioButton.isSelected() && compYesjRadioButton.isSelected())
        {
            SmallBusiness smallBusiness = (SmallBusiness)companyjComboBox.getSelectedItem();
            userAccount.getCustomer().setSmallBusinessStatus(true);
            userAccount.getCustomer().setSmallBusiness(smallBusiness);
        }
        if(empYesjRadioButton.isSelected() && compnojRadioButton.isSelected())
        {
            userAccount.getCustomer().setSmallBusinessStatus(true);
        }
       JOptionPane.showMessageDialog(null, "Profile Updated"); 
    }//GEN-LAST:event_updatejButtonActionPerformed

    private void empYesjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empYesjRadioButtonActionPerformed
        // TODO add your handling code here:
        for(SmallBusiness sB : userAccount.getExchangeEnterprise().getSmallBusinessDirectory().getSmallBusinessDirectory())
        {
            companyjComboBox.addItem(sB);
        }
    }//GEN-LAST:event_empYesjRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JRadioButton compYesjRadioButton;
    private javax.swing.JComboBox companyjComboBox;
    private javax.swing.JRadioButton compnojRadioButton;
    private javax.swing.JRadioButton empNojRadioButton;
    private javax.swing.JRadioButton empYesjRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton mNojRadioButton;
    private javax.swing.JRadioButton mYesjRadioButton;
    private javax.swing.JButton updatejButton;
    // End of variables declaration//GEN-END:variables
}
