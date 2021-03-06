/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Treasurary;

import Business.Customer;
import Business.CustomerDirectory;
import Business.PaymentPlan.PaymentPlan;
import Business.Transaction.Transaction;
import Business.UserAccount;
import Business.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haripal
 */
public class ViewAllCustomerTransactionsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAllCustomerTransactionsJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    CustomerDirectory customerDirectory;
    ArrayList<Transaction> transactionHistory;
    Date date;
    public ViewAllCustomerTransactionsJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
         Calendar cal = Calendar.getInstance();
        date = cal.getTime();
        customerDirectory = userAccount.getExchangeEnterprise().getCustomerDirectory();
        transactionHistory = new ArrayList<Transaction>();
        for(Customer customer : customerDirectory.getCustomerDirectory())
        {
            
            for(PaymentPlan pp : customer.getPaymentSchedule().getPaymentSchedule())
            {
                if(pp.getTransactionHistory().getTransactionHistory().size() > 0)
                {
                for(Transaction t : pp.getTransactionHistory().getTransactionHistory())
                {              
                    transactionHistory.add(t);
                }
                }
            }
        }
        Refresh();
    }
    
    public void getExchangeRevenueFromCustomers()
    {
        for(Transaction t : transactionHistory)
        {
          double  temp =   t.getAmount()* 0.1;
          userAccount.getExchangeEnterprise().setExchangeRevenue(temp + userAccount.getExchangeEnterprise().getExchangeRevenue());
        }
    }
    public void Refresh()
    {
        int rowCount = transactionjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)transactionjTable.getModel()).removeRow(i);
       }
                        
        for(Transaction t : transactionHistory)
        {
         
            Object row[] = new Object[5];
            
            row[0] = t.getTransactionId();
            row[1] = t.getAmount();
            row[2] = t;
            row[3] = t.getCustomer();
            row[4] = t.getPaymentPlan().getInvoice().getOrder().getOffer().getInsuranceEnterprise();
            
            
            
           
           
          
            
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
        backjButton = new javax.swing.JButton();
        sendjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionjTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 12)); // NOI18N
        jLabel1.setText("Send Payments To Concerned Parties");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 308, -1, -1));

        sendjButton.setText("Send Payments");
        sendjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendjButtonActionPerformed(evt);
            }
        });
        add(sendjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 308, -1, -1));

        transactionjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Amount", "Transaction Date", "Customer", "Insurance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(transactionjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 70, -1, 87));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void sendjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendjButtonActionPerformed
        // TODO add your handling code here:
        int selectedRowCount = transactionjTable.getSelectedRowCount();
        if(selectedRowCount == 0)
        {
            JOptionPane.showMessageDialog(null,"Please select row");
            return;
        }

        if(selectedRowCount <= 0 || selectedRowCount> transactionjTable.getRowCount())
        {
            return;
        }

        int selectedRow =  transactionjTable.getSelectedRow();
        Transaction selectedTransaction = (Transaction)transactionjTable.getValueAt(selectedRow, 2);
        for(WorkRequest wR1: selectedTransaction.getPaymentPlan().getInvoice().getOrder().getOffer().getInsuranceEnterprise().getReceivingQueue().getWorkQueue())
        {
            if(wR1.getType().equals("Transaction") && (wR1.getTransaction().equals(selectedTransaction)))
            {
                JOptionPane.showMessageDialog(null,"Transaction Already Sent");
                return;
            }
        }
        WorkRequest wR = selectedTransaction.getPaymentPlan().getInvoice().getOrder().getOffer().getInsuranceEnterprise().getReceivingQueue().newWorkRequest();
        selectedTransaction.setAmount(selectedTransaction.getAmount()*0.9);
        wR.setType("Transaction");
        wR.setTransaction(selectedTransaction);
        wR.setStatus("Sent");
        getExchangeRevenueFromCustomers();
        Transaction transaction = userAccount.getExchangeEnterprise().getTransactionHistory().newTransaction();
        transaction.setAmount(selectedTransaction.getAmount());
        SimpleDateFormat formatter= new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(date);
        transaction.setPaidDate(dateNow );
        transaction.setInsuranceEnterprise(selectedTransaction.getPaymentPlan().getInvoice().getOrder().getOffer().getInsuranceEnterprise());
        JOptionPane.showMessageDialog(null,"Transaction Sent");
    }//GEN-LAST:event_sendjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sendjButton;
    private javax.swing.JTable transactionjTable;
    // End of variables declaration//GEN-END:variables
}
