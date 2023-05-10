package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber; //This is needed to be imported
import pageObject.HomePagePO;
import pageObject.LoginPagePO;
import resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.Assert;


@RunWith(Cucumber.class)
public class StepDefinition extends Base {
	
	//Creating this Log object for this LogManager API
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
    @Given("^Initialize a browser with Chrome$")
    public void initialize_a_browser_with_chrome() throws Throwable {
    	//Creating this Log object for this LogManager API
    	
    	driver = initializeDriver(); //Since this Method returns driver, we have to set driver = initializeDriver();
		log.info("Driver has been initiated");
    }
    
    @When("^A user enters a (.+) and a (.+) and clicks on the login button$")
    public void a_user_enters_a_and_a_and_clicks_on_the_login_button(String username, String password) throws Throwable {
LoginPagePO lppo = new LoginPagePO(driver);
		
		lppo.userEmailMethod().sendKeys(username);
		lppo.passwordMethod().sendKeys(password);
		Thread.sleep(1000);
		log.info("Username - " +username+ " and password - " + password +" are used in this TC");
		lppo.loginButtonMethod().click();
    }

   /* @When("^A user enters a \"([^\"]*)\" and a \"([^\"]*)\" and clicks on the login button$")
    public void a_user_enters_a_something_and_a_something_and_clicks_on_the_login_button(String strArg1, String strArg2) throws Throwable {
    	LoginPagePO lppo = new LoginPagePO(driver);
		
		lppo.userEmailMethod().sendKeys(strArg1);
		lppo.passwordMethod().sendKeys(strArg2);
		Thread.sleep(1000);
		log.info("Username - " +strArg1+ " and password - " + strArg2 +" are used in this TC");
		lppo.loginButtonMethod().click();
    }*/

    @Then("^Verify that a user is on the page with an expected h1 headline$")
    public void verify_that_a_user_is_on_the_page_with_an_expected_h1_headline() throws Throwable {
    	LoginPagePO lppo = new LoginPagePO(driver);
    	Assert.assertEquals(lppo.h1Method(), "Log In to WebServices Testing using SoapUI");
		log.info("A user is on the Login page");
    }

    @And("^Navigate to the \"([^\"]*)\"$")
    public void navigate_to_the_something(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^Wait for a popup to be visible and click on the No thanx button and navigate to the Login page$")
    public void wait_for_a_popup_to_be_visible_and_click_on_the_no_thanx_button_and_navigate_to_the_login_page() throws Throwable {
    	HomePagePO hppo =new HomePagePO(driver); //Place this driver into () and choose Create constructor
    	if(hppo.noThxSizeMethod()>0) //This IF block is instead of the Explicit wait
		{
			hppo.noThxMethod().click();
		}
				
hppo.loginLinkMethod().click();
    }

    @And("^Close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.close();
    }

}