import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartEcommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Chrome launch
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Find all elements with Product names
		List<WebElement> allProductNamesList = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<allProductNamesList.size(); i++)
		{
			String singleProductName = allProductNamesList.get(i).getText();
			
			if(singleProductName.contains("Cucumber"))
			{
				//Now when we have found product with the desirable name, we want to click on the Add to cart button
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
		
		
		
		
	}

}
