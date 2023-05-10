package Academy.JKE2E;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePagePO;
import resources.Base;

public class HomePageFail extends Base {

	
	//This is only if we have parallel execution of these test in testng.xml file (video 202)
	public WebDriver driver;

//Creating this Log object for this LogManager API
	public static Logger log = LogManager.getLogger(Base.class.getName());


@BeforeTest
public void begining() throws IOException
{
driver = initializeDriver(); //Since this Method returns driver, we have to set driver = initializeDriver();
driver.get(prop.getProperty("url"));
log.info("Driver has been initiated and an url is opened");

}

@Test
public void validateHeadlineh2() throws IOException
{
//driver = initializeDriver(); //Since this Method returns driver, we have to set driver = initializeDriver();
//driver.get(prop.getProperty("url"));

//Creating an Object of a class HomePagePO
HomePagePO hppo =new HomePagePO(driver); //Place this driver into () and choose Create constructor

//Explicit wait - define the object of the class
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='NO THANKS']")));
		w.until(ExpectedConditions.visibilityOfElementLocated(hppo.noThx));
		
hppo.noThxMethod().click();		
Assert.assertEquals(hppo.h2Method(), "FEATURED COURSES123");
log.info("Headline h2 is verified");

hppo.loginLinkMethod().click();
}

@AfterTest
public void teardown()
{
driver.close();
}
	
}
