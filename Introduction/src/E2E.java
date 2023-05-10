import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Chrome launch
		
				System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
				//webdriver.chrome.driver is a key value, a property
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
				//Chose FROM and TO
				driver.findElement(By.cssSelector("span#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
				driver.findElement(By.xpath("//a[@value='MAA']")).click();
				Thread.sleep(2000);
				//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
				driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
				
				Thread.sleep(1000);
				//Chose Current date from the calendar
				driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
				
				Thread.sleep(1000);
				//Chose a checkbox and a number of Passangers
				Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());	
				driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
				Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
					
				List<WebElement> allCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
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
				
				Thread.sleep(1000);
				//Dropdown with Select tag for Currency
				WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dropdown = new Select(staticDropdown);
				dropdown.selectByIndex(3);
				dropdown.getFirstSelectedOption().getText();
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByVisibleText("AED");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByValue("INR");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				
				Thread.sleep(1000);
				//Enabled or Disabled element - here we wont to stay disabled
				System.out.println( driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
				Assert.assertEquals(driver.findElement(By.id("Div1")).getAttribute("style"), "display: block; opacity: 0.5;", "This calendar is Disabled");
				
				
				if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
				{
					System.out.println( "This calendar is Disabled");
						Assert.assertTrue(true);
				}
				else
				{
					System.out.println( "This calendar is Enabled");
					Assert.assertTrue(false);
				}
				
				
				Thread.sleep(1000);
				//Submit your request
				driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
				
				
				
	}

}
