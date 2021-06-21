package FeedbackManagementGUI;

import FeedbackManagementGUI.GUI.MainFrame;

public class MainApplication {
    
    public MainFrame mainFrame;
    
    public MainApplication()
    {
        mainFrame = new MainFrame(this);
    }

    public static void main(String[] args) {
        
        new MainApplication().mainFrame.start();
    }
    
}
