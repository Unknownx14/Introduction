import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TableSorting116Rahul {
	
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
				
				//Get all elements from the first column in the table while still unsorted and create a List using Stream
				List<WebElement> listUnsorted = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"));
				List<String> UIListUnsorted = listUnsorted.stream().map(s->s.getText()).collect(Collectors.toList());	
				
				//Now sort the first column in the table and get the list of those elements
				driver.findElement(By.cssSelector(".table.table-bordered th:nth-child(1)")).click();
				
				List<WebElement> listSorted = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"));
				//Stream of lists
				List<String> streamListSorted = listSorted.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
				List<String> UIListSorted = listSorted.stream().map(s->s.getText()).collect(Collectors.toList());
				
				//Now once we have all the fruits and veggies check if it is sorted in ascending order
				
				Assert.assertEquals(UIListSorted, streamListSorted);
				//Assert.assertEquals(UIListUnsorted, streamListSorted);
				
				
				/*
				//117. Get all the Vegetables and their prices e.g. [Wheat, Tomato, Strawberry, Rice, Potato, 67, 37, 23, 37, 34]
				List<WebElement> listPrices = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[2]"));
				List<String> streamListPrices = listPrices.stream().map(s->s.getText()).collect(Collectors.toList());
				
				Stream<String> mergedStreamLists = Stream.concat(UIListUnsorted.stream(), streamListPrices.stream());
				List<String> listAfterMerged = mergedStreamLists.collect(Collectors.toList());
				System.out.println(listAfterMerged);
				*/
				
				
				//117. For Rice print the price that belongs to rice - WebElements are in Stream, 
				//getPriceVeggie() is our Method
				List<String> listRicePrice = listSorted.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
				listRicePrice.forEach(a->System.out.println(a));
				
				
				
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		 String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
