import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowPopUp342 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		
		
		driver.findElement(By.linkText("Basic Auth")).click();
		
		String pText = driver.findElement(By.xpath("//p")).getText();
		Assert.assertEquals(pText, "Congratulations! You must have the proper credentials.");
	}

}
