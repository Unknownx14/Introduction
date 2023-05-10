import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Chrome launch
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());	
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
		
		//Enabled or Disabled element
		System.out.println( driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style"), "display: block; opacity: 0.5;", "This calendar is Disabled");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println( driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		System.out.println( driver.findElement(By.id("Div1")).getAttribute("style"));
		Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style"), "display: block; opacity: 1;", "This calendar is Enabled");
		
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println( "This calendar is Enabled");
				Assert.assertTrue(true);
		}
		else
		{
			System.out.println( "This calendar is Disabled");
			Assert.assertTrue(false);
		}
			
		/*List<WebElement> allCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println( allCheckboxes.size() +" Checkboxes are presented on this page");
		Assert.assertEquals(allCheckboxes.size(), 6);
		
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
		*/
		
		
		
		
		
		
		
		
		
	}

}
