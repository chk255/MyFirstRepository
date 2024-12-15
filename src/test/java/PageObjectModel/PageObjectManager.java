package PageObjectModel;

import org.openqa.selenium.WebDriver;

import StepDefination.ProductCustomizationPage;

public class PageObjectManager {

	public WebDriver driver;
	public LandingPageObject landingPageObject;
	public ProductPageObject productPageObject;
	public CartPageObject cartPageObject;
	public ProductCustomizationPageObject productCustomizationPageObject;
	public PageObjectManager(WebDriver driver) {
		
		this.driver=driver;
	}

	public LandingPageObject getLandingPageObject()
	{
		landingPageObject=new LandingPageObject(driver);
		return landingPageObject;
	}
	
	public ProductPageObject getProductPageObject()
	{
		productPageObject=new ProductPageObject(driver);
		return productPageObject;
	}
	public CartPageObject getCartPageObject()
	{
		cartPageObject=new CartPageObject(driver);
		return cartPageObject;
	}
	public ProductCustomizationPageObject getProductCustomizationPageObject()
	{
		productCustomizationPageObject=new ProductCustomizationPageObject(driver);
		return productCustomizationPageObject;
	}
}
