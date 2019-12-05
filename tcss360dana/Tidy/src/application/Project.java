package application;
import java.util.*;

/**
 * The Project class creates and stores information for a Project object.
 * @author Amelia
 */
public class Project {
	
	/** The name of the project item. */
	private String name;
	/** The list of Item objects associated with the Project object. */
	private List<Item> itemsList;
	
	/**
	 * Creates a project object.
	 * @param Name	the name of the project object
	 */
	public Project(String Name) {
		this.name = Name;
		this.itemsList = new ArrayList<Item>();
	}
	
	/**
	 * Returns the name of the Project object.
	 * @return the name of the Project object
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the mane of the Project object to the given string.
	 * @param newName the new name of the project
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Returns the list of Item objects associated with this Project object.
	 * @return the list of Item objects associated with this Project object
	 */
	public List<Item> getItemsList() {
		return this.itemsList;
	}
	
	/**
	 * Returns the number of Item objects associated with the Project object.
	 * @return the number of Item objects associated with the Project object
	 */
	public int getSize() {
		return this.itemsList.size();
	}

	/**
	 * Adds the given Item object to the list of Item objects associated with the Project object.
	 * @param newItem the item to be added to the list
	 */
	public void addItem(Item newItem) {
		this.itemsList.add(newItem);
	}
	
	/**
	 * Removes the specified object from the list of Item objects associated with the Project object. 
	 * @param oldItem the Item to be removed from the list
	 */
	public void removeItem(Item oldItem) {
		this.itemsList.remove(oldItem);
	}
	
	/**
	 * Returns the specified Item object given the string name of the Item object.
	 * If the item is contained in the Projects Item list then the Item object is returned.
	 * Otherwise this method returns null.
	 * @param find
	 * @return
	 */
	public Item getItem(String find) {
		for (Item i : this.itemsList) {
			if (i.getName().equals(find)) {
				return i;
			}
		}
		return null;
	}
}
