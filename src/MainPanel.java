import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

public class MainPanel {

    //Components
    public static JPanel panel = new JPanel();
    public static JPanel navbar = new JPanel();
    public static JLabel welcome = new JLabel("Welcome, ", JLabel.CENTER);
    public static JButton menuItem1 = new JButton();
    public static JButton menuItem2 = new JButton();
    public static JButton logoutBtn = new JButton();
    public static CoursePanel coursePanel = new CoursePanel();
    public static SettingsPanel settingsPanel = new SettingsPanel();

    //Images
    public static BufferedImage findCourse_Unselected;
    public static BufferedImage findCourse_Selected;
    public static BufferedImage accountSettings_Unselected;
    public static BufferedImage accountSettings_Selected;
    public static BufferedImage logoutBtn_Unselected;
    public static BufferedImage logoutBtn_Selected;

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Logged In User Info
    private static int userID;
    private static String username;

    public MainPanel(){
        loadImages();
        setupComponents();
        addComponents();
    }

    public static void loadUser(int userID){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(Main.database.DRIVER);
            Connection con = DriverManager.getConnection(Main.database.SERVER, Main.database.USERNAME, Main.database.PASSWORD);

            String sql = "SELECT Username FROM Users WHERE ID = '" + userID + "';";

            //Create the java statement
            Statement statement = con.createStatement();

            // execute the Statement
            ResultSet row = statement.executeQuery(sql);

            while(row.next()){
                //Set the Username
                username = row.getString("Username");
            }

            //Set the welcome Text
            welcome.setText("Welcome, " + username);


        } catch (Exception ex) {
            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, "Error Connecting to Database! \n" + ex.getMessage());
        }
    }

    //Load the Images
    public static void loadImages(){
        //try to load the Images
        try {

            //Logout Images
            logoutBtn_Unselected = ImageIO.read(new File("images/LogoutBtn_Unselected.png"));
            logoutBtn_Selected = ImageIO.read(new File("images/LogoutBtn_Selected.png"));

            //Find Course Images
            findCourse_Unselected = ImageIO.read(new File("images/FindCourse_Unselected.png"));
            findCourse_Selected = ImageIO.read(new File("images/FindCourse_Selected.png"));

            //Account Settings Images
            accountSettings_Unselected = ImageIO.read(new File("images/AccountSettings_Unselected.png"));
            accountSettings_Selected = ImageIO.read(new File("images/AccountSettings_Selected.png"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Setup the Components
    public static void setupComponents(){

        //Panel
        panel.setBounds(0, 0, 1000, 750);
        panel.setOpaque(false);

        //Navbar
        navbar.setBounds(0, 0, 1000, 50);
        navbar.setBackground(new Color(51,51,51));

        //Welcome Text
        welcome.setBounds(0, 0, 250, 50);
        welcome.setFont(h3);
        welcome.setForeground(Color.WHITE);

        //MenuItem 1
        menuItem1.setBounds(250, 0, 250, 50);
        menuItem1.setIcon(new ImageIcon(findCourse_Unselected));
        menuItem1.setRolloverIcon(new ImageIcon(findCourse_Selected));
        menuItem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem1.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCourses();
            }

        });


        //MenuItem 2
        menuItem2.setBounds(500, 0, 250, 50);
        menuItem2.setIcon(new ImageIcon(accountSettings_Unselected));
        menuItem2.setRolloverIcon(new ImageIcon(accountSettings_Selected));
        menuItem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowSettings();
            }
        });

        //Logout Button
        logoutBtn.setBounds(750, 0, 250, 50);
        logoutBtn.setIcon(new ImageIcon(logoutBtn_Unselected));
        logoutBtn.setRolloverIcon(new ImageIcon(logoutBtn_Selected));
        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutBtn.addActionListener(new ActionListener(){

            //When the Logout Button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Logout();
            }

        });


    }

    //Add the Components
    public static void addComponents(){
        navbar.add(welcome);
        navbar.add(menuItem1);
        navbar.add(menuItem2);
        navbar.add(logoutBtn);
        navbar.setLayout(new BorderLayout());
        panel.add(navbar);
        panel.add(coursePanel.panel);
        panel.add(settingsPanel.panel);
        panel.setLayout(new BorderLayout());
    }

    //Show the account settings
    public static void ShowSettings(){
        coursePanel.panel.setVisible(false);
        settingsPanel.panel.setVisible(true);
    }

    public static void ShowCourses(){
        settingsPanel.panel.setVisible(false);
        coursePanel.panel.setVisible(true);
    }
}
