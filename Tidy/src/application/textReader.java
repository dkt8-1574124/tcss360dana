package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class textReader {
	

	private String myText = "";
	
	public textReader(String theFile) throws FileNotFoundException {
		File myFile = new File(theFile);
		Scanner scan = new Scanner(myFile);
		
		while(scan.hasNextLine()) {
			String test = scan.nextLine();
			myText += test + "\n";
		}
		scan.close();
	}
	
	public String getText() {
		return myText;
		
	}

}
