package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
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
    private static JMenu mySettings = new JMenu("Settings");
    private static JMenuItem myImport = new JMenuItem("Import");
    private static JMenuItem myExport = new JMenuItem("Export");
    private static JMenuItem myEditButton = new JMenuItem("Edit Settings");
    private static JMenuItem myViewButton = new JMenuItem("View");
    private static JButton myAdd = new JButton("+");

    private static JFileChooser myChoice = new JFileChooser();
    
    private JPanel leftPanel = new JPanel(new BorderLayout());
    private JPanel rightPanel = new JPanel(new GridLayout(1,2));
    private JPanel topPanel = new JPanel(new BorderLayout());

    private JPanel projectPanel = new JPanel();
    private JScrollPane myScroll = new JScrollPane(projectPanel);
    
    private projectController myController = new projectController();
    
    private JPanel listView = new JPanel(new GridLayout(1,1,10,10));
    private Project choosenProject = null;
    private JButton addDoc = new JButton("Add Document");

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
        myAdd.setBounds( 100, 100, 100, 100);
        //Creates the panels for layout design

        this.add(topPanel, BorderLayout.CENTER);

       // final JTextArea test = new JTextArea("Test           west");
        final JTextArea test2 = new JTextArea("Test Center");
        final JTextArea test3 = new JTextArea("Test Center");

        projectPanel.setLayout(new GridLayout(0,1));
        leftPanel.setBackground(Color.BLUE);
        myScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        leftPanel.add(myScroll, BorderLayout.CENTER);
        leftPanel.add(myAdd, BorderLayout.SOUTH);

        //leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        
        
        //listView.setLayout(new BoxLayout(listView, BoxLayout.PAGE_AXIS));
        //JButton b1 = new JButton("B1");
        //b1.setMaximumSize(new Dimension(Integer.MAX_VALUE, b1.getMinimumSize().height));
        //listView.add(b1);
        //listView.add(new JButton("B2"));
        
        rightPanel.setBackground(Color.RED);
        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel);
        
        // Creates the menu and menu items
        this.add(myMenuBar, BorderLayout.NORTH);
        myMenuBar.add(myInfoMenu);
        myMenuBar.add(mySettings);
        myInfoMenu.add(myAboutMenuItem);
        mySettings.add(myImport);
        mySettings.add(myExport);
        mySettings.add(myEditButton);
        mySettings.add(myViewButton);
        
        myAboutMenuItem.addActionListener(this);
        myEditButton.addActionListener(this);
        myImport.addActionListener(this);
        myExport.addActionListener(this);
        myViewButton.addActionListener(this);
        myAdd.addActionListener(this);
        
        addDoc.addActionListener(this);
    }
    
    /**
     * Ensures that the given file is a .txt file.
     * @param theString the name of the file.
     * @return whether the file is a .txt file.
     */
    /*private boolean validateFile(final String theString) {

        return false;
    }*/
    
    public void actionPerformed(final ActionEvent theEvent) {
    	//final Object source = theEvent.getSource();
    	textReader text;
    	System.out.println("control: " + myController.toString());
    	System.out.println(theEvent.getActionCommand());
    	
    	if(theEvent.getSource() == myAdd) {
    		projectPanel.removeAll();
    		
    		JTextField field1 = new JTextField();
    		Object[] fields = {"Enter a project Name:", field1};
    		int returnVal = JOptionPane.showConfirmDialog(this, fields, "Project Name", JOptionPane.OK_CANCEL_OPTION);
    		if(returnVal == JOptionPane.OK_OPTION) {
    			myController.add(field1.getText());
    			for(JButton j: myController.getProjects()) {
    				j.setPreferredSize(new Dimension(100,50));
    				projectPanel.add(j);
    				j.addActionListener(this);
    			}
    			this.validate();
    		}
    	} else if(theEvent.getSource() == myAboutMenuItem) {
    		try {
    			text = new textReader("./src/files/version.txt");
    			JOptionPane.showMessageDialog(this, text.getText(), "About Tidy", JOptionPane.INFORMATION_MESSAGE);
    		} catch (FileNotFoundException e) {
    			System.out.println("File not found");
    		}
    	} else if(theEvent.getSource() == myImport) {
    		int returnVal = myChoice.showOpenDialog(this);
    		String fileContent ="";
    		if(returnVal == JFileChooser.APPROVE_OPTION) {
    			try {
					text = new textReader(myChoice.getSelectedFile().toString());
					fileContent = text.getText();
				} catch (FileNotFoundException e1) {
					
				}	
    	     
    			BufferedWriter writer;
    			try {
    				writer = new BufferedWriter(new FileWriter("./src/files/settings.txt"));
    				writer.write(fileContent);
    				writer.close();
    			} catch (IOException e) {
    				System.out.println("No file found");
    			}
    		}
    	} else if(theEvent.getSource() == myExport) {
    		try {
				text = new textReader("./src/files/settings.txt");
				File exportFile = new File("./src/files/export.txt");
				exportFile.createNewFile();
				FileWriter writer = new FileWriter(exportFile);
				writer.write(text.getText());
				writer.close();
			} catch (IOException e) {
			}
    	} else if(theEvent.getSource() == myEditButton) {    		
    		JTextField field1 = new JTextField();
    		JTextField field2 = new JTextField();
    		
    		Object[] fields = {
    				"Enter Your First Name:", field1,
    				"Enter Your Email Address", field2
    		};
    		JOptionPane.showConfirmDialog(null, fields, "Customize My Settings", JOptionPane.OK_CANCEL_OPTION);
    		try {
				File exportFile = new File("./src/files/settings.txt");
				exportFile.createNewFile();
				FileWriter writer = new FileWriter(exportFile);
				writer.write(field1.getText() + "\n");
				writer.write(field2.getText());
				writer.close();
			} catch (IOException e) {
			}
    	} else if(theEvent.getSource() == myViewButton) {
    		try {
				text = new textReader("./src/files/settings.txt");
				JOptionPane.showMessageDialog(this, text.getText(), "Settings", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	} else if (myController.contains(theEvent.getActionCommand())) {
	    	rightPanel.removeAll();
    		for (JButton b: myController.getProjects()) {	
	    		if (theEvent.getActionCommand().equals(b.getText())) {
	    			System.out.println("works");
	    			choosenProject = myController.getChoosenProject(b.getText());		
	    		}
	    	}
    		if(choosenProject != null) {
            	System.out.println("go");
    	        listView = new JPanel(new GridLayout(choosenProject.getSize(),1,10,10));
    	        
    	        for (Item i: choosenProject.getItemsList()) {
    		        JButton b = new JButton(i.getName());
    		        listView.add(b);
    	        }
    	      
    	        JPanel bottomMenu = new JPanel();
    	        bottomMenu.add(addDoc);addDoc.addActionListener(this);
    	        listView.add(bottomMenu, BorderLayout.PAGE_END);
    	        
    	        JPanel docView = new JPanel();
    	        docView.setBackground(Color.RED);
    	        rightPanel.add(listView);
    	        rightPanel.add(docView);
            }
	    	this.validate();
    	} else if (theEvent.getSource() == addDoc) {
    		//adjsut size
	        //listView = new JPanel(new GridLayout(myController.getItemSize(choosenProject),1,10,10));
    		listView.add(new JButton("(document here)"));
    		
    		JPanel bottomMenu = new JPanel();
	        bottomMenu.add(addDoc);addDoc.addActionListener(this);
	        listView.add(bottomMenu, BorderLayout.PAGE_END);
	        
	        this.validate();
    	}
    }
    
}
