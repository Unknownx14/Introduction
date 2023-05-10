import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Chrome launch
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
			
		List<WebElement> allCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println( allCheckboxes.size() +" Checkboxes are presented on this page");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		int i=1;   // While loop
		while (i<5)
		{
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
			i++;
		}
		
		for(int j=1; j<5; j++)   // For loop
		{
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
			
		}
			
		
		//driver.findElement(By.id("hrefIncAdt")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.findElement(By.cssSelector("div#divpaxinfo")).getText();
		System.out.println(driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div#divpaxinfo")).getText(), "9 Adult");
		
		
		
		
		
		
		
		
		
		
	}

}
