package fileUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	//part of the keyword search functionality. Will match user's keyword input with stored links to find the most relevant link 
	public void searchingString(String str, String file) {
		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			int lineNum = 0;
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				lineNum++;
				if (line.toLowerCase().contains(str.toLowerCase())) {
					System.out.println("We found a link in our file that seems relevant to your keyword");
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
	
	//takes all of the stored link texts and store it into arraylist
	public ArrayList<String> storeFileDataToArrayList(String file) throws IOException{
		ArrayList<String> listOfLines = new ArrayList<String>();
		try {
			BufferedReader bufReader = new BufferedReader(new FileReader(file));
			String sCurrentLine;
			//as long as sCurrentLine is not empty, it means there are more lines from textfile to add to arraylist
			while((sCurrentLine = bufReader.readLine()) != null) {
				listOfLines.add(sCurrentLine);
			}		
			bufReader.close();
		}catch(FileNotFoundException e) {
			System.out.println("Ann error occured.");
			e.printStackTrace();
		}
		System.out.println("arraylist of links");
		System.out.println(listOfLines);
		return listOfLines;	
	}
}
	
