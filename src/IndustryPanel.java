import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndustryPanel {

    //Create Components
    public static JPanel panel = new JPanel();
    public static JPanel navBar = new JPanel();
    public static JLabel heading = new JLabel("Select Industry", JLabel.CENTER);
    public static JButton logoutBtn = new JButton("Logout");

    //Fonts
    public static final String font = "Apple Casual";
    public static Font h1 = new Font(font, Font.PLAIN, 50);
    public static Font h2 = new Font(font, Font.PLAIN, 30);

    //Colors
    public static final Color backgroundColor = new Color(0,170,255);

    public IndustryPanel() {
        setupComponents();
        addComponents();
    }

    //Setup the Components
    public static void setupComponents(){

        //Login Panel
        panel.setBounds(0,0,1000,112);
        panel.setOpaque(true);
        //panel.setBackground(backgroundColor);

        //NavBar
        navBar.setBounds(0, 0, 1000, 100);
        navBar.setBackground(Color.WHITE);

        //Heading
        heading.setBounds(250, 0, 500, 100);
        heading.setFont(h1);

        //Login Button
        logoutBtn.setBounds(775, 12, 200, 75);
        logoutBtn.setFont(h2);
        logoutBtn.addActionListener(new ActionListener() {

            //When the Login button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                Main.Logout();
            }
        });
    }

    //Add the Components to the panel
    public static void addComponents(){
        navBar.add(heading);
        navBar.add(logoutBtn);
        navBar.setLayout(new BorderLayout());
        panel.add(navBar);
        panel.setLayout(new BorderLayout());
    }
}
