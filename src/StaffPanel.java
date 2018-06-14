import com.apple.eawt.Application;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

public class StaffPanel extends JPanel {

    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Staff Panel", JLabel.CENTER);
    public static DefaultTableModel model;
    public static JTable staffTable = new JTable();
    public static JButton refreshBtn = new JButton();

    //colour
    public static Color backgroundColour = new Color(255, 255, 255);
    public static Color textColour = new Color(51, 51, 51);
    public static Color gridColour = new Color(51, 51, 51);

    //fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 35);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Images
    public static BufferedImage refreshBtn_Selected;
    public static BufferedImage refreshBtn_Unselected;

    public StaffPanel() {
        loadImages();
        loadStudents();
        setupComponents();
        addComponents();
    }

    //Load the Images
    public static void loadImages(){
        //Try to load the images
        try{

            //Add Refresh Btn Images
            refreshBtn_Unselected = ImageIO.read(new File("images/Refresh_Unselected.png"));
            refreshBtn_Selected = ImageIO.read(new File("images/Refresh_Selected.png"));

        }
        catch(Exception ex){
            //Print error to the console
            System.out.println(ex.getMessage());
        }
    }

    //load the students information from the database
    public static void loadStudents(){
        //try to connect to database
        try {
            //create database connection
            Class.forName(Main.database.DRIVER);
            Connection conn = DriverManager.getConnection(Main.database.SERVER, Main.database.USERNAME, Main.database.PASSWORD);
            String sql = "SELECT * FROM Users WHERE Access = '2'";

            //create the java statement
            Statement statement = conn.createStatement();

            //execute the statement
            ResultSet row = statement.executeQuery(sql);

            model = new DefaultTableModel(new String[]{"Student Name", "Email", "Selected Course", "Last Logged In"}, 0)
            {
                public boolean isCellEditable(int row, int column){return false;}
            };

            //add the table heading
            model.addRow(new Object[]{" Student Name", " Email", " Selected Course", " Last Logged In"});

            //iterate through the results
            while (row.next()) {

                //get the student name from the database
                String name = " " + row.getString("Username");

                //get the email from the database
                String email = " " + row.getString("Email");

                //get the selected courseID from the database
                int selectedCourseID = row.getInt("CourseID");

                //get the selected course name from the database
                String selectedCourseName = " " + Main.database.getCourseName(selectedCourseID);

                //Get the Last Logged In
                String lastLoggedIn = " " + row.getString("LastLoggedIn");

                //add the row to the table model
                model.addRow(new Object[]{name, email, selectedCourseName, lastLoggedIn});
            }

            //set the tables model
            staffTable.setModel(model);
            staffTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            staffTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            staffTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            staffTable.getColumnModel().getColumn(3).setPreferredWidth(250);

        }catch(Exception ex){
            //we got an exception
            System.err.println(ex.getMessage());
            //alert error
            Main.Alert("Error connecting to Database.");
        }
    }

    //Setup the components
    public static void setupComponents(){

        //panel
        panel.setBounds(50, 75, 900, 450);
        panel.setBackground(backgroundColour);
        panel.setVisible(false);

        //title
        title.setBounds(0, 25, 900, 50);
        title.setFont(h1);

        //staff table
        staffTable.setBounds(0, 100, 900, 350);
        staffTable.setFont(h4);
        staffTable.setRowHeight(30);
        staffTable.setGridColor(gridColour);
        staffTable.setCellSelectionEnabled(false);
        staffTable.setRowSelectionAllowed(false);

        //Refresh Button
        refreshBtn.setBounds(825, 25, 50,50);
        refreshBtn.setOpaque(false);
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setBorderPainted(false);
        refreshBtn.setIcon(new ImageIcon(refreshBtn_Unselected));
        refreshBtn.setRolloverIcon(new ImageIcon(refreshBtn_Selected));
        refreshBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refreshBtn.addActionListener(new ActionListener() {

            //When the Refresh button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                loadStudents();
                Main.Alert("Refreshed Students!");
            }
        });
    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(refreshBtn);
        panel.add(title);
        panel.add(staffTable);
        panel.setLayout(new BorderLayout());
    }
}
