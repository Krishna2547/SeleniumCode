package com.krishna.ci;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearch {
	
	public WebDriver driver;
	JavascriptExecutor jse;
	String Browser = "chrome";
	@BeforeClass
	public void Start(){
		try {
			
			if(Browser == "ff"){
			System.out.println("Launching Firefox browser");
			System.setProperty("webdriver.gecko.driver", "src/main/resources/ffDriver/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			}
			else if(Browser == "chrome"){
				
				System.out.println("Launching Chrome browser");
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
			
			else{
				
				System.out.println("Select a valid browser");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void demoMethod() throws InterruptedException{
		
		System.out.println("Integrated Eclipse - Selenium - Maven - GIT");
		driver.get("https://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("testing");

		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		
		Thread.sleep(4000);
		
		System.out.println(driver.getTitle());
		
		jse=(JavascriptExecutor) driver;
		jse.executeScript("scroll(0,1400)");
		
		driver.findElement(By.linkText("Next")).isDisplayed();
		System.out.println("Next link is displayed");
		driver.findElement(By.linkText("Next")).click();
	}
	
	@AfterClass
	public void End() throws InterruptedException{
		System.out.println("Closing browser");
		Thread.sleep(4000);
		driver.close();
		//driver.quit();
	}
}
