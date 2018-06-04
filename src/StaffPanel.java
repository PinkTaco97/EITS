import javax.swing.*;
import java.awt.*;

public class StaffPanel extends JPanel {

    public static JPanel panel = new JPanel();
    public static JLabel title = new JLabel("Staff Panel", JLabel.CENTER);

    //colour
    public static Color bgColour = new Color(255, 255, 255);

    //fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 40);

    public StaffPanel() {

        setupComponents();
        addComponents();

    }

    //Setup the components
    public static void setupComponents(){

        //panel
        panel.setBounds(50, 75, 900, 450);
        panel.setBackground(bgColour);
        panel.setVisible(false);

        //title
        title.setBounds(0, 25, 900, 50);
        title.setFont(h1);

    }

    //Add the components to the panel
    public static void addComponents(){
        panel.add(title);
        panel.setLayout(new BorderLayout());
    }
}
