import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class LoginPanel {

    //Create Components
    public static JPanel panel = new JPanel();
    public static JLabel heading = new JLabel("Welcome to EITS", JLabel.CENTER);
    public static JLabel heading1 = new JLabel("Please login to your account.", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password");
    public static JPasswordField passwordInput = new JPasswordField();
    public static JButton registerBtn = new JButton();
    public static JButton loginBtn = new JButton();

    //Images
    public static BufferedImage loginBtn_Unselected;
    public static BufferedImage loginBtn_Selected;
    public static BufferedImage registerBtn_Unselected;
    public static BufferedImage registerBtn_Selected;

    //Font
    public static final String font = "Apple Casual";
    public static Font h1 = new Font(font, Font.PLAIN, 40);
    public static Font h2 = new Font(font, Font.PLAIN, 30);
    public static Font h3 = new Font(font, Font.PLAIN, 20);
    public static Font h4 = new Font(font, Font.PLAIN, 15);

    //Color
    public static final Color backgroundColor = new Color(51, 51,51);

    public LoginPanel(){
        loadImages();
        setupComponents();
        addComponents();
    }

    public static void loadImages(){
        //try to load the Images
        try {

            //Login Images
            loginBtn_Unselected = ImageIO.read(new File("images/LoginBtn_Unselected.png"));
            loginBtn_Selected = ImageIO.read(new File("images/LoginBtn_Selected.png"));

            //Register Images
            registerBtn_Unselected = ImageIO.read(new File("images/RegisterBtn_Unselected.png"));
            registerBtn_Selected = ImageIO.read(new File("images/RegisterBtn_Selected.png"));

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //Setup the Components
    public static void setupComponents(){

        //Register Panel
        panel.setBounds(600,0,400,750);
        panel.setBackground(backgroundColor);

        //Heading
        heading.setBounds(0, 25, 400, 100);
        heading.setFont(h1);
        heading.setForeground(Color.WHITE);

        //Heading
        heading1.setBounds(0, 100, 400, 50);
        heading1.setFont(h3);
        heading1.setForeground(Color.white);

        //Username Text
        usernameText.setBounds(25, 200, 300, 50);
        usernameText.setFont(h2);
        usernameText.setForeground(Color.WHITE);

        //Username Input
        usernameInput.setBounds(25, 250, 350, 50);
        usernameInput.setFont(h2);

        //Password Text
        passwordText.setBounds(25, 325, 300, 50);
        passwordText.setFont(h2);
        passwordText.setForeground(Color.WHITE);

        //Password Input
        passwordInput.setBounds(25, 375, 350, 50);
        passwordInput.setFont(h2);
        passwordInput.addActionListener(new ActionListener(){

            //When the enter key is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Login();
            }
        });

        //Login Button
        loginBtn.setBounds(25, 525, 350, 75);
        loginBtn.setFont(h2);
        loginBtn.setIcon(new ImageIcon(loginBtn_Unselected));
        loginBtn.setRolloverIcon(new ImageIcon(loginBtn_Selected));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new ActionListener() {

            //When the Register button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Main.Login();
            }
        });

        //Register Button
        registerBtn.setBounds(25, 625, 350, 75);
        registerBtn.setFont(h2);
        registerBtn.setIcon(new ImageIcon(registerBtn_Unselected));
        registerBtn.setRolloverIcon(new ImageIcon(registerBtn_Selected));
        registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerBtn.addActionListener(new ActionListener() {

            //When the Register button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Main.ShowRegister();
            }
        });
    }

    //Add the Components to the panel
    public static void addComponents(){
        panel.add(heading);
        panel.add(heading1);
        panel.add(usernameText);
        panel.add(usernameInput);
        panel.add(passwordText);
        panel.add(passwordInput);
        panel.add(loginBtn);
        panel.add(registerBtn);
        panel.setLayout(new BorderLayout());
    }
}