package com.krishna.ci;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoCode {
	@Test
	public void demoMethod(){
		
		System.out.println("Integrated Eclipse - Selenium - Maven - GIT");
		System.setProperty("webdriver.gecko.driver", "src/main/resources/ffDriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("testing");

		//driver.findElement(By.name("btnK")).click();
	
			System.out.println("Closing browser");
		driver.quit();
	}
}
