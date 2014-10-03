/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Business;
import Business.Customer;
import Business.Invoice.Invoice;
import Business.Offer;
import Business.Order.MasterOrderCatalog;
import Business.Order.Order;
import Business.PaymentPlan.PaymentPlan;
import Business.SmallBusiness.SmallBusiness;
import Business.UserAccount;
import java.awt.CardLayout;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haripal
 */
public class ViewYourOffersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewYourOffersJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    Business business;
    MasterOrderCatalog tempMasterOrderCatalog;
    boolean ar = false;
    Order tempOrder;
    Invoice invoice;
    boolean checkoutInd = false;
    public ViewYourOffersJPanel(JPanel UserProcessContainer,UserAccount userAccount,Business business) {
        initComponents();
        this.UserProcessContainer  = UserProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        tempMasterOrderCatalog = new MasterOrderCatalog();
        invoice = userAccount.getExchangeEnterprise().getInvoiceCatalog().newInvoice();
        Refresh();
    }
    

     public void Refresh()
    {
       
        int rowCount = customerOffersjTable1.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)customerOffersjTable1.getModel()).removeRow(i);
       }
                       
        for(Offer o : business.getCustomerOffers(userAccount))
        {
                       
           
            Object row[] = new Object[6];
            
            row[0] = o.getPlan().getInsuranceEnterprise();
            row[1] = o;
            
            row[2] = o.getPremium();
            row[3] = o.getDeductable().getAmount();
            row[4] = o.getCoPay().getPercentage();
            row[5] = o.getDoctorVisit().getLimit();
            
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)customerOffersjTable1.getModel();
                    defTableModel.addRow(row);
           
            
    }
    }
     
     public void Refresh2()
     { 
        
        
        
        int selectedRowCount = customerOffersjTable1.getSelectedRowCount();
        if (selectedRowCount == 0) {
            JOptionPane.showMessageDialog(null, "Please select product");
            return;
        }

        
        if (selectedRowCount <= 0 || selectedRowCount > customerOffersjTable1.getRowCount()) {
            return;
        }
        
        if((!userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().isEmpty() ))
        {
            JOptionPane.showMessageDialog(null, "Order is already Invoiced");
//
            return;
            
        }
//        for(Order och: userAccount.getExchangeEnterprise().getMasterOrderCatalog().getMasterOrderCatalog())
//        {
//            if(userAccount.getCustomer().equals(och.getPerson()))
//            {
//                JOptionPane.showMessageDialog(null, "Order is already Invoiced");
//                return;
//            }
//        }
       
        int selectedRow = customerOffersjTable1.getSelectedRow();
        Offer selectedOffer = (Offer) customerOffersjTable1.getValueAt(selectedRow, 1);
        if(tempMasterOrderCatalog.getMasterOrderCatalog().size() > 0)
        {
            JOptionPane.showMessageDialog(null, "You Cannot order more than one insurance");
            return;
        }
        
     
//        if(selectedOffer.equals(userAccount.getCustomer().getPaymentSchedule().getInvoice().getOrder().getOffer()))
//        {
//           
//            JOptionPane.showMessageDialog(null, "");
//            return;
//        
//        }
        for(Order oc:tempMasterOrderCatalog.getMasterOrderCatalog())
        {
            if(oc.getOffer().equals(selectedOffer))
            {
                
                JOptionPane.showMessageDialog(null, "Already Added to the Cart");
                ar = true;
                return;
            }
            
                                            
            
        }
        if(ar ==false)
        {
                Customer customer = (Customer)userAccount.getPerson();
                tempOrder = tempMasterOrderCatalog.newOrder();
                tempOrder.setOffer(selectedOffer); 
                tempOrder.setPerson(userAccount.getPerson());
                tempOrder.setCustomer(userAccount.getCustomer());
                System.out.println(tempMasterOrderCatalog.getMasterOrderCatalog().size());
        }
        int rowCount1 = orderOffersjTable.getRowCount();
        for (int i = rowCount1 - 1; i >= 0; i--) {
            ((DefaultTableModel) orderOffersjTable.getModel()).removeRow(i);
        }
//        if(tempMasterOrderCatalog.getMasterOrderCatalog().size() > 0)
//        {
//            JOptionPane.showMessageDialog(null, "You Cannot order more than one insurance");
//            return;
//        }
       
        for(Order tO:tempMasterOrderCatalog.getMasterOrderCatalog())
        {
        Object row[] = new Object[3];
            row[0] = tO;
            row[1] = tO.getOffer();
            row[2] = tO.getOffer().getPremium();
            
            DefaultTableModel defTableModel = (DefaultTableModel) orderOffersjTable.getModel();
            defTableModel.addRow(row);
        }
         invoice.setOrder(tempOrder);
       invoice.setPrice(tempOrder.getOffer().getPremium());
        if(userAccount.getPerson().getRiskFactor() == 0)
        {
            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.1));
            invoice.setOtherAmount(  (tempOrder.getOffer().getPremium()*0.1));
            System.out.println((tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.1)));
        }
        if(userAccount.getPerson().getRiskFactor() == 1)
        {
            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.2));
            invoice.setOtherAmount(invoice.getOtherAmount() + (tempOrder.getOffer().getPremium()*0.2));
        }
        if(userAccount.getPerson().getRiskFactor() == 2)
        {
            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.3));
            invoice.setOtherAmount(invoice.getOtherAmount() + (tempOrder.getOffer().getPremium()*0.3));
        }
        if(userAccount.getPerson().getRiskFactor() > 2)
        {
            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.4));
            invoice.setOtherAmount(invoice.getOtherAmount() + (tempOrder.getOffer().getPremium()*0.4));
        }
        if(!(userAccount.getCustomer() == null))
        {
        if(userAccount.getCustomer().isSmallBusinessStatus() && userAccount.getPerson().getIncome() < 11000 )
        {
        invoice.setPrice(invoice.getPrice() - (tempOrder.getOffer().getPremium()*(userAccount.getCustomer().getSmallBusiness().getApprovedDiscount()/100))-
                (tempOrder.getOffer().getPremium()* 0.2));
        invoice.setSubsidy(((tempOrder.getOffer().getPremium()*userAccount.getCustomer().getSmallBusiness().getApprovedDiscount()/100))-
                (tempOrder.getOffer().getPremium()* 0.2));
        }
        else if((userAccount.getCustomer().isSmallBusinessStatus() && userAccount.getPerson().getIncome() > 11000))
                {
                    for(SmallBusiness sB : invoice.getOrder().getOffer().getInsuranceEnterprise().getSmallBusinessDirectory().getSmallBusinessDirectory())
                    {
                    if(sB.equals(userAccount.getCustomer().getSmallBusiness()))
                        
                    {
                        System.out.println("in invoice bdhfcas");
                    invoice.setPrice(invoice.getPrice() - (tempOrder.getOffer().getPremium()*(userAccount.getCustomer().getSmallBusiness().getApprovedDiscount()/100)));
                    invoice.setSubsidy(tempOrder.getOffer().getPremium()*(userAccount.getCustomer().getSmallBusiness().getApprovedDiscount()/100));
                    }
                    }  
                }
        else if((!userAccount.getCustomer().isSmallBusinessStatus() && userAccount.getPerson().getIncome() < 11000))
                {
                   
                   // invoice.setPrice(tempOrder.getOffer().getPremium() - (tempOrder.getOffer().getPremium()* 0.2));
                    invoice.setPrice(invoice.getPrice() - (tempOrder.getOffer().getPremium()* 0.2));
                    invoice.setSubsidy(tempOrder.getOffer().getPremium()* 0.2);
                }
        userAccount.getCustomer().setInvoice(invoice);
       
     }
     }
     
     public void Refresh3()
     {
         int rowCount1 = orderOffersjTable.getRowCount();
        for (int i = rowCount1 - 1; i >= 0; i--) {
            ((DefaultTableModel) orderOffersjTable.getModel()).removeRow(i);
        }
//        if(tempMasterOrderCatalog.getMasterOrderCatalog().size() > 0)
//        {
//            JOptionPane.showMessageDialog(null, "You Cannot order more than one insurance");
//            return;
//        }
       
        for(Order tO:tempMasterOrderCatalog.getMasterOrderCatalog())
        {
        Object row[] = new Object[3];
            row[0] = tO;
            row[1] = tO.getOffer();
            row[2] = tO.getOffer().getPremium();
            
            DefaultTableModel defTableModel = (DefaultTableModel) orderOffersjTable.getModel();
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
        orderOffersjTable = new javax.swing.JTable();
        backjButton = new javax.swing.JButton();
        viewDetailsjButton = new javax.swing.JButton();
        orderjButton = new javax.swing.JButton();
        checkOutjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerOffersjTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        removejButton = new javax.swing.JButton();
        removeExistingjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("View Health Plans For Your Profile");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 25, -1, -1));

        orderOffersjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Isurance Issuer", "OfferName", "Basic Premium"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderOffersjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 201, -1, 91));

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 344, -1, -1));

        viewDetailsjButton.setText("View Your Invoice");
        viewDetailsjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsjButtonActionPerformed(evt);
            }
        });
        add(viewDetailsjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 344, -1, -1));

        orderjButton.setText("Order");
        orderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderjButtonActionPerformed(evt);
            }
        });
        add(orderjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 344, -1, -1));

        checkOutjButton.setText("Check Out");
        checkOutjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutjButtonActionPerformed(evt);
            }
        });
        add(checkOutjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 344, -1, -1));

        customerOffersjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Isurance Issuer", "OfferName", "Basic Premium", "Deductable", "Co-Pay", "DoctorVisit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(customerOffersjTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 55, -1, 91));

        jLabel2.setText("View Your Orders Here");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 169, -1, -1));

        removejButton.setText("Remove");
        removejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removejButtonActionPerformed(evt);
            }
        });
        add(removejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 378, -1, -1));

        removeExistingjButton.setText("Remove exising Plan");
        removeExistingjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeExistingjButtonActionPerformed(evt);
            }
        });
        add(removeExistingjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 378, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void orderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderjButtonActionPerformed
        // TODO add your handling code here:
        checkoutInd = true;
        Refresh2();
//        ViewInvoicesJPanel viewInvoicesJPanel  = new ViewInvoicesJPanel(UserProcessContainer,invoice,userAccount);
//        UserProcessContainer.add("Customer Invoice",viewInvoicesJPanel);
//        CardLayout cardLayout = (CardLayout)UserProcessContainer.getLayout();
//        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_orderjButtonActionPerformed

    private void checkOutjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutjButtonActionPerformed
        // TODO add your handling code here:
        
        if(tempMasterOrderCatalog.getMasterOrderCatalog().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You must order your offer first");
            return;
        }
        for(Order oCheck :tempMasterOrderCatalog.getMasterOrderCatalog())
        {
            userAccount.getExchangeEnterprise().getMasterOrderCatalog().getMasterOrderCatalog().add(oCheck);
        }
        
//        invoice.setOrder(tempOrder);
//       invoice.setPrice(tempOrder.getOffer().getPremium());
//        if(userAccount.getPerson().getRiskFactor() == 0)
//        {
//            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.1));
//            invoice.setOtherAmount(invoice.getOtherAmount() + (tempOrder.getOffer().getPremium()*0.1));
//        }
//        if(userAccount.getPerson().getRiskFactor() == 1)
//        {
//            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.2));
//            invoice.setOtherAmount(invoice.getOtherAmount() + (tempOrder.getOffer().getPremium()*0.2));
//        }
//        if(userAccount.getPerson().getRiskFactor() == 2)
//        {
//            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.3));
//            invoice.setOtherAmount(invoice.getOtherAmount() + (tempOrder.getOffer().getPremium()*0.3));
//        }
//        if(userAccount.getPerson().getRiskFactor() > 2)
//        {
//            invoice.setPrice(tempOrder.getOffer().getPremium() + (tempOrder.getOffer().getPremium()*0.4));
//            invoice.setOtherAmount(invoice.getOtherAmount() + (tempOrder.getOffer().getPremium()*0.4));
//        }
//        if(userAccount.getCustomer().isSmallBusinessStatus() && userAccount.getPerson().getIncome() < 11000 )
//        {
//        invoice.setPrice(tempOrder.getOffer().getPremium() - (tempOrder.getOffer().getPremium()*userAccount.getCustomer().getSmallBusiness().getApprovedDiscount())-
//                (tempOrder.getOffer().getPremium()* 0.2));
//        invoice.setSubsidy(tempOrder.getOffer().getPremium() - (tempOrder.getOffer().getPremium()*userAccount.getCustomer().getSmallBusiness().getApprovedDiscount())-
//                (tempOrder.getOffer().getPremium()* 0.2));
//        }
//        else if((userAccount.getCustomer().isSmallBusinessStatus() && userAccount.getPerson().getIncome() > 11000))
//                {
//                    invoice.setPrice(tempOrder.getOffer().getPremium() - (tempOrder.getOffer().getPremium()*userAccount.getCustomer().getSmallBusiness().getApprovedDiscount()));
//                    invoice.setSubsidy(tempOrder.getOffer().getPremium() - (tempOrder.getOffer().getPremium()*userAccount.getCustomer().getSmallBusiness().getApprovedDiscount()));
//                }
//        userAccount.getCustomer().setInvoice(invoice);
        invoice.getOrder().getOffer().getCustomerList().add(userAccount.getCustomer());
        SelectPaymentTypeJPanel selectPaymentTypeJPanel  = new SelectPaymentTypeJPanel(UserProcessContainer,invoice,userAccount);
        UserProcessContainer.add("Select Payment Type ",selectPaymentTypeJPanel);
        CardLayout cardLayout = (CardLayout)UserProcessContainer.getLayout();
        cardLayout.next(UserProcessContainer);

    }//GEN-LAST:event_checkOutjButtonActionPerformed

    private void removejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removejButtonActionPerformed
        // TODO add your handling code here:
         int selectedRowCount = orderOffersjTable.getSelectedRowCount();
        if(selectedRowCount == 0)
        {
            JOptionPane.showMessageDialog(null,"Please select row");
            return;
        }
        //System.out.println("selected Row Count" + selectedRowCount);
        if(selectedRowCount <= 0 || selectedRowCount> orderOffersjTable.getRowCount())
        {
            return;
        }
        //System.out.println("After selected Row Count");
        int selectedRow =  orderOffersjTable.getSelectedRow();
        Order selectedOrder = (Order)orderOffersjTable.getValueAt(selectedRow, 0);
        
        
        tempMasterOrderCatalog.getMasterOrderCatalog().remove(selectedOrder);
        JOptionPane.showMessageDialog(null, "Order Removed");
        int rowCount1 = orderOffersjTable.getRowCount();
        for (int i = rowCount1 - 1; i >= 0; i--) {
            ((DefaultTableModel) orderOffersjTable.getModel()).removeRow(i);
        }
