import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Chrome launch
		
				System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
				//webdriver.chrome.driver is a key value, a property
				WebDriver driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
				System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
				Assert.assertEquals(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText(), "Login");
		
		
		
		
	}

}
