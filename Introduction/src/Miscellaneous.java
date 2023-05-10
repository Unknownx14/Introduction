import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); //Delete all cookies
		driver.manage().deleteCookieNamed("qwer"); //Delete just one cookie
		
		
		//Session cookie deletion - after this cookie is deleted, we should be automatically navigated to the Login page
		//driver.manage().deleteCookieNamed("sessionKey"); //Lets assume we have deleted the session cookie
		//After the deletion of this cookie, click anywhere and verify you are navigated to the Login page
		
		driver.get("https://google.com/");
		
		//For Screenshots, this object src has a screenshot
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\screenshot.png")); //To be visible in our local machine
		
	}
	
	
	

}
