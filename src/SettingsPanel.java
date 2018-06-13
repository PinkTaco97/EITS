import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class SettingsPanel {

    //GUIComponents
    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Account Settings", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username:");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password:");
    public static JPasswordField passwordInput = new JPasswordField();
    public static JLabel emailText = new JLabel("Email:");
    public static JTextField emailInput = new JTextField();
    public static JButton updateBtn = new JButton();

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 50);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Colors
    public static final Color backgroundColor = new Color(255,255,255);
    public static final Color textColor = new Color(51,51,51);

    //Images
    public static BufferedImage updateBtn_Unselected;
    public static BufferedImage updateBtn_Selected;

    //Constructor
    public SettingsPanel(){
        loadImages();
        setupComponents();
        addComponents();
    }

    //Try to load the Images
    public static void loadImages(){
        //try to load the Images
        try {

            //Select Course Button Images
            updateBtn_Unselected = ImageIO.read(new File("images/Update_Unselected.png"));
            updateBtn_Selected = ImageIO.read(new File("images/Update_Selected.png"));

        } catch (Exception ex) {

            //Print the error to the console
            System.out.println(ex.getMessage());
        }
    }

    //Load the users Username, Password and Email
    public static void loadUser(){
        //Load the users Username, Password and Email
        String[] user = Main.database.LoadUser(Main.userID);

        //If the Username is not empty
        if(!user[0].isEmpty()){
            //If the Password is not empty
            if(!user[1].isEmpty()){
                //If the Email is not empty
                if(!user[2].isEmpty()){

                    //Set the username to the Users Username
                    usernameInput.setText(user[0]);

                    //Set the password to the Users Password
                    passwordInput.setText(user[1]);

                    //Set the email to the Users Email
                    emailInput.setText(user[2]);
                }
            }
        }
    }

    //Setup the Components
    public static void setupComponents() {

        //Panel
        panel.setBounds(50, 65, 900, 650);
        panel.setBackground(backgroundColor);
        panel.setVisible(false);

        //Title
        title.setBounds(0, 25, 900, 75);
        title.setFont(h1);

        //Username Text
        usernameText.setBounds(250, 125, 400, 50);
        usernameText.setFont(h2);

        //Username Input
        usernameInput.setBounds(250, 175, 400, 50);
        usernameInput.setFont(h2);

        //Password Text
        passwordText.setBounds(250, 250, 400, 50);
        passwordText.setFont(h2);

        //Password Input
        passwordInput.setBounds(250, 300, 400, 50);
        passwordInput.setFont(h2);

        //Email Text
        emailText.setBounds(250, 375, 400, 50);
        emailText.setFont(h2);

        //Email Font
        emailInput.setBounds(250, 425, 400, 50);
        emailInput.setFont(h2);

        //Update Button
        updateBtn.setBounds(250, 525 , 400, 75);
        updateBtn.setOpaque(false);
        updateBtn.setIcon(new ImageIcon(updateBtn_Unselected));
        updateBtn.setRolloverIcon(new ImageIcon(updateBtn_Selected));
        updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new ActionListener(){

            //When the Logout Button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get what the user entered
                String username = usernameInput.getText();
                String password = new String(passwordInput.getPassword());
                String email = emailInput.getText();

                //Update the user
                Main.database.updateUser(Main.userID, username, password, email);

                //Alert the user
                Main.Alert("User Updated");

                //Load the user
                loadUser();
            }

        });

    }

    //Add the Components
    public static void addComponents(){
        panel.add(title);
        panel.add(usernameText);
        panel.add(usernameInput);
        panel.add(passwordText);
        panel.add(passwordInput);
        panel.add(emailText);
        panel.add(emailInput);
        panel.add(updateBtn);
        panel.setLayout(new BorderLayout());
    }
}
