package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utils.ReusabeUtility;

public class LandingPageObject extends ReusabeUtility{

	public WebDriver driver;
	public LandingPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="input[class='Pke_EE']")
	WebElement searchBox;
	@FindBy(xpath="//div[text()='Apple']//preceding-sibling::div")
	WebElement BrandCheckBox;
	

	public String getPageTile() {
		String Title=driver.getTitle();
		return Title;
	}
	public void Search(String Name) {
		
		checkforvisibilityofElement(searchBox);
		searchBox.sendKeys("mobile");
     	searchBox.sendKeys(Keys.ENTER);
	}
	public void SelectBrand() {
		
		BrandCheckBox.click();
	}

}
