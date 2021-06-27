/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement.Models;

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
public class Department {
    int departmentCode;
    String departmentName;
}
