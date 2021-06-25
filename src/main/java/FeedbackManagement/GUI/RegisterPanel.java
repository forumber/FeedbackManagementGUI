/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.GUI;

import FeedbackManagement.Models.Admin;
import FeedbackManagement.Models.Customer;
import FeedbackManagement.Models.Employee;
import static FeedbackManagement.GUI.EmployeeRegisterPanel.EmpStartDateTF;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 
 * @author Serhat Korkmaz
 */
public class RegisterPanel extends javax.swing.JPanel {
    
    private final MainFrame mainFrame;

    public RegisterPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }
    
    public static int generatedID(){
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }
    
    public static Date ConverttoDate(String s) throws ParseException{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) format.parse(s);
        System.out.println(date);
        return date;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        UserNameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        EmailTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DateofBirthTF = new javax.swing.JTextField();
        PasswordTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        ExtraPanel = new javax.swing.JPanel();
        TypeCB = new javax.swing.JComboBox();

        jLabel1.setText("User Name:");

        jLabel2.setText("Email Address:");

        jLabel3.setText("Date of Birth:");

        DateofBirthTF.setText("DD.MM.YYYY");
        DateofBirthTF.setToolTipText("DD.MM.YYYY");

        jLabel4.setText("Password:");

        jLabel5.setText("UserType:");

        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        TypeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Employee", "Customer" }));
        TypeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExtraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RegisterButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserNameTF)
                            .addComponent(EmailTF)
                            .addComponent(DateofBirthTF)
                            .addComponent(PasswordTF)
                            .addComponent(TypeCB, 0, 119, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(UserNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DateofBirthTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExtraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegisterButton)
                .addContainerGap())
        );

        UserNameTF.getAccessibleContext().setAccessibleName("RegisterName");
        EmailTF.getAccessibleContext().setAccessibleName("RegisterMail");
        DateofBirthTF.getAccessibleContext().setAccessibleName("RegisterDOB");
        PasswordTF.getAccessibleContext().setAccessibleName("RegisterPassword");
        RegisterButton.getAccessibleContext().setAccessibleName("RegisterButton");
        ExtraPanel.getAccessibleContext().setAccessibleName("ExtraPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        if(DateofBirthTF.getText().length() == 0 || EmailTF.getText().length() == 0 || PasswordTF.getText().length() == 0 || UserNameTF.getText().length() == 0) 
            JOptionPane.showMessageDialog(null, "You need to fill all the fields to register!!");
        else{
            if(TypeCB.getSelectedItem() != null) switch (TypeCB.getSelectedItem().toString()) {
                case "Admin":{
                    Date date = null;
                    try {
                        date = ConverttoDate(DateofBirthTF.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int clearance = Integer.parseInt(AdminRegisterPanel.AdminClearanceTF.getText());
                    Admin admin = new Admin(); //(generatedID(),EmailTF.getText(),3,UserNameTF.getText(),date,PasswordTF.getText(),clearance);
                    admin.setUserID(generatedID());
                    admin.setEmail(EmailTF.getText());
                    admin.setUserType(3);
                    admin.setUserName(UserNameTF.getText());
                    admin.setDateOfBirth(date);
                    admin.setPassword(PasswordTF.getText());
                    admin.setClearanceLevel(clearance);
                    break;
                }
                case "Employee":{
                    Date date = null;
                    try {
                        date = ConverttoDate(DateofBirthTF.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }       Date startDate = null;
                    try {
                        startDate = ConverttoDate(EmpStartDateTF.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }       int depcode = Integer.parseInt(EmployeeRegisterPanel.EmpDepCodeTF.getText());
                    Employee employee = new Employee(); //(generatedID(),EmailTF.getText(),3,UserNameTF.getText(),date,PasswordTF.getText(),startDate,depcode);
                    employee.setUserID(generatedID());
                    employee.setEmail(EmailTF.getText());
                    employee.setUserType(3);
                    employee.setUserName(UserNameTF.getText());
                    employee.setDateOfBirth(date);
                    employee.setPassword(PasswordTF.getText());
                    employee.setStartDate(startDate);
                    employee.setDepCode(depcode);
                    break;
                }
                case "Customer":{
                    Date date = null;
                    try {
                        date = ConverttoDate(DateofBirthTF.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate= formatter.format(date);
                    Date regDate = null;
                    try {
                        regDate = ConverttoDate(strDate);
                    } catch (ParseException ex) {
                        Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }       Customer customer = new Customer();//(generatedID(),EmailTF.getText(),3,UserNameTF.getText(),date,PasswordTF.getText(),CustomerRegisterPanel.CustPhoneTF.getText());
                    customer.setUserID(generatedID());
                    customer.setEmail(EmailTF.getText());
                    customer.setUserType(3);
                    customer.setUserName(UserNameTF.getText());
                    customer.setDateOfBirth(date);
                    customer.setPassword(PasswordTF.getText());
                    customer.setPhoneNumber(CustomerRegisterPanel.CustPhoneTF.getText());
                    customer.setRegistrationDate(regDate);
                    break;
                }
                default:
                    break;
            }
        }
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void TypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeCBActionPerformed
        ExtraPanel.removeAll();
        if(TypeCB.getSelectedItem() != null) switch (TypeCB.getSelectedItem().toString()) {
            case "Admin":
                ExtraPanel.add( new AdminRegisterPanel());
                break;
            case "Employee":
                ExtraPanel.add( new EmployeeRegisterPanel());
                break;
            case "Customer":
                ExtraPanel.add( new CustomerRegisterPanel());
                break;
            default:
                break;
        }
        ExtraPanel.validate();
        ExtraPanel.repaint();
    }//GEN-LAST:event_TypeCBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateofBirthTF;
    private javax.swing.JTextField EmailTF;
    private javax.swing.JPanel ExtraPanel;
    private javax.swing.JTextField PasswordTF;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JComboBox TypeCB;
    private javax.swing.JTextField UserNameTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
