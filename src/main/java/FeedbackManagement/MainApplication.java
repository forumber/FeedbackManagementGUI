package FeedbackManagement;

import FeedbackManagement.GUI.MainFrame;
import java.util.concurrent.CompletableFuture;

public class MainApplication {
    
    public MainFrame mainFrame;
    public Repository repository;
    
    public MainApplication()
    {
        mainFrame = new MainFrame(this);
        
        CompletableFuture.runAsync(() -> {
            repository = new Repository();
        });
    }

    public static void main(String[] args) {

        
        new MainApplication().mainFrame.start();
    }
    
}
