import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class RelativeLocators122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Relative locator
		WebElement relativeLoc01 = driver.findElement(By.cssSelector("input[name='name']"));	
		System.out.println( driver.findElement(with(By.tagName("label")).above(relativeLoc01)).getText());
		
		
		WebElement relativeLoc02 = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(relativeLoc02)).click();
		
		
		WebElement relativeLoc03 = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(relativeLoc03)).click();
		
		
		WebElement relativeLoc04 = driver.findElement(By.id("inlineRadio1"));
		System.out.println( driver.findElement(with(By.tagName("label")).toRightOf(relativeLoc04)).getText());
		
	}

}
