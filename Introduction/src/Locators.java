import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//Chrome launch
				// chromedriver.exe
				System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
				
				//webdriver.chrome.driver is a key value, a property
				WebDriver driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
				driver.findElement(By.id("inputUsername")).sendKeys("Jovan K");
				driver.findElement(By.name("inputPassword")).sendKeys("Jovan");
				
				driver.findElement(By.className("signInBtn")).click();
				//driver.findElement(By.cssSelector("p.error")).getText();
				System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
				driver.findElement(By.linkText("Forgot your password?")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Lillian");
				driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("something@something.com");
				driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
				driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("lillian@something.com");
				driver.findElement(By.xpath("//form/input[3]")).sendKeys("0655555555");
				driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
				System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
				driver.findElement(By.className("go-to-login-btn")).click();
				
				//Now with the proper credentials
				driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
				driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("input#chkboxOne")).click();
				driver.findElement(By.cssSelector("button.signInBtn")).click();
				
				// After a successful login
				Thread.sleep(2000);
				System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText());
				driver.findElement(By.cssSelector("button.logout-btn")).click();
				
				
				
				
				// Nesto moje za vezbanje
				//driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
				//driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("contact@rahulshettyacademy.com");
				//driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
				//driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahulshettyacademy123");
				//driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
				//driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("0111111111");
				
		
		
	}

}
