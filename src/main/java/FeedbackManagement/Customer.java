/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement;

import java.sql.Date;

/**
 *
 * @author Serhat Korkmaz
 */
public class Customer extends User {
    private String phoneNumber;
    private Date registrationDate;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Customer(String phoneNumber, Date registrationDate, int userID, String email, int userType, String userName, Date dateOfBirth, String password) {
        super(userID, email, userType, userName, dateOfBirth, password);
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }
}
