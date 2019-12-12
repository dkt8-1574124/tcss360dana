package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Creates the GUI for a basic word counter.
 * @author Nick and Duy
 * @version Autumn 2019
 */
public class MainFrame extends JFrame implements ActionListener {
    /** Auto generated SID. */
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
    private static JButton myRemove = new JButton("-");

    
    private static JFileChooser myChoice = new JFileChooser();
    
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel(new GridLayout(1,2));
    private JPanel topPanel = new JPanel(new BorderLayout());

    private JPanel projectPanel = new JPanel();
    private JScrollPane myScroll = new JScrollPane(projectPanel);
    
    private projectController myController = new projectController();
    //private ArrayList<JButton> myProjectButtons = new ArrayList<JButton>();
    

    private JPanel myScrollPanel = new JPanel();
    private JPanel listView = new JPanel();
    private JPanel itemBorderPanel = new JPanel();
    private JScrollPane myItemScroll = new JScrollPane(myScrollPanel);
    private Project choosenProject = null;
    private Item choosenItem = null;

    
    private JButton addDoc = new JButton("Add");
    private JButton removeDoc = new JButton("Remove");
    private JButton editDocument = new JButton("Edit");
    private JButton openDocument = new JButton("Open");

    /**
     * Sets up the frame with a title and basic exit operations.
     */
    public MainFrame() {
        super("Tidy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,500));; 
        this.setResizable(false);
        setVisible(true);
    }
    /**
     * Adds all of the GUI elements and adds all the action listeners.
     */
    public void start() {


        this.add(topPanel, BorderLayout.CENTER);

        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.PAGE_AXIS));
        projectPanel.setPreferredSize(new Dimension(200,2000));
        myScroll.setPreferredSize(new Dimension(200,380));
        JPanel borderPanel = new JPanel();
        JPanel borderPanelSouth = new JPanel();
        
        projectPanel.setLayout(new GridLayout(50,1));
        
        
        listView.add(itemBorderPanel);
        itemBorderPanel.add(myScrollPanel);
        myScrollPanel.setLayout(new GridLayout(0,2));
        myScrollPanel.setPreferredSize(new Dimension(400,2000));
        myItemScroll.setPreferredSize(new Dimension(500, 300));
        
        myScroll.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        myScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myItemScroll.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        myItemScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        myItemScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        leftPanel.add(borderPanel);
        borderPanel.add(myScroll);
        borderPanelSouth.add(myAdd);
        borderPanelSouth.add(myRemove);
        myRemove.setEnabled(false);
        

