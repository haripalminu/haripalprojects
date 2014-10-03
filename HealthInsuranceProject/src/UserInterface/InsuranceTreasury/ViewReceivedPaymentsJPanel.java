/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InsuranceTreasury;

import Business.Transaction.Transaction;
import Business.UserAccount;
import Business.WorkQueue;
import Business.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haripal
 */
public class ViewReceivedPaymentsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewReceivedPaymentsJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    WorkQueue workQueue;
    public ViewReceivedPaymentsJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
        workQueue = userAccount.getInsuranceEnterprise().getReceivingQueue();
        Refresh();
    }
    public void Refresh()
    {
        ArrayList<WorkRequest> wRList = workQueue.getWorkQueue();
        int rowCount = transactionjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)transactionjTable.getModel()).removeRow(i);
       }
                        
        for(WorkRequest wR : wRList)
        {
         
            Object row[] = new Object[5];
            
            row[0] = wR.getTransaction().getTransactionId();
            row[1] = wR.getTransaction().getAmount();
            row[2] = wR.getTransaction().getPaidDate();
            row[3] = wR.getTransaction().getCustomer();
            row[4] = wR.getTransaction().getPaymentPlan().getInvoice().getOrder().getOffer().getOfferName();
            
            
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)transactionjTable.getModel();
                    defTableModel.addRow(row);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionjTable = new javax.swing.JTable();
        backjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Received Payments");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 22, -1, -1));

        transactionjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Amount", "Transaction Date", "Customer", "Offer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(transactionjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 67, -1, 87));

        backjButton.setText("Back>>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 286, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable transactionjTable;
    // End of variables declaration//GEN-END:variables
}
