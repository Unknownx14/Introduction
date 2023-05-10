import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome launch
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Locators2 useThisPassword = new Locators2();
		String correctPassword = useThisPassword.getPassword(driver);
		
		String name = "John";
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(correctPassword);	
		driver.findElement(By.className("signInBtn")).click();
		
		// After a successful login
		Thread.sleep(3000);
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText());
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Hello " + name + ",");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		//driver.findElement(By.cssSelector("button.logout-btn")).click();
		
		//After the successfull Logout
		System.out.println(driver.findElement(By.className("signInBtn")).getText());
		Assert.assertEquals(driver.findElement(By.className("signInBtn")).getText(), "SIGN IN");
		System.out.println(driver.findElement(By.xpath("//h1[text()='Sign in']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Sign in']")).getText(), "Sign in");
		driver.close();
		
			
		
		
	}

	
	
	public String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		String wholeText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] passwordArray = wholeText.split("'");
		String [] onlyPassword = passwordArray[1].split("'");
		System.out.println(onlyPassword[0]);
		return onlyPassword[0];
		
			
		
	}
	
	
}