//        if(tempMasterOrderCatalog.getMasterOrderCatalog().size() > 0)
//        {
//            JOptionPane.showMessageDialog(null, "You Cannot order more than one insurance");
//            return;
//        }
       
        for(Order tO:tempMasterOrderCatalog.getMasterOrderCatalog())
        {
        Object row[] = new Object[3];
            row[0] = tO;
            row[1] = tO.getOffer();
            row[2] = tO.getOffer().getPremium();
            
            DefaultTableModel defTableModel = (DefaultTableModel) orderOffersjTable.getModel();
            defTableModel.addRow(row);
        }
       
    }//GEN-LAST:event_removejButtonActionPerformed

    private void viewDetailsjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsjButtonActionPerformed
        // TODO add your handling code here:
//        if(checkoutInd == true )
//        {
//           JOptionPane.showMessageDialog(null, "You must check out first to see invoice");
//            return; 
//        } 
        if(checkoutInd == false)
        {
           JOptionPane.showMessageDialog(null, "You must order offer first");
            return; 
        }
            
        ViewInvoicesJPanel viewInvoicesJPanel  = new ViewInvoicesJPanel(UserProcessContainer,userAccount.getCustomer().getInvoice(),userAccount);
        UserProcessContainer.add("Customer Invoice",viewInvoicesJPanel);
        CardLayout cardLayout = (CardLayout)UserProcessContainer.getLayout();
        cardLayout.next(UserProcessContainer);
    }//GEN-LAST:event_viewDetailsjButtonActionPerformed

    private void removeExistingjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeExistingjButtonActionPerformed
        // TODO add your handling code here:
        
        for(Iterator<Order> itr = userAccount.getExchangeEnterprise().getMasterOrderCatalog().getMasterOrderCatalog().iterator(); itr.hasNext();)  
        { 
            Order och = itr.next();
           if(userAccount.getCustomer().equals(och.getCustomer()))
           {                            
              itr.remove();
              if(userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().size()> 0)
              {
                  userAccount.getCustomer().getPaymentSchedule().setInvoice(null);
                  userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().clear();
              }
              JOptionPane.showMessageDialog(null, "Now, You are able to select new Plan");
           }
            
           
        
//        if(tempMasterOrderCatalog.getMasterOrderCatalog().size() > 0)
//        {
//            System.out.println("in if");
//        for(Iterator<Order> itr = userAccount.getExchangeEnterprise().getMasterOrderCatalog().getMasterOrderCatalog().iterator(); itr.hasNext();)
//        {
//             System.out.println("in if1");
//            Order och = itr.next();
//             System.out.println("in if2");
//            if(userAccount.getCustomer().equals(och.getCustomer()))
//            {
//                
//                
//               itr.remove();
//                tempMasterOrderCatalog.getMasterOrderCatalog().remove(och);
//                 System.out.println("in if3");
//                if(userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().size()> 0)
//                {
//                    
////                for(PaymentPlan pp : userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule())
////                {
////                    userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().remove(pp);
////                   
////                }
////                    for(Iterator<PaymentPlan> pp = userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().iterator();pp.hasNext(); )
////                    {
//                     System.out.println("in if4");
//                        this.userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().clear();
//                        System.out.println("Sizeof"+ userAccount.getCustomer().getPaymentSchedule().getPaymentSchedule().size());
//                       // pp.remove();
//                        
//                userAccount.getCustomer().getPaymentSchedule().setInvoice(null);
//                JOptionPane.showMessageDialog(null, "Now, You are able to select new Plan");
//                    }
//                
//                }
//            
//            else
//            {
//                JOptionPane.showMessageDialog(null, "No Order Selected");
//            }
//        }
//        } 
//        Refresh3();
           Refresh3();
    }//GEN-LAST:event_removeExistingjButtonActionPerformed
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JButton checkOutjButton;
    private javax.swing.JTable customerOffersjTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderOffersjTable;
    private javax.swing.JButton orderjButton;
    private javax.swing.JButton removeExistingjButton;
    private javax.swing.JButton removejButton;
    private javax.swing.JButton viewDetailsjButton;
    // End of variables declaration//GEN-END:variables
}
