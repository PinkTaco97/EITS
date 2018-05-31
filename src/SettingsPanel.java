import javax.swing.*;
import java.awt.*;

public class SettingsPanel {

    //Components
    public static JPanel panel = new JPanel();

    //Fonts
    public static final String fontFamily = "Apple Casual";
    public static Font h1 = new Font(fontFamily, Font.PLAIN, 50);
    public static Font h2 = new Font(fontFamily, Font.PLAIN, 30);
    public static Font h3 = new Font(fontFamily, Font.PLAIN, 20);
    public static Font h4 = new Font(fontFamily, Font.PLAIN, 15);

    //Colors
    public static final Color backgroundColor = new Color(255,255,255);
    public static final Color textColor = new Color(51,51,51);

    public SettingsPanel(){
        setupComponents();
        addComponents();
    }

    //Setup the Components
    public static void setupComponents() {

        //Panel
        panel.setBounds(50, 65, 900, 650);
        panel.setBackground(backgroundColor);
        panel.setVisible(false);

    }

    //Add the Components
    public static void addComponents(){
        panel.setLayout(new BorderLayout());
    }
}
