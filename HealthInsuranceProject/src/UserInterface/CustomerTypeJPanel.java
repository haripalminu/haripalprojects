/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Business;
import UserInterface.CustomerRegistration.AddSmallBusinessJPanel;
import UserInterface.CustomerRegistration.CustomerRegistrationJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Haripal
 */
public class CustomerTypeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerTypeJPanel
     */
    JPanel UserProcessContainer;
    Business business;
    public CustomerTypeJPanel(JPanel UserProcessContainer,Business business) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.business = business;
        customerTypejComboBox.removeAllItems();
        customerTypejComboBox.addItem("Individual");
        customerTypejComboBox.addItem("Small Business");
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
        customerTypejComboBox = new javax.swing.JComboBox();
        gojButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();

        jLabel1.setText("Customer Type");

        jLabel2.setText("Customer Type");

        gojButton.setText("Go");
        gojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gojButtonActionPerformed(evt);
            }
        });

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backjButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(229, 229, 229)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addComponent(jLabel2)
                            .addGap(36, 36, 36)
                            .addComponent(customerTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(gojButton))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customerTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gojButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(backjButton)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void gojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gojButtonActionPerformed
        // TODO add your handling code here:
        String selectedString = (String)customerTypejComboBox.getSelectedItem();
        if(selectedString.equals("Individual"))
        {
        CustomerRegistrationJPanel customerRegistrationJPanel  = new CustomerRegistrationJPanel(UserProcessContainer,business);
        UserProcessContainer.add("CustomerRegistration",customerRegistrationJPanel);
        CardLayout cardLayout = (CardLayout)UserProcessContainer.getLayout();
        cardLayout.next(UserProcessContainer);
        }
        else
        {
        AddSmallBusinessJPanel addSmallBusinessJPanel  = new AddSmallBusinessJPanel(UserProcessContainer,business);
        UserProcessContainer.add("addSmallBusiness",addSmallBusinessJPanel);
        CardLayout cardLayout = (CardLayout)UserProcessContainer.getLayout();
        cardLayout.next(UserProcessContainer);
        }
        
    }//GEN-LAST:event_gojButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JComboBox customerTypejComboBox;
    private javax.swing.JButton gojButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
