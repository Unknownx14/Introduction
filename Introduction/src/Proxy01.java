import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;

public class Proxy01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ChromeOptions class for bypassing SSL certificate
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//FirefoxOptions options1 = new FirefoxOptions();
		//options1.setAcceptInsecureCerts(true);
		
		//For proxy we need the class Proxy
		Proxy proxyJK = new Proxy();
		proxyJK.setHttpProxy("ipaddress:4444"); //this http proxy will be given by someone form my team
		options.setCapability("proxy", proxyJK);
		
		//For Set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(options); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		
		System.out.println(driver.getTitle());
		
		
	}

}
