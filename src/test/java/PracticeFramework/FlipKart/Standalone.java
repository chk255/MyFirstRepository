package PracticeFramework.FlipKart;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		WebElement fashion=driver.findElement(By.xpath("//span[text()='Fashion']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(fashion).build().perform();
		
		driver.findElement(By.xpath("//a[text()='All']")).click();

	}

}
