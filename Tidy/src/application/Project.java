package application;
import java.util.*;

public class Project {
	private String name;
	private List<Item> itemsList;
	
	public Project(String Name) {
		this.name = Name;
		this.itemsList = new ArrayList<Item>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public List<Item> getItemsList() {
		return this.itemsList;
	}
	
	public int getSize() {
		return this.itemsList.size();
	}
	
	//need to do
	public int getItemSize(Project p) {
		return -1;
	}
	
	public void addItem(Item newItem) {
		this.itemsList.add(newItem);
	}
	
	public void removeItem(Item oldItem) {
		this.itemsList.remove(oldItem);
	}
	
	public Item getItem(Item find) {
		for (Item i : this.itemsList) {
			if (i == find) {
				return i;
			}
		}
		return null;
	}
}
