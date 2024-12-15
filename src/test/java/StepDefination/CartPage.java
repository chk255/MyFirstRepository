package StepDefination;

import org.testng.Assert;

import PageObjectModel.CartPageObject;
import PageObjectModel.PageObjectManager;
import PageObjectModel.ProductPageObject;
import io.cucumber.java.en.Then;
import utils.ContextSetup;

public class CartPage {
	
	public ContextSetup contextSetup;
	public CartPageObject cartPageObject;
	public String SelectedPhone;
	public String SelectedPhonelPrice;
	public PageObjectManager pageObjectManager;
	//public String PhoneModalPrice;
	public CartPage(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
	}
	
	@Then("Same Phone should be added to cart and validate price")
	public void same_phone_should_be_added_to_cart_and_validate_price() throws InterruptedException {
		Thread.sleep(2000);
		cartPageObject=contextSetup.pageObjectManager.getCartPageObject();
		String CartPhoneName= cartPageObject.ValidateProductName();
		System.out.println("CartPhoenName is"+CartPhoneName);
		System.out.println("contextSetup phone is"+contextSetup.SelectedPhone);
		Assert.assertEquals(CartPhoneName, "Apple iPhone 15 (Black, 128 GB)");
		String SelectedPhoneNamePrice=cartPageObject.ValidateProductPrice();
		System.out.println(SelectedPhoneNamePrice);
		Assert.assertEquals(SelectedPhoneNamePrice, "₹60,999");
		System.out.println("All Good");
	}

}
