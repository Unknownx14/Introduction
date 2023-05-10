import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLbypass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ChromeOptions class for bypassing SSL certificate
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//FirefoxOptions options1 = new FirefoxOptions();
		//options1.setAcceptInsecureCerts(true);
		
		//System.setProperty("webdriver.gecko.driver", "C:\\JK\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver(options1);
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(options); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		
		System.out.println(driver.getTitle());
		
		
		
	}

}
