package FeedbackManagement;

import FeedbackManagement.GUI.MainFrame;
import FeedbackManagement.Models.User;
import java.util.concurrent.CompletableFuture;

public class MainApplication {
    
    public MainFrame mainFrame;
    public static Repository repository;
    public static User loggedInUser;
    
    public MainApplication()
    {
        mainFrame = new MainFrame(this);
        loggedInUser = null;
        
        CompletableFuture.runAsync(() -> {
            repository = new Repository();
        });
    }

    public static void main(String[] args) {
        new MainApplication().mainFrame.start();
    }
    
}
