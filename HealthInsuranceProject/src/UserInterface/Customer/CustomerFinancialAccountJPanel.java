/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Customer;
import Business.PaymentPlan.PaymentPlan;
import Business.Transaction.Transaction;
import Business.UserAccount;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haripal
 */
public class CustomerFinancialAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerFinancialAccountJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    Customer customer;
    double c = 0.0;
    public CustomerFinancialAccountJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
        DecimalFormat df = new DecimalFormat("#.##");
        customer = userAccount.getCustomer();
        dueAmountjTextField.setText(String.valueOf(df.format(customer.getPaymentSchedule().getDueAmount())));
       // paidAmountjTextField.setText(String.valueOf(df.format(customer.getPaymentSchedule().getAmountPaid())));
        if(customer.getPaymentSchedule().getInvoice() == null)
        {
           paidAmountjTextField.setText("0.0") ;
        }
        else
        {
        paidAmountjTextField.setText(String.valueOf(df.format(customer.getPaymentSchedule().getInvoice().getPrice() - customer.getPaymentSchedule().getDueAmount()  )));
        
        offerNamejTextField.setText(customer.getPaymentSchedule().getInvoice().getOrder().getOffer().getOfferName());
        }
        Refresh();
        
    }

    public void Refresh()
    {
         int rowCount = paymentsmadejTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)paymentsmadejTable.getModel()).removeRow(i);
       }
        
        ArrayList<PaymentPlan> uAList = customer.getPaymentSchedule().getPaymentSchedule();
        
        for(PaymentPlan pp : uAList)
        {
            if(pp.getStatus().equals("Paid"))  
            {
          
            Object row[] = new Object[3];
            
            row[0] = pp.getDate();
            for(Transaction t : pp.getTransactionHistory().getTransactionHistory())
            {
            
            double temp = t.getAmount();
            c = c + temp;
            
            }
            row[1] = c;
            row[2] = pp.getInvoice().getOrder().getOffer().getOfferName();
            
            
            
            
            DefaultTableModel defTableModel = (DefaultTableModel)paymentsmadejTable.getModel();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentsmadejTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dueAmountjTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        paidAmountjTextField = new javax.swing.JTextField();
        backjButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        offerNamejTextField = new javax.swing.JTextField();

        jLabel1.setText("Customer Financial Account");

        paymentsmadejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Payment Made Date", "Amount Paid", "Offer Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(paymentsmadejTable);

        jLabel2.setText("Payments Made");

        jLabel3.setText("Amount Yet to be Paid");

        dueAmountjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueAmountjTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Amount Paid till Date");

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Offer Name");

        offerNamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerNamejTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backjButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(376, 376, 376))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dueAmountjTextField)
                            .addComponent(paidAmountjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(offerNamejTextField))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dueAmountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(paidAmountjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(offerNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(backjButton)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dueAmountjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueAmountjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dueAmountjTextFieldActionPerformed

    private void offerNamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerNamejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offerNamejTextFieldActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JTextField dueAmountjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField offerNamejTextField;
    private javax.swing.JTextField paidAmountjTextField;
    private javax.swing.JTable paymentsmadejTable;
    // End of variables declaration//GEN-END:variables
}
