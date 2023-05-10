import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileDownloadDynamic348 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		//How to get a path of this project
				String downloadPath = System.getProperty("user.dir");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\JK\\chromedriver_win32\\chromedriver.exe");
		//webdriver.chrome.driver is a key value, a property
		
		//This is a Hashmap for something and is copy/paste
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		//This goes before WebDriver and is set in the brackets of this ChromeDriver(options) and is used for setting preferences for 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/jpg_to_pdf");
		
		driver.findElement(By.xpath("//span[text()='Select JPG images']")).click();
		Thread.sleep(1000);
		
		//This clas Runtime is used for executing .exe files
		Runtime.getRuntime().exec("C:\\Users\\joko2909\\Desktop\\Prntscr\\Prnt for a bug\\14.06\\fileUpload.exe");
		
		//Explicit wait - define the object of the class
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				w.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
				
		driver.findElement(By.id("processTaskTextBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		
		//This class
		File f = new File(downloadPath + "/Jenkins01.pdf");
		f.exists();
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			System.out.println("The file has been downloaded");
			if(f.delete())
			{
				System.out.println("The downloaded file has been deleted");
			}
		}
		else
		{
			System.out.println("The file has NOT been downloaded");
		}
		
		
		
	}
	
	/*HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

	chromePrefs.put("profile.default_content_settings.popups", 0);

	chromePrefs.put("download.default_directory", downloadPath);*/

}
