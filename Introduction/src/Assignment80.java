import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//Explicit wait - define the object of the class
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//Populating the initial page
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[text()=' User']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select chooseDropdown =  new Select(staticDropdown);
		chooseDropdown.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		//New page is opened
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));
		List<WebElement> myListOfProducts = driver.findElements(By.xpath("//button[text()='Add ']"));
		for(int i=0; i<myListOfProducts.size(); i++)
		{
			//String allProducts= myListOfProducts.get(i).getText();
			//myListOfProducts.get(i).click();
			driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();
		}
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		
		//Again new page is opened
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Total']")));
		System.out.println( driver.findElement(By.cssSelector(".glyphicon.glyphicon-shopping-cart")).getText());
		System.out.println( driver.findElement(By.cssSelector(".btn.btn-success")).getText());
		System.out.println( driver.findElement(By.xpath("//h3[text()='Total']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Total']")).getText(), "Total");
		
		
		
	}

}
