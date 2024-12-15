package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

	public WebDriver driver;
	public WebDriver WebDrivermanager() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL=prop.getProperty("QA1URL");
		String Browser=prop.getProperty("browser");
		
		if(driver == null)
		{
		if(Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		}
		return driver;
		
	}
}
