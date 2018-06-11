import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class RegisterPanel {

    //GUI Components
    public static JPanel panel = new JPanel();
    public static JLabel heading = new JLabel("Welcome to EITS", JLabel.CENTER);
    public static JLabel heading1 = new JLabel("Please register an account.", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password");
    public static JPasswordField passwordInput = new JPasswordField();
    public static JLabel emailText = new JLabel("Email");
    public static JTextField emailInput = new JTextField();
    public static JButton registerBtn = new JButton();
    public static JButton loginBtn = new JButton();

    //Images
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
    public static final Color backgroundColor = new Color(255, 255,255);
    public static final Color textColor = new Color(51,51,51);

    public RegisterPanel(){
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
        panel.setBounds(200,0,600,750);
        panel.setBackground(backgroundColor);

        //Heading
        heading.setBounds(100, 25, 400, 100);
        heading.setFont(h1);
        heading.setForeground(textColor);

        //Heading
        heading1.setBounds(100, 100, 400, 50);
        heading1.setFont(h3);
        heading1.setForeground(textColor);

        //Username Text
        usernameText.setBounds(125, 150, 300, 50);
        usernameText.setFont(h2);
        usernameText.setForeground(textColor);

        //Username Input
        usernameInput.setBounds(125, 200, 350, 50);
        usernameInput.setFont(h2);
        usernameInput.addActionListener(new ActionListener(){

            //When the enter key is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Register();
            }
        });

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
                Main.Register();
            }
        });

        //Email Text
        emailText.setBounds(125, 400, 300, 50);
        emailText.setFont(h2);
        emailText.setForeground(textColor);

        //Email Input
        emailInput.setBounds(125, 450, 350, 50);
        emailInput.setFont(h2);
        emailInput.addActionListener(new ActionListener(){

            //When the enter key is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Register();
            }
        });

        //Register Button
        registerBtn.setBounds(150, 525, 300, 75);
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
                Main.Register();
            }
        });

        //Login Button
        loginBtn.setBounds(150, 625, 300, 75);
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
                Main.ShowLogin();
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
        panel.add(emailText);
        panel.add(emailInput);
        panel.add(registerBtn);
        panel.add(loginBtn);
        panel.setLayout(new BorderLayout());
    }
}