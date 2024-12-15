package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductCustomizationPageObject {

	public WebDriver driver;
	public ProductCustomizationPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Apple iPhone 15 (Black, 128 GB)']")
	WebElement CartPhoneName;
	@FindBy(xpath="//span[@class='LAlF6k re6bBo']")
	WebElement CartPhonePrice;
	
	public String CartPhoneName() {
	return CartPhoneName.getText();
	}
	public String getCartPhonePrice() {
	return CartPhonePrice.getText();
	}
	
}
