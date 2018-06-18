/*
    Author: Nathan Robertson
    Student Number: 0100623918
    Known Bugs: None
    Date: 15/5/2018
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddCoursePanel extends JPanel {

    //GUI Components
    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Add Course", JLabel.CENTER);
    public static JLabel industryText = new JLabel("Select Industry");
    public static JComboBox industryInput = new JComboBox();
    public static JLabel courseText = new JLabel("Course Name:");
    public static JTextField courseInput = new JTextField();
    public static JButton addCourseBtn = new JButton();

    //Images
    public static BufferedImage addCourseBtn_Unselected;
    public static BufferedImage addCourseBtn_Selected;

    //Colours
    public static Color bgColor = new Color(255, 255, 255);

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Industry
    public static int selectedIndustryID;

    //Constructor
    public AddCoursePanel(){

        //Load the Images
        loadImages();

        //Setup the Components
        setupComponents();

        //Add the Components to the Panel
        addComponents();
    }

    //Load the Industrys from the database
    public static void loadIndustrys(){

        //Clear the Industry List
        industryInput.removeAllItems();

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

            //Add a ComboItem to the industry input
            industryInput.addItem(new ComboItem("Select an Industry"));

            //Iterate through the results
            while (row.next()) {
                //Add a ComboItem to the industry input
                industryInput.addItem(new ComboItem(row.getString("Name"), row.getInt("ID")));
            }

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

            //Add Industry Btn Images
            addCourseBtn_Unselected = ImageIO.read(new File("images/AddCourseBtn_Unselected.png"));
            addCourseBtn_Selected = ImageIO.read(new File("images/AddCourseBtn_Selected.png"));

        } catch (Exception ex) {

            //Print the Exception to the Console
            System.out.println(ex.getMessage());
        }
    }

    //Setup the components
    public static void setupComponents(){

        //Panel
        panel.setBounds(250,175,500,450);
        panel.setBackground(bgColor);
        panel.setVisible(false);

        //Title
        title.setBounds(0, 25,500, 50);
        title.setFont(h1);

        //Industry Text
        industryText.setBounds(50, 100, 400, 50);
        industryText.setFont(h2);

        //Industry Input
        industryInput.setBounds(50, 140, 400, 50);
        industryInput.setFont(h4);
        industryInput.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //If there are Industrys in the list
                if(industryInput.getItemCount() > 0) {
                    //Get the selected item
                    Object item = industryInput.getSelectedItem();
                    //Get the Industry ID
                    selectedIndustryID = ((ComboItem)item).getID();
                }
            }

        });

        //Course Text
        courseText.setBounds(50, 200, 400, 50);
        courseText.setFont(h2);

        //Course Input
        courseInput.setBounds(50, 250, 400, 50);
        courseInput.setFont(h2);
        courseInput.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get what the user entered
                String course = courseInput.getText();

                //If the user has selected an industry
                if(selectedIndustryID > 0){

                    //If the user entered a course name
                    if(!course.isEmpty()){

                        //Insert the course into the database
                        Main.database.insertCourse(course, selectedIndustryID);
                    }
                    else{
                        Main.Alert("Please input a Course name.");
                    }
                }
                else{
                    Main.Alert("Please Select an Industry");
                }
            }

        });

        //Add Course Btn
        addCourseBtn.setBounds(50, 350, 400, 75);
        addCourseBtn.setIcon(new ImageIcon(addCourseBtn_Unselected));
        addCourseBtn.setRolloverIcon(new ImageIcon(addCourseBtn_Selected));
        addCourseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addCourseBtn.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get what the User entered
                String course = courseInput.getText();

                //If the User selected an Industry
                if(selectedIndustryID > 0){
                    //If the User entered a Course
                    if(!course.isEmpty()){
                        //Insert the Course into the database
                        Main.database.insertCourse(course, selectedIndustryID);
                        //Reset the Course Input
                        courseInput.setText("");
                    }
                    else{
                        //Alert the user to input a Course name
                        Main.Alert("Please input a Course name.");
                    }
                }
                else{
                    //Alert the User to select an Industry
                    Main.Alert("Please Select an Industry");
                }
            }
        });
    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(title);
        panel.add(industryText);
        panel.add(industryInput);
        panel.add(courseText);
        panel.add(courseInput);
        panel.add(addCourseBtn);
        panel.setLayout(new BorderLayout());
    }
}
