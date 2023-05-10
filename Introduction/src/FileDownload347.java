import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileDownload347 {

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
		
		//This clas Runtime is used for executing .exe files from AutoIT
		Runtime.getRuntime().exec("C:\\Users\\joko2909\\Desktop\\Prntscr\\Prnt for a bug\\14.06\\fileUpload.exe");
		
		//Explicit wait - define the object of the class
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				w.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
				
		driver.findElement(By.id("processTaskTextBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		
		//This class
		File f = new File("C:\\Users\\joko2909\\Downloads\\Jenkins01.pdf");
		f.exists();
		if(f.exists())
		{
			System.out.println("The file has been downloaded");
		}
		else
		{
			System.out.println("The file has NOT been downloaded");
		}
		
		
		
	}

}
