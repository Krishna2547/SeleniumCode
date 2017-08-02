package com.krishna.ci;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Test;

public class TestConfigFile extends BaseTest {

	@Test
	public void FetchData() throws Exception{
		File srce = new File("src/main/resources/config.property");
		FileInputStream fis=new FileInputStream(srce);
		Properties pro=new Properties();
		pro.load(fis);	
		String Cpath=pro.getProperty("chromePath");
		System.out.println("Chrome path is "+Cpath);
		driver.get(pro.getProperty("url"));
		System.out.println("The URL is "+pro.getProperty("url"));
	}
}
