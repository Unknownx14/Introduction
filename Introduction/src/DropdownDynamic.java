import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownDynamic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Chrome launch
		
				System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
				//webdriver.chrome.driver is a key value, a property
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
				driver.findElement(By.cssSelector("span#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
				driver.findElement(By.xpath("//a[@value='MAA']")).click();
				Thread.sleep(2000);
				//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
				driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		
		
		
	}

}
