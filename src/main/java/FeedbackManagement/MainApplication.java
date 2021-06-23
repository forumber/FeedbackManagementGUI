package FeedbackManagement;

import FeedbackManagement.GUI.MainFrame;

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
