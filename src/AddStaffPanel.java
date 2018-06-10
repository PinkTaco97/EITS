import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class AddStaffPanel extends JPanel {

    //Components
    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Add Staff Account", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username:");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password:");
    public static JPasswordField passwordInput = new JPasswordField();
    public static JLabel emailText = new JLabel("Email:");
    public static JTextField emailInput = new JTextField();
    public static JButton addStaffBtn = new JButton();

    //Images
    public static BufferedImage addStaffBtn_Unselected;
    public static BufferedImage addStaffBtn_Selected;

    //Colours
    public static Color bgColor = new Color(255, 255, 255);

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    public AddStaffPanel(){
        loadImages();
        setupComponents();
        addComponents();
    }

    //Load the Images
    public static void loadImages(){
        //try to load the Images
        try {

            //Add Industry Btn Images
            addStaffBtn_Unselected = ImageIO.read(new File("images/AddStaffBtn_Unselected.png"));
            addStaffBtn_Selected = ImageIO.read(new File("images/AddStaffBtn_Selected.png"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Setup the components
    public static void setupComponents(){

        //Panel
        panel.setBounds(250,125,500,525);
        panel.setBackground(bgColor);
        panel.setVisible(false);

        //Title
        title.setBounds(0, 25,500, 50);
        title.setFont(h1);

        //Username Text
        usernameText.setBounds(50,100,400,50);
        usernameText.setFont(h2);

        //Username Input
        usernameInput.setBounds(50, 150, 400, 50);
        usernameInput.setFont(h2);

        //Password Text
        passwordText.setBounds(50,200,400,50);
        passwordText.setFont(h2);

        //Password Input
        passwordInput.setBounds(50, 250, 400, 50);
        passwordInput.setFont(h2);

        //Email Text
        emailText.setBounds(50,300,400,50);
        emailText.setFont(h2);

        //Email Input
        emailInput.setBounds(50, 350, 400, 50);
        emailInput.setFont(h2);

        //Add Staff Button
        addStaffBtn.setBounds(50, 425, 400, 75);
        addStaffBtn.setIcon(new ImageIcon(addStaffBtn_Unselected));
        addStaffBtn.setRolloverIcon(new ImageIcon(addStaffBtn_Selected));
        addStaffBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addStaffBtn.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get what the user entered
                String username = usernameInput.getText();
                String password = new String(passwordInput.getPassword());
                String email = emailInput.getText();

                //The Access
                int access = 1; //Staff Member

                //If the Username isnt empty
                if(!username.isEmpty()){
                    //If the Password isnt empty
                    if(!password.isEmpty()){
                        //If the Email isnt empty
                        if(!email.isEmpty()){
                            //If the Email is valid
                            if(email.contains("@") && email.contains(".com")){
                                //If the Username is taken
                                if(Main.database.isUsernameTaken(username)){

                                    //Alert that the Username is taken
                                    Main.Alert("Username Taken");

                                    //Reset Username InputField
                                    usernameInput.setText("");
                                }
                                //If the Username isnt taken
                                else{
                                    //Insert the User into the database
                                    Main.database.insertUser(username, password, email, access);

                                    //Reset the input fields
                                    usernameInput.setText("");
                                    passwordInput.setText("");
                                    emailInput.setText("");
                                }
                            }
                            else{
                                //Email invaild
                                Main.Alert("Email Invalid");
                            }
                        }
                        else{
                            //No Email
                            Main.Alert("Please enter an Email");
                        }
                    }
                    else{
                        //No Password
                        Main.Alert("Please enter a Password");
                    }
                }
                else{
                    //No Username
                    Main.Alert("Please enter a Username");
                }

            }

        });

    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(title);
        panel.add(usernameText);
        panel.add(usernameInput);
        panel.add(passwordText);
        panel.add(passwordInput);
        panel.add(emailText);
        panel.add(emailInput);
        panel.add(addStaffBtn);
        panel.setLayout(new BorderLayout());
    }
}
