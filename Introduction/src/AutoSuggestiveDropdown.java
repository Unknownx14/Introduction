import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome launch
		
				System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
				//webdriver.chrome.driver is a key value, a property
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				driver.findElement(By.id("autosuggest")).sendKeys("ia");
				Thread.sleep(2000);
				List<WebElement> listedOptions = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
				
				for(WebElement singledOption : listedOptions)
				{
					String nameCountry = singledOption.getText();
					if (nameCountry.equalsIgnoreCase("Yugoslavia"))
					{
						singledOption.click();
						break;
					}
							
				}
		
		
		
		
		
		
		
		
	}

}
