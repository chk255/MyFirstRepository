package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusabeUtility {
	
	public WebDriver driver;
	public ReusabeUtility(WebDriver driver)
	{
		this.driver=driver;
	}

	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public void checkforvisibilityofElement(WebElement Element)
	{
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public void checkforpresenceOfElementLocated(By by)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public void switchtochild() {
		Set<String> switchwindow=driver.getWindowHandles();
		Iterator<String> it=switchwindow.iterator();
		String main=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
	}
}
