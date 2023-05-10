import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment95 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1.Click on the checkbox and get the text
		driver.findElement(By.id("checkBoxOption3")).click();
		String checkboxText = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
		System.out.println(checkboxText);
		
		//2.Choose for the dropdown the same option that was selected in the checkbox
		//Dropdown with Select tag
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(checkboxText);
		
		//3.In Enter Your Name field paste the text form the checkbox
		driver.findElement(By.id("name")).sendKeys(checkboxText);
		
		//4. Click on the Alert and verify that the text form the checkbox is presented in the popup
		driver.findElement(By.id("alertbtn")).click();
		
		// For Alerts and Popups we need to switch
		String alertText = driver.switchTo().alert().getText();
				System.out.println(alertText);
				String[] splitted01 = alertText.split(",");
				String[] splitted02 = splitted01[0].split(" ");
				String matchingCheckboxText = splitted02[1];
				System.out.println(splitted02[1]);
				
		Assert.assertEquals(checkboxText, matchingCheckboxText);
				
				
				
		
		
		
		
		
		
	}

}
