package com.actitime.pages;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.actitime.generics.BasePage;
import com.actitime.generics.Screenshot;

public class HomePage extends BasePage
{
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	
	@FindBy(xpath = "(//*[text()='Logout'])[1]")
	private WebElement logoutLink;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logoutMethod() throws IOException, InterruptedException
	{
		//javascriptHighlightElement(driver, logoutLink);
		javascriptClick(driver, logoutLink);
	}
}