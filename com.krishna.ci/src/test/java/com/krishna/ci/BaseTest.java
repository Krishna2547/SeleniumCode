package com.krishna.ci;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	@Parameters({"Browser"})
	@BeforeClass
	public void Start(String Browser){
		try {
			
			if(Browser.equalsIgnoreCase("ff")){
			System.out.println("Launching Firefox browser");
			System.setProperty("webdriver.gecko.driver", "src/main/resources/ffDriver/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			}
			else if(Browser.equalsIgnoreCase("chrome"))
			{
				System.out.println("Launching Chrome browser");
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
			}
			
			else{
				
				System.out.println("Select a valid browser "+Browser);
				Assert.fail("Invalid browser choosen");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void End() throws InterruptedException{
		System.out.println("Closing browser");
		Thread.sleep(4000);
		driver.close();
		//driver.quit();
	}
}
