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
public class Admin extends User{
    private int clearanceLevel;

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public Admin(int clearanceLevel, int userID, String email, int userType, String userName, Date dateOfBirth, String password) {
        super(userID, email, userType, userName, dateOfBirth, password);
        this.clearanceLevel = clearanceLevel;
    }
}
