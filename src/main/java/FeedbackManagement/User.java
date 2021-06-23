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
public abstract class User {
   private int userID;
   private String email;
   private int userType;
   private String userName;
   private Date dateOfBirth;
   private String password;
   
   
    public User(int userID, String email, int userType, String userName, Date dateOfBirth, String password) {
        this.userID = userID;
        this.email = email;
        this.userType = userType;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
