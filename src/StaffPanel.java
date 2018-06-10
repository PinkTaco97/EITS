import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StaffPanel extends JPanel {

    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Staff Panel", JLabel.CENTER);
    public static DefaultTableModel model;
    public static JTable staffTable = new JTable();

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

    public StaffPanel() {
        loadStudents();
        setupComponents();
        addComponents();

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

            model = new DefaultTableModel(new String[]{"Student Name", "Email", "Selected Course"}, 0)
            {
                public boolean isCellEditable(int row, int column){return false;}
            };

            //add the table heading
            model.addRow(new Object[]{"Student Name", "Email", "Selected Course"});

            //iterate through the results
            while (row.next()) {

                //get the student name from the database
                String name = row.getString("Username");

                //get the email from the database
                String email = row.getString("Email");

                //get the selected courseID from the database
                int selectedCourseID = row.getInt("CourseID");

                //get the selected course name from the database
                String selectedCourseName = Main.database.getCourseName(selectedCourseID);

                //add the row to the table model
                model.addRow(new Object[]{name, email, selectedCourseName});
            }

            //set the tables model
            staffTable.setModel(model);
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
        staffTable.setFont(h3);
        staffTable.setRowHeight(30);
        staffTable.setGridColor(gridColour);
        staffTable.setCellSelectionEnabled(false);
        staffTable.setRowSelectionAllowed(false);
    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(title);
        panel.add(staffTable);
        panel.setLayout(new BorderLayout());
    }
}
