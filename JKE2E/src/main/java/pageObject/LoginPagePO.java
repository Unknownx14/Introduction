package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {

		public WebDriver driver;
	
	
		By userEmail = By.id("user_email");
		By password = By.id("user_password");
		By loginButton = By.name("commit");
		By h1 = By.xpath("//h1");
	
	
	//This is the Created constructor
		public LoginPagePO(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
			
		}
		
		public WebElement userEmailMethod()
		{
			return driver.findElement(userEmail);
		}
		
		public WebElement passwordMethod()
		{
			return driver.findElement(password);
		}
		
		public WebElement loginButtonMethod()
		{
			return driver.findElement(loginButton);
		}
	
		public String h1Method()
		{
			return driver.findElement(h1).getText();
		}
}
