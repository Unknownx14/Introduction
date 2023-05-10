import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartCommerce3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome launch
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Explicit wait - define the object of the class
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//Make an Array of all the products we want to search for
		String[] wantedItems = {"Cucumber", "Brocolli", "Beetroot", "Raspberry"};
		int numberOfWantedItems = wantedItems.length;   //found the number of items
		System.out.println("numberOfWantedItems is " + numberOfWantedItems);
		//int j=0; This now moved to be in this created method
		
		//Calling this created Method by creating an Object of this Class
		//addItems(driver, wantedItems, numberOfWantedItems);   //This is for a static Method
		CartCommerce3 myObject = new CartCommerce3();
		myObject.addItems(driver, wantedItems, numberOfWantedItems);
		
		
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//Explicit wait for this targeted element
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		//Explicit wait for this targeted element
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");
		System.out.println( driver.findElement(By.className("discountPerc")).getText());
		Assert.assertEquals(driver.findElement(By.className("discountPerc")).getText(), "10%");
		 
	}

	
	
	
	//Create a Method
	public void addItems(WebDriver driver, String[] wantedItems, int numberOfWantedItems)
	{
		
		//Find all elements with Product names
		int j=0; //This now moved here in this method
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
