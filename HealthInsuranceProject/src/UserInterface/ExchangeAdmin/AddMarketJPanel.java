/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ExchangeAdmin;

import Business.Business;
import Business.Conditions.Condition;
import Business.Market;
import Business.Markets;
import Business.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Haripal
 */
public class AddMarketJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddMarketJPanel
     */
    JPanel UserProcessContainer;
    Business business;
    Market market;
    Markets markets;
    UserAccount userAccount;
    public AddMarketJPanel(JPanel UserProcessContainer,UserAccount userAccount) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        this.userAccount = userAccount;
        markets = userAccount.getExchangeEnterprise().getMarkets();
        
        conditionjComboBox.removeAllItems();
        conditionjComboBox.addItem("Junior");
        conditionjComboBox.addItem("Senior");
        conditionjComboBox.addItem("Family");
        conditionjComboBox.addItem("SeniorAndEmployee");
        conditionjComboBox.addItem("JuniorAndEmployee");
        conditionjComboBox.addItem("FamilyAndSmallBusiness");
        conditionjComboBox.addItem("JuniorAndEmployeeAndFamily");
        conditionjComboBox.addItem("SeniorAndEmployeeAndFamily");
        conditionjComboBox.addItem("JuniorAndEmployee");

        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        createjButton = new javax.swing.JButton();
        marketNamejTextField = new javax.swing.JTextField();
        conditionjComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        conditionjTextField = new javax.swing.JTextField();

        jLabel1.setText("Add Markets Here");

        backjButton.setText("Back >>");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Market Name");

        jLabel3.setText("Condition");

        createjButton.setText("Create");
        createjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createjButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Enter Your Condition");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(marketNamejTextField)
                            .addComponent(conditionjComboBox, 0, 101, Short.MAX_VALUE)
                            .addComponent(conditionjTextField))))
                .addContainerGap(345, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backjButton)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(createjButton)
                        .addGap(252, 252, 252))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marketNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(conditionjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(conditionjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(createjButton)
                .addGap(73, 73, 73)
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

    private void createjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createjButtonActionPerformed
        // TODO add your handling code here:
       // String ClassName = conditionjTextField.getText();
      
           
      
               
        if(conditionjTextField.getText().length() == 0 
                || marketNamejTextField.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Condition field or marketname field is null");
            
        }
        else
        {
//        Junior junior = new Junior();
//        Senior senior = new Senior();
//        if(conditionjTextField.getText().equals("Senior")){
//           market.setCondition(senior); 
//        }
//        else if(conditionjTextField.getText().equals("Junior"))
//        {
//            market.setCondition(junior); 
//        }
        
         try
       {
       
        
       
        String sClass = "Business.Conditions."+conditionjTextField.getText();
        ClassLoader loader = getClass().getClassLoader();      
        Class classCond = loader.loadClass(sClass);
         Condition condInstance  = (Condition) classCond.newInstance();
        for(Market m : markets.getMarkets())
            {
            if(m.getCondition().getConditionName().equals(condInstance.getConditionName()))
            {
                JOptionPane.showMessageDialog(null, "Market is Already Created");
                return;
            }
           }
         market = markets.newMarket();
        market.setCondition(condInstance);
        market.setMarketName(conditionjTextField.getText());
       }
       catch (Exception ex){
              JOptionPane.showMessageDialog(null, "startOperation: Exception-Error Loading Class: " );
           }
       
        
    }//GEN-LAST:event_createjButtonActionPerformed
   JOptionPane.showMessageDialog(null, "Market Created");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JComboBox conditionjComboBox;
    private javax.swing.JTextField conditionjTextField;
    private javax.swing.JButton createjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField marketNamejTextField;
    // End of variables declaration//GEN-END:variables
}
