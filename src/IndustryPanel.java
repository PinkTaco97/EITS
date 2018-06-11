import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IndustryPanel {

    //GUI Components
    public static JPanel panel = new JPanel();
    public static JPanel navBar = new JPanel();
    public static JLabel heading = new JLabel("Select Industry", JLabel.CENTER);
    public static JButton logoutBtn = new JButton("Logout");
    public static JComboBox industrys = new JComboBox();

    //Fonts
    public static final String font = "Apple Casual";
    public static Font h1 = new Font(font, Font.PLAIN, 50);
    public static Font h2 = new Font(font, Font.PLAIN, 20);

    //Colors
    public static final Color backgroundColor = new Color(0,170,255);

    public IndustryPanel() {
        loadIndustrys();
        setupComponents();
        addComponents();
    }

    //Load the Industrys from the database
    public static void loadIndustrys(){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(Main.database.DRIVER);
            Connection con = DriverManager.getConnection(Main.database.SERVER, Main.database.USERNAME, Main.database.PASSWORD);

            String sql = "SELECT * FROM Industry";

            //Create the java statement
            Statement statement = con.createStatement();

            //Execute the query and get the result
            ResultSet row = statement.executeQuery(sql);

            //Iterate through the results
            while (row.next()) {
                industrys.addItem(makeItem(row.getString("Name")));
            }

        } catch (Exception ex) {

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");
        }
    }

    //Setup the Components
    public static void setupComponents(){

        //Login Panel
        panel.setBounds(0,0,1000,500);
        panel.setBackground(backgroundColor);

        //NavBar
        navBar.setBounds(0, 0, 1000, 100);
        navBar.setBackground(Color.WHITE);
        navBar.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));
        navBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

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

        industrys.setBounds(250, 112, 350, 250);
        industrys.setSize(350, 250);
        industrys.setFont(h2);
    }

    //Add the Components to the panel
    public static void addComponents(){
        navBar.add(heading);
        navBar.add(logoutBtn);
        navBar.setLayout(new BorderLayout());
        panel.add(navBar);
        panel.add(industrys);
        panel.setLayout(new BorderLayout());
    }

    //Make the ComboBox List Items
    private static Object makeItem(final String item){
        return new Object(){
            public String toString() {
                return item;
            }
        };
    }
}
