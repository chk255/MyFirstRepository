package StepDefination;

import org.testng.Assert;

import PageObjectModel.PageObjectManager;
import PageObjectModel.ProductPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ContextSetup;

public class ProductPage {
	
	public ContextSetup contextSetup;
	public ProductPageObject productPageObject;
	public String PhoneModalPrice;
	public String SelectedPhone;
	public String SelectedPhonelPrice;
	public PageObjectManager pageObjectManager;
	
	public ProductPage(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
		productPageObject=contextSetup.pageObjectManager.getProductPageObject();
	}
	@Then("All Apple phone result should be displayed")
	public void all_apple_phone_result_should_be_displayed() {
	   
		
		boolean match=productPageObject.ValidateApplePhone();
		Assert.assertTrue(match);
		System.out.println("Pass");
	}

	
	@When("User Select phone")
	public void user_select_phone() throws InterruptedException {
		Thread.sleep(2000);
		SelectedPhone=productPageObject.GetPhoneName();
		System.out.println(SelectedPhone);
		SelectedPhonelPrice=productPageObject.GetPhonePrice();
		System.out.println(SelectedPhonelPrice);
		productPageObject.SelectPhone();
		productPageObject.SwitchtoChild();
		

		
		
		
	}
	
	

}
