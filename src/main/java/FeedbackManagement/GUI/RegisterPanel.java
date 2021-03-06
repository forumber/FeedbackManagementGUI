/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.GUI;

import FeedbackManagement.GUI.RegisterAltPanels.CustomerRegisterPanel;
import FeedbackManagement.GUI.RegisterAltPanels.EmployeeRegisterPanel;
import FeedbackManagement.GUI.RegisterAltPanels.AdminRegisterPanel;
import FeedbackManagement.Models.Admin;
import FeedbackManagement.Models.Customer;
import FeedbackManagement.Models.Employee;
import FeedbackManagement.Models.User;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 
 * @author Serhat Korkmaz
 */
public class RegisterPanel extends javax.swing.JPanel {
    
    private final MainFrame mainFrame;
    private javax.swing.JPanel extraPanel;

    public RegisterPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        TypeCBActionPerformed(null);
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
        BackButton = new javax.swing.JButton();

        jLabel1.setText("User Name:");

        jLabel2.setText("Email Address:");

        jLabel3.setText("Date of Birth:");

        DateofBirthTF.setText("DD/MM/YYYY");
        DateofBirthTF.setToolTipText("DD/MM/YYYY");

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

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
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
                        .addComponent(BackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegisterButton)
                    .addComponent(BackButton))
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
        if (DateofBirthTF.getText().isEmpty() || EmailTF.getText().isEmpty() || PasswordTF.getText().isEmpty() || UserNameTF.getText().isEmpty())
            JOptionPane.showMessageDialog(mainFrame, "You need to fill all the fields to register!!");
        else {
            try {
                User newUser = null;
                java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat("dd/MM/yyyy");

                switch (TypeCB.getSelectedItem().toString()) {
                    case "Admin": {
                        newUser = new Admin();

                        ((Admin) newUser).setClearanceLevel(Integer.parseInt(((AdminRegisterPanel) extraPanel).AdminClearanceTF.getText()));
                        newUser.setUserType(User.UserType.ADMIN);
                        break;
                    }
                    case "Employee": {
                        newUser = new Employee();

                        ((Employee) newUser).setDepCode(Integer.parseInt(((EmployeeRegisterPanel) extraPanel).EmpDepCodeTF.getText()));
                        ((Employee) newUser).setStartDate(dateFormatter.parse(((EmployeeRegisterPanel) extraPanel).EmpStartDateTF.getText()));
                        newUser.setUserType(User.UserType.EMPLOYEE);
                        break;
                    }
                    case "Customer": {
                        newUser = new Customer();

                        ((Customer) newUser).setPhoneNumber(((CustomerRegisterPanel) extraPanel).CustPhoneTF.getText());
                        newUser.setUserType(User.UserType.CUSTOMER);
                        break;
                    }
                    default:
                        break;
                }

                newUser.setDateOfBirth(dateFormatter.parse(DateofBirthTF.getText()));
                newUser.setEmail(EmailTF.getText());
                newUser.setPassword(PasswordTF.getText());
                newUser.setUserName(UserNameTF.getText());
                
                mainFrame.application.repository.registerUser(newUser);
                
                JOptionPane.showMessageDialog(mainFrame, "Created successfully!");
                
                mainFrame.changePanel("LoginRegisterSelection");
            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Email is already being used!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(mainFrame, "Error on creation!");
            }
        }
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void TypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeCBActionPerformed
        ExtraPanel.removeAll();
        if(TypeCB.getSelectedItem() != null) switch (TypeCB.getSelectedItem().toString()) {
            case "Admin":
                extraPanel = new AdminRegisterPanel();
                break;
            case "Employee":
                extraPanel = new EmployeeRegisterPanel();
                break;
            case "Customer":
                extraPanel = new CustomerRegisterPanel();
                break;
            default:
                break;
        }
        ExtraPanel.add(extraPanel);
        ExtraPanel.validate();
        ExtraPanel.repaint();
    }//GEN-LAST:event_TypeCBActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        mainFrame.changePanel("LoginRegisterSelection");
    }//GEN-LAST:event_BackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
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
