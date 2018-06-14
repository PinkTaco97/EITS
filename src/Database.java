import javax.swing.*;
import java.net.InetAddress;
import java.sql.*;
import java.util.Date;

public class Database {

    //Reference to the Driver
    static final String DRIVER = "com.mysql.jdbc.Driver";

    //Reference to the server
    static final String SERVER = "jdbc:mysql://localhost:8889/EITS";

    //Database Username
    static final String USERNAME = "root";

    //Database Password
    static final String PASSWORD = "root";

    /*
    * Check the database to see whether the Username is taken.
    * Returns TRUE if the Username is taken.
    * Returns FALSE if the Username is free.
    */
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

        }//If we get an Exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

            //Alert the Error to the user
            Main.Alert("Error Connecting to Database!");

        }
        return null;
    }

    /*
    * Insert a User into the database.
    * Returns TRUE if the User was inserted.
    * Returns FALSE if the User wasn't inserted.
    */
    public Boolean insertUser(String username, String password, String email, int access){
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
            Main.Alert("Registration Successful!\n" + "Please Login.");

            //Reset the Username InputField
            Main.registerPanel.usernameInput.setText("");

            //Reset the Password InputField
            Main.registerPanel.passwordInput.setText("");

            //Reset the Eamil InputField
            Main.registerPanel.emailInput.setText("");

            //The User was added to the database
            return true;

        }//If we get an Exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

            //Alert the Error to the user
            Main.Alert("Error Connecting to Database!");

            //The User was not added to the database
            return false;

        }
    }

    /*
    * Insert an Industry into the database.
    * Returns TRUE if the Industry was inserted.
    * Returns FALSE if the Industry wasn't inserted.
    */
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
            Main.Alert("Inserted Industry: \n'" + name + "'\n Into the Database.");

            //The Industry was added to the database
            return true;

        }//If we get an Exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

            //Alert the Error to the user
            Main.Alert("Error Connecting to Database!");

            //The Industry was not added to the database
            return false;
        }
    }

    /*
    * Insert a Course into the database.
    * Returns TRUE if the Course was inserted.
    * Returns FALSE if the Course wasn't inserted.
    */
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
            Main.Alert("Inserted Course:\n '" + name + "'\n Into the Database");

            //The Course was added to the database
            return true;

        }//If we get an Exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

            //Alert the Error to the user
            Main.Alert("Error Connecting to Database!");

            //The course was not added to the database
            return false;
        }
    }

    /*
    * Insert a Unit into the database.
    * Returns TRUE if the Unit was inserted.
    * Returns FALSE if the Unit wasn't inserted.
    */
    public Boolean insertUnit(String code, String description, int courseID){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL query
            String insert = "INSERT INTO Units (Code, Description, CourseID) VALUES ('" + code + "', '" + description + "', '" + courseID + "');";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(insert);

            // execute the preparedstatement
            preparedStmt.execute();

            //Alert the user that the registration was successful
            Main.Alert("Inserted Unit:\n '" + code + " - " + description + "'\n Into the Database");

            //The Unit was added to the database
            return true;

        }//If we get an Exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

            //Alert the Error to the user
            Main.Alert("Error Connecting to Database!");

            //The Unit was not added to the database
            return false;

        }
    }

    //Insert the selected Course.
    public static void insertSelectedCourse(int userID, int courseID){
        //Try to connect to the database
        try{
            //Create Database Connection
            Class.forName(DRIVER);
            Connection con =DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL query
            String sql = "UPDATE Users SET CourseID = " + courseID + " WHERE ID = '" + userID + "';";

            //Create the preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(sql);

            //Execute the preparedstatement
            preparedStmt.execute();

            //Alert the user that the Course was selected
            Main.Alert("Selected Successfully!");

        }//If we get an Exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

            //Alert the Error to the user
            Main.Alert("Error Connecting to Database!");

        }
    }

    /*
    * Get the Course Name.
    * Returns the CourseName.
    */
    public static String getCourseName(int courseID){
        //Try to connect to the database
        try {

            //Create Database Connection
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL query
            String sql = "SELECT * FROM Courses WHERE ID = '" + courseID + "';";

            //Create the java statement
            Statement statement = con.createStatement();

            //Execute the statement
            ResultSet row = statement.executeQuery(sql);

            //Iterate through the results
            while (row.next()){

                //Get the Course Name
                String name = row.getString("Name");

                //if the name isnt empty
                if(!name.isEmpty()){
                    //Return the Course Name
                    return name;
                }
                else{
                    return "No Course Selected";
                }
            }

        } catch(Exception ex){

            //We got an Exception
            System.err.println(ex.getMessage());

            //Alert Error
            Main.Alert("Error Connecting to Database!");

            return "";
        }

        return "No Course Selected";
    }

    /*
    * Compares the username and password to the database username and password.
    * Returns userID if they matched.
    * Returns 0 if no match in database.
    */
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

                        //Set the UserID
                        int userID = row.getInt("ID");
                        Main.userID = userID;

                        //Get the current Date and Time
                        Date now = new Date();

                        //Get the current IP Address
                        InetAddress IP=InetAddress.getLocalHost();
                        String ipAddress = IP.getHostAddress();

                        //Set the user to active
                        String sql1 = "UPDATE Users SET Active = '1', LastLoggedIn = '" + now + "', IPAddress = '" + ipAddress + "' WHERE ID='" + userID + "';";

                        //Create the preparedstatement
                        PreparedStatement preparedStmt = con.prepareStatement(sql1);

                        //Execute the preparedstatement
                        preparedStmt.execute();

                        //Return the Users ID.
                        return userID;
                    }
                }
            }
        }//If we get an Exception
        catch (Exception ex) {
            //Print the Exception to the console
            System.err.println(ex.getMessage());

            //Alert Error
            Main.Alert("Error Connecting to Database!");
        }

        //Wrong Username or Password
        return 0;
    }

    /*
    * Load The users Username Password and Email from the database
    * Return the Username, Password and Email
    */
    public static String[] LoadUser(int userID){
        //Try to connect to the database
        try{

            //Create a Connection to the database
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL Code
            String sql = "SELECT * from Users WHERE ID='" + userID + "';";

            //Create the java statement
            Statement statement = con.createStatement();

            //Execute the query and get the result
            ResultSet row = statement.executeQuery(sql);

            //Iterate through the results
            while (row.next()){

                //Get the Username
                String username = row.getString("Username");
                //Get the Password
                String password = row.getString("Password");
                //Get the Email
                String email = row.getString("Email");

                //Return the users data
                return new String[]{username, password, email};
            }


        } //If we get an exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

        }

        //Return an empty string
        return new String[]{"", "", ""};
    }

    /*
    * Updates the User in the database
    */
    public static void updateUser(int userID, String username, String password, String email){
        //Try to connect to the database
        try{

            //Create a Connection to the database
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL Code
            String sql = "UPDATE Users SET Username = '" + username + "', Password = '" + password + "', Email = '" + email + "' WHERE ID='" + userID + "';";

            //Create the preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(sql);

            //Execute the preparedstatement
            preparedStmt.execute();

        } //If we get an exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

        }
    }

    //Log the user out
    public static void Logout(int userID){
        //Try to connect to the database
        try{

            //Create a Connection to the database
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);

            //Our SQL Code
            String sql = "UPDATE Users SET Active = '0' WHERE ID='" + userID + "';";

            //Create the preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(sql);

            //Execute the preparedstatement
            preparedStmt.execute();

        } //If we get an exception
        catch(Exception ex){

            //Print the Exception to the console
            System.err.println(ex.getMessage());

        }
    }
}
