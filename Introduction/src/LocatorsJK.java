import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LocatorsJK {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome launch
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		
		//Firefox launch
		//System.setProperty("webdriver.gecko.driver", "C:\\JK\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//USed Method for getting a correct password
		LocatorsJK useThisPassword = new LocatorsJK();
		String correctPassword = useThisPassword.getPassword(driver);
		
		String name = "John";
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(correctPassword);	
		Thread.sleep(3000);
		driver.findElement(By.className("signInBtn")).click();
		
		// After a successful login
				Thread.sleep(3000);
				//System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText());
				System.out.println(driver.findElement(By.tagName("p")).getText());
				Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
				System.out.println(driver.findElement(By.cssSelector("h2")).getText());
				Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Hello " + name + ",");
				Thread.sleep(1000);
				
				driver.quit();
		
			
		
		
	}

	
	
	public String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(3000);
		//System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		String wholeText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] passwordArray = wholeText.split("'");
		String [] onlyPassword = passwordArray[1].split("'");
		System.out.println(onlyPassword[0]);
		return onlyPassword[0];
		
			
		
	}
	
	
}
