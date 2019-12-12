package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads the text in a file.
 * @author Duy and Nick
 *
 */
public class textReader {

	/** A string that will become equal to the text of the file. */
	private String myText = "";
	
	/**
	 * Takes a file and reads through the text copying it into a single string.
	 * @param theFile the file to be read
	 * @throws FileNotFoundException
	 */
	public textReader(String theFile) throws FileNotFoundException {
		File myFile = new File(theFile);
		Scanner scan = new Scanner(myFile);
		
		while(scan.hasNextLine()) {
			String test = scan.nextLine();
			myText += test + "\n";
		}
		scan.close();
	}
	
	/**
	 * Returns the string copy of the text from the file.
	 * @return the text from the file
	 */
	public String getText() {
		return myText;
		
	}

}
