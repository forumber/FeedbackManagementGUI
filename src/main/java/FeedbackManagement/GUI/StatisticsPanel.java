/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.GUI;

import FeedbackManagement.MainApplication;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Serhat Korkmaz
 */
public class StatisticsPanel extends javax.swing.JPanel{

    /**
     * Creates new customizer Statistics
     */
    public StatisticsPanel() {
        initComponents();
        try {
            initTables();
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
    public void initTables() throws SQLException{
        
        List<String[]> customer = MainApplication.repository.getRepoStatistics().getNumberOfCustomersThatHaveNotYetBeenReponded();
        List<String[]> avgfeed = MainApplication.repository.getRepoStatistics().getAverageNumberOfDailyFeedbackReceivedForEachDepartmentInTheLastMonth();
        ResponseRateLabel.setText(MainApplication.repository.getRepoStatistics().getResponseRateToTotalFeedbacks().toString());
        
        String data2[][] = null;
        String data3[][] = null;
        
        for(int i = 0 ; i < customer.size() ; i++){
            //data2[i][0] = List.get(i).[0];
            //data2[i][1] = List.get(i).[1];
        }
        
        for(int i = 0 ; i < avgfeed.size() ; i++){
            //data1[i][0] = List.get(i).[0];
            //data1[i][1] = List.get(i).[1];
        }
        
        String column2[]={"User ID","User Name"};  
        String column3[]={"Department","Average Feedbacks"};  
        
        CustomerNotRespondedTable = new JTable(data2,column2); 
        DailyFeedbackTable  = new JTable(data3,column3);     
        
        jScrollPane3.setViewportView(CustomerNotRespondedTable);
        jScrollPane4.setViewportView(DailyFeedbackTable);
    }
    
    public Date convertToDate(String s){
        try {
            SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
            Date date=formatter1.parse(s);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(StatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ResponseRateLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BestEmployeeTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        CustomerNotRespondedTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        DailyFeedbackTable = new javax.swing.JTable();
        startDateTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        endDateTF = new javax.swing.JTextField();
        GetButton = new javax.swing.JButton();

        jLabel1.setText("Total Response Rate:");

        ResponseRateLabel.setText("jLabel3");

        jLabel3.setText("Daily Number of Feedbacks in the Last Month:");

        jLabel4.setText("Customers that hasn't been responded:");

        jLabel5.setText("Employee who gave the most response:");

        BestEmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(BestEmployeeTable);

        CustomerNotRespondedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(CustomerNotRespondedTable);

        DailyFeedbackTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(DailyFeedbackTable);

        jLabel6.setText("~");

        endDateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateTFActionPerformed(evt);
            }
        });

        GetButton.setText("Find");
        GetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResponseRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(26, 26, 26))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(startDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(endDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(GetButton)
                                .addGap(91, 91, 91))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(ResponseRateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(endDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GetButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void endDateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateTFActionPerformed

    private void GetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetButtonActionPerformed
        if(startDateTF.getText().isEmpty() || endDateTF.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"You need to fill all the fields");
        else{
            try {
                Date startDate = convertToDate(startDateTF.getText());
                Date endDate = convertToDate(endDateTF.getText());
                
                List<String[]> bestemp = MainApplication.repository.getRepoStatistics().getEmployeeWhoGaveTheMostResponseForEachDepartmentWithinTheSpecifiedDays(startDate, endDate); // get
                String data1[][] = null;
                for(int i = 0 ; i < bestemp.size() ; i++){
                    //data1[i][0] = List.get(i).[0];
                    //data1[i][1] = List.get(i).[1];
                    //data1[i][2] = List.get(i).[2];
                }
                String column1[]={"Department","Employee","#Responses"};
                BestEmployeeTable = new JTable(data1,column1);
                jScrollPane2.setViewportView(BestEmployeeTable);
            } catch (SQLException ex) {
                Logger.getLogger(StatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_GetButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BestEmployeeTable;
    private javax.swing.JTable CustomerNotRespondedTable;
    private javax.swing.JTable DailyFeedbackTable;
    private javax.swing.JButton GetButton;
    private javax.swing.JLabel ResponseRateLabel;
    private javax.swing.JTextField endDateTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField startDateTF;
    // End of variables declaration//GEN-END:variables
}