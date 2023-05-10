import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class InvokingMultipleWindows125 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver(); //This object has to be put as an argument
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Open a new window - Invoking a new window or a new tab
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		
		//For switching to another window or tab
		Set<String> windowsAll = driver.getWindowHandles(); // Set<String> for this getWindowHandles()
		Iterator<String> iter = windowsAll.iterator(); //import java.util.Iterator;
		String parentId = iter.next();
		String childId = iter.next();
		
		//Now we switched to another window or tab
		driver.switchTo().window(childId);
		
		driver.get("https://rahulshettyacademy.com/");
		//String name = driver.findElement(By.xpath("//div[@class='upper-box']//h2")).getText();
		
		//Using a Stream to get the text
		List<WebElement> allCourses = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
		List<String> allCoursesNames = allCourses.stream().map(s->s.getText()).collect(Collectors.toList());
		String name01 = allCoursesNames.get(1);
		
		//Now we switched to another window or tab
		driver.switchTo().window(parentId);
		WebElement nameField = driver.findElement(By.cssSelector("input[name='name']"));
		nameField.sendKeys(name01);
		
		//Take a screenshot of this WebElement; We capture a screenshot (fileJK) and convert it to a physical file (new File("logo.png"))
		File fileJK = nameField.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(fileJK, new File("logo.png")); //Source file (fileJK) and destination(target) file (new File("logo.png"))
		
		//Get Height and Width of a WebElement
		System.out.println( nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
		
		
	}

}
