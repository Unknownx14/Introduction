import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class JavaScripExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Firefox launch
				// geckodriver.exe
				System.setProperty("webdriver.gecko.driver", "C:\\JK\\geckodriver-v0.31.0-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		//WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		
		//Casting the driver into JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		//instead of the code in the line above, use this below - not working for this Chrome version
		List<WebElement> numbersAmount =driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int SumOfAmount = 0;
		for(int i=0; i<numbersAmount.size(); i++)

		{
			String everyAmount = numbersAmount.get(i).getText();
		    System.out.println(everyAmount);
		    int everyAmountInteger =Integer.parseInt(everyAmount); //for parsing a String into an integer
		    SumOfAmount = SumOfAmount + everyAmountInteger;

		}
		
		System.out.println("The sum of Amount is "+SumOfAmount);

		//Compare the sum from adding all Amounts with the sum stated below the table
		String textAmount = driver.findElement(By.cssSelector(".totalAmount")).getText();
		
		String[] splittedText = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
		String justTheNumber = splittedText[1].trim();
		int statedNumber = Integer.parseInt(justTheNumber);
		System.out.println("Stated sum of Amount is "+statedNumber);
		Assert.assertEquals(SumOfAmount, statedNumber);
		

		

		
		
		
		
	}

}
