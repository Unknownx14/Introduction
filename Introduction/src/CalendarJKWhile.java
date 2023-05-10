import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarJKWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.opodo.com/");
		
	
		//Input the date in a calendar
		String wantedDate = "29";
		String wantedMonth = "September '22";
		String wantedDateReturn = "7";
		String wantedMonthReturn = "June '23";
		
		//Explicit wait - define the object of the class
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("didomi-notice-agree-button")));
		
		//Click on the accept cookies and then click on the Departure
		driver.findElement(By.id("didomi-notice-agree-button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
		
		//This List is in Methods now
		//List<WebElement> allDates = driver.findElements(By.cssSelector(".odf-calendar-day"));
	
		CalendarJKWhile something = new CalendarJKWhile();
		
		//firstMonthDeparture with the exact locator, so we can use the While loop
		WebElement firstMonthDeparture = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/section[1]/div/div[6]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[3]/div/div[2]/div/div[1]/div/div[2]/div/div[1]"));
		
		while(!firstMonthDeparture.getText().contains(wantedMonth))
		{
			driver.findElement(By.xpath("//span[@glyph='arrow-right']")).click();
		}
		
		something.myMethodJKDepartureWhile(driver, wantedDate);
		
		
		//Click on the Return and choose a month and a date
		driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
		
		WebElement firstMonthReturn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/section[1]/div/div[6]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[4]/div/div[2]/div/div[1]/div/div[2]/div/div[1]"));
		
		while(!firstMonthReturn.getText().contains(wantedMonthReturn))
		{
			driver.findElement(By.xpath("//span[@glyph='arrow-right']")).click();
		}
		
		something.myMethodJKReturnWhile(driver, wantedDateReturn);
				
			
	}
	
	
	//My Methods
	//This Method is for selecting desirable date Departure
	public void myMethodJKDepartureWhile (WebDriver driver, String wantedDate) 
	{
		List<WebElement> allDates = driver.findElements(By.cssSelector(".odf-calendar-day"));
		for(int i=0; i<allDates.size(); i++)
		{
			String singleDate = allDates.get(i).getText();

			if (singleDate.equalsIgnoreCase(wantedDate))
			{
				System.out.println(singleDate);
				allDates.get(i).click();
				break;
			}
		}
	}
	
	//This Method is for selecting desirable date Return
	public void myMethodJKReturnWhile (WebDriver driver, String wantedDateReturn) 
	{
		List<WebElement> allDates = driver.findElements(By.cssSelector(".odf-calendar-day"));
		for(int i=0; i<allDates.size(); i++)
		{
			String singleDate = allDates.get(i).getText();

			if (singleDate.equalsIgnoreCase(wantedDateReturn))
			{
				System.out.println(singleDate);
				allDates.get(i).click();
				break;
			}
		}
	}
	

}
