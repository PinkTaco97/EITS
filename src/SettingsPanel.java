import javax.swing.*;
import java.awt.*;

public class SettingsPanel {

    //Components
    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Account Settings", JLabel.CENTER);
    public static JLabel usernameText = new JLabel("Username:");
    public static JTextField usernameInput = new JTextField();
    public static JLabel passwordText = new JLabel("Password:");
    public static JTextField passwordInput = new JTextField();
    public static JLabel emailText = new JLabel("Email:");
    public static JTextField emailInput = new JTextField();




    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 50);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Colors
    public static final Color backgroundColor = new Color(255,255,255);
    public static final Color textColor = new Color(51,51,51);

    public SettingsPanel(){
        setupComponents();
        addComponents();
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
        panel.setLayout(new BorderLayout());
    }
}
