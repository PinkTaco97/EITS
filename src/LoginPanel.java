import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel {

    //Create Components
    public static JPanel panel = new JPanel();
    public static JLabel heading = new JLabel("Login", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username: ");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password: ");
    public static JPasswordField passwordField = new JPasswordField(1);
    public static JButton loginBtn = new JButton("Login");

    //Fonts
    public static final String font = "Helvetica";
    public static Font h1 = new Font(font, Font.PLAIN, 75);
    public static Font h2 = new Font(font, Font.PLAIN, 30);

    //Color
    public static final Color backgroundColor = new Color(0,170,255);

    public LoginPanel() {
        setupComponents();
        addComponents();
    }

    //Setup the Components
    public static void setupComponents(){

        //Login Panel
        panel.setBounds(0,0,400,750);
        panel.setBackground(backgroundColor);

        //Heading
        heading.setBounds(0, 50, 400, 100);
        heading.setFont(h1);

        //Username Text
        usernameText.setBounds(50, 200, 300, 50);
        usernameText.setFont(h2);

        //Username Input
        usernameInput.setBounds(50, 250, 300, 50);
        usernameInput.setFont(h2);

        //Password Text
        passwordText.setBounds(50, 325, 300, 50);
        passwordText.setFont(h2);

        //Password Input
        passwordField.setBounds(50, 375, 300, 50);
        passwordField.setFont(h2);

        //Login Button
        loginBtn.setBounds(50, 600, 300, 100);
        loginBtn.setFont(h2);
        loginBtn.addActionListener(new ActionListener() {

            //When the Login button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Main.Login();
            }
        });
    }

    //Add the Components to the panel
    public static void addComponents(){
        panel.add(heading);
        panel.add(usernameText);
        panel.add(usernameInput);
        panel.add(passwordText);
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.setLayout(new BorderLayout());
    }
}