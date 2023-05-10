import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive146 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//Class Properties is used for getting the global variables from some .properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\joko2909\\SeleniumTraining\\Introduction\\src\\dataRahul.properties");
		prop.load(fis); //load reads from the .properties file
		//prop.getProperty("browser") to get one of properties from .properties file
		System.out.println( prop.getProperty("browser"));
		System.out.println( prop.getProperty("url"));
		
		//prop.setProperty("browser", "Firefox") sets a new value
		prop.setProperty("browser", "Firefox");
		System.out.println( prop.setProperty("browser", "Firefox"));
		
		//To change a value in this .properties file
		FileOutputStream fos = new FileOutputStream("C:\\Users\\joko2909\\SeleniumTraining\\Introduction\\src\\dataRahul.properties");
		
		prop.store(fos, null); //here is null but we can insert some comment instead, store is used to write in the .properties file
		
		
	}

}
