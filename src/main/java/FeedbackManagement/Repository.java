package FeedbackManagement;

import FeedbackManagement.Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Repository {
    private Connection connection;
    private final String insertToUsersQuery = "INSERT INTO USERS (dateofbirth, email, userid, usertype, usr_name, usr_password) VALUES (?, ?, ?, ?, ?, ?)";
    private final String insertToAdminsQuery = "INSERT INTO ADMINS (clearancelevel, userid) VALUES (?, ?)";
    private final String insertToEmployeesQuery = "INSERT INTO EMPLOYEES (depcode, startdate, userid) VALUES (?, ?, ?)";
    private final String insertToCustomersQuery = "INSERT INTO CUSTOMERS (phonenumber, registrationdate, userid) VALUES (?, ?, ?)";
    
    public Repository()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "applicationuser", "q1w2e3r4t5y6");
            if (connection == null) {
                throw new Exception();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect DB!");
            System.exit(0);
        }
    }
    
    private int getNextUserId() throws SQLException
    {
        ResultSet result = connection.createStatement().executeQuery("SELECT SEQ_USERS.nextval FROM DUAL");
        result.next();
        return result.getInt(1);
    }
    
    public void registerUser(User newUser) throws SQLException
    {
        int newUserId = getNextUserId();
        
        PreparedStatement insertToUsersStatement =  connection.prepareStatement(insertToUsersQuery);
        
        insertToUsersStatement.setDate(1, new java.sql.Date(newUser.getDateOfBirth().getTime()));
        insertToUsersStatement.setString(2, newUser.getEmail());
        insertToUsersStatement.setInt(3, newUserId);
        
        insertToUsersStatement.setString(5, newUser.getUserName());
        insertToUsersStatement.setString(6, newUser.getPassword());
        
        PreparedStatement insertToSpecificUserStatement = null;
        
        switch(newUser.getUserType())
        {
            case ADMIN:
                Admin newAdminUser = (Admin) newUser;
                
                insertToUsersStatement.setInt(4, 3);
                insertToSpecificUserStatement = connection.prepareStatement(insertToAdminsQuery);
                insertToSpecificUserStatement.setInt(1, newAdminUser.getClearanceLevel());
                insertToSpecificUserStatement.setInt(2, newUserId);
                break;
            case EMPLOYEE:
                Employee newEmployeeUser = (Employee) newUser;
                
                insertToUsersStatement.setInt(4, 2);
                insertToSpecificUserStatement = connection.prepareStatement(insertToEmployeesQuery);
                insertToSpecificUserStatement.setInt(1, newEmployeeUser.getDepCode());
                insertToSpecificUserStatement.setDate(2, new java.sql.Date(newEmployeeUser.getStartDate().getTime()));
                insertToSpecificUserStatement.setInt(3, newUserId);
                break;
            case CUSTOMER:
                Customer newCustomerUser = (Customer) newUser;
                
                insertToUsersStatement.setInt(4, 1);
                insertToSpecificUserStatement = connection.prepareStatement(insertToCustomersQuery);
                insertToSpecificUserStatement.setString(1, newCustomerUser.getPhoneNumber());
                insertToSpecificUserStatement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
                insertToSpecificUserStatement.setInt(3, newUserId);
                break;
            default:
                break;
        }
        
        insertToUsersStatement.executeUpdate();
        insertToSpecificUserStatement.executeUpdate();
    }
            
}
