/*
    Author: Rani Siddavaram
    Student Number: 1100474418
    Known Bugs: None
    Date: 5/6/2018
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class HelpPanel extends JPanel {

    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Staff Panel", JLabel.CENTER);
    public static JButton closeBtn = new JButton();
    public static JLabel help = new JLabel();

    //colour
    public static Color backgroundColour = new Color(255, 255, 255);
    public static Color textColour = new Color(51, 51, 51);

    //fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 35);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Images
    public static BufferedImage closeBtn_Unselected;
    public static BufferedImage closeBtn_Selected;
    public static BufferedImage helpImg;

    public HelpPanel() {
        loadImages();
        setupComponents();
        addComponents();
    }

    public static void loadImages(){
        //try to load the Images
        try {

            //Close Button Images
            closeBtn_Unselected = ImageIO.read(new File("images/Close_Unselected.png"));
            closeBtn_Selected = ImageIO.read(new File("images/Close_Selected.png"));

            //Help Image
            helpImg = ImageIO.read(new File("images/Help.png"));

        } catch (Exception ex) {

            //Print the error to the console
            System.out.println(ex.getMessage());
        }
    }

    //Setup the components
    public static void setupComponents(){

        //panel
        panel.setBounds(0, 0, 900, 650);
        panel.setBackground(backgroundColour);
        panel.setVisible(false);

        //title
        title.setBounds(0, 25, 900, 50);
        title.setFont(h1);

        //Close Button
        closeBtn.setBounds(825,25,50,50);
        closeBtn.setIcon(new ImageIcon(closeBtn_Unselected));
        closeBtn.setRolloverIcon(new ImageIcon(closeBtn_Selected));
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.setOpaque(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setBorderPainted(false);
        closeBtn.addActionListener (new ActionListener() {
            //Called when an item has been selected
            public void actionPerformed(ActionEvent e) {
                CoursePanel.HideHelp();
            }
        });

        //Help
        help.setBounds(50,50, 800, 600);
        help.setIcon(new ImageIcon(helpImg));

    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(title);
        panel.add(closeBtn);
        panel.add(help);
        panel.setLayout(new BorderLayout());
    }
}
