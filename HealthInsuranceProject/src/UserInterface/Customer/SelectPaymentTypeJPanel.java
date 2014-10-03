/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Invoice.Invoice;
import Business.PaymentPlan.PaymentPlan;
import Business.PaymentPlan.PaymentSchedule;
import Business.UserAccount;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Haripal
 */
public class SelectPaymentTypeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SelectPaymentTypeJPanel
     */
    JPanel UserProcessContainer;
    Invoice invoice;
    UserAccount userAccount;
    
    double j;
    boolean  getInd = false;
    boolean ind1 = false;
    boolean ind2 = false;
    PaymentSchedule tempPaymentSchedule;
    public SelectPaymentTypeJPanel(JPanel UserProcessContainer,Invoice invoice,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.invoice = invoice;
        this.userAccount= userAccount;
        tempPaymentSchedule = new PaymentSchedule();
        paymentTypejComboBox.removeAllItems();
        paymentTypejComboBox.addItem("Monthly");
        paymentTypejComboBox.addItem("Bi-Weekly");
        paymentTypejComboBox.addItem("Yearly");
        paymentTypejComboBox.addItem("Half Yearly");
        getPaymentPlan();
       paymentTypejComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    String selectedType = (String)paymentTypejComboBox.getSelectedItem();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        if(selectedType.equals("Monthly"))
                        {
                            
                        tempPaymentSchedule.getPaymentSchedule().clear();
                        getPaymentPlan();
                        
                        }
                        else if(selectedType.equals("Bi-Weekly"))
                                {
                                     tempPaymentSchedule.getPaymentSchedule().clear();
                                    
                                    getBiWeeklyPaymentPlan();
                                    
                                }
                        else if(selectedType.equals("Yearly"))
                                {
                                     tempPaymentSchedule.getPaymentSchedule().clear();
                                    
                                    getYearlyPaymentPlan();
                                    
                                }
                        else if(selectedType.equals("Half Yearly"))
                                {
                                     tempPaymentSchedule.getPaymentSchedule().clear();
                                    getHalfYearlyPaymentPlan();
                                    
                                }
                    }
                    //throw new UnsupportedOperationException("Not supported yet.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } );
    }
    
   
    
    public void getPaymentPlan()
    {
        int k = 1;
        
 
        for(int i=0;i<331;i= i+30)
       {
        Calendar cal = Calendar.getInstance();
        
        cal.add(Calendar.DAY_OF_YEAR, i);
        //Date monthAgo = cal.getTime();
        PaymentPlan paymentPlan = tempPaymentSchedule.newPaymentPlan();
        userAccount.getCustomer().getPaymentSchedule().setInvoice(invoice);
        SimpleDateFormat formatter= new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(cal.getTime());
        paymentPlan.setDate(dateNow);
        paymentPlan.setStatus("Not Paid");
        paymentPlan.setType("Monthly");
        paymentPlan.setPaymentId(k++);
        paymentPlan.setInstallment((invoice.getPrice()/12.0));
        paymentPlan.setInvoice(invoice);
       }
        
           
            
       int rowCount = paymentPlanjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)paymentPlanjTable.getModel()).removeRow(i);
       }
                       
        for(PaymentPlan  p: tempPaymentSchedule.getPaymentSchedule())
        {
                       
           
            Object row[] = new Object[5];
            
            row[0] = p.getPaymentId();
            row[1] = p.getDate();
            row[2] = p.getType();
            row[3] = p.getStatus();
            DecimalFormat df = new DecimalFormat("#.##");
            row[4] = df.format(p.getInstallment());
            
            
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)paymentPlanjTable.getModel();
                    defTableModel.addRow(row);
           
            
    }
    }
    
     public void getBiWeeklyPaymentPlan()
    {
       int k = 1; 
        for(int i=0;i<346;i= i+15)
       {
           Calendar cal = Calendar.getInstance();
        
        cal.add(Calendar.DAY_OF_YEAR, i);
        //Date monthAgo = cal.getTime();
        PaymentPlan paymentPlan = tempPaymentSchedule.newPaymentPlan();
        SimpleDateFormat formatter= new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(cal.getTime());
        paymentPlan.setDate(dateNow);
        paymentPlan.setStatus("Not Paid");
        paymentPlan.setType("Monthly");
        paymentPlan.setPaymentId(k++);
        paymentPlan.setInvoice(invoice);
        
        paymentPlan.setInstallment(invoice.getPrice()/24);
       }
       int rowCount = paymentPlanjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)paymentPlanjTable.getModel()).removeRow(i);
       }
                       
        for(PaymentPlan  p: tempPaymentSchedule.getPaymentSchedule())
        {
                       
           
            Object row[] = new Object[5];
            
            row[0] = p.getPaymentId();
            row[1] = p.getDate();
            row[2] = p.getType();
            row[3] = p.getStatus();
            DecimalFormat df = new DecimalFormat("#.##");
        
            row[4] = df.format(p.getInstallment());
            
            System.out.println(df.format(p.getInstallment()));
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)paymentPlanjTable.getModel();
                    defTableModel.addRow(row);
           
            
    }
    }

     public void getYearlyPaymentPlan()
    {
        int k = 1;
        
           Calendar cal = Calendar.getInstance();
        
        //cal.add(Calendar.DAY_OF_YEAR, 30);
        //Date monthAgo = cal.getTime();
        PaymentPlan paymentPlan = tempPaymentSchedule.newPaymentPlan();
        SimpleDateFormat formatter= new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(cal.getTime());
        paymentPlan.setDate(dateNow);
        paymentPlan.setStatus("Not Paid");
        paymentPlan.setType("Yearly");
        paymentPlan.setPaymentId(k++);
        paymentPlan.setInvoice(invoice);
        
        paymentPlan.setInstallment(invoice.getPrice());
       
       int rowCount = paymentPlanjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)paymentPlanjTable.getModel()).removeRow(i);
       }
                       
        for(PaymentPlan  p: tempPaymentSchedule.getPaymentSchedule())
        {
                       
           
            Object row[] = new Object[5];
            
            row[0] = p.getPaymentId();
            row[1] = p.getDate();
            row[2] = p.getType();
            row[3] = p.getStatus();
            DecimalFormat df = new DecimalFormat("#.##");
        
            row[4] = df.format(p.getInstallment());
            
            System.out.println(df.format(p.getInstallment()));
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)paymentPlanjTable.getModel();
                    defTableModel.addRow(row);
           
            
    }
    }
     
     public void getHalfYearlyPaymentPlan()
    {
        int k = 1;
        for(int i=0;i<181;i= i+180)
       {
           Calendar cal = Calendar.getInstance();
        
        cal.add(Calendar.DAY_OF_YEAR, i);
        //Date monthAgo = cal.getTime();
        PaymentPlan paymentPlan = tempPaymentSchedule.newPaymentPlan();
        SimpleDateFormat formatter= new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(cal.getTime());
        paymentPlan.setDate(dateNow);
        paymentPlan.setStatus("Not Paid");
        paymentPlan.setType("HalfYearly");
        paymentPlan.setPaymentId(k++);
        paymentPlan.setInvoice(invoice);
        
        paymentPlan.setInstallment(invoice.getPrice()/2);
       }
       int rowCount = paymentPlanjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)paymentPlanjTable.getModel()).removeRow(i);
       }
                       
        for(PaymentPlan  p: tempPaymentSchedule.getPaymentSchedule())
        {
                       
           
            Object row[] = new Object[5];
            
            row[0] = p.getPaymentId();
            row[1] = p.getDate();
            row[2] = p.getType();
            row[3] = p.getStatus();
            DecimalFormat df = new DecimalFormat("#.##");
        
            row[4] = df.format(p.getInstallment());
            
            System.out.println(df.format(p.getInstallment()));
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)paymentPlanjTable.getModel();
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
        paymentTypejComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentPlanjTable = new javax.swing.JTable();
        getjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();
        paymentjButton = new javax.swing.JButton();
        autoDebitjButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Select Your Payment Type");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 23, -1, -1));

        add(paymentTypejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 20, -1, -1));

        paymentPlanjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Payment Due Date", "Payment Type", "Payment Status", "Due Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(paymentPlanjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 74, -1, 253));

        getjButton.setText("Select Your Payment Schedule");
        getjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getjButtonActionPerformed(evt);
            }
        });
        add(getjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 19, -1, -1));

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 333, -1, -1));

        paymentjButton.setText("Proceed With Your Payment");
        paymentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentjButtonActionPerformed(evt);
            }
        });
        add(paymentjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 333, -1, -1));

        autoDebitjButton.setText("Enable Auto Debit");
        autoDebitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoDebitjButtonActionPerformed(evt);
            }
        });
        add(autoDebitjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 333, -1, -1));

        jButton1.setText("Enter Account Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 19, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        if(ind1 == false || ind2 == false)
        {
            JOptionPane.showMessageDialog(null, "Must Select Payment Plan");
            return;
        }
                
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void getjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getjButtonActionPerformed
        // TODO add your handling code here:
            if(userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().size() > 0)
        {
            JOptionPane.showMessageDialog(null, "Payment schedule has already been generated for you");
            return;
        }
        
        for(PaymentPlan pp : tempPaymentSchedule.getPaymentSchedule())
        {
            userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().add(pp);
        }
        ind1 = true;
        
//        if(userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().size() > 0)
//        {
//            JOptionPane.showMessageDialog(null, "Payment schedule has already been generated for you");
//            return;
//        }
//        try{
//        String selectedPaymentPlan = (String)paymentTypejComboBox.getSelectedItem();
//        if(selectedPaymentPlan.equals("Monthly"))
//        {
//        
//            
//            
//            
//                   
//        }
//        else if(selectedPaymentPlan.equals("Bi-Weekly"))
//        {
//            
//            
//            
//            getBiWeeklyPaymentPlan();
//        }
//        else if(selectedPaymentPlan.equals("Yearly"))
//        {
//           
//            getYearlyPaymentPlan();
//        }
//         else if(selectedPaymentPlan.equals("Half Yearly"))
//        {
//            
//            getHalfYearlyPaymentPlan();
//        }
//        }catch(ConcurrentModificationException e)
//        {
//            JOptionPane.showMessageDialog(null, "Payment schedule has already been generated for you");
//            
//        }
//      getInd = true;  
        JOptionPane.showMessageDialog(null, "Payment Plan added");
    }//GEN-LAST:event_getjButtonActionPerformed

    private void paymentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentjButtonActionPerformed
        // TODO add your handling code here:
        if(ind2 == false)
        {
             JOptionPane.showMessageDialog(null, "Must Enter Card Details");
             return;
        }
        PayYourMonthlyPremiumJPanel payYourMonthlyPremiumJPanel  = new PayYourMonthlyPremiumJPanel(UserProcessContainer,userAccount);
        UserProcessContainer.add("Payment",payYourMonthlyPremiumJPanel);
        CardLayout cardLayout = (CardLayout)UserProcessContainer.getLayout();
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_paymentjButtonActionPerformed

    private void autoDebitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoDebitjButtonActionPerformed
        // TODO add your handling code here:
        
        if(userAccount.getCustomer().getAutoDebit().getCardNumber() == null)
        {
            JOptionPane.showMessageDialog(null, "No Card Details");
        }
        if(ind1== true && ind2== true)
            
        {
            userAccount.getCustomer().getAutoDebit().setAutoDebitStatus(true);
            
            JOptionPane.showMessageDialog(null, "AutoDebitEnabled");
        }
       else
        {
            JOptionPane.showMessageDialog(null, "Must select Payment Plan and enter card details");
            
        }
        
        
    }//GEN-LAST:event_autoDebitjButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(ind1 == false)
        {
            JOptionPane.showMessageDialog(null, "Select Payment Plan and then enter a/c Details");
            return;
        }
         AutoDebitJPanel autoDebitJPanel  = new AutoDebitJPanel(UserProcessContainer,userAccount);
        UserProcessContainer.add("autoDebit",autoDebitJPanel);
        CardLayout cardLayout = (CardLayout)UserProcessContainer.getLayout();
        cardLayout.next(UserProcessContainer);
        ind2 = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autoDebitjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JButton getjButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable paymentPlanjTable;
    private javax.swing.JComboBox paymentTypejComboBox;
    private javax.swing.JButton paymentjButton;
    // End of variables declaration//GEN-END:variables
}
