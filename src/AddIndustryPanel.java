import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class AddIndustryPanel extends JPanel {

    //Components
    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Add Industry", JLabel.CENTER);
    public static JLabel industryText = new JLabel("Industry Name:");
    public static JTextField industryInput = new JTextField();
    public static JButton addIndustryBtn = new JButton();

    //Images
    public static BufferedImage addIndustryBtn_Unselected;
    public static BufferedImage addIndustryBtn_Selected;

    //Colours
    public static Color bgColor = new Color(255, 255, 255);

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Constructor
    public AddIndustryPanel(){

        //Load the Images
        loadImages();

        //Setup the Components
        setupComponents();

        //Add the Components to the Panel
        addComponents();
    }

    //Load the Images
    public static void loadImages(){

        //try to load the Images
        try {

            //Add Industry Btn Images
            addIndustryBtn_Unselected = ImageIO.read(new File("images/AddIndustryBtn_Unselected.png"));
            addIndustryBtn_Selected = ImageIO.read(new File("images/AddIndustryBtn_Selected.png"));

        } catch (Exception ex) {

            //Print the Exception to the console
            System.out.println(ex.getMessage());
        }
    }

    //Setup the components
    public static void setupComponents(){

        //Panel
        panel.setBounds(250,225,500,350);
        panel.setBackground(bgColor);
        panel.setVisible(false);

        //Title
        title.setBounds(0, 25,500, 50);
        title.setFont(h1);

        //IndustryText
        industryText.setBounds(50, 100, 400, 50);
        industryText.setFont(h2);

        //IndustryInput
        industryInput.setBounds(50, 150, 400, 50);
        industryInput.setFont(h2);
        industryInput.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get the Industry Name
                String industry = industryInput.getText();

                if(!industry.isEmpty()){
                    if(Main.database.insertIndustry(industry)){
                        industryInput.setText("");
                    }
                    else{

                        //Alert the User
                        Main.Alert("Industry not Inserted");
                    }
                }
                else{

                    //Alert the User
                    Main.Alert("Please Input an Industry name.");
                }
            }

        });

        //Add Industry Btn
        addIndustryBtn.setBounds(50, 250, 400, 75);
        addIndustryBtn.setIcon(new ImageIcon(addIndustryBtn_Unselected));
        addIndustryBtn.setRolloverIcon(new ImageIcon(addIndustryBtn_Selected));
        addIndustryBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addIndustryBtn.addActionListener(new ActionListener() {

            //When the JButton is clicked
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get the Industry Name
                String industry = industryInput.getText();

                if(!industry.isEmpty()){
                    if(Main.database.insertIndustry(industry)){
                        industryInput.setText("");
                    }
                    else{
                        //Alert the user
                        Main.Alert("Industry not Inserted");
                    }
                }
                else{
                    //Alert the user
                    Main.Alert("Please Input an Industry name.");
                }
            }

        });

    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(title);
        panel.add(industryText);
        panel.add(industryInput);
        panel.add(addIndustryBtn);
        panel.setLayout(new BorderLayout());
    }

}
