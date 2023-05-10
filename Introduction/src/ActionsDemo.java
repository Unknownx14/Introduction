import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement move = driver.findElement(By.id("nav-link-accountList-nav-line-1")); //To be more readable
		WebElement textBox = driver.findElement(By.id("twotabsearchtextbox")); //To be more readable
		
		
		//We need the Actions class
		Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		act.moveToElement(move).contextClick().build().perform();
		Boolean displayed01 = driver.findElement(By.id("nav-al-signin")).isDisplayed();
		Assert.assertTrue(displayed01);
		
		act.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello kitty").doubleClick().build().perform();
		
		
		
		
		
		
		
		
	}

}
