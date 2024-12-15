package StepDefination;

import org.testng.Assert;

import PageObjectModel.CartPageObject;
import PageObjectModel.LandingPageObject;
import PageObjectModel.PageObjectManager;
import PageObjectModel.ProductCustomizationPageObject;
import PageObjectModel.ProductPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ContextSetup;

public class ProductCustomizationPage {
	
	
	public ContextSetup contextSetup;
	public LandingPageObject landingPageObject;
	public String SelectedPhone;
	public String SelectedPhonelPrice;
	public PageObjectManager pageObjectManager;
	public ProductPageObject productPageObject;
	public CartPageObject cartPageObject;
	public ProductCustomizationPageObject productCustomizationPageObject;
	public ProductCustomizationPage(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
	}
	
	@Given("User is at Cart Page")
	public void user_is_at_cart_page() throws InterruptedException {
		landingPageObject=contextSetup.pageObjectManager.getLandingPageObject();
		landingPageObject.Search("mobile");
		landingPageObject.SelectBrand();
		Thread.sleep(2000);
		productPageObject=contextSetup.pageObjectManager.getProductPageObject();
		SelectedPhone=productPageObject.GetPhoneName();
		System.out.println(SelectedPhone);
		SelectedPhonelPrice=productPageObject.GetPhonePrice();
		System.out.println(SelectedPhonelPrice);
		productPageObject.SelectPhone();
		productPageObject.SwitchtoChild();
		
	}
	@When("Add Product to the Customization page")
	public void add_product_to_the_customization_page() throws InterruptedException {
		Thread.sleep(2000);
		cartPageObject=contextSetup.pageObjectManager.getCartPageObject();
		String CartPhoneName= cartPageObject.ValidateProductName();
		System.out.println("CartPhoenName is"+CartPhoneName);
		System.out.println("contextSetup phone is"+contextSetup.SelectedPhone);
		Assert.assertEquals(CartPhoneName, "Apple iPhone 15 (Black, 128 GB)");
		String SelectedPhoneNamePrice=cartPageObject.ValidateProductPrice();
		System.out.println(SelectedPhoneNamePrice);
		Assert.assertEquals(SelectedPhoneNamePrice, "₹60,999");
		cartPageObject.AddtoCart();
		
	}
	@Then("Customization page prodcut is ame as Cart page Product")
	public void customization_page_prodcut_is_ame_as_cart_page_product() {
		productCustomizationPageObject=contextSetup.pageObjectManager.getProductCustomizationPageObject();
		String CartPhoneName=productCustomizationPageObject.CartPhoneName();
		Assert.assertEquals(CartPhoneName, "Apple iPhone 15 (Black, 128 GB)");
		String CartPhonePrice=productCustomizationPageObject.getCartPhonePrice();
		Assert.assertEquals(CartPhonePrice, "₹60,999");
	}

}
