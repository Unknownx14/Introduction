import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions/");
		
		//Input the date in a calendar
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("travel_date")));
		js.executeScript("window.scrollBy(0,100)");
		
		//Explicit wait - define the object of the class
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(55));
				//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cc_btn.cc_btn_accept_all")));
				//driver.findElement(By.cssSelector(".cc_btn.cc_btn_accept_all")).click();
				//w.until(ExpectedConditions.visibilityOfElementLocated(By.className("sumome-react-svg-image-container")));
				//driver.findElement(By.className("sumome-react-svg-image-container")).click();
		
		
		driver.findElement(By.id("travel_date")).click();
					
		String wantedDate = "29";
		String wantedMonth = "September '22";
		
		List<WebElement> allDates = driver.findElements(By.cssSelector(".day"));
		for (int i=0; i<allDates.size(); i++)
		{
			String singleDate = allDates.get(i).getText();
			if(singleDate.equalsIgnoreCase(wantedDate))
			{
				allDates.get(i).click();
				break;
			}
		}
		
		
		
	/*	//Input the date in a calendar
		String wantedDate = "21";
		String wantedMonth = "August '22";
		driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
		
		//Explicit wait - define the object of the class
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("didomi-notice-agree-button")));
		
		driver.findElement(By.id("didomi-notice-agree-button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
		
		List<WebElement> allDates = driver.findElements(By.cssSelector(".odf-calendar-day"));
		//List<WebElement> allMonths = driver.findElements(By.cssSelector(".odf-calendar-title"));
		
		Calendar something = new Calendar();
		
		
		for (int j=0; j<1; j++)
		{
			List<WebElement> allMonths = driver.findElements(By.cssSelector(".odf-calendar-title"));
			String singleMonth = allMonths.get(j).getText();
			if(singleMonth.equalsIgnoreCase(wantedMonth))
			{
				something.myMethod(driver, allDates, wantedDate);
			}
			else
			{
				driver.findElement(By.xpath("//span[@glyph='arrow-right']")).click();
			}
		}
		
		/*for(int i=0; i<allDates.size(); i++)
		{
			String singleDate = allDates.get(i).getText();

			if (singleDate.equalsIgnoreCase(wantedDate))
			{
				System.out.println(singleDate);
				allDates.get(i).click();
				break;
			}
		}*/
		
		
	}
	
	
	//My Method
	public void myMethod (WebDriver driver, List<WebElement> allDates, String wantedDate) 
	{
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
	

}
