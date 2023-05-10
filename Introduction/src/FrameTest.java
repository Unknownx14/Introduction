import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//Count how many iFrames are there so we can use an index of an iFrame
		System.out.println( driver.findElements(By.tagName("iframe")).size()+ " is the number of iFrames");
		
		//Switch to iFrame
		WebElement myiFrame = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(myiFrame);
		driver.findElement(By.id("draggable")).click();
		
		//We need the Actions class
		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		
		//Switch back from the iFrame
		driver.switchTo().defaultContent();
		
	}

}
