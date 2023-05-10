import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment103b {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


				System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
				//webdriver.chrome.driver is a key value, a property
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().window().maximize();
				driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
				
				//Autocomplete autosuggest
				WebElement move = driver.findElement(By.id("autocomplete"));
				driver.findElement(By.id("autocomplete")).sendKeys("via");
				
				Thread.sleep(1000);
				//We need the Actions class
				Actions act = new Actions(driver);
				
				//act.moveToElement(move).sendKeys(Keys.ARROW_DOWN).build().perform();
				//act.sendKeys(Keys.ARROW_DOWN).build().perform();
				int selectOption = 3;
				for (int i=0; i<selectOption; i++)
				{
					move.sendKeys(Keys.ARROW_DOWN);
					//act.sendKeys(Keys.ARROW_DOWN).build().perform();
				}
				
				//This will return the Country from the list to which Arrow Down points out
				List<WebElement> myList = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
				for (int j=0; j<selectOption; j++)
				{
					myList.get(j).getText();
					if(j==selectOption-1)
					{
						String selectedCountry = myList.get(j).getText();
						System.out.println(selectedCountry);
					}
				}
				
				//In this case there is no text, therefore .getText() doesn't return anything
				String inTheFieldCountry = driver.findElement(By.id("autocomplete")).getText();
				System.out.println(inTheFieldCountry);
				
				//From Rahul, how to find the value when there is no text .getText(), use .getAttribute("value")
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
				
	}

}
