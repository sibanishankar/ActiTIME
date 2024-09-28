package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	public Properties prop;
	
	@BeforeClass
	public void setup() throws IOException
	{
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream fis=new FileInputStream(properties_path);
		prop=new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}