package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;

/**
 * Handles and organizes the Project Objects.
 * @author Nick and Duy
 */
public class projectController {
	
	/** An ArrayList to hold the Project objects created by the user. */
	private ArrayList<Project> myProjects;
	
	/** A map to be used for storing Projects and the Items. */
	private HashMap<Project, Item> storage;
	
	/**
	 * Creates the project list and storage map.
	 */
	public projectController() {
		myProjects = new ArrayList<Project>();
		storage = new HashMap<Project, Item>();
	}
	
	/**
	 * Creates a new project with the given name and adds the given project to the project list.
	 * @param theProjectName	the project to be added
	 */
	public void add(String theProjectName) {
		Project project = new Project(theProjectName);
		myProjects.add(project);
	}
	
	/**
	 * Searches through the project list and returns the project if its name matches the given buttonName
	 * otherwise returns null.
	 * @param buttonName the button name to be compared with each projects name
	 * @return the project if its name matches the given buttonName
	 * 			otherwise returns null
	 */
	public Project getChoosenProject(String buttonName) {
		for (Project p: myProjects) {
			if(p.getName().equals(buttonName)) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Creates a list for JButtons and populates it with one button for each Project in the project list.
	 * @return the list of JButtons
	 */
	public ArrayList<JButton> getProjects() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for(Project p: myProjects) {
			buttons.add(new JButton(p.getName()));
		}
		return buttons;
	}
	
	/**
	 * Checks to see if the project list contains a certain project.
	 * @param otherProjectName	the project to be searched for
	 * @return whether the project is contained in the project list or not
	 */
	public boolean contains(String otherProjectName) {
		for (Project p: myProjects) {
			if (p.getName().equals(otherProjectName)) {
				return true;
			}
		}
		return false;
	}
	
	public void remove(Project theProject) {
		myProjects.remove(theProject);
	}

	
	
	/**
	 * Returns a string representation of the projects list.
	 * @return	string representation of the projects list
	 */
	public String toString() {
		if(myProjects == null) {
			return "[]";
		}
		String result = "[";
		for (Project p: myProjects) {
			result +=  p.getName() + ",";
		}
		return result.substring(0, result.length() - 1) + "]";
	}
}
