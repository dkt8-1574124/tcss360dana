package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * The item class creates and stores the information of an Item object.
 * @author Amelia
 */
public class Item {

	//private String type; //.pdf  .txt  .jpeg  .png  .doc
	
	/** The name of the item */
	private String name;
	
	/** The description of the item */
	private String description;
	
	/** The file path to the item */
	private File filePath;
	
	/** 
	 * Creates an item object.
	 * @param Name	the name of the item
	 * @param Description	a description of the item
	 * @param FilePath	the file path to this item
	 * 
	 * @author Amelia
	 */
	public Item(String Name, String Description, File FilePath) {
		this.description = Description;
		this.name = Name;
		this.filePath = FilePath;
		
//		String[] parts = FilePath.split(".");
//		this.type = "." + parts[parts.length - 1];
	} 
	
	/** 
	 * Returns the name of an item object.
	 * @return the name of the item object
	 */
	public String getName() {
		return this.name;
	}
	
	/** 
	 * Sets the name of an item object to the given string.
	 * @param Name	the new name of the item
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
//	public String getType() {
//		return this.type;
//	}
	
	/**
	 * Returns the description of the item.
	 * @return the description of the item
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Sets the description of the item to the given string.
	 * @param newDescription the new description
	 */
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public void openItem() {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(filePath);
		} catch (IOException e) {
			System.out.println("Cannot open file");
		}
	}
}
