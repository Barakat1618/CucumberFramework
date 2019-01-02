package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjectMethods.LoginPageMethods;
import resources.BaseClass;



public class MyStepDefinitions extends BaseClass{

	
	private static LoginPageMethods lpm = null;
	
	@Given("^User enters the url \"([^\"]*)\"$")
	public void user_enters_the_url(String arg1) throws Throwable {
	   driver = initializeDriver();
	   driver.get(arg1);
	   
	}

	
	@When("^The user enters a user name (.+) and passowrd (.+) and then clicks on submit button$")
	public void the_user_enters_a_user_name_and_passowrd_and_then_clicks_on_submit_button(String arg1, String arg2) throws Throwable {
		lpm = new LoginPageMethods(driver);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		lpm.emailId().sendKeys(arg1);
		lpm.password().sendKeys(arg2);
		lpm.login().click();
	}

	@Then("^The user must not be logged in$")
	public void the_user_must_not_be_logged_in() throws Throwable {
	    Assert.assertTrue(lpm.wrongMailIdPassword().isDisplayed());
	}

	

}
