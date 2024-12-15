package StepDefination;

import org.testng.Assert;

import PageObjectModel.LandingPageObject;
import PageObjectModel.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ContextSetup;

public class LandingPage {

	public ContextSetup contextSetup;
	public LandingPageObject landingPageObject;
	public String SelectedPhone;
	public String SelectedPhonelPrice;
	public PageObjectManager pageObjectManager;
	public LandingPage(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
		landingPageObject=contextSetup.pageObjectManager.getLandingPageObject();
	}
	@Given("User is at Landing Page")
	public void user_is_at_landing_page() {
		
		
		String title=landingPageObject.getPageTile();
		Assert.assertTrue(title.contains("Online Shopping"));
	    
	}
	@When("User Search with {string} in Search Box and select Brand Apple")
	public void user_search_with_in_search_box_and_select_brand_as(String string) {
	
		landingPageObject.Search(string);
		landingPageObject.SelectBrand();
		
	}
	@Given("User is at Product Page")
	public void user_is_at_product_page() {
		landingPageObject.Search("mobile");
		landingPageObject.SelectBrand();
	}
}
