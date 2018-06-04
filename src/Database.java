import javax.swing.*;
import java.sql.*;

public class Database {

    //Reference to the Driver
    static final String DRIVER = "com.mysql.jdbc.Driver";

    //Reference to the server
    static final String SERVER = "jdbc:mysql://localhost:8889/EITS";

    //Database Username
    static final String USERNAME = "root";

    //Database Password
    static final String PASSWORD = "root";

    public Database(){

    }

    //Check the database to see whether the Username is taken
    public Boolean isUsernameTaken(String username) {

        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL query
            String sql = "SELECT Username FROM Users";

            //Create the java statement
            Statement statement = con.createStatement();

            //Execute the query and get the result
            ResultSet row = statement.executeQuery(sql);

            //Iterate through the results
            while(row.next()){
                //Check each username in the UsersTable
                if(row.getString("Username").equalsIgnoreCase(username)){
                    //The Username was taken
                    return true;
                }
            }

            //The Username isnt taken
            return false;

        } catch(Exception ex){

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");

        }
        return null;
    }

    //Insert a User into the database
    public void insertUser(String username, String password, String email, int access){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL query
            String insert = "INSERT INTO Users (Username, Password, Email, Access) VALUES ('" + username + "', '" + password + "', '" + email + "', '" + access + "');";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(insert);

            // execute the preparedstatement
            preparedStmt.execute();

            //Alert the user that the registration was successful
            JOptionPane.showMessageDialog(Main.frame,"Registration Successful!\n" + "Please Login.");

            //Reset the Username InputField
            Main.registerPanel.usernameInput.setText("");

            //Reset the Password InputField
            Main.registerPanel.passwordInput.setText("");

            //Reset the Eamil InputField
            Main.registerPanel.emailInput.setText("");

        } catch(Exception ex){

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");
        }
    }

    //Insert an Industry into the database
    public Boolean insertIndustry(String name){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL query
            String insert = "INSERT INTO Industry (Name) VALUES ('" + name + "');";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(insert);

            // execute the preparedstatement
            preparedStmt.execute();

            //Alert the user that the registration was successful
            JOptionPane.showMessageDialog(Main.frame,"Inserted Successful!");

            return true;

        } catch(Exception ex){

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");

            return false;
        }
    }

    //Insert a Course into the database
    public Boolean insertCourse(String name, int industryID){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL query
            String insert = "INSERT INTO Courses (Name, IndustryID) VALUES ('" + name + "', '" + industryID + "');";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(insert);

            // execute the preparedstatement
            preparedStmt.execute();

            //Alert the user that the registration was successful
            JOptionPane.showMessageDialog(Main.frame,"Inserted Successful!");

            return true;

        } catch(Exception ex){

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");

            return false;
        }
    }

    public int Login(String username, String password) {
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            String sql = "SELECT ID, Username, Password FROM Users";

            //Create the java statement
            Statement statement = con.createStatement();

            //Execute the query and get the result
            ResultSet row = statement.executeQuery(sql);

            //Iterate through the results
            while (row.next()) {
                //Check each username in the UsersTable
                if (row.getString("Username").equalsIgnoreCase(username)) {
                    //Check the Password coresponding password
                    if (row.getString("Password").equalsIgnoreCase(password)) {
                        Main.userID = row.getInt("ID");
                        return row.getInt("ID");
                    }
                }
            }
        } catch (Exception ex) {
            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            JOptionPane.showMessageDialog(Main.frame, " Error Connecting to Database!");
        }

        //Wrong Username or Password
        return 0;
    }
}
