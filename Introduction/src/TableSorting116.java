import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TableSorting116 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		
		//For switching to another window or tab
				Set<String> windowsAll = driver.getWindowHandles(); // Set<String> for this getWindowHandles()
				Iterator<String> iter = windowsAll.iterator(); //import java.util.Iterator;
				String parentId = iter.next();
				String childId = iter.next();
				
				//Now we switched to another window or tab
				driver.switchTo().window(childId);
				
				//Get all elements from the first column in the table while still unsorted
				List<WebElement> listUnsorted = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"));
				List<String> allUnsorted = new ArrayList<String> ();
				
				for(int i=0; i<listUnsorted.size(); i++)
				{
					
					allUnsorted.add(listUnsorted.get(i).getText());
					System.out.println(allUnsorted.get(i));
					
				}
				
				
				
				//Now sort the first column in the table and get the list of those elements
				driver.findElement(By.cssSelector(".table.table-bordered th:nth-child(1)")).click();
				
				List<WebElement> listSorted = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"));
				List<String> allSorted = new ArrayList<String> ();
				
				for(int i=0; i<listSorted.size(); i++)
				{
					
					allSorted.add(listSorted.get(i).getText());
					System.out.println(allSorted.get(i));
					
				}
				
				
				//Now once we have all the fruits and veggies check if it is sorted in ascending order
				List<String> streamListUnsorted = allUnsorted.stream().collect(Collectors.toList());
				List<String> streamListSorted = allSorted.stream().sorted().collect(Collectors.toList());
				Assert.assertEquals(allSorted, streamListSorted);
				//Assert.assertEquals(streamListUnsorted, allSorted);
				
				//Summary - Uzeo sam nesortovanu listu i sortovao je preko Stream, onda sam na UI sortovao i uzeo tu listu i na kraju
				//uporedio te dve liste
				
	}

}
