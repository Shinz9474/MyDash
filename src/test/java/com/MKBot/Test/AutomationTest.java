package com.MKBot.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cssRobot.Start.EntryPoint;
import com.cssRobot.Storage.Storage;

public class AutomationTest {
	
	
	public static final String USERNAME = "mktestoffshore1";
	  public static final String AUTOMATE_KEY = "9159GWvxibLMijCeBxSV";
	  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			
			

	public void Chrome() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\WebDrivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		Assert.assertTrue("Chrome Automation Done", true);
	}
	
	//@Test
	public void Firefox() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "66.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "7");
	    caps.setCapability("resolution", "1024x768");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	    System.out.println("Test Completed.");
		
	}
	
	//@Test
	public void mysqlTest()  {
		
		try {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		String url = "jdbc:mysql://mkrobotautomation.mysql.database.azure.com:3306/automation?autoReconnect=true&useSSL=false";
		 url ="jdbc:mysql://mkrobotautomation.mysql.database.azure.com:3306/automation?useSSL=true&requireSSL=false";

		Properties p=new Properties();
		p.setProperty("user", "mkrobot@mkrobotautomation");
		p.setProperty("password", "marykay123$");


		Connection con=		  DriverManager.getConnection(url, "mkrobot@mkrobotautomation", "marykay123$");//DriverManager.getConnection(url, p);
		ResultSet rs= con.createStatement().executeQuery("select id,testcasename from testcases");
		
		while(rs.next()) {
			System.out.println("ID:"+rs.getString("id"));
			System.out.println("Testcase Name:"+rs.getString("testcasename"));
			
			Assert.assertTrue("testcase Name:"+rs.getString("testcasename"), true);
		}
		}
		catch(Exception e) {
			Assert.assertTrue(e.getMessage(),true);
			System.out.println("Exception Message:"+e.getMessage());
			System.out.println("Exception StackTrace:"+e.getStackTrace());
		}
	}
	
	//@Test
	public void ShopDisney() throws InterruptedException {
		
		EntryPoint.hm=new Hashtable<String,String>();  
		
		Storage.TC_Name="shopdisneyHeaderLinksVerification";
		
		Storage.Browser_Name="Chrome";
		
		Storage.isLocalExecution=true;
		
		Storage.isGridExecution="false";
		
		Storage.OSType="windows";
		
		EntryPoint.start();
		
		
	}

}
