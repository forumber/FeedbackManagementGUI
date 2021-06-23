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
public class Employee extends User{

    private Date startDate;
    private int depCode;
    
    public Employee(Date startDate, int depCode, int userID, String email, int userType, String userName, Date dateOfBirth, String password) {
        super(userID, email, userType, userName, dateOfBirth, password);
        this.startDate = startDate;
        this.depCode = depCode;
    }
    
      public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDepCode() {
        return depCode;
    }

    public void setDepCode(int depCode) {
        this.depCode = depCode;
    }
}
