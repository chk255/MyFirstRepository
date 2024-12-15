package PageObjectModel;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.ReusabeUtility;

public class CartPageObject extends ReusabeUtility {

	public WebDriver driver;
	public CartPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone 15 (Black, 128 GB)')]")
	WebElement SelectedPhone;
	@FindBy(xpath="//div[@class='Nx9bqj CxhGGd']")
	WebElement SelectedPhonePrice;
	@FindBy(xpath="//li[@class='col col-6-12 ']")
	WebElement AddtoCart;
	
	public String ValidateProductName() {
		String SelectedPhoneName=SelectedPhone.getText();
		return SelectedPhoneName;
	}
	public String ValidateProductPrice() {
		String SelectedPhoneNamePrice=SelectedPhonePrice.getText();
		return SelectedPhoneNamePrice;
	}

	public void AddtoCart() {
		AddtoCart.click();
	}
}
