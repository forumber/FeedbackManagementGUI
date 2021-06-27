package FeedbackManagement;

import FeedbackManagement.Models.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.xml.bind.DatatypeConverter;

public class Repository {
    private Connection connection;
    private final String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String connectionUserName = "applicationuser";
    private final String connectionPass = "q1w2e3r4t5y6";
    private final String insertToUsersQuery = "INSERT INTO USERS (dateofbirth, email, userid, usertype, usr_name, usr_password) VALUES (?, ?, ?, ?, ?, ?)";
    private final String insertToAdminsQuery = "INSERT INTO ADMINS (clearancelevel, userid) VALUES (?, ?)";
    private final String insertToEmployeesQuery = "INSERT INTO EMPLOYEES (depcode, startdate, userid) VALUES (?, ?, ?)";
    private final String insertToCustomersQuery = "INSERT INTO CUSTOMERS (phonenumber, registrationdate, userid) VALUES (?, ?, ?)";
    private final String getNextUserIdQuery = "SELECT SEQ_USERS.nextval FROM DUAL";
    private final String getNextFeedbackIdQuery = "SELECT SEQ_FEEDBACKS.nextval FROM DUAL";
    private final String getUserQuery = "SELECT * FROM USERS";
    private final String getAdminQuery = "SELECT clearancelevel FROM ADMINS WHERE userid = ?";
    private final String getEmployeeQuery = "SELECT depcode, startdate FROM EMPLOYEES WHERE userid = ?";
    private final String getCustomerQuery = "SELECT phonenumber, registrationdate FROM CUSTOMERS WHERE userid = ?";
    private final String getResponseQuery = "SELECT * FROM RESPONSES";
    private final String getFeedbackQuery = "SELECT * FROM FEEDBACKS";
    private final String postNewFeedbackQuery = "INSERT INTO FEEDBACKS (catýd, customerýd, depcode, empýd, fd_date, feedbackýd, message, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    public Repository()
    {
        try
        {
            connection = DriverManager.getConnection(connectionString, connectionUserName, connectionPass);
            if (connection == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect DB!");
            System.exit(0);
        }
    }
    

    
    public void postNewFeedback(Feedback newFeedback) throws SQLException
    {
        PreparedStatement insertStatement =  connection.prepareStatement(postNewFeedbackQuery);
        insertStatement.setInt(1, newFeedback.getCategoryID());
        insertStatement.setInt(2, newFeedback.getCustomerID());
        insertStatement.setInt(3, newFeedback.getDepCode());
        insertStatement.setInt(4, 5162); // FIX ME
        insertStatement.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
        insertStatement.setInt(6, getNextFeedbackId());
        insertStatement.setString(7, newFeedback.getMessage());
        insertStatement.setString(8, "SENT");
        
        insertStatement.executeUpdate();
        
        
    }
    
    private int getNextUserId() throws SQLException
    {
        ResultSet result = connection.createStatement().executeQuery(getNextUserIdQuery);
        result.next();
        return result.getInt(1);
    }
    
    private int getNextFeedbackId() throws SQLException
    {
        ResultSet result = connection.createStatement().executeQuery(getNextFeedbackIdQuery);
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
        insertToUsersStatement.setString(6, generateMD5(newUser.getPassword()));
        
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
    
    public User login(String email, String password) throws SQLException
    {
        Map<String, Object> newFilter = new HashMap();
        newFilter.put("email", email);
        newFilter.put("usr_password", generateMD5(password));
        
        List<User> userList = getUsers(newFilter);
        if (userList.isEmpty())
            return null;
        else
            return userList.get(0);
    }
    
    private static String generateMD5(String stringToGenerate)
    {
        return org.apache.commons.codec.digest.DigestUtils.md5Hex(stringToGenerate).toLowerCase();
    }
    
    private ResultSet buildAndRunQuery(Map<String, Object> filters, String SQLQuery) throws SQLException
    {
        if (filters == null)
        {
            return connection.prepareStatement(SQLQuery).executeQuery();
        }
        
        String query = SQLQuery;
        for (String columnName : filters.keySet())
        {
            query += query.contains("WHERE") ? " AND " : " WHERE ";
            query += columnName + " = ?";
        }
        
        PreparedStatement statement = connection.prepareStatement(query);
        
        int statementIndex = 1;
        
        for (String columnName : filters.keySet())
        {
            Object arg = filters.get(columnName);
            
            try
            {
                statement.setString(statementIndex, (String)arg);
            }
            catch(ClassCastException e1)
            {
                try
                {
                    statement.setInt(statementIndex, (int)arg);
                }
                catch(ClassCastException e2)
                {
                    statement.setDate(statementIndex, new java.sql.Date(((java.util.Date)arg).getTime()));
                }
            }
            
            statementIndex++;
        }
        
        return statement.executeQuery();
    }
    
    public List<Response> getResponses(Map<String, Object> filters) throws SQLException
    {
        ResultSet result = buildAndRunQuery(filters, getResponseQuery);
        
        List<Response> responses = new ArrayList();
        
        while (result.next())
        {
            responses.add(new Response(result.getInt("responseid"),
                    result.getString("answer"),
                    result.getDate("response_date"),
                    result.getString("status"),
                    result.getInt("feedid"),
                    result.getInt("empid")));
        }
        
        return responses;
    }
    
    public List<Feedback> getFeedbacks(Map<String, Object> filters) throws SQLException
    {
        ResultSet result = buildAndRunQuery(filters, getFeedbackQuery);
        
        List<Feedback> feedbacks = new ArrayList();
        
        while (result.next())
        {
            feedbacks.add(new Feedback(result.getInt("feedbackid"), 
                    result.getString("message"), 
                    result.getString("status"), 
                    result.getInt("empid"), 
                    result.getInt("depcode"), 
                    result.getInt("customerid"), 
                    result.getInt("catid"), 
                    result.getDate("fd_date")));
        }
        
        return feedbacks;
    }
    
    public List<User> getUsers(Map<String, Object> filters) throws SQLException
    {
        ResultSet result = buildAndRunQuery(filters, getUserQuery);
        
        List<User> users = new ArrayList();
        
        while (result.next())
        {
            User newUser = null;
            PreparedStatement statement2 = null;

            int userType = result.getInt("usertype");
            int userId = result.getInt("userid");

            switch(userType)
            {
                case 1:
                    statement2 = connection.prepareStatement(getCustomerQuery);
                    statement2.setInt(1, userId);
                    ResultSet CustomerResults = statement2.executeQuery();
                    CustomerResults.next();
                    newUser = new Customer(CustomerResults.getString("phonenumber"), CustomerResults.getDate("registrationdate"));
                    newUser.setUserType(User.UserType.CUSTOMER);
                    break;
                case 2:
                    statement2 = connection.prepareStatement(getEmployeeQuery);
                    statement2.setInt(1, userId);
                    ResultSet EmployeeResults = statement2.executeQuery();
                    EmployeeResults.next();
                    newUser = new Employee(EmployeeResults.getDate("startdate"), EmployeeResults.getInt("depcode"));
                    newUser.setUserType(User.UserType.EMPLOYEE);
                    break;
                case 3:
                    statement2 = connection.prepareStatement(getAdminQuery);
                    statement2.setInt(1, userId);
                    ResultSet AdminResults = statement2.executeQuery();
                    AdminResults.next();
                    newUser = new Admin(AdminResults.getInt("clearancelevel"));
                    newUser.setUserType(User.UserType.ADMIN);
                    break;
            }

            newUser.setDateOfBirth(result.getDate("dateofbirth"));
            newUser.setEmail(result.getString("email"));
            newUser.setUserID(userId);
            newUser.setUserName(result.getString("usr_name"));
            users.add(newUser);
        }
        
        return users;
    }
    
    public RepositoryStatistics getRepoStatistics()
    {
        return new RepositoryStatistics(connection);
    }
}
