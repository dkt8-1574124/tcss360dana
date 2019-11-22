package application;

import java.util.LinkedList;

import javax.swing.JButton;

public class projectController {
	private LinkedList<Project> myProjects;
	
	public projectController() {
		myProjects = new LinkedList<Project>();
	}
	
	public void add(String theProjectName) {
		Project project = new Project(theProjectName);
		myProjects.add(project);
	}
	
	public JButton[] getProjects() {
		JButton[] buttons = new JButton[myProjects.size()];
		int count = 0;
		for(Project p: myProjects) {
			buttons[count] = new JButton(p.getName());
			count ++;
		}
		return buttons;
	}

}
