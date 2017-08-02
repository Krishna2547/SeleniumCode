package com.krishna.ci;

import org.testng.annotations.Test;

public class Amazon extends BaseTest {

	@Test
	public void testAmazon(){
		
		driver.get("http://www.amazon.in");
		
	}
}
