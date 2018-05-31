import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CoursePanel {

    //Components
    public static JPanel panel = new JPanel();
    public static JPanel header = new JPanel();
    public static JLabel industryText = new JLabel("Select Industry", JLabel.CENTER);
    public static JComboBox industryInput = new JComboBox();
    public static JLabel courseText = new JLabel("Select Course", JLabel.CENTER);
    public static JComboBox courseInput = new JComboBox();
    public static JPanel content = new JPanel();
    public static JLabel courseTitle = new JLabel("Diploma of Software Development", JLabel.CENTER);

    //The Units Table
    public static String[] unitHeading = {"Unit Code", "Unit Description"};
    public static Object[][] unitdata = {{"ICT134", "Web Programming"}};
    public static JTable unitsTable = new JTable(unitdata, unitHeading);

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 50);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Colors
    public static final Color backgroundColor = new Color(255,255,255);
    public static final Color textColor = new Color(51,51,51);

    //The Selected industry ID
    public static int selectedIndustry = 1;

    //The Selected course ID
    public static int selectedCourse = 1;

    public static boolean changingCourse = false;


    public CoursePanel(){
        loadIndustrys();
        loadCourses(selectedIndustry);
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
                industryInput.addItem(new ComboItem(row.getString("Name"), row.getInt("ID")));
            }

        } catch (Exception ex) {

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");
        }
    }

    //Load the Courses from the database
    public static void loadCourses(int industry){

        //Changing the courses
        changingCourse = true;

        //Clear Course List
        courseInput.removeAllItems();

        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(Main.database.DRIVER);
            Connection con = DriverManager.getConnection(Main.database.SERVER, Main.database.USERNAME, Main.database.PASSWORD);

            String sql = "SELECT * FROM Courses WHERE IndustryID = '" + industry + "';";

            //Create the java statement
            Statement statement = con.createStatement();

            // execute the Statement
            ResultSet row = statement.executeQuery(sql);

            //Iterate through the results
            while (row.next()) {
                courseInput.addItem(new ComboItem(row.getString("Code") + " - " + row.getString("Name"), row.getInt("ID")));
            }

        } catch (Exception ex) {

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");
        }

        changingCourse = false;
    }

    //Load the Units from the database
    public static void loadUnits(int course){

        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(Main.database.DRIVER);
            Connection con = DriverManager.getConnection(Main.database.SERVER, Main.database.USERNAME, Main.database.PASSWORD);

            String sql = "SELECT * FROM Units WHERE CourseID = '" + course + "';";

            //Create the java statement
            Statement statement = con.createStatement();

            // execute the Statement
            ResultSet row = statement.executeQuery(sql);

            System.out.println(" Code  |  Description");
            System.out.println("-------|-------------------------------");

            //Iterate through the results
            while (row.next()) {
                System.out.println(row.getString("Code") + " | " + row.getString("Description"));
            }

            System.out.println("\n");

        } catch (Exception ex) {

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");
        }
    }


    //Setup the Components
    public static void setupComponents() {

        //Panel
        panel.setBounds(50, 65, 900, 650);
        panel.setBackground(backgroundColor);

        //Header
        header.setBounds(0, 0, 900, 150);
        //header.setBackground(new Color(0,0,0));

        //Industry Text
        industryText.setBounds(50, 25, 350, 50);
        industryText.setFont(h2);

        //Industry Input
        industryInput.setBounds(50, 75, 350, 50);
        industryInput.setFont(h4);
        industryInput.addActionListener (new ActionListener() {
            //Called when an item has been selected
            public void actionPerformed(ActionEvent e) {
                //Changing the courses
                changingCourse = true;
                //Get the selected item
                Object item = industryInput.getSelectedItem();
                //Get the Industry ID
                selectedIndustry = ((ComboItem)item).getID();
                //Load the courses
                loadCourses(selectedIndustry);
            }
        });

        //Course Text
        courseText.setBounds(500, 25, 350, 50);
        courseText.setFont(h2);

        //Course Input
        courseInput.setBounds(500, 75, 350, 50);
        courseInput.setFont(h4);
        courseInput.addActionListener (new ActionListener() {
            //Called when an item has been selected
            public void actionPerformed(ActionEvent e) {

                //If we arnt changing the course
                if(!changingCourse){
                    //Get the selected item
                    Object item = courseInput.getSelectedItem();
                    //Get the Course ID
                    selectedCourse = ((ComboItem)item).ID;
                    //Load the Course Units
                    loadUnits(selectedCourse);
                }
            }
        });

        //Content
        content.setBounds(0, 150, 900, 500);
        content.setBackground(Color.WHITE);

        //Course Title
        courseTitle.setBounds(0, 0, 900, 50);
        courseTitle.setFont(h1);

    }

    //Add the Components
    public static void addComponents(){
        header.add(industryText);
        header.add(industryInput);
        header.add(courseText);
        header.add(courseInput);
        header.setLayout(new BorderLayout());
        content.add(courseTitle);
        content.add(unitsTable.getTableHeader(), BorderLayout.PAGE_START);
        content.add(unitsTable, BorderLayout.CENTER);
        content.setLayout(new BorderLayout());
        panel.add(header);
        panel.add(content);
        panel.setLayout(new BorderLayout());
    }

    //Make the ComboBox List Items
    private static Object makeItem(final String item, final int ID){
        return new Object(){

            public int id = ID;

            public String toString() {
                return item;
            }

            public int getId(){
                return id;
            }
        };
    }

}
