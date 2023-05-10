import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment62 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome launch
		
				System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
				//webdriver.chrome.driver is a key value, a property
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.rahulshettyacademy.com/angularpractice/");
				
				driver.findElement(By.name("name")).sendKeys("Jovan");
				driver.findElement(By.name("email")).sendKeys("contact@rahulshettyacademy.com");
				//driver.findElement(By.name("email")).click();
				driver.findElement(By.id("exampleInputPassword1")).sendKeys("rahulshettyacademy");
				driver.findElement(By.id("exampleCheck1")).click();
				driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']/option[2]")).click();
				driver.findElement(By.id("inlineRadio1")).click();
				Thread.sleep(1000);
				driver.findElement(By.name("bday")).sendKeys("09291982");
				driver.findElement(By.cssSelector("input.btn-success")).click();
				Thread.sleep(2000);
				//System.out.println( driver.findElement(By.xpath("//div[text()='Email is required']")).getText());
				//Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Email is required']")).getText(), "Email is required");
				driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText();
				System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());
				
		
		
		
		
	}

}
