package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class textReader {
	

	private static String myText = "";
	
	public textReader(String theFile) throws FileNotFoundException {
		File myFile = new File("./src/application/version.txt");

		Scanner scan = new Scanner(myFile);
		
		while(scan.hasNextLine()) {
			String test = scan.nextLine();
			System.out.println(test);
			myText += test + "\n";
		}
		scan.close();
	}
	
	public String getText() {
		return myText;
	}

}
