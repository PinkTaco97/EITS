import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel {

    //Create Components
    public static JPanel panel = new JPanel();
    public static JLabel heading = new JLabel("Welcome to EITS", JLabel.CENTER);
    public static JLabel heading1 = new JLabel("Please register an account.", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password");
    public static JPasswordField passwordInput = new JPasswordField();
    public static JLabel emailText = new JLabel("Email");
    public static JTextField emailInput = new JTextField();
    public static JButton registerBtn = new JButton("Register");
    public static JButton loginBtn = new JButton("Login");

    //Font
    public static final String font = "Apple Casual";
    public static Font h1 = new Font(font, Font.PLAIN, 50);
    public static Font h2 = new Font(font, Font.PLAIN, 30);
    public static Font h3 = new Font(font, Font.PLAIN, 20);
    public static Font h4 = new Font(font, Font.PLAIN, 15);

    //Color
    public static final Color backgroundColor = new Color(51, 51,51);

    public RegisterPanel(){
        setupComponents();
        addComponents();
    }

    //Setup the Components
    public static void setupComponents(){

        //Register Panel
        panel.setBounds(200,0,600,750);
        panel.setBackground(backgroundColor);

        //Heading
        heading.setBounds(100, 25, 400, 100);
        heading.setFont(h1);
        heading.setForeground(Color.WHITE);

        //Heading
        heading1.setBounds(100, 100, 400, 50);
        heading1.setFont(h3);
        heading1.setForeground(Color.white);

        //Username Text
        usernameText.setBounds(125, 150, 300, 50);
        usernameText.setFont(h2);
        usernameText.setForeground(Color.WHITE);

        //Username Input
        usernameInput.setBounds(125, 200, 350, 50);
        usernameInput.setFont(h2);

        //Password Text
        passwordText.setBounds(125, 275, 300, 50);
        passwordText.setFont(h2);
        passwordText.setForeground(Color.WHITE);

        //Password Input
        passwordInput.setBounds(125, 325, 350, 50);
        passwordInput.setFont(h2);

        //Email Text
        emailText.setBounds(125, 400, 300, 50);
        emailText.setFont(h2);
        emailText.setForeground(Color.WHITE);

        //Email Input
        emailInput.setBounds(125, 450, 350, 50);
        emailInput.setFont(h2);

        //Register Button
        registerBtn.setBounds(125, 525, 350, 75);
        registerBtn.setFont(h2);
        registerBtn.addActionListener(new ActionListener() {

            //When the Register button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Main.Register();
            }
        });

        //Login Button
        loginBtn.setBounds(125, 625, 350, 75);
        loginBtn.setFont(h2);
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