/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.GUI;

import FeedbackManagement.Tables.FeedbackTablePanel;
import FeedbackManagement.Tables.ResponseTablePanel;
import javax.swing.JFrame;

/**
 *
 * @author Serhat Korkmaz
 */
public class EmployeePanel extends javax.swing.JPanel{
    private final MainFrame mainFrame;
    private javax.swing.JPanel tablePanel;

    /**
     * Creates new customizer EmployeePanel
     */
    public EmployeePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }
    
     public void ChangePanel(String s){
        TablePanel.removeAll();
        switch (s) {
            case "Feedback":
                tablePanel = new FeedbackTablePanel();
                break;
            case "Response":
                tablePanel = new ResponseTablePanel();
                break;
            default:
                break;
        }
        TablePanel.add(tablePanel);
        TablePanel.validate();
        TablePanel.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TablePanel = new javax.swing.JPanel();
        FeedbacksButton = new javax.swing.JButton();
        myResponsesButton = new javax.swing.JButton();
        newResponseButton = new javax.swing.JButton();

        FeedbacksButton.setText("Feedbacks");
        FeedbacksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbacksButtonActionPerformed(evt);
            }
        });

        myResponsesButton.setText("My Responses");
        myResponsesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myResponsesButtonActionPerformed(evt);
            }
        });

        newResponseButton.setText("New Response");
        newResponseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newResponseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FeedbacksButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myResponsesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newResponseButton)
                        .addGap(0, 506, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FeedbacksButton)
                    .addComponent(myResponsesButton)
                    .addComponent(newResponseButton))
                .addGap(4, 4, 4)
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void FeedbacksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeedbacksButtonActionPerformed
        ChangePanel("Feedback");
    }//GEN-LAST:event_FeedbacksButtonActionPerformed

    private void myResponsesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myResponsesButtonActionPerformed
        ChangePanel("Response");
    }//GEN-LAST:event_myResponsesButtonActionPerformed

    private void newResponseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newResponseButtonActionPerformed
        NewResponseFrame frame = new NewResponseFrame(mainFrame);    
        frame.setSize(280, 380);
        frame.setVisible(true);  
    }//GEN-LAST:event_newResponseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FeedbacksButton;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JButton myResponsesButton;
    private javax.swing.JButton newResponseButton;
    // End of variables declaration//GEN-END:variables
}
