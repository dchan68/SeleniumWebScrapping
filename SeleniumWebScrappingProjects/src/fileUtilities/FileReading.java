package fileUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReading {
	
	public void readingFile(String file) {

	    try {
	        File myObj = new File(file);
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          System.out.println(data);
	        }
	        myReader.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	}
	
	public void searchingString(String str, String file) {
		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			int lineNum = 0;
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				lineNum++;
				if (line.toLowerCase().contains(str.toLowerCase())) {
					System.out.println("We see that the particular link you're interested in does exist in our storage. Here it is");
					System.out.println(line);
					break;
				}
				if (!myReader.hasNextLine()) {
					System.out.println("Sorry, we don't have anything related to your keyword in our storage");
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
	

}
	
