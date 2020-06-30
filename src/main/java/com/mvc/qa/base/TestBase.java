package com.mvc.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mvc.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop=new Properties();
			//FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"E:\\Photon_Workspace\\ToDoMvc\\src\\main\\java\\com\\mvc\\qa\\config\\config.properties");
			FileInputStream ip=new FileInputStream("E:\\Photon_Workspace\\ToDoMvc\\src\\main\\java\\com\\mvc\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
	}
	
	

}
	
	public static void initialization() {
		
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Photon_Workspace\\ToDoMvc\\Drivers\\chromedriver_83.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Photon_Workspace\\ToDoMvc\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
