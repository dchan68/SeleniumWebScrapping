package dataManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import fileUtilities.FileReading;

public class DataManipulation {
	
	FileReading FR = new FileReading();
	
	//will reverse the order of the file data
	public ArrayList<String> reverseOrder(String nameOfFile) throws IOException {
		
		ArrayList<String> reversedArrayList = new ArrayList<String>();
		reversedArrayList = FR.storeFileDataToArrayList(nameOfFile);
		Collections.reverse(reversedArrayList);
		return reversedArrayList;
	}
	
	//will alphabetically sort the file data
	public ArrayList<String> sortAlphabetically(String nameOfFile) throws IOException {
		ArrayList<String> arraylistToSort = new ArrayList<String>();
		arraylistToSort = FR.storeFileDataToArrayList(nameOfFile);
		Collections.sort(arraylistToSort);
		return arraylistToSort;
	}
}
