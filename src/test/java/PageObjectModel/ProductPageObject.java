package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utils.ReusabeUtility;

public class ProductPageObject extends ReusabeUtility {

	public WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	By listphonenames=By.xpath("//div[@class='_75nlfW']//div[@class='KzDlHZ']");
	@FindBy(xpath="(//div[text()='Apple iPhone 15 (Black, 128 GB)'])//ancestor::div[@class='yKfJKb row']/div[2]/div/div/div[@class='Nx9bqj _4b5DiR']")
	WebElement price;
	@FindBy(xpath="//div[text()='Apple iPhone 15 (Black, 128 GB)']")
	WebElement Phone;
	
	public boolean ValidateApplePhone() {
		
		List<WebElement> PhoneNames=driver.findElements(listphonenames);
		boolean match=PhoneNames.stream().anyMatch(p->p.getText().contains("Apple"));
		return match;
	}
	
	public void SelectPhone() {
	Phone.click();
	}
	public String GetPhonePrice() {
		return price.getText();
	}
	public String GetPhoneName() {
		return Phone.getText();
	}
	public void SwitchtoChild() {
		switchtochild();
	}
	
	

	

}
