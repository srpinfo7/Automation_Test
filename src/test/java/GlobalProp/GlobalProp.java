package GlobalProp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Ecommerce.EcommerceOder.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalProp {

	public LoginPage login;
	public WebDriver driver;
	public WebDriver inializeDriver() throws IOException
	{
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//GlobalProperties.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		ChromeOptions options=new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")) {
			options.addArguments("browser");
		}
		driver= new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else
		{
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		return driver;

	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage lunchApp() throws IOException
	{
		driver=inializeDriver();
		login = new LoginPage(driver);
		login.goTo();
		return login;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException
	{
		String jsonContent=FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}
	
	
	public String takeScreeShot(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File source = screenShot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
	
}
