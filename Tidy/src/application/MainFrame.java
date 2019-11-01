package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Creates the GUI for a basic word counter.
 * @author Nick
 * @version Feb 2019
 */
public class MainFrame extends JFrame implements ActionListener {
    /**
     * Auto generated SID.
     */
    private static final long serialVersionUID = -7133489110046511553L;
    
    private static JMenuBar myMenuBar = new JMenuBar();
    private static JMenu myInfoMenu = new JMenu("Info");
    private static JMenuItem myAboutMenuItem = new JMenuItem("About");


    /**
     * Sets up the frame with a title and basic exit operations.
     */
    public MainFrame() {
        super("Tidy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * Adds all of the GUI elements and adds all the action listeners.
     */
    public void start() {
        final int width = 800;
        final int height = 500;
        this.setSize(new Dimension(width, height));
        this.setResizable(false);

        //Creates the panels for layout design
        final JPanel topPanel = new JPanel(new BorderLayout());
        this.add(topPanel, BorderLayout.CENTER);
        final JPanel leftPanel = new JPanel();
        final JPanel rightPanel = new JPanel();
        final JTextArea test = new JTextArea("Test           west");
        final JTextArea test2 = new JTextArea("Test Center");
        leftPanel.setBackground(Color.BLUE);
        leftPanel.add(test);
        rightPanel.setBackground(Color.RED);
        rightPanel.add(test2);
        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel);
        
        // Creates the menu and menu items
        this.add(myMenuBar, BorderLayout.NORTH);
        myMenuBar.add(myInfoMenu);
        myInfoMenu.add(myAboutMenuItem);
        myAboutMenuItem.addActionListener(this);
       

    }
    
    /**
     * Ensures that the given file is a .txt file.
     * @param theString the name of the file.
     * @return whether the file is a .txt file.
     */
    private boolean validateFile(final String theString) {

        return false;
    }
    

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
    	final Object source = theEvent.getSource();
    	JOptionPane.showMessageDialog(this, "Team D.N.A.\n Amelia\nDuy\nNick\nVersion 0.0", "About Tidy", JOptionPane.INFORMATION_MESSAGE);
 
    }
    
}
