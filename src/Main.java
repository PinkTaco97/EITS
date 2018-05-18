import javax.swing.*;
import java.awt.*;

public class Main {

    //Create the Frame
    public static JFrame frame;

    //Create the Panels
    public static LoginPanel loginPanel;
    public static RegisterPanel registerPanel;

    //Colors
    public static final Color backgroundColor = new Color(255,255,255);



    public static void main(String[] args) {
        // write your code here
        createWindow();
        createPanels();
    }

    public static void createWindow(){

        //Create the frame
        frame = new JFrame();

        //Set the title
        frame.setTitle("Education Industry Training System (EITS)");

        //Set the size
        frame.setSize(1000,750);

        //Set the background color
        frame.getContentPane().setBackground(backgroundColor);

        //Set the layout
        frame.getContentPane().setLayout(null);

        //Set the visibility
        frame.setVisible(true);

        //Stop the application when the window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the resizability
        frame.setResizable(false);

    }

    //Create the Login Panel
    public static void createPanels(){

        //Create the Panels
        loginPanel = new LoginPanel();
        registerPanel = new RegisterPanel();

        //Add the LoginPanel to the frame
        frame.add(loginPanel.panel);
        frame.add(registerPanel.panel);

        //Refresh the frame
        frame.repaint();
    }

    //Login
    public static void Login(){
        JOptionPane.showMessageDialog(frame,"Login");
    }

    //Register
    public static void Register(){
        JOptionPane.showMessageDialog(frame, "Register");
    }
}
