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
    public static JPanel header = new JPanel();
    public static JLabel heading = new JLabel(" Welcome Page");
    public static JButton logoutBtn = new JButton();
    public static JPanel navbar = new JPanel();
    public static JLabel welcome = new JLabel("Welcome, ", JLabel.CENTER);
    public static JButton menuItem1 = new JButton();
    public static JButton menuItem2 = new JButton();

    //Images
    public static BufferedImage logoutBtn_Unselected;
    public static BufferedImage logoutBtn_Selected;
    public static BufferedImage findCourse_Unselected;
    public static BufferedImage findCourse_Selected;
    public static BufferedImage accountSettings_Unselected;
    public static BufferedImage accountSettings_Selected;

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
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");
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
            System.out.println(ex);
        }
    }

    //Setup the Components
    public static void setupComponents(){

        //Panel
        panel.setBounds(0, 0, 1000, 750);

        //Header
        header.setBounds(250, 0, 750, 50);
        header.setBackground(Color.WHITE);

        //heading
        heading.setBounds(0, 0, 600, 50);
        heading.setFont(h1);

        //Logout Button
        logoutBtn.setBounds(600, 0, 150, 50);
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

        //Navbar
        navbar.setBounds(0, 0, 250, 750);
        navbar.setBackground(new Color(51,51,51));

        //Welcome Text
        welcome.setBounds(0, 0, 250, 50);
        welcome.setFont(h3);
        welcome.setForeground(Color.WHITE);

        //MenuItem 1
        menuItem1.setBounds(0, 50, 250, 50);
        menuItem1.setIcon(new ImageIcon(findCourse_Unselected));
        menuItem1.setRolloverIcon(new ImageIcon(findCourse_Selected));
        menuItem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem1.addActionListener(new ActionListener() {

            //When the Register button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //MenuItem 2
        menuItem2.setBounds(0, 100, 250, 50);
        menuItem2.setIcon(new ImageIcon(accountSettings_Unselected));
        menuItem2.setRolloverIcon(new ImageIcon(accountSettings_Selected));
        menuItem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    //Add the Components
    public static void addComponents(){
        //header.add(heading);
        header.add(logoutBtn);
        header.setLayout(new BorderLayout());
        navbar.add(welcome);
        navbar.add(menuItem1);
        navbar.add(menuItem2);
        navbar.setLayout(new BorderLayout());
        panel.add(header);
        panel.add(navbar);
        panel.setLayout(new BorderLayout());
    }
}
