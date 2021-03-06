/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.Models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Serhat Korkmaz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    public enum UserType {
        ADMIN,
        EMPLOYEE,
        CUSTOMER
    }

    private int userID;
    private String email;
    private UserType userType;
    private String userName;
    private Date dateOfBirth;
    private String password;
}
