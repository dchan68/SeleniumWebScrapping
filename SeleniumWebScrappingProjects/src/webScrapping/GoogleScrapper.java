package webScrapping;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleScrapper {

	public static void main(String[] args) throws InterruptedException {
		String strXpath;
		System.setProperty("webdriver.edge.driver", "C:\\Users\\darya\\eclipse-workspace\\SeleniumProjects\\driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Toronto Raptors");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		for (int i = 1; i <= 5; i++) {
			
			//since the first page will automatically be 1 when searching, will implement if statement since selenium won't be able to find page 1 link
			if (i>1) {
				//using browser inspect tool, pagination has this attribute //a[@class='fl' and text()='depends on page number'] 
				//therefore will use for loop to iterate through the pages and substituting 1,2,etc into text()=''
				strXpath = "//a[@class='fl' and text()='"+i+"']"; 
				driver.findElement(By.xpath(strXpath)).click();
				Thread.sleep(2000);
			}
			
		}
	}

}