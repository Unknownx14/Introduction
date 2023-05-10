import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment103a {

	public static void main(String[] args) {
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
		driver.get("https://qaclickacademy.com/");
		
		
		//Explicit wait - define the object of the class
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='NO THANKS']")));
		driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		
		driver.findElement(By.xpath("//a[text()='Practice']")).click();
		
		
		//Print the number of all rows in the first table
		List<WebElement> allRows = driver.findElements(By.cssSelector(".table-display tr"));
		
		int sumOfRows =0;
		for (int i=0; i<allRows.size(); i++)
		{
			allRows.get(i);
			sumOfRows++;
		}
		
		System.out.println(sumOfRows+" is the total number of rows");
		
		
		//Print the number of all headers in the first table
				List<WebElement> allHeaders = driver.findElements(By.cssSelector(".table-display th"));
				
				int sumOfHeaders =0;
				for (int j=0; j<allHeaders.size(); j++)
				{
					allHeaders.get(j);
					sumOfHeaders++;
				}
				
				System.out.println(sumOfHeaders+" is the total number of headers");
		
		
		// Print the entire second row in this table
				List<WebElement> allRowsInstructor = driver.findElements(By.cssSelector(".table-display td:nth-child(1)"));
				List<WebElement> allRowsCourse = driver.findElements(By.cssSelector(".table-display td:nth-child(2)"));
				List<WebElement> allRowsPrice = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
				
				int askedRow = 1;
				
				for (int a=0; a<allRowsInstructor.size(); a++)
				{
					allRowsInstructor.get(a).getText();
					if(a==askedRow)
					{
						System.out.println(allRowsInstructor.get(a).getText());
					}
				}
				
				for (int b=0; b<allRowsCourse.size(); b++)
				{
					allRowsInstructor.get(b).getText();
					if(b==askedRow)
					{
						System.out.println(allRowsCourse.get(b).getText());
					}
				}
				
				for (int c=0; c<allRowsPrice.size(); c++)
				{
					allRowsInstructor.get(c).getText();
					if(c==askedRow)
					{
						System.out.println(allRowsPrice.get(c).getText());
					}
				}
				
				
	}

}
