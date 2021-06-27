/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.GUI;

import FeedbackManagement.MainApplication;
import FeedbackManagement.Models.Feedback;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Serhat Korkmaz
 */
public class NewFeedbackFrame extends javax.swing.JFrame{
    
    private final MainFrame mainFrame;
    /**
     * Creates new customizer FeedbackPanel
     */
    public NewFeedbackFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        feedbackTF = new javax.swing.JTextField();
        SendB = new javax.swing.JButton();

        categoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feedback", "Problem" }));

        jLabel4.setText("Feedback Category");

        feedbackTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackTFActionPerformed(evt);
            }
        });

        SendB.setText("Send Feedback");
        SendB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feedbackTF)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SendB))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feedbackTF, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SendB)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void feedbackTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feedbackTFActionPerformed

    private void SendBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendBActionPerformed
        if (feedbackTF.getText().isEmpty())
            JOptionPane.showMessageDialog(mainFrame, "You need to enter your feedback first!!");
        else{
            Feedback feedback = new Feedback();
            feedback.setCustomerID(MainApplication.loggedInUser.getUserID());
            feedback.setMessage(feedbackTF.getText());
            feedback.setCategoryID(1); // FIX ME
            feedback.setDepCode(3); // FIX ME
            
            try {
                MainApplication.repository.postNewFeedback(feedback);
                JOptionPane.showMessageDialog(this, "Success!");
                dispose();
                
            } catch (SQLException ex) {
                Logger.getLogger(NewFeedbackFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SendBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SendB;
    private javax.swing.JComboBox<String> categoryCB;
    private javax.swing.JTextField feedbackTF;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
