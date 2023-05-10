import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterTables120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		String desiredVeggie = "ppl";
		
		//Using Stream, filer all veggies by this desiredVeggie variable - imitate backend process
		List<String> emptyListJK = new ArrayList<String>();
		String nextButton;
		String something="false";

		do
		{
		
		nextButton = driver.findElement(By.cssSelector("[aria-label='Next']")).getAttribute("aria-disabled");
		System.out.println(nextButton);
		List<WebElement> originalList = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"));
		//List<String> originalListPerPage =  originalList.stream().filter(s->s.getText().contains(desiredVeggie)).map(s->s.getText()).collect(Collectors.toList());
		//The line above is used if we want to filter right away
		List<String> originalListPerPage =  originalList.stream().map(s->s.getText()).collect(Collectors.toList());

		emptyListJK.addAll(originalListPerPage);
		
		if(nextButton.equals(something))
		{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(nextButton.equals(something));
		
		System.out.println("All veggies in backend "+emptyListJK);
		
		//Here apply a filter on a list of all veggies in the backend
		List<String> listAllWithFilter = emptyListJK.stream().filter(s->s.contains(desiredVeggie)).collect(Collectors.toList());
		
		System.out.println("Applied filter in backend "+listAllWithFilter);	
		
		
		//Now do the same on the UI and get the list of veggies with applied filter
		driver.findElement(By.id("search-field")).sendKeys(desiredVeggie);
		
		List<String> emptyListUI = new ArrayList<String>();
		do
		{
			
			nextButton = driver.findElement(By.cssSelector("[aria-label='Next']")).getAttribute("aria-disabled");	
		List<WebElement> listAppliedFilter = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"));
		List<String> listUIFilter = listAppliedFilter.stream().map(s->s.getText()).collect(Collectors.toList());
		
		emptyListUI.addAll(listUIFilter);
		
		if(nextButton.equals(something))
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(nextButton.equals(something));
		
		System.out.println("Applied filter in UI "+emptyListUI);
		
		Assert.assertEquals(listAllWithFilter, emptyListUI);

		
		
		
		
	}

}
