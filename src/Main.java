import javax.swing.*;
import java.awt.*;

public class Main {

    //Create the Frame
    public static JFrame frame;

    //Create the LoginPanel
    public static LoginPanel loginPanel;

    //Create the RegisterPanel
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

        //Create the LoginPanel
        loginPanel = new LoginPanel();

        //Create the RegisterPanel
        registerPanel = new RegisterPanel();

        //Add the LoginPanel to the frame
        frame.add(loginPanel.panel);

        //Add the RegisterPanel to the frame
        frame.add(registerPanel.panel);

        //Refresh the frame
        frame.repaint();
    }

    //Login
    public static void Login(){

        //The username entered
        String username = loginPanel.usernameInput.getText();

        //The password entered
        String password = new String (loginPanel.passwordField.getPassword());

        //Alert the username and password
        JOptionPane.showMessageDialog(frame,"Username: " + username + "\n" + "Password: " + password);

        //Reset the Username InputField
        loginPanel.usernameInput.setText("");

        //Reset the Password InputField
        loginPanel.passwordField.setText("");
    }

    //Register
    public static void Register(){

        //The username entered
        String username = registerPanel.usernameInput.getText();

        //The password entered
        String password = new String (registerPanel.passwordInput.getPassword());

        //The email entered
        String email = registerPanel.emailInput.getText();

        //Alert the username and password and email
        JOptionPane.showMessageDialog(frame, "Username: " + username + "\n" + "Password: " + password + "\n" + "Email: " + email);

        //Reset the Username InputField
        registerPanel.usernameInput.setText("");

        //Reset the Password InputField
        registerPanel.passwordInput.setText("");

        //Reset the Email InputField
        registerPanel.emailInput.setText("");
    }
}
