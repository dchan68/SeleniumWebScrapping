package webScrapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import dataManagement.DataManipulation;
import dataManagement.DataSearching;
import fileUtilities.FileReading;
import fileUtilities.FileWriting;

public class GoogleScrapper {

	public static void main(String[] args) throws InterruptedException, IOException {
		String strXpath;
		List <WebElement> searchPageResults;
		List <String> allLinkText = new ArrayList<String>();
		FileWriting fw;
		FileReading fr;
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\darya\\eclipse-workspace\\SeleniumProjects\\driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Toronto Raptors");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
		for (int i = 1; i <= 3; i++) {
			
			//since the first page will automatically be 1 when searching, will implement if statement since selenium won't be able to find page 1 link
			if (i>1) {
				//using browser inspect tool, pagination has this attribute //a[@class='fl' and text()='depends on page number'] 
				//therefore will use for loop to iterate through the pages and substituting 1,2,etc into text()=''
				strXpath = "//a[@class='fl' and text()='"+i+"']"; 
				driver.findElement(By.xpath(strXpath)).click();
				Thread.sleep(2000);
			}
			//Getting each link results
			searchPageResults = driver.findElements(By.xpath("//div[@class='yuRUbf']/a"));
			
			for (WebElement link : searchPageResults) {
				allLinkText.add(link.getText());
				
			}
		}
		
		fw = new FileWriting();
		String nameOfFile = "links.txt";
		
		fw.createFile(nameOfFile);
		fw.writeToFile(allLinkText, nameOfFile);

		fr = new FileReading();
		fr.readingFile(nameOfFile);
		
		driver.close();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Need a site suggestion? Enter a keyword and we'll see if we have something relevant for you");
		String requestedStr = scan.nextLine();
		
		fr.searchingString(requestedStr, nameOfFile);
		
		ArrayList<String> reversedArrayList = new ArrayList<String>();
		ArrayList<String> AlphabeticallySortedArrayList = new ArrayList<String>();
		
		//Reverse the order of links within links.txt and then rewrites it to the file
		DataManipulation dm = new DataManipulation();
		reversedArrayList = dm.reverseOrder(nameOfFile);
		fw.reWriteToFile(reversedArrayList, nameOfFile);
		fr.readingFile(nameOfFile);
		
		//Alphabetically orders the links within links.txt and then rewrites it to the file
		AlphabeticallySortedArrayList = dm.sortAlphabetically(nameOfFile);
		fw.reWriteToFile(AlphabeticallySortedArrayList, nameOfFile);
		fr.readingFile(nameOfFile);
	}

}
