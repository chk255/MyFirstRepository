package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjectModel.PageObjectManager;

public class ContextSetup {
	
	public WebDriver driver;
	public testBase testbase;
	public PageObjectManager pageObjectManager;
	public ReusabeUtility reusabeUtility;
	public String SelectedPhonelPrice;
	public String SelectedPhone;
	
	public ContextSetup() throws IOException {
		
		testbase=new testBase();
		pageObjectManager=new PageObjectManager(testbase.WebDrivermanager());
		reusabeUtility=new ReusabeUtility(testbase.WebDrivermanager());
		
		
	}
	

}
