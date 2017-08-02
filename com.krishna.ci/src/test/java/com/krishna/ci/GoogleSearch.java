package com.krishna.ci;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class GoogleSearch extends BaseTest{
	
	JavascriptExecutor jse;
	@Test(priority = 1, description="This test case will perform Google search")
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
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	@Test(dependsOnMethods="demoMethod")
	public void TestGoogle(){
		System.out.println("Learning testNG");
		
	}
	
	
}
