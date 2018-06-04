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
    public static JPanel adminNav = new JPanel();
    public static JButton menuItem3 = new JButton();
    public static JButton menuItem4 = new JButton();
    public static JButton menuItem5 = new JButton();
    public static JButton menuItem6 = new JButton();
    public static CoursePanel coursePanel = new CoursePanel();
    public static SettingsPanel settingsPanel = new SettingsPanel();
    public static AddIndustryPanel addIndustryPanel = new AddIndustryPanel();
    public static AddCoursePanel addCoursePanel = new AddCoursePanel();
    public static AddUnitPanel addUnitPanel = new AddUnitPanel();
    public static AddStaffPanel addStaffPanel = new AddStaffPanel();
    public static StaffPanel staffPanel = new StaffPanel();

    //Images
    public static BufferedImage findCourse_Unselected;
    public static BufferedImage findCourse_Selected;
    public static BufferedImage accountSettings_Unselected;
    public static BufferedImage accountSettings_Selected;
    public static BufferedImage logoutBtn_Unselected;
    public static BufferedImage logoutBtn_Selected;
    public static BufferedImage addIndustry_Unselected;
    public static BufferedImage addIndustry_Selected;
    public static BufferedImage addCourse_Unselected;
    public static BufferedImage addCourse_Selected;
    public static BufferedImage addUnit_Unselected;
    public static BufferedImage addUnit_Selected;
    public static BufferedImage addStaff_Unselected;
    public static BufferedImage addStaff_Selected;

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    public MainPanel(){
        loadImages();
        setupComponents();
        addComponents();
    }

    public static void loadUser(int userId){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(Main.database.DRIVER);
            Connection con = DriverManager.getConnection(Main.database.SERVER, Main.database.USERNAME, Main.database.PASSWORD);

            String sql = "SELECT * FROM Users WHERE ID = '" + userId + "';";

            //Create the java statement
            Statement statement = con.createStatement();

            // execute the Statement
            ResultSet row = statement.executeQuery(sql);

            while(row.next()){
                //Set the logged in users data
                Main.userID = userId;
                Main.username = row.getString("Username");
                Main.email = row.getString("Email");
                Main.access = row.getInt("Access");
            }

        } catch (Exception ex) {
            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            Main.Alert("Error Connecting to Database! \n" + ex.getMessage());
        }
    }

    //Login
    public static void setup(){
        //Set the welcome Text
        welcome.setText("Welcome, " + Main.username);

        switch(Main.access){
            //Admin
            case 0:
                ShowAdmin(true);
                ShowStudentNav(false);
                break;

            //Staff
            case 1:
                ShowStaffPanel();
                break;

            //Student
            case 2:
                ShowCourses();
                ShowStudentNav(true);
                break;

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

            //Add Industry Images
            addIndustry_Unselected = ImageIO.read(new File("images/AddIndustry_Unselected.png"));
            addIndustry_Selected = ImageIO.read(new File("images/AddIndustry_Selected.png"));

            //Add Course Images
            addCourse_Unselected = ImageIO.read(new File("images/AddCourse_Unselected.png"));
            addCourse_Selected = ImageIO.read(new File("images/AddCourse_Selected.png"));

            //Add Unit Images
            addUnit_Unselected = ImageIO.read(new File("images/AddUnit_Unselected.png"));
            addUnit_Selected = ImageIO.read(new File("images/AddUnit_Selected.png"));

            //Add Staff Images
            addStaff_Unselected = ImageIO.read(new File("images/AddStaff_Unselected.png"));
            addStaff_Selected = ImageIO.read(new File("images/AddStaff_Selected.png"));

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
        menuItem1.setVisible(false);


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
        menuItem2.setVisible(false);

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
                logout();
            }

        });

        //Admin Navbar
        adminNav.setBounds(0, 50, 1000, 50);
        adminNav.setBackground(new Color(255,255,255));
        adminNav.setVisible(false);

        //MenuItem 3
        menuItem3.setBounds(0,0,250,50);
        menuItem3.setIcon(new ImageIcon(addIndustry_Unselected));
        menuItem3.setRolloverIcon(new ImageIcon(addIndustry_Selected));
        menuItem3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem3.addActionListener(new ActionListener(){

            //When the Logout Button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAddIndustryPanel();
            }

        });

        //MenuItem 4
        menuItem4.setBounds(250,0,250,50);
        menuItem4.setIcon(new ImageIcon(addCourse_Unselected));
        menuItem4.setRolloverIcon(new ImageIcon(addCourse_Selected));
        menuItem4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem4.addActionListener(new ActionListener(){

            //When the Logout Button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAddCoursePanel();
                addCoursePanel.loadIndustrys();
            }

        });

        //MenuItem 5
        menuItem5.setBounds(500,0,250,50);
        menuItem5.setIcon(new ImageIcon(addUnit_Unselected));
        menuItem5.setRolloverIcon(new ImageIcon(addUnit_Selected));
        menuItem5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem5.addActionListener(new ActionListener(){

            //When the Logout Button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAddUnitPanel();
                addUnitPanel.loadCourses();
            }

        });

        //MenuItem 6
        menuItem6.setBounds(750,0,250,50);
        menuItem6.setIcon(new ImageIcon(addStaff_Unselected));
        menuItem6.setRolloverIcon(new ImageIcon(addStaff_Selected));
        menuItem6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuItem6.addActionListener(new ActionListener(){

            //When the Logout Button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAddStaffPanel();
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
        adminNav.add(menuItem3);
        adminNav.add(menuItem4);
        adminNav.add(menuItem5);
        adminNav.add(menuItem6);
        adminNav.setLayout(new BorderLayout());
        panel.add(navbar);
        panel.add(adminNav);
        panel.add(coursePanel.panel);
        panel.add(settingsPanel.panel);
        panel.add(addIndustryPanel.panel);
        panel.add(addCoursePanel.panel);
        panel.add(addUnitPanel.panel);
        panel.add(addStaffPanel.panel);
        panel.add(staffPanel.panel);
        panel.setLayout(new BorderLayout());
    }

    //Logout
    public static void logout(){
        coursePanel.panel.setVisible(false);
        settingsPanel.panel.setVisible(false);
        adminNav.setVisible(false);
        addIndustryPanel.panel.setVisible(false);
        addCoursePanel.panel.setVisible(false);
        addUnitPanel.panel.setVisible(false);
        addStaffPanel.panel.setVisible(false);
        StaffPanel.panel.setVisible(false);
    }

    //Show the account settings
    public static void ShowSettings(){
        coursePanel.panel.setVisible(false);
        settingsPanel.panel.setVisible(true);
    }

    //Show the Course Selection
    public static void ShowCourses(){
        settingsPanel.panel.setVisible(false);
        coursePanel.panel.setVisible(true);
    }

    //Show the StudentNav
    public static void ShowStudentNav(Boolean show){
        menuItem1.setVisible(show);
        menuItem2.setVisible(show);
    }

    //Show the AdminNav
    public static void ShowAdmin(Boolean show){
        adminNav.setVisible(show);
        addIndustryPanel.panel.setVisible(show);
    }

    //Show the Add Industry Panel
    public static void ShowAddIndustryPanel(){
        addIndustryPanel.panel.setVisible(true);
        addCoursePanel.panel.setVisible(false);
        addUnitPanel.panel.setVisible(false);
        addStaffPanel.panel.setVisible(false);
    }

    //Show the Add Course Panel
    public static void ShowAddCoursePanel(){
        addIndustryPanel.panel.setVisible(false);
        addCoursePanel.panel.setVisible(true);
        addUnitPanel.panel.setVisible(false);
        addStaffPanel.panel.setVisible(false);
    }

    //Show the Add Unit Panel
    public static void ShowAddUnitPanel(){
        addIndustryPanel.panel.setVisible(false);
        addCoursePanel.panel.setVisible(false);
        addUnitPanel.panel.setVisible(true);
        addStaffPanel.panel.setVisible(false);
    }

    //Show the Add Staff Panel
    public static void ShowAddStaffPanel(){
        addIndustryPanel.panel.setVisible(false);
        addCoursePanel.panel.setVisible(false);
        addUnitPanel.panel.setVisible(false);
        addStaffPanel.panel.setVisible(true);
    }

    //Show the Staff Panel
    public static void ShowStaffPanel(){
        staffPanel.panel.setVisible(true);
    }
}
