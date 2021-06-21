package FeedbackManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {
    public static void testConnection()
    {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "applicationuser", "q1w2e3r4t5y6")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
