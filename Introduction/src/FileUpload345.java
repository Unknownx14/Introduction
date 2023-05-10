import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload345 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/jpg_to_pdf");
		
		driver.findElement(By.xpath("//span[text()='Select JPG images']")).click();
		Thread.sleep(1000);
		
		//This clas Runtime is used for executing .exe files
		Runtime.getRuntime().exec("C:\\Users\\joko2909\\Desktop\\Prntscr\\Prnt for a bug\\14.06\\fileUpload.exe");
		
	}

}
