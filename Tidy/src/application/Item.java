package application;

public class Item {

	//private String type; //.pdf  .txt  .jpeg  .png  .doc
	private String name;
	private String description;
	private String filePath;
	
	public Item(String Name, String Description, String FilePath) {
		this.description = Description;
		this.name = Name;
		this.filePath = FilePath;
		
//		String[] parts = FilePath.split(".");
//		this.type = "." + parts[parts.length - 1];
	} 
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
//	public String getType() {
//		return this.type;
//	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
}
