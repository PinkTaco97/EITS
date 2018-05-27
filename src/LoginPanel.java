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
    public static JLabel background = new JLabel();
    public static JLabel heading = new JLabel("Welcome to EITS", JLabel.CENTER);
    public static JLabel heading1 = new JLabel("Please login to your account.", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password");
    public static JPasswordField passwordInput = new JPasswordField();
    public static JButton registerBtn = new JButton();
    public static JButton loginBtn = new JButton();

    //Images
    public static BufferedImage backgroundImage;
    public static BufferedImage loginBtn_Unselected;
    public static BufferedImage loginBtn_Selected;
    public static BufferedImage registerBtn_Unselected;
    public static BufferedImage registerBtn_Selected;

    //Font
    public static final String font = "Apple Casual";
    public static Font h1 = new Font(font, Font.PLAIN, 50);
    public static Font h2 = new Font(font, Font.PLAIN, 30);
    public static Font h3 = new Font(font, Font.PLAIN, 20);
    public static Font h4 = new Font(font, Font.PLAIN, 15);

    //Color
    public static final Color backgroundColor = new Color(51, 51,51);
    public static final Color textColor = new Color(51,51,51);

    public LoginPanel(){
        loadImages();
        setupComponents();
        addComponents();
    }

    public static void loadImages(){
        //try to load the Images
        try {

            //Login Panel Image
            backgroundImage = ImageIO.read(new File("images/LoginPanel.png"));

            //Login Images
            loginBtn_Unselected = ImageIO.read(new File("images/LoginBtn_Unselected.png"));
            loginBtn_Selected = ImageIO.read(new File("images/LoginBtn_Selected.png"));

            //Register Images
            registerBtn_Unselected = ImageIO.read(new File("images/RegisterBtn_Unselected.png"));
            registerBtn_Selected = ImageIO.read(new File("images/RegisterBtn_Selected.png"));

        } catch (Exception ex) {

            //Print the error to the console
            System.out.println(ex.getMessage());
        }
    }

    //Setup the Components
    public static void setupComponents(){

        //Login Panel
        panel.setBounds(200,75,600,600);
        panel.setOpaque(false);
        //panel.setBackground(backgroundColor);

        //Background
        background.setBounds(0,0,600,600);
        background.setIcon(new ImageIcon(backgroundImage));

        //Heading
        heading.setBounds(0, 0, 600, 100);
        heading.setFont(h1);
        heading.setForeground(textColor);

        //Heading 1
        heading1.setBounds(0, 75, 600, 50);
        heading1.setFont(h3);
        heading1.setForeground(textColor);

        //Username Text
        usernameText.setBounds(125, 150, 300, 50);
        usernameText.setFont(h2);
        usernameText.setForeground(textColor);

        //Username Input
        usernameInput.setBounds(125, 200, 350, 50);
        usernameInput.setFont(h2);

        //Password Text
        passwordText.setBounds(125, 275, 300, 50);
        passwordText.setFont(h2);
        passwordText.setForeground(textColor);

        //Password Input
        passwordInput.setBounds(125, 325, 350, 50);
        passwordInput.setFont(h2);
        passwordInput.addActionListener(new ActionListener(){

            //When the enter key is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Login();
            }
        });

        //Login Button
        loginBtn.setBounds(150, 400, 300, 75);
        loginBtn.setFont(h2);
        loginBtn.setOpaque(false);
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
        registerBtn.setBounds(150, 500, 300, 75);
        registerBtn.setFont(h2);
        registerBtn.setOpaque(false);
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
        panel.add(background);
        panel.setLayout(new BorderLayout());
    }
}