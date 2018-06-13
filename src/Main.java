import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    //Create the Frame
    public static JFrame frame;

    //Create the LoginPanel
    public static LoginPanel loginPanel = new LoginPanel();

    //Create the RegisterPanel
    public static RegisterPanel registerPanel = new RegisterPanel();

    //Create the MainPanel
    public static MainPanel mainPanel = new MainPanel();

    //Create the Database Class
    public static Database database = new Database();

    //Colors
    public static final Color backgroundColor = new Color(255,255,255);

    //Background Image File
    public static String bgImage = "images/background1.jpg";

    //Background Image Icon
    public static ImageIcon backgroundImage = new ImageIcon();

    //Background
    public static JLabel background = new JLabel();

    //Logged In User
    public static int userID;
    public static String username;
    public static String email;
    public static int access;

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
        //frame.getContentPane().setBackground(backgroundColor);

        //Try to load the background image
        try{

            //Load the Background Image
            BufferedImage image = ImageIO.read(new File(bgImage));

            //Set the Background image to the background
            backgroundImage.setImage(image);
            background.setBounds(0,0,1000,750);
            background.setIcon(backgroundImage);

        }catch(Exception ex){

            //Print the error to the console
            System.err.println(ex.getMessage());

        }

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

        //Set panels Visibility
        loginPanel.panel.setVisible(true);
        registerPanel.panel.setVisible(false);
        mainPanel.panel.setVisible(false);

        //Add the LoginPanel to the frame
        frame.add(loginPanel.panel);

        //Add the RegisterPanel to the frame
        frame.add(registerPanel.panel);

        //Add the MainPanel to the frame
        frame.add(mainPanel.panel);

        //Add the background to the frame
        frame.add(background);

        //Refresh the frame
        frame.repaint();
    }

    //Show the Register Form
    public static void ShowRegister(){
        loginPanel.panel.setVisible(false);
        registerPanel.panel.setVisible(true);
    }

    //Show the Register Form
    public static void ShowLogin(){
        registerPanel.panel.setVisible(false);
        loginPanel.panel.setVisible(true);
    }

    //Login
    public static void Login(){

        //The username entered
        String username = loginPanel.usernameInput.getText();

        //The password entered
        String password = new String (loginPanel.passwordInput.getPassword());

        //If the Username isnt empty
        if(!username.isEmpty()) {
            //If the Password isnt empty
            if (!password.isEmpty()) {
                //Login the user in
                if (database.Login(username, password) > 0) {
                    //The User Logged in

                    //Load the users Info
                    mainPanel.loadUser(userID);
                    mainPanel.setup();

                    //Alert Login Successful
                    Alert("Login Successful!");

                    //Reset the Login Inputs
                    loginPanel.usernameInput.setText("");
                    loginPanel.passwordInput.setText("");

                    //Hide Login Panel
                    loginPanel.panel.setVisible(false);

                    //Hide Register Panel
                    registerPanel.panel.setVisible(false);

                    //Show Main Panel
                    mainPanel.panel.setVisible(true);

                } else {
                    //Wrong Username
                    Alert("Wrong Username or Password");
                }
            } else{
                //No Password
                Alert("Please enter a Password");
            }
        }
        else{
            //No Username
            Alert("Please enter a Username");
        }
    }

    //Register
    public static void Register(){

        //The username entered
        String username = registerPanel.usernameInput.getText();

        //The password entered
        String password = new String (registerPanel.passwordInput.getPassword());

        //The email entered
        String email = registerPanel.emailInput.getText();

        //The Access
        int access = 2; //Student

        //If the Username isnt empty
        if(!username.isEmpty()){
            //If the Password isnt empty
            if(!password.isEmpty()){
                //If the Email isnt empty
                if(!email.isEmpty()){
                    //If the Email is valid
                    if(email.contains("@") && email.contains(".com")){
                        //If the Username is taken
                        if(database.isUsernameTaken(username)){

                            //Alert that the Username is taken
                            Alert("Username Taken");

                            //Reset Username InputField
                            registerPanel.usernameInput.setText("");
                        }
                        //If the Username isnt taken
                        else{
                            //Insert the User into the database
                            database.insertUser(username, password, email, access);

                            ShowLogin();
                        }
                    }
                    else{
                        //Email invaild
                        Alert("Email Invalid");
                    }
                }
                else{
                    //No Email
                    Alert("Please enter an Email");
                }
            }
            else{
                //No Password
                Alert("Please enter a Password");
            }
        }
        else{
            //No Username
            Alert("Please enter a Username");
        }
    }

    //Logout
    public static void Logout(){

        //Hide Register Panel
        registerPanel.panel.setVisible(false);

        //Hide Industry Panel
        mainPanel.panel.setVisible(false);

        //Hide student nav
        mainPanel.menuItem1.setVisible(false);
        mainPanel.menuItem2.setVisible(false);

        //Show Login Panel
        loginPanel.panel.setVisible(true);
    }

    //Alert a message to the user
    public static void Alert(String message){
        JOptionPane.showMessageDialog(frame, message);
    }

}