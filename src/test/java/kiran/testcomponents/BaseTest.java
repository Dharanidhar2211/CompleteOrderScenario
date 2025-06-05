package kiran.testcomponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Kiran.PageObjects.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Properties;
public class BaseTest 
{
	public WebDriver driver;
	public LoginPage loginpage;
	public WebDriver LaunchDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\DHARANIDHAR\\eclipse-workspace\\CompleteOrderPlacemenet\\src\\main\\java\\Kiran\\resources\\Data.properties");
		prop.load(fis);
		String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("FireFox"))
		{
			 driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	@BeforeMethod(alwaysRun = true)
	public LoginPage InitinilizeDriver() throws IOException
	{
		 driver=LaunchDriver();
		 loginpage=new LoginPage(driver);
		 loginpage.GoTO();
		 return loginpage;	 
	}
	@AfterMethod(alwaysRun = true)
	public void End()
	{
		loginpage.Close();
	}
	public List<HashMap<String, String>> GetJsonData(String filepath) throws IOException
	{
		String Jsondata=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(Jsondata, new TypeReference<List<HashMap<String ,String>>>() {});
		return data;
		
	}
	public String GetScreenshotHandles(String TestCaseName,WebDriver driver) throws IOException
	{
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"//Reports//"+TestCaseName+".png"));
		return System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
	}

}
