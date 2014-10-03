/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ExchangeAdmin;

import Business.UserAccount;
import Business.WorkQueue;
import Business.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haripal
 */
public class ApproveInsuranceIssuerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ApproveInsuranceIssuerJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    public ApproveInsuranceIssuerJPanel(JPanel UserProcessContainer, UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
        Refresh();
    }
    
     public void Refresh()
    {
       // WorkQueue workQueue = userAccount.getRole().getWorkArea().getWorkQueue();
        WorkQueue workQueue = userAccount.getExchangeEnterprise().getReceivingQueue();
        ArrayList<WorkRequest> workQueueList = workQueue.getWorkQueue();
        int rowCount = exchangeAdminjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)exchangeAdminjTable.getModel()).removeRow(i);
       }
                        
        for(WorkRequest wR : workQueueList)
        {
                       
          if(wR.getType().equals("Issuer Registartion"))
           { 
            Object row[] = new Object[2];
            
            row[0] = wR.getInsuranceEnterprise();
            row[1] = wR;
            
           
            
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)exchangeAdminjTable.getModel();
                    defTableModel.addRow(row);
           }     
            
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

        approvejButton = new javax.swing.JButton();
        rejectjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        exchangeAdminjTable = new javax.swing.JTable();
        backjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        approvejButton.setText("Approve");
        approvejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvejButtonActionPerformed(evt);
            }
        });

        rejectjButton.setText("Reject");
        rejectjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectjButtonActionPerformed(evt);
            }
        });

        exchangeAdminjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Insurance Enterprise", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(exchangeAdminjTable);

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Approve Insurance Issuer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(rejectjButton)
                .addGap(65, 65, 65)
                .addComponent(approvejButton)
                .addGap(48, 48, 48)
                .addComponent(backjButton)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approvejButton)
                    .addComponent(rejectjButton)
                    .addComponent(backjButton))
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void approvejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvejButtonActionPerformed
        // TODO add your handling code here:
        int selectedRowCount = exchangeAdminjTable.getSelectedRowCount();
        if(selectedRowCount == 0)
        {
            JOptionPane.showMessageDialog(null,"Please select row");
            return;
        }

        if(selectedRowCount <= 0 || selectedRowCount> exchangeAdminjTable.getRowCount())
        {
            return;
        }

        int selectedRow =  exchangeAdminjTable.getSelectedRow();
        WorkRequest selectedWR = (WorkRequest)exchangeAdminjTable.getValueAt(selectedRow, 1);
        selectedWR.setStatus("Approved");
        selectedWR.getInsuranceEnterprise().setStatus("Approved");
        userAccount.getExchangeEnterprise().getInsuranceIssuers().add(selectedWR.getInsuranceEnterprise());
        selectedWR.getInsuranceEnterprise().getExchangeEnterprises().add(userAccount.getExchangeEnterprise());
        Refresh();
        JOptionPane.showMessageDialog(null, "Work Request Approved");
    }//GEN-LAST:event_approvejButtonActionPerformed

    private void rejectjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectjButtonActionPerformed
        // TODO add your handling code here:
        int selectedRowCount = exchangeAdminjTable.getSelectedRowCount();
        if(selectedRowCount == 0)
        {
            JOptionPane.showMessageDialog(null,"Please select row");
            return;
        }

        if(selectedRowCount <= 0 || selectedRowCount> exchangeAdminjTable.getRowCount())
        {
            return;
        }

        int selectedRow =  exchangeAdminjTable.getSelectedRow();
        WorkRequest selectedWR = (WorkRequest)exchangeAdminjTable.getValueAt(selectedRow, 1);
        if(selectedWR.getStatus().equals("Approved"))
        {
            userAccount.getExchangeEnterprise().getInsuranceIssuers().remove(selectedWR.getInsuranceEnterprise());
        selectedWR.getInsuranceEnterprise().getExchangeEnterprises().remove(userAccount.getExchangeEnterprise());
        }
        selectedWR.setStatus("Rejected");
       
        Refresh();
        JOptionPane.showMessageDialog(null, "Work Request Rejected");
    }//GEN-LAST:event_rejectjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approvejButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JTable exchangeAdminjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rejectjButton;
    // End of variables declaration//GEN-END:variables
}
