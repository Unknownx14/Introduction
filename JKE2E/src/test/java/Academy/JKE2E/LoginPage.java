package Academy.JKE2E;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePagePO;
import pageObject.LoginPagePO;
import resources.Base;

public class LoginPage extends Base {

	//This is only if we have parallel execution of these test in testng.xml file (video 202)
			public WebDriver driver;
	
	//Creating this Log object for this LogManager API
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void begining() throws IOException
	{
		driver = initializeDriver(); //Since this Method returns driver, we have to set driver = initializeDriver();
		log.info("Driver has been initiated");
	}
	
	
	@Test(dataProvider="getData")
	public void loginPageNavigation(String usernameDP, String passwordDP) throws IOException, InterruptedException
	{
		
		//driver = initializeDriver(); //Since this Method returns driver, we have to set driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		//Creating an Object of a class HomePagePO
		HomePagePO hppo =new HomePagePO(driver); //Place this driver into () and choose Create constructor
		
		//Explicit wait - define the object of the class
				//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
				//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='NO THANKS']")));
				if(hppo.noThxSizeMethod()>0) //This IF block is instead of the Explicit wait
				{
					hppo.noThxMethod().click();
				}
				
		//hppo.noThxMethod().click();		
		hppo.loginLinkMethod().click();
		
		LoginPagePO lppo = new LoginPagePO(driver);
		
		lppo.userEmailMethod().sendKeys(usernameDP);
		lppo.passwordMethod().sendKeys(passwordDP);
		Thread.sleep(1000);
		log.info("Username - " +usernameDP+ " and password - " + passwordDP +" are used in this TC");
		lppo.loginButtonMethod().click();
		
		Assert.assertEquals(lppo.h1Method(), "Log In to WebServices Testing using SoapUI");
		log.info("A user is on the Login page");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] dataProv = new Object [2][2]; //There are 2 rows and 2 columns (index starts from 0, so in order to have 0 and 1, there must be [2])
		dataProv[0][0] = "private@spotter.com";
		dataProv[0][1] = "passwordPrivate";
		
		dataProv[1][0] = "enterprise@spotter.com";
		dataProv[1][1] = "passwordEnterprise";
		
		return dataProv;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
