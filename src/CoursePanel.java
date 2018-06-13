import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CoursePanel extends JPanel {

    //GUI Components
    public static JPanel panel = new JPanel();
    public static JPanel header = new JPanel();
    public static JLabel industryText = new JLabel("Select Industry", JLabel.CENTER);
    public static JComboBox industryInput = new JComboBox();
    public static JLabel courseText = new JLabel("Select Course", JLabel.CENTER);
    public static JComboBox courseInput = new JComboBox();
    public static JPanel content = new JPanel();
    public static JLabel courseTitle = new JLabel("", JLabel.CENTER);
    public static JButton selectCourseBtn = new JButton();
    public static JButton helpBtn = new JButton();
    public static JPanel helpPanel = new JPanel();
    public static JButton closeBtn = new JButton();

    //The units table
    public static DefaultTableModel model;
    public static JTable unitTable = new JTable();

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 50);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 35);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Colors
    public static final Color backgroundColor = new Color(255,255,255);
    public static final Color textColor = new Color(51,51,51);
    public static final Color gridColor = new Color(51, 51, 51);

    //Images
    public static BufferedImage selectBtn_Unselected;
    public static BufferedImage selectBtn_Selected;
    public static BufferedImage helpBtn_Unselected;
    public static BufferedImage helpBtn_Selected;
    public static BufferedImage closeBtn_Unselected;
    public static BufferedImage closeBtn_Selected;

    //The Selected industry ID
    public static int selectedIndustryID = 0;
    public static String selectedIndustry = "";

    //The Selected course ID
    public static int selectedCourseID = 0;
    public static String selectedCourse = "";

    public static boolean changingCourse = false;

    //Constructor
    public CoursePanel(){
        loadImages();
        loadIndustrys();
        loadCourses(selectedIndustryID);
        setupComponents();
        addComponents();
    }

    public static void loadImages(){
        //try to load the Images
        try {

            //Select Course Button Images
            selectBtn_Unselected = ImageIO.read(new File("images/SelectCourse_Unselected.png"));
            selectBtn_Selected = ImageIO.read(new File("images/SelectCourse_Selected.png"));

            //Help Button Images
            helpBtn_Unselected = ImageIO.read(new File("images/Help_Unselected.png"));
            helpBtn_Selected = ImageIO.read(new File("images/Help_Selected.png"));

            //Close Button Images
            closeBtn_Unselected = ImageIO.read(new File("images/Close_Unselected.png"));
            closeBtn_Selected = ImageIO.read(new File("images/Close_Selected.png"));

        } catch (Exception ex) {

            //Print the error to the console
            System.out.println(ex.getMessage());
        }
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

            industryInput.addItem(new ComboItem("Select an Industry"));

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

            courseInput.addItem(new ComboItem("Select a Course"));

            //Iterate through the results
            while (row.next()) {
                courseInput.addItem(new ComboItem(row.getString("Name"), row.getInt("ID")));
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

            model = new DefaultTableModel(new String[]{"Unit Code", "Unit Description"}, 0)
            {
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }

            };

            //Add the table heading
            model.addRow(new Object[]{" Unit Code", "  Unit Description"});

            //Iterate through the results
            while (row.next()) {

                //Get the Unit code from the database
                String code = "  " + row.getString("Code");

                //Get the Unit description from the database
                String description = " " + row.getString("Description");

                //Add the row to the table model
                model.addRow(new Object[]{code, description});
            }

            //set the Tables model
            unitTable.setModel(model);
            unitTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            unitTable.getColumnModel().getColumn(1).setPreferredWidth(750);

        } catch (Exception ex) {

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, "Error Connecting to Database!");
        }
    }


    //Setup the Components
    public static void setupComponents() {

        //Panel
        panel.setBounds(50, 65, 900, 650);
        panel.setBackground(backgroundColor);
        panel.setVisible(false);

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
                selectedIndustryID = ((ComboItem)item).getID();
                //Load the courses
                loadCourses(selectedIndustryID);
                courseTitle.setText("Select a Course");
                selectedCourseID = 0;
                loadUnits(0);
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
                    selectedCourseID = ((ComboItem)item).ID;
                    //Get the Course Title
                    selectedCourse = ((ComboItem)item).text;
                    courseTitle.setText(((ComboItem) item).text);
                    //Load the Course Units
                    loadUnits(selectedCourseID);
                }
            }
        });


        //Content
        content.setBounds(0, 150, 900, 500);
        content.setBackground(Color.WHITE);

        //Course Title
        courseTitle.setBounds(0, 0, 900, 50);
        courseTitle.setFont(h2);

        //Unit Table
        unitTable.setBounds(0, 75, 900, 300);
        unitTable.setFont(h3);
        unitTable.setRowHeight(30);
        unitTable.setGridColor(gridColor);
        unitTable.setCellSelectionEnabled(false);
        unitTable.setRowSelectionAllowed(false);

        //Select Course Button
        selectCourseBtn.setBounds(250, 400, 400, 75);
        selectCourseBtn.setOpaque(false);
        selectCourseBtn.setContentAreaFilled(false);
        selectCourseBtn.setBorderPainted(false);
        selectCourseBtn.setIcon(new ImageIcon(selectBtn_Unselected));
        selectCourseBtn.setRolloverIcon(new ImageIcon(selectBtn_Selected));
        selectCourseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectCourseBtn.addActionListener (new ActionListener() {
            //Called when an item has been selected
            public void actionPerformed(ActionEvent e) {

                if(selectedCourseID > 0){
                    //enrol
                    //Main.Alert("UserID: " + Main.userID + "\nName: " + Main.username);
                    Main.database.insertSelectedCourse(Main.userID, selectedCourseID);
                    Main.Alert("You have selected:\n'" + selectedCourse + "'");
                }
                else{
                    Main.Alert("Pleaes select a Course.");
                }
            }
        });

        //Help Button
        helpBtn.setBounds(425, 25, 50, 50);
        helpBtn.setIcon(new ImageIcon(helpBtn_Unselected));
        helpBtn.setRolloverIcon(new ImageIcon(helpBtn_Selected));
        helpBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        helpBtn.setOpaque(false);
        helpBtn.setContentAreaFilled(false);
        helpBtn.setBorderPainted(false);
        helpBtn.addActionListener (new ActionListener() {
            //Called when an item has been selected
            public void actionPerformed(ActionEvent e) {
                ShowHelp();
            }
        });

        //Help Panel
        helpPanel.setBounds(0, 0, 900, 650);
        helpPanel.setBackground(new Color(255,255,255));
        helpPanel.setVisible(false);

        //Close Button
        closeBtn.setBounds(850,0,50,50);
        closeBtn.setIcon(new ImageIcon(closeBtn_Unselected));
        closeBtn.setRolloverIcon(new ImageIcon(closeBtn_Selected));
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.setOpaque(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setBorderPainted(false);
        closeBtn.addActionListener (new ActionListener() {
            //Called when an item has been selected
            public void actionPerformed(ActionEvent e) {
                HideHelp();
            }
        });
    }

    //Add the Components
    public static void addComponents(){

        header.add(industryText);
        header.add(industryInput);
        header.add(courseText);
        header.add(courseInput);
        header.add(helpBtn);
        header.setLayout(new BorderLayout());
        content.add(courseTitle);
        content.add(unitTable);
        content.add(selectCourseBtn);
        content.setLayout(new BorderLayout());
        helpPanel.add(closeBtn);
        helpPanel.setLayout(new BorderLayout());
        panel.add(helpPanel);
        panel.add(header);
        panel.add(content);
        panel.setLayout(new BorderLayout());
    }

    //Show the Help Panel
    public static void ShowHelp(){
        header.setVisible(false);
        content.setVisible(false);
        helpPanel.setVisible(true);
    }

    //Hide the Help Panel
    public static void HideHelp(){
        helpPanel.setVisible(false);
        header.setVisible(true);
        content.setVisible(true);
    }
}
