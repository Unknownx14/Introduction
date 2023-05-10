import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarJK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		
		//These Lists are in the For loops and in the Methods
		//List<WebElement> allDates = driver.findElements(By.cssSelector(".odf-calendar-day"));
		//List<WebElement> allMonths = driver.findElements(By.cssSelector(".odf-calendar-title"));
		
		CalendarJK something = new CalendarJK();
		
		//For loop for searching a desired month Departure
		for (int j=0; j<1;)
		{
			List<WebElement> allMonths = driver.findElements(By.cssSelector(".odf-calendar-title"));
			String singleMonth = allMonths.get(j).getText();
			if(singleMonth.equalsIgnoreCase(wantedMonth))
			{
				something.myMethodJK(driver, wantedDate);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@glyph='arrow-right']")).click();
			}
		}
		
		//Click on the Return and then For loop for searching a desired month Departure
		driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
		
		for (int k=0; k<1;)
		{
			List<WebElement> allMonthsReturn = driver.findElements(By.cssSelector(".odf-calendar-title"));
			String singleMonthReturn = allMonthsReturn.get(k).getText();
			if(singleMonthReturn.equalsIgnoreCase(wantedMonthReturn))
			{
				something.myMethodReturn(driver, wantedDateReturn);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@glyph='arrow-right']")).click();
			}
		}
			
			
	}
	
	//My Methods
	//This Method is for selecting desirable date Departure
	public void myMethodJK (WebDriver driver, String wantedDate) 
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
	public void myMethodReturn (WebDriver driver, String wantedDateReturn) 
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
