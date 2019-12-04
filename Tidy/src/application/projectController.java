package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;

public class projectController {
	private ArrayList<Project> myProjects;
	private HashMap<Project, Item> storage;
	
	public projectController() {
		myProjects = new ArrayList<Project>();
		storage = new HashMap<Project, Item>();
	}
	
	public void add(String theProjectName) {
		Project project = new Project(theProjectName);
		myProjects.add(project);
	}
	
//	public void addDocment(String theDocName) {
//		Project project = new Project(theProjectName);
//		myProjects.add(project);
//	}
	
	public Project getChoosenProject(String buttonName) {
		for (Project p: myProjects) {
			if(p.getName().equals(buttonName)) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<JButton> getProjects() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for(Project p: myProjects) {
			buttons.add(new JButton(p.getName()));
		}
		return buttons;
	}
	
	public boolean contains(String otherProjectName) {
		for (Project p: myProjects) {
			if (p.getName().equals(otherProjectName)) {
				return true;
			}
		}
		return false;
	}
	
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
