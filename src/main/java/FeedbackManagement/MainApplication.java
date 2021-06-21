package FeedbackManagement;

import FeedbackManagement.GUI.MainFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApplication {
    
    public MainFrame mainFrame;
    
    public MainApplication()
    {
        mainFrame = new MainFrame(this);
    }

    public static void main(String[] args) {
        
        Repository.testConnection();
        
        new MainApplication().mainFrame.start();
    }
    
}
