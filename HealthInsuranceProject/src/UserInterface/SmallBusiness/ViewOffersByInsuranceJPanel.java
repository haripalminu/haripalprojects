/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SmallBusiness;

import Business.Plan;
import Business.PlanCatalouge;
import Business.UserAccount;
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
public class ViewOffersByInsuranceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewOffersByInsuranceJPanel
     */
    JPanel UserProcessContainer;
    UserAccount userAccount;
    public ViewOffersByInsuranceJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
        Refresh();
        
    }
    public void Refresh()
    {
       // WorkQueue workQueue = userAccount.getRole().getWorkArea().getWorkQueue();
        PlanCatalouge planCatalouge = userAccount.getExchangeEnterprise().getPlanCatalogue();
        ArrayList<Plan> planList = planCatalouge.getPlanCatalouge();
        int rowCount = plansjTable.getRowCount();
       for(int i = rowCount - 1; i>=0; i--)
       {
           ((DefaultTableModel)plansjTable.getModel()).removeRow(i);
       }
                        
        for(Plan p : planList)
        {
                       
          if(p.getType().equals("Small Business") && p.getStatus().equals("Approved"))
           { 
            Object row[] = new Object[6];
            
            row[0] = p.getInsuranceEnterprise();
            row[1] = p.getOfferedDiscount();
            row[2] = p.getNoOfPersonsCovered();
            row[3] = p.getFee();
            row[4] = p.getCoverage();
            row[5] = p;
            
           
           
          
            
            DefaultTableModel defTableModel = (DefaultTableModel)plansjTable.getModel();
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
        plansjTable = new javax.swing.JTable();
        payjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("View Your Offers");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 32, -1, -1));

        plansjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Insurance Issuer", "Offered Discount", "No Of Person Covered", "Fees to be paid", "Coverage", "PlanName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(plansjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 64, -1, 92));

        payjButton.setText("Select");
        payjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payjButtonActionPerformed(evt);
            }
        });
        add(payjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 349, -1, -1));

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 349, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        UserProcessContainer.remove(this);
        CardLayout cardLayout =(CardLayout)UserProcessContainer.getLayout();
        cardLayout.previous(UserProcessContainer);
        
    }//GEN-LAST:event_backjButtonActionPerformed

    private void payjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payjButtonActionPerformed
        // TODO add your handling code here:
        int selectedRowCount = plansjTable.getSelectedRowCount();
        if(selectedRowCount == 0)
        {
            JOptionPane.showMessageDialog(null,"Please select row");
            return;
        }
        
        if(selectedRowCount <= 0 || selectedRowCount> plansjTable.getRowCount())
        {
            return;
        }
       
        int selectedRow =  plansjTable.getSelectedRow();
        Plan selectedPlan = (Plan)plansjTable.getValueAt(selectedRow, 5);
        userAccount.getSmallBusiness().setApprovedDiscount(selectedPlan.getOfferedDiscount());
        userAccount.getSmallBusiness().setInsuranceEnterprise(selectedPlan.getInsuranceEnterprise());
        selectedPlan.getInsuranceEnterprise().getSmallBusinessDirectory().getSmallBusinessDirectory().add(userAccount.getSmallBusiness());
        JOptionPane.showMessageDialog(null,"Plan Selected");
    }//GEN-LAST:event_payjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton payjButton;
    private javax.swing.JTable plansjTable;
    // End of variables declaration//GEN-END:variables
}