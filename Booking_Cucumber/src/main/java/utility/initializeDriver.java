
package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class initializeDriver {
 WebDriver driver;
	String readDataFile(String data) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\SUSBHADR\\eclipse-workspace\\Booking_Cucumber\\src\\main\\java\\dta.properties");
		prop.load(fis);
		return prop.getProperty(data);
	}
	public String getUrl() throws IOException
	{
		return this.readDataFile("url");
	}
	public void getBrowser() throws IOException
	{
		String browserName= this.readDataFile("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\CapgeminiDecember Testing\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "C:\\CapgeminiDecember Testing\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();  
		}
	}
}

