import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class draganddrop extends JFrame{
    //create the labels
    JLabel pic1, pic2, pic3;
    JLabel pic4, pic5, pic6;
    JLabel pic7, pic8, pic9;
    JLabel greyscale, colour;
    JLabel title;

    //create the button
    JButton button;
    public draganddrop(){
       //sets title
       super("Tic Tac Toe");

       //sets background colour of JFrame
       getContentPane().setBackground(Color.red);

       //setup components
       title = new JLabel("Tic Tac Toe");
       pic1 = new JLabel();
       pic2 = new JLabel();
       pic3 = new JLabel();
       pic4 = new JLabel();
       pic5 = new JLabel();
       pic6 = new JLabel();
       pic7 = new JLabel();
       pic8 = new JLabel();
       pic9 = new JLabel();
       greyscale = new JLabel();
       colour = new JLabel();
       button = new JButton("RESET");

       //sets the colour of the title
       title.setForeground(Color.WHITE);

       //sets the background of the grid
       pic1.setBackground(Color.WHITE);
       pic1.setOpaque(true);
       pic2.setBackground(Color.WHITE);
       pic2.setOpaque(true);
       pic3.setBackground(Color.WHITE);
       pic3.setOpaque(true);
       pic4.setBackground(Color.WHITE);
       pic4.setOpaque(true);
       pic5.setBackground(Color.WHITE);
       pic5.setOpaque(true);
       pic6.setBackground(Color.WHITE);
       pic6.setOpaque(true);
       pic7.setBackground(Color.WHITE);
       pic7.setOpaque(true);
       pic8.setBackground(Color.WHITE);
       pic8.setOpaque(true);
       pic9.setBackground(Color.WHITE);
       pic9.setOpaque(true);

       //sets the grid lines
       pic1.setBorder(BorderFactory.createLineBorder(Color.black));
       pic2.setBorder(BorderFactory.createLineBorder(Color.black));
       pic3.setBorder(BorderFactory.createLineBorder(Color.black));
       pic4.setBorder(BorderFactory.createLineBorder(Color.black));
       pic5.setBorder(BorderFactory.createLineBorder(Color.black));
       pic6.setBorder(BorderFactory.createLineBorder(Color.black));
       pic7.setBorder(BorderFactory.createLineBorder(Color.black));
       pic8.setBorder(BorderFactory.createLineBorder(Color.black));
       pic9.setBorder(BorderFactory.createLineBorder(Color.black));

       //sets the font for the title and button
       title.setFont(new Font("monospaced", Font.BOLD, 30));
       button.setFont(new Font("Arial", Font.PLAIN, 16));

       //sets the bounds of the labels and button
       title.setBounds(100, 10, 205, 25);
       pic1.setBounds(50, 50, 100, 100);
       pic2.setBounds(150, 50, 100, 100);
       pic3.setBounds(250,50, 100, 100);
       pic4.setBounds(50, 150, 100, 100);
       pic5.setBounds(150, 150, 100, 100);
       pic6.setBounds(250,150, 100, 100);
       pic7.setBounds(50, 250, 100, 100);
       pic8.setBounds(150, 250, 100, 100);
       pic9.setBounds(250,250, 100, 100);
       button.setBounds(152, 400, 96, 30);
       greyscale.setBounds(50, 355, 100, 100);
       colour.setBounds(250, 355, 100, 100);

       //sets the icons (disabled or image)
       pic1.setDisabledIcon(new ImageIcon());
       pic2.setDisabledIcon(new ImageIcon());
       pic3.setDisabledIcon(new ImageIcon());
       pic4.setDisabledIcon(new ImageIcon());
       pic5.setDisabledIcon(new ImageIcon());
       pic6.setDisabledIcon(new ImageIcon());
       pic7.setDisabledIcon(new ImageIcon());
       pic8.setDisabledIcon(new ImageIcon());
       pic9.setDisabledIcon(new ImageIcon());
       greyscale.setIcon(new ImageIcon("images/greyscalejava.png"));
       colour.setIcon(new ImageIcon("images/colourjava.png"));

       //sets mouselistener
       MouseListener ml = new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }

           @Override
           public void mousePressed(MouseEvent e) {
                //initialized the event
                JComponent jc = (JComponent)e.getSource();

                //gets the transferhandler()
                TransferHandler th = jc.getTransferHandler();

                //initiates the drag and drop
                th.exportAsDrag(jc, e, TransferHandler.COPY);
           }

           @Override
           public void mouseReleased(MouseEvent e) {

           }

           @Override
           public void mouseEntered(MouseEvent e) {

           }

           @Override
           public void mouseExited(MouseEvent e) {

           }
       };

       //adds mouselistener functionality to the labels
       pic1.addMouseListener(ml);
       pic2.addMouseListener(ml);
       pic3.addMouseListener(ml);
       pic4.addMouseListener(ml);
       pic5.addMouseListener(ml);
       pic6.addMouseListener(ml);
       pic7.addMouseListener(ml);
       pic8.addMouseListener(ml);
       pic9.addMouseListener(ml);
       greyscale.addMouseListener(ml);
       colour.addMouseListener(ml);

       //sets transferhandler to the labels
       pic1.setTransferHandler(new TransferHandler("icon"));
       pic2.setTransferHandler(new TransferHandler("icon"));
       pic3.setTransferHandler(new TransferHandler("icon"));
       pic4.setTransferHandler(new TransferHandler("icon"));
       pic5.setTransferHandler(new TransferHandler("icon"));
       pic6.setTransferHandler(new TransferHandler("icon"));
       pic7.setTransferHandler(new TransferHandler("icon"));
       pic8.setTransferHandler(new TransferHandler("icon"));
       pic9.setTransferHandler(new TransferHandler("icon"));
       greyscale.setTransferHandler(new TransferHandler("icon"));
       colour.setTransferHandler(new TransferHandler("icon"));

       //add components to the JFrame
       add(title);
       add(pic1);
       add(pic2);
       add(pic3);
       add(pic4);
       add(pic5);
       add(pic6);
       add(pic7);
       add(pic8);
       add(pic9);
       add(greyscale);
       add(colour);
       add(button);

       //sets action listener to the button
       button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //closes JFrame
                dispose();
                //opens application
                draganddrop.main(null);
            }
       });

       //setup the JFrame
       setLayout(null);
       setSize(415, 500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       setLocationRelativeTo(null);

    }//end of draganddrop();

    public static void main(String[] args){
       //adds draganddrop() class to the JFrame
       new draganddrop();
    }
}
