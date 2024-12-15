package PracticeFramework.FlipKart;



import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String Title=driver.getTitle();
		System.out.println(Title);
		Assert.assertTrue(Title.contains("Online Shopping"));
		
		WebElement searchBox=driver.findElement(By.cssSelector("input[class='Pke_EE']"));
		wait.until(ExpectedConditions.visibilityOf(searchBox));

		searchBox.sendKeys("mobile");
		searchBox.sendKeys(Keys.ENTER);
		String BrandName="Apple";
		WebElement BrandCheckBox=driver.findElement(By.xpath("//div[text()='"+BrandName+"']//preceding-sibling::div"));
		BrandCheckBox.click();
		
		//Thread.sleep(2000);
		
		By listphonenames=By.xpath("//div[@class='_75nlfW']//div[@class='KzDlHZ']");
		wait.until(ExpectedConditions.presenceOfElementLocated(listphonenames));
		
		List<WebElement> PhoneNames=driver.findElements(listphonenames);
		
		//PhoneNames.stream().forEach(p->System.out.println(p.getText()));
		boolean match=PhoneNames.stream().anyMatch(p->p.getText().contains("Apple"));
		Assert.assertTrue(match);
		System.out.println("Pass");
		
		Thread.sleep(2000);
		String PhoneModal="Apple iPhone 15 (Black, 128 GB)";
		WebElement price=driver.findElement(By.xpath("(//div[text()='"+PhoneModal+"'])//ancestor::div[@class='yKfJKb row']/div[2]/div/div/div[@class='Nx9bqj _4b5DiR']"));
		System.out.println(price.getText());
		String PhoneModalPrice=price.getText();
		WebElement Phone=driver.findElement(By.xpath("//div[text()='"+PhoneModal+"']"));
		
		Phone.click();
		
		Set<String> switchwindow=driver.getWindowHandles();
		Iterator<String> it=switchwindow.iterator();
		String main=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
		Thread.sleep(2000);
		String SelectedPhone=driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 15 (Black, 128 GB)')]")).getText();
		Assert.assertTrue(SelectedPhone.equalsIgnoreCase(PhoneModal));
		String SelectedPhonePrice=driver.findElement(By.xpath("//div[@class='Nx9bqj CxhGGd']")).getText();
		Assert.assertTrue(SelectedPhonePrice.equals(PhoneModalPrice));
		
		System.out.println("Till now Pass");
		
		driver.findElement(By.xpath("//li[@class='col col-6-12 ']")).click();
		
		String CartPhone=driver.findElement(By.xpath("//a[text()='Apple iPhone 15 (Black, 128 GB)']")).getText();
		Assert.assertTrue(CartPhone.equalsIgnoreCase(PhoneModal));
		String CartPhonePrice=driver.findElement(By.xpath("//span[@class='LAlF6k re6bBo']")).getText();
		Assert.assertTrue(CartPhonePrice.equals(PhoneModalPrice));
		driver.quit();
		
		
		
	}

}
