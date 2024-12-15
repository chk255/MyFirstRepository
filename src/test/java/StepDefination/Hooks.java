package StepDefination;

import java.io.IOException;

import io.cucumber.java.After;
import utils.ContextSetup;

public class Hooks {
	
	public ContextSetup contextSetup;
	public Hooks(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
	}
	
	@After
	public void teardown() throws IOException {
		contextSetup.testbase.WebDrivermanager().quit();
	}

}
