package fileUtilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	public void writeToFile(List <String> links, String fileName) throws IOException {
		
		FileWriter fw = new FileWriter(fileName);
		
		int size = links.size();
		for (int i=0; i<size; i++) {
			String str = links.get(i).toString();
			fw.write(str);
		}
		
		fw.close();
	}

}