import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		

		//Invoking a Browser
		// WebDriver implementing methods only - WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		
		//Chrome launch
		// chromedriver.exe
		//System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		
		//webdriver.chrome.driver is a key value, a property
		//WebDriver driver = new ChromeDriver();
		
		
		//Firefox launch
		// geckodriver.exe
		//System.setProperty("webdriver.gecko.driver", "C:\\JK\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		//Edge launch
		//msedgedriver.exe
		System.setProperty("webdriver.edge.driver", "C:\\JK\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		//driver.quit();
	}

}
