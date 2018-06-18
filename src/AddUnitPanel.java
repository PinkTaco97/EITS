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

public class AddUnitPanel extends JPanel {

    //GUI Components
    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Add Unit", JLabel.CENTER);
    public static JLabel courseText = new JLabel("Select Course:");
    public static JComboBox courseInput = new JComboBox();
    public static JLabel unitCodeText = new JLabel("Unit Code:");
    public static JTextField unitCodeInput = new JTextField();
    public static JLabel unitDescriptionText = new JLabel("Unit Description:");
    public static JTextField unitDescriptionInput = new JTextField();
    public static JButton addUnitBtn = new JButton();

    //Images
    public static BufferedImage addUnitBtn_Unselected;
    public static BufferedImage addUnitBtn_Selected;

    //Colours
    public static Color bgColor = new Color(255, 255, 255);

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Course
    public static int selectedCourseID = 0;

    public AddUnitPanel(){
        loadImages();
        loadCourses();
        setupComponents();
        addComponents();
    }

    //Load the Industrys from the database
    public static void loadCourses(){

        //Clear industry input
        courseInput.removeAllItems();

        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(Main.database.DRIVER);
            Connection con = DriverManager.getConnection(Main.database.SERVER, Main.database.USERNAME, Main.database.PASSWORD);

            String sql = "SELECT * FROM Courses";

            //Create the java statement
            Statement statement = con.createStatement();

            //Execute the query and get the result
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
    }

    //Load the Images
    public static void loadImages(){
        //try to load the Images
        try {

            //Add Industry Btn Images
            addUnitBtn_Unselected = ImageIO.read(new File("images/AddUnitBtn_Unselected.png"));
            addUnitBtn_Selected = ImageIO.read(new File("images/AddUnitBtn_Selected.png"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Setup the components
    public static void setupComponents(){

        //Panel
        panel.setBounds(250,125,500,550);
        panel.setBackground(bgColor);
        panel.setVisible(false);

        //Title
        title.setBounds(0, 25,500, 50);
        title.setFont(h1);

        //Course Text
        courseText.setBounds(50, 100, 400, 50);
        courseText.setFont(h2);

        //Course Input
        courseInput.setBounds(50, 140, 400, 50);
        courseInput.setFont(h4);
        courseInput.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //If there are Courses in the list
                if(courseInput.getItemCount() > 0) {
                    //Get the selected item
                    Object item = courseInput.getSelectedItem();
                    //Get the Course ID
                    selectedCourseID = ((ComboItem)item).getID();
                }
            }

        });

        //Unit Code Text
        unitCodeText.setBounds(50, 200, 400, 50);
        unitCodeText.setFont(h2);

        //Unit Code Input
        unitCodeInput.setBounds(50, 250, 400, 50);
        unitCodeInput.setFont(h2);

        //Unit Description Text
        unitDescriptionText.setBounds(50, 300, 400, 50);
        unitDescriptionText.setFont(h2);

        //Unit Description Input
        unitDescriptionInput.setBounds(50, 350, 400, 50);
        unitDescriptionInput.setFont(h2);

        //Add Unit Btn
        addUnitBtn.setBounds(50, 450, 400, 75);
        addUnitBtn.setIcon(new ImageIcon(addUnitBtn_Unselected));
        addUnitBtn.setRolloverIcon(new ImageIcon(addUnitBtn_Selected));
        addUnitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addUnitBtn.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get what the user entered
                String code = unitCodeInput.getText();
                String description = unitDescriptionInput.getText();

                //If the user has selected a course
                if(selectedCourseID > 0){

                    //If the user has entered a Unit Code
                    if(!code.isEmpty()){

                        //If the user has entered a Unit Description
                        if(!description.isEmpty()){

                            //Insert the Unit
                            Main.database.insertUnit(code, description, selectedCourseID);

                            //Clear the Inputs
                            unitCodeInput.setText("");
                            unitDescriptionInput.setText("");
                        }
                        else{
                            Main.Alert("Please input a Unit Description");
                        }
                    }
                    else{
                        Main.Alert("Please input a Unit Code.");
                    }
                }
                else{
                    Main.Alert("Please Select a Course");
                }

            }
        });
    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(title);
        panel.add(courseText);
        panel.add(courseInput);
        panel.add(unitCodeText);
        panel.add(unitCodeInput);
        panel.add(unitDescriptionText);
        panel.add(unitDescriptionInput);
        panel.add(addUnitBtn);
        panel.setLayout(new BorderLayout());
    }
}
