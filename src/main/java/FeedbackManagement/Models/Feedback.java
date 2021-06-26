/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.Models;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Burak Korkmaz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    int feedbackID;
    String message;
    String status;
    int empID;
    int depCode;
    int customerID;
    int categoryID;
    Date feedbackDate;
}
