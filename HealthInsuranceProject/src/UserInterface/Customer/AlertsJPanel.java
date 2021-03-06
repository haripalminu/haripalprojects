/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.PaymentPlan.PaymentPlan;
import Business.PaymentPlan.PaymentSchedule;
import Business.UserAccount;
import java.awt.CardLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haripal
 */
public class AlertsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AlertsJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    Date date ;
    Date date1;
    PaymentSchedule paymentSchedule;
    public AlertsJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
        paymentSchedule = userAccount.getCustomer().getPaymentSchedule();
        Calendar cal = Calendar.getInstance();
        date = cal.getTime();
        dateRefresh();
        
        
    }
    public void dateRefresh()
    {
         int rowCount = alertsjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)alertsjTable.getModel()).removeRow(i);
       }
        for(PaymentPlan pp: paymentSchedule.getPaymentSchedule())
        {
             try {
                   date1 = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH).parse(pp.getDate());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Not in Format");
                    return;
                }
             if(date.compareTo(date1)== 0 || date.compareTo(date1) > 0 )
             {
                 Object row[] = new Object[3];
            
            row[0] = pp.getDate();
            row[1] = pp.getInstallment();
            row[2] = pp.getStatus();
            
            DefaultTableModel defTableModel = (DefaultTableModel)alertsjTable.getModel();
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

        backjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alertsjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 394, -1, -1));

        alertsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Amount to be Paid", "PaymentDue Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(alertsjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 88, -1, 91));

        jLabel1.setText("Alerts!!!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 24, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alertsjTable;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
