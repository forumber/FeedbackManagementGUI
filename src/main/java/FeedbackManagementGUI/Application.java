/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackManagementGUI;

import FeedbackManagementGUI.GUI.MainFrame;

/**
 *
 * @author Berkay
 */
public class Application {
    
    public MainFrame mainFrame;
    
    public Application()
    {
        mainFrame = new MainFrame();
    }

    public static void main(String[] args) {
        new Application();
    }
    
}
