package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public static WebDriver getdriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-3.141.59\\chromedriver_win32\\84\\chromedriver.exe");
		ChromeDriver  driver = new ChromeDriver();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\FirstCucumberE2E\\src\\test\\java\\Common\\ProDetails.properties");
		prop.load(fis);

	    System.out.println("chrome lauched");
		driver.get(prop.getProperty("url"));
		
		//Mazimize current window
		driver.manage().window().maximize();
		
		//wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		return driver;
	}
}

