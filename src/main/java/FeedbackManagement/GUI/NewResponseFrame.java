/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.GUI;

import FeedbackManagement.MainApplication;
import FeedbackManagement.Models.Response;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Serhat Korkmaz
 */
public class NewResponseFrame extends javax.swing.JPanel  {
    
    private final MainFrame mainFrame;

    /**
     * Creates new customizer ResponsePanel
     */
    public NewResponseFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }
    
    public Date currentDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return date;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        responseTF = new javax.swing.JTextField();
        SendB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        statusCB = new javax.swing.JComboBox<>();
        FeedbackIDTF = new javax.swing.JTextField();

        jLabel2.setText("Feedback ID:");

        responseTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responseTFActionPerformed(evt);
            }
        });

        SendB.setText("Send Response");
        SendB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendBActionPerformed(evt);
            }
        });

        jLabel5.setText("Mark as ");

        statusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESPONDED", "DONE_SUCCESS", "DONE_FAIL" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(responseTF)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SendB))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FeedbackIDTF))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FeedbackIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(responseTF, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(SendB)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void responseTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responseTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_responseTFActionPerformed

    private void SendBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendBActionPerformed
         if (responseTF.getText().isEmpty())
            JOptionPane.showMessageDialog(mainFrame, "You need to enter your response first!!");
        else{
            Response response = new Response();
            response.setAnswer(responseTF.getText());
            response.setEmpID(MainApplication.loggedInUser.getUserID());
            response.setResponseDate((java.sql.Date) currentDate());
            switch (statusCB.getSelectedItem().toString()) {
                    case "RESPONDED":
                         response.setStatus("RESPONDED");
                        break;
                    case "DONE_SUCCESS":
                        response.setStatus("DONE_SUCCESS");
                        break;
                    case "DONE_FAIL":
                        response.setStatus("DONE_FAIL");
                        break;
                    default:
                        break;
                }
            response.setFeedID(Integer.parseInt(FeedbackIDTF.getText()));
            
            try {
                MainApplication.repository.postNewResponse(response);
                JOptionPane.showMessageDialog(this, "Success!");
                //dispose();
                
            } catch (SQLException ex) {
                Logger.getLogger(NewResponseFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SendBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FeedbackIDTF;
    private javax.swing.JButton SendB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField responseTF;
    private javax.swing.JComboBox<String> statusCB;
    // End of variables declaration//GEN-END:variables
}
