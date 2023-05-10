package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePO {

	public WebDriver driver;
	
	
	public By noThx = By.xpath("//button[text()='NO THANKS']");
	By loginLink = By.xpath("//span[text()='Login']");
	By h2 = By.xpath("//h2[text()='Featured Courses']");
	By navigationBar = By.cssSelector(".navbar-collapse.collapse");
	
	
	//This is the Created constructor
	public HomePagePO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//this.driver refers to public WebDriver driver; here in HomePagePO that doesn't have a life, and =driver is public HomePagePO(WebDriver driver) that has a life from HomePage.java
	}

	public WebElement noThxMethod()
	{
		 return driver.findElement(noThx);
	}
	
	public WebElement loginLinkMethod()
	{
		return driver.findElement(loginLink);
	}
	
	public String h2Method()
	{
		return driver.findElement(h2).getText();
	}
	
	public boolean navigationBarMethod()
	{
		return driver.findElement(navigationBar).isDisplayed();
	}
	
	public int noThxSizeMethod()
	{
		 return driver.findElements(noThx).size();
	}
	
}
