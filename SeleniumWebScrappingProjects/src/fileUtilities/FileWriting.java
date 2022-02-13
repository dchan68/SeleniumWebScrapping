package fileUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWriting {
	
	public void createFile(String fileName) {
	    try {
	    	File myFile = new File(fileName);
	    	if(!myFile.exists()) {
	    		myFile.createNewFile();
	    	}else {
	    		System.out.println("File already exists");
	    	}
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
		
	}
	
	public void writeToFile(List<String> links, String fileName) throws IOException {
		
		FileWriter fw = new FileWriter(fileName);
		
		int size = links.size();
		for (int i=0; i<size; i++) {
			String str = links.get(i).toString();
			fw.write(str);
		}
		
		fw.close();
	}
	
	//To be used with the DataManipulation class so that it can rewrite the files data with newly sorted data
	public void reWriteToFile(ArrayList<String> links, String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		for(String s : links) {
			bw.write(s + System.getProperty("line.separator"));
		}
		bw.close();
	}

}
