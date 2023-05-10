import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartCommerce2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Chrome launch
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Make an Array of all the products we want to search for
		String[] wantedItems = {"Cucumber", "Brocolli", "Beetroot", "Raspberry"};
		int numberOfWantedItems = wantedItems.length;   //found the number of items
		System.out.println("numberOfWantedItems is " + numberOfWantedItems);
		int j=0;
		
		//Find all elements with Product names
		List<WebElement> allProductNamesList = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<allProductNamesList.size(); i++)
		{
			String[] singleProductName = allProductNamesList.get(i).getText().split("-");
			//After getting singleProductName we have to trim it so there is only name (Cucumber) not Cucumber - 1 kg
			//That's why we used this split()
			String formatedNameItem = singleProductName[0].trim();
			
			//Naknadno ubaceno - convert Array into ArrayList
			//Then check whether an Item is presented in this ArrayList
			List alJKArrList = Arrays.asList(wantedItems);
			
			
			if(alJKArrList.contains(formatedNameItem))
			{
				//Now when we have found product with the desirable name, we want to click on the Add to cart button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//break; cannot be used in Array list
				j++;
				if(j==numberOfWantedItems)   //Used the found the number of items so when it searches for all of them, it could get out of Loop (break)
				{
					System.out.println("There are "+j + " items in the List");
					break;
				}
			}
		}
		
		
		
		
	}

}
