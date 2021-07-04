/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Berkay
 */
public class RepositoryStatistics {
    private Connection connection;
    
    public RepositoryStatistics(Connection newConnection)
    {
        connection = newConnection;
    }
    
    public ResultSet getEmployeeWhoGaveTheMostResponseForEachDepartmentWithinTheSpecifiedDays(java.util.Date after, java.util.Date before) throws SQLException
    {
        String query = String.join(System.lineSeparator(), 
                "SELECT dp.departmentname, us.usr_name, COUNT(rp.responseid) AS COUNT_RP",
                "  FROM RESPONSES rp",
                " INNER JOIN EMPLOYEES emp",
                "    ON rp.empid = emp.userid",
                " INNER JOIN USERS us",
                "    ON emp.userid = us.userid",
                " INNER JOIN DEPARTMENTS dp",
                "    ON emp.depcode = dp.departmentcode",
                " WHERE (rp.response_date > ? AND",
                "       rp.response_date < ?)",
                " GROUP BY dp.departmentname, us.usr_name",
                "HAVING COUNT(rp.responseid) = (SELECT MAX(tt1.COUNT_RP) AS COUNT_RPM",
                "                                 FROM (SELECT dp.departmentname,",
                "                                              us.usr_name,",
                "                                              COUNT(rp.responseid) AS COUNT_RP",
                "                                         FROM RESPONSES rp",
                "                                        INNER JOIN EMPLOYEES emp",
                "                                           ON rp.empid = emp.userid",
                "                                        INNER JOIN USERS us",
                "                                           ON emp.userid = us.userid",
                "                                        INNER JOIN DEPARTMENTS dp",
                "                                           ON emp.depcode = dp.departmentcode",
                "                                        WHERE (rp.response_date >",
                "                                              ? AND",
                "                                              rp.response_date <",
                "                                              ?)",
                "                                        GROUP BY dp.departmentname,",
                "                                                 us.usr_name) tt1)",
                "");
        
        PreparedStatement statement =  connection.prepareStatement(query);
        statement.setDate(1, new java.sql.Date(after.getTime()));
        statement.setDate(2, new java.sql.Date(before.getTime()));
        statement.setDate(3, new java.sql.Date(after.getTime()));
        statement.setDate(4, new java.sql.Date(before.getTime()));
        return statement.executeQuery();
        

    }
    
    public ResultSet getAverageNumberOfDailyFeedbackReceivedForEachDepartmentInTheLastMonth() throws SQLException
    {
        String query = String.join(System.lineSeparator(), 
                "SELECT dp.departmentname, AVG(fd.feedbackid) AS AVG_FD",
                "  FROM FEEDBACKS fd",
                " INNER JOIN DEPARTMENTS dp",
                "    ON fd.depcode = dp.departmentcode",
                " WHERE fd.fd_date > SYSDATE - 3000", //her departmana son 30 günde feedback atýlmadýðý için çalýþmýyormuþ :)
                " GROUP BY dp.departmentname",
                "");
        
        PreparedStatement statement =  connection.prepareStatement(query);
        return statement.executeQuery();

    }
    
    public void deleteOldRecords() throws SQLException
    {
        String query = String.join(System.lineSeparator(), 
                "DELETE FROM FEEDBACKS WHERE FD_DATE < TRUNC(SYSDATE) - 30");
        
        PreparedStatement statement =  connection.prepareStatement(query);
        statement.executeQuery();
        
        query = String.join(System.lineSeparator(), 
                "DELETE FROM RESPONSES WHERE RESPONSE_DATE < TRUNC(SYSDATE) - 30");
        
        statement =  connection.prepareStatement(query);
        statement.executeQuery();
    }
    
    public void updateOldRecords() throws SQLException
    {
        String query = String.join(System.lineSeparator(), 
                "UPDATE FEEDBACKS SET STATUS = 'DONE_SUCCESS' WHERE FD_DATE < TRUNC(SYSDATE) - 30 AND (STATUS = 'RESPONDED' OR STATUS = 'SENT')");
        
        PreparedStatement statement =  connection.prepareStatement(query);
        statement.executeQuery();
    }
    
    public ResultSet getNumberOfCustomersThatHaveNotYetBeenReponded() throws SQLException
    {
        String query = String.join(System.lineSeparator(), 
                "SELECT us.userid, us.usr_name",
                "  FROM FEEDBACKS fd",
                " INNER JOIN CUSTOMERS css",
                "    ON fd.customerid = css.userid",
                " INNER JOIN USERS us",
                "    ON css.userid = us.userid",
                "",
                "MINUS",
                "",
                "SELECT us.userid, us.usr_name",
                "  FROM RESPONSES rp",
                " INNER JOIN FEEDBACKS fd",
                "    ON rp.feedid = fd.feedbackid",
                " INNER JOIN CUSTOMERS css",
                "    ON fd.customerid = css.userid",
                " INNER JOIN USERS us",
                "    ON css.userid = us.userid",
                "");
        
        PreparedStatement statement =  connection.prepareStatement(query);
        return statement.executeQuery();
        
    }
}
