package com.actitime.pages;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.actitime.generics.AutoConstant;
import com.actitime.generics.BasePage;
import com.actitime.generics.ExcelLibrary;
import com.actitime.generics.Screenshot;;

public class LoginPage extends BasePage implements AutoConstant
{
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	
	@FindBy(id = "username")
	private WebElement usernameTextfield;

	@FindBy(name =  "pwd")
	private WebElement passwordTextfield;
	
	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement keepmeloggedinCheckbox;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	@FindBy(id = "toPasswordRecoveryPageLink")
	private WebElement forgotpasswordLink;
	
	@FindBy(xpath = "//a[starts-with(text(),'actiTIME')]")
	private WebElement actitimeincLink;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginMethod() throws InterruptedException, IOException
	{
		//javascriptHighlightElement(driver, usernameTextfield);
		usernameTextfield.sendKeys(ExcelLibrary.getStringTypeCellData(login_sheet, 1, 0));
		
		//javascriptHighlightElement(driver, passwordTextfield);
		passwordTextfield.sendKeys(ExcelLibrary.getStringTypeCellData(login_sheet, 1, 1));
		
		//javascriptHighlightElement(driver, keepmeloggedinCheckbox);
		javascriptClick(driver, keepmeloggedinCheckbox);
		
		//javascriptHighlightElement(driver, loginButton);
		javascriptClick(driver, loginButton);
	}
}