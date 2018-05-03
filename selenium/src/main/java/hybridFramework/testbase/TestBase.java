package hybridFramework.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	public Properties OR;
	public File f1;
	public FileInputStream file; 
	
	public void getBrowser(String browser){
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("user.dir"));
				driver = new FirefoxDriver();
				driver.get("https://wwww.google.com");
				
				
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Tools\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			
		}
		if(System.getProperty("os.name").contains("Mac")){
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println(System.getProperty("user.dir"));
				driver = new FirefoxDriver();
				
				
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Tools\\chromedriver");
				driver = new ChromeDriver();
				
			}
			
		}
		
	}
	public void loadPropertiesFile() throws IOException{
		
		 OR = new Properties();
		 f1 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\config\\config.properties");
	     file = new FileInputStream(f1);
		 OR.load(file);
		 
		 f1 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\config\\or.properties");
	     file = new FileInputStream(f1);
		 OR.load(file);
		
		
	}
	
	public void takeScreenshot(String imagename) throws IOException{
		
		if(imagename.equals("")){
			imagename="blank";
			
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir")+"\\src\\main\\java\\hybridFramework\\screenshots\\";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImagename = imagelocation+imagename+"_"+formater.format(calendar.getTime()+".png");
		File destFile = new File(actualImagename);
		FileUtils.copyFile(image, destFile);
		
	}
	
	public void getPropertiesData(){
		
	}
	
	public static void main(String[] args) throws IOException{
		TestBase test = new TestBase();
		//test.getBrowser("firefox");
		test.loadPropertiesFile();
		System.out.println(test.OR.getProperty("url"));
		System.out.println(test.OR.getProperty("testname"));
		
	}

}
