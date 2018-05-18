import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel {

    //Create Components
    public static JPanel panel = new JPanel();
    public static JLabel heading = new JLabel("Register", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username: ");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password: ");
    public static JPasswordField passwordInput = new JPasswordField();
    public static JLabel emailText = new JLabel("Email: ");
    public static JTextField emailInput = new JTextField();
    public static JButton registerBtn = new JButton("Register");

    //Font
    public static final String font = "Helvetica";
    public static Font h1 = new Font(font, Font.PLAIN, 75);
    public static Font h2 = new Font(font, Font.PLAIN, 30);

    //Color
    public static Color backgroundColor = new Color(255, 255, 255);

    public RegisterPanel(){
        setupComponents();
        addComponents();
    }

    public static void setupComponents(){

        //Register Panel
        panel.setBounds(400,0,600,750);
        panel.setBackground(backgroundColor);

        //Heading
        heading.setBounds(100, 50, 400, 100);
        heading.setFont(h1);

        //Username Text
        usernameText.setBounds(125, 200, 300, 50);
        usernameText.setFont(h2);

        //Username Input
        usernameInput.setBounds(125, 250, 375, 50);
        usernameInput.setFont(h2);

        //Password Text
        passwordText.setBounds(125, 325, 300, 50);
        passwordText.setFont(h2);

        //Password Input
        passwordInput.setBounds(125, 375, 375, 50);
        passwordInput.setFont(h2);

        //Email Text
        emailText.setBounds(125, 450, 300, 50);
        emailText.setFont(h2);

        //Email Input
        emailInput.setBounds(125, 500, 375, 50);
        emailInput.setFont(h2);

        //Register Button
        registerBtn.setBounds(125, 600, 375, 100);
        registerBtn.setFont(h2);
        registerBtn.addActionListener(new ActionListener() {

            //When the Register button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Main.Register();
            }
        });

    }

    //Add the Components to the panel
    public static void addComponents(){
        panel.add(heading);
        panel.add(usernameText);
        panel.add(usernameInput);
        panel.add(passwordText);
        panel.add(passwordInput);
        panel.add(emailText);
        panel.add(emailInput);
        panel.add(registerBtn);
        panel.setLayout(new BorderLayout());
    }
}