        leftPanel.add(borderPanelSouth);


        
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
        myRemove.addActionListener(this);
        addDoc.addActionListener(this);
        removeDoc.addActionListener(this);
        editDocument.addActionListener(this);
        openDocument.addActionListener(this);
        
    }
    

    private void createDocPanel(Project theProject) {
    	
    	if(theProject == null) {
    		rightPanel.removeAll();
    		rightPanel.repaint();
    		return;
    	}
    	rightPanel.removeAll();
        JPanel testRight = new JPanel();
        JPanel itemsList = new JPanel();
        JPanel projectName = new JPanel();
        projectName.add(new JLabel(theProject.getName()));

        JPanel textText = new JPanel();
        JScrollPane docScrolls = new JScrollPane(textText);
        textText.setLayout(new GridLayout(0,2,5,5));
        docScrolls.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        docScrolls.setPreferredSize(new Dimension(750,354));


        
        for(JButton b : theProject.getItemButtons()) {
        	textText.add(b);
        	b.addActionListener(this);
        }
        
        itemsList.add(addDoc);
        itemsList.add(removeDoc);
        removeDoc.setEnabled(false);
        itemsList.add(editDocument);
        editDocument.setEnabled(false);
        itemsList.add(openDocument);
        openDocument.setEnabled(false);
        testRight.add(docScrolls);
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(projectName, BorderLayout.PAGE_START);
        rightPanel.add(testRight, BorderLayout.CENTER);
        rightPanel.add(itemsList, BorderLayout.PAGE_END);
        
        
    }
    
    
    private void updateProjects() {
    	projectPanel.removeAll();
		for(JButton j: myController.getProjects()) {
			projectPanel.add(j);
			j.addActionListener(this);
		}
		projectPanel.repaint();
		
    }
    
    /**
     * Decides which action to perform based on which event is triggered.
     */
    public void actionPerformed(final ActionEvent theEvent) {

    	textReader text;

    	System.out.println("Action command:" + theEvent.getActionCommand());
    	
    	
    	//ADD PROJECT
    	if(theEvent.getSource() == myAdd) {

    		
    		JTextField field1 = new JTextField();
    		Object[] fields = {"Enter a project Name:", field1};
    		int returnVal = JOptionPane.showConfirmDialog(this, fields, "Project Name", JOptionPane.OK_CANCEL_OPTION);
    		if(returnVal == JOptionPane.OK_OPTION) {
    			myController.add(field1.getText());
    			updateProjects();
    			this.validate();
    		}
    		
    		
    		
    	//REMOVE PROJECT BUTTON
    	} else if(theEvent.getSource() == myRemove){
    		if(choosenProject == null) {
    			myRemove.setEnabled(false);
    			return;
    		}
    		int n = JOptionPane.showConfirmDialog(this
    											  ,"Are you sure you want to delete: " + choosenProject.getName()
    											  , "Confirm"
    											  , JOptionPane.YES_NO_OPTION
    											  , JOptionPane.WARNING_MESSAGE);
    		if(n == JOptionPane.YES_OPTION) {
    			myController.remove(choosenProject);
    			createDocPanel(null);
    			myRemove.setEnabled(false);
    			updateProjects();
    			this.validate();
    		}
    		
    	}
    	
    	
    	else if(theEvent.getSource() == removeDoc) {
    		if(choosenItem == null) {
    			removeDoc.setEnabled(false);
    			editDocument.setEnabled(false);
    			openDocument.setEnabled(false);
    			return;
    		}
    		int n = JOptionPane.showConfirmDialog(this
    													,"Are you sure you want to delete: " + choosenItem.getName()
    													, "Confirm"
    													, JOptionPane.YES_NO_OPTION
    													, JOptionPane.WARNING_MESSAGE);
    		if(n == JOptionPane.YES_OPTION) {
    			choosenProject.removeItem(choosenItem);
    			createDocPanel(choosenProject);
    			removeDoc.setEnabled(false);
    			editDocument.setEnabled(false);
    			openDocument.setEnabled(false);
    			this.validate();
    		}

    	}
    	
    	//EDIT DOCUMENT
    	else if(theEvent.getSource() == editDocument) {
    		if(choosenItem == null) {
    			removeDoc.setEnabled(false);
    			editDocument.setEnabled(false);
    			openDocument.setEnabled(false);
    			return;
    		}
    		JTextField field1 = new JTextField(choosenItem.getName());
			JTextField field2 = new JTextField(choosenItem.getDescription());
			field2.setPreferredSize(new Dimension(50,50));
    		Object[] fields = {"Enter a new Item name for: " + choosenItem.getName(), field1, "Enter a new description of the Item:", field2};
    		int returnVal = JOptionPane.showConfirmDialog(this, fields, "Item Name", JOptionPane.OK_CANCEL_OPTION);
    		if(returnVal == JOptionPane.OK_OPTION) {
    			choosenItem.setName(field1.getText());
    			choosenItem.setDescription(field2.getText());
    			createDocPanel(choosenProject);
    			this.validate();
    		}
    	}
    	
    	//OPEN DOCUMENT BUTTON
    	else if(theEvent.getSource() == openDocument) {
    		if(choosenItem == null) {
    			removeDoc.setEnabled(false);
    			editDocument.setEnabled(false);
    			openDocument.setEnabled(false);
    			return;
    		}
    		choosenItem.openItem();
    	}
    	
    	//ABOUT BUTTON 
    	else if(theEvent.getSource() == myAboutMenuItem) {
    		try {
    			text = new textReader("./src/files/version.txt");
    			JOptionPane.showMessageDialog(this, text.getText(), "About Tidy", JOptionPane.INFORMATION_MESSAGE);
    		} catch (FileNotFoundException e) {
    			System.out.println("File not found");
    		}
    	}
    	
    	
    	//IMPORT BUTTON
    	else if(theEvent.getSource() == myImport) {
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
    	}
    	
    	
    	
    	//EXPORT BUTTON
    	else if(theEvent.getSource() == myExport) {
    		try {
				text = new textReader("./src/files/settings.txt");
				File exportFile = new File("./src/files/export.txt");
				exportFile.createNewFile();
				FileWriter writer = new FileWriter(exportFile);
				writer.write(text.getText());
				writer.close();
			} catch (IOException e) {
			}
    	}
    	
    	
    	
    	//EDIT BUTTON
    	else if(theEvent.getSource() == myEditButton) {    		
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
    	} 
    	
    	
    	
    	//VIEW BUTTON
    	else if(theEvent.getSource() == myViewButton) {
    		try {
				text = new textReader("./src/files/settings.txt");
				JOptionPane.showMessageDialog(this, text.getText(), "Settings", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	//ADD PROJECT BUTTONS
    	else if (myController.contains(theEvent.getActionCommand())) {
	    	
    		for (JButton b: myController.getProjects()) {	
	    		if (theEvent.getActionCommand().equals(b.getText())) {
	    			choosenProject = myController.getChoosenProject(b.getText());
	    			myRemove.setEnabled(true);
	    			createDocPanel(choosenProject);
	    			break;
	    		}
	    	}
    		

	    	this.validate();		    	
	    	
    	}
    	
    	//SELECT A DOCUMENT
    	else if(choosenProject != null && choosenProject.getItemNames().contains(theEvent.getActionCommand())) {
    		choosenItem = choosenProject.getItem(theEvent.getActionCommand());
    		System.out.println("Project: " + choosenProject.getName() + " Item: " + choosenItem.getName());
    		if(choosenProject != null) {
    			editDocument.setEnabled(true);
    			openDocument.setEnabled(true);
    			removeDoc.setEnabled(true);
    		}
    	}
    	
    	//ADD DOCUMENT
    	else if (theEvent.getSource() == addDoc) {
    		
    		JFileChooser fc = new JFileChooser();
    		int choice = fc.showOpenDialog(this);
    		if(choice == JFileChooser.APPROVE_OPTION) {
    			File theFile = fc.getSelectedFile();
    			JTextField field1 = new JTextField();
    			JTextField field2 = new JTextField();
    			field2.setPreferredSize(new Dimension(50,50));
        		Object[] fields = {"Enter a Item Name:", field1, "Enter a description of the Item:", field2};
        		int returnVal = JOptionPane.showConfirmDialog(this, fields, "Item Name", JOptionPane.OK_CANCEL_OPTION);
        		if(returnVal == JOptionPane.OK_OPTION) {
        				if(choosenProject != null) {
        					choosenProject.addItem(new Item(field1.getText(), field2.getText(), theFile));
        					createDocPanel(choosenProject);
        				}
        		}
    		}

    		
    		
    		JPanel bottomMenu = new JPanel();

	        listView.add(bottomMenu, BorderLayout.PAGE_END);
	        
	        this.validate();
    	} 
    }
    
}
