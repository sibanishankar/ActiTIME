package com.actitime.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
		//WebDriver Interface
		public void validateTitle(WebDriver driver, String expectedTitle)
		{
			Assert.assertEquals(driver.getTitle(),expectedTitle,"both titles are not matching");
		}

		public void validateCurrentURL(WebDriver driver, String expectedURL)
		{
			Assert.assertEquals(driver.getCurrentUrl(),expectedURL,"both url's are not matching");
		}

		//WebElement Interface --- completed
		public void clearText(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			Assert.assertEquals(element.getAttribute("value").isEmpty(), true,"text not cleared");
			Reporter.log("text is cleared", true);
		}

		public void clearDelete(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL,"a");
			element.sendKeys(Keys.DELETE);
			Assert.assertEquals(element.getAttribute("value").isEmpty(), true,"text not deleted");
			Reporter.log("text is deleted",true);
		}

		public void clearBackspace(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL,"a");
			element.sendKeys(Keys.BACK_SPACE);
			Assert.assertEquals(element.getAttribute("value").isEmpty(), true,"text not deleted");
		}

		public void clearSingleBackspace(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.BACK_SPACE);
		}

		public void copyPaste(WebElement copyElement,WebElement pasteElement, WebDriver driver, String text, String expectedText)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(copyElement));
			wait.until(ExpectedConditions.visibilityOf(pasteElement));
			copyElement.sendKeys(Keys.CONTROL,"a");
			copyElement.sendKeys(Keys.CONTROL,"c");
			pasteElement.sendKeys(Keys.CONTROL,"v");
			Assert.assertEquals(pasteElement.getAttribute("value").equals(text), expectedText,"not copied properly");
		}

		public void cutPaste(WebElement copyElement,WebElement pasteElement, WebDriver driver, String text, String expectedText)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(copyElement));
			wait.until(ExpectedConditions.visibilityOf(pasteElement));
			copyElement.sendKeys(Keys.CONTROL,"a");
			copyElement.sendKeys(Keys.CONTROL,"c");
			pasteElement.sendKeys(Keys.CONTROL,"v");
			Assert.assertEquals(pasteElement.getAttribute("value").equals(text), expectedText,"not copied properly");
		}

		public void enter(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.ENTER);
		}

		public void getElementAttribute(WebElement element, WebDriver driver, String attribute, String value, String expectedValue)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(element.getAttribute(attribute).equals(value), expectedValue, "attribute value is not matching");
		}

		public void getElementCssValue(WebDriver driver, WebElement element, String cssValue)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log(element.getCssValue(cssValue),true);
		}

		public void getElementLocation(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Point point=element.getLocation();
			Reporter.log("x-axis location of element is : " +point.getX(),true); 
			Reporter.log("y-axis location of element is : " +point.getY(),true); 
		}

		public void getElementSize(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Dimension dimension=element.getSize();
			Reporter.log("width of element is : " +dimension.getWidth(),true); 
			Reporter.log("height of element is : " +dimension.getHeight(),true); 
		}

		public void getElementTagName(WebElement element, WebDriver driver, String expectedTagname)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(element.getTagName(), expectedTagname, "tag name is matching");
		}

		public void validateText(WebElement element, WebDriver driver,String expectedText)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(element.getText(), expectedText,"both text are not matching");
		}

		public void replaceElementText(WebElement sourceElement, WebElement targetElement,WebDriver driver,String targetValue, String expectedText)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(sourceElement));
			wait.until(ExpectedConditions.visibilityOf(targetElement));
			sourceElement.clear();
			targetElement.sendKeys(targetValue);
			Assert.assertEquals(targetElement.getAttribute("value"), expectedText,"both text are not matching");
		}

		public void elementDisplayed(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(element.isDisplayed(), "true" , "element is not displayed");
		}

		public void elementEnabled(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(element.isEnabled(), "true" , "element is not enabled");
		}

		public void elementSelected(WebElement element, WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertEquals(element.isSelected(), "true" , "element is not selected");
		}

		//Select Class --- completed
		public void selectByText(WebDriver driver, WebElement element, String text)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.selectByVisibleText(text);
		}

		public void selectByValue(WebDriver driver ,WebElement element, String value)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.selectByValue(value);
		}

		public void selectByIndex(WebDriver driver,WebElement element, int index)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.selectByIndex(index);
		}

		public void deselectByText(WebDriver driver,WebElement element, String text)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.deselectByVisibleText(text);
		}

		public void deselectByValue(WebDriver driver,WebElement element, String value)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.deselectByValue(value);
		}

		public void deselectByIndex(WebDriver driver,WebElement element, int index)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.deselectByIndex(index);
		}

		public void deselectAll(WebDriver driver,WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			select.deselectAll();
		}

		public void selectIsMultiple(WebDriver driver,WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select=new Select(element);
			Assert.assertEquals(select.isMultiple(), true,"dropdown is not multiple");
		}

		public void getAllOptions(WebDriver driver,List<WebElement> elements, WebElement element, int expectedSize)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			Select select=new Select(element);
			List<WebElement> allOptions=select.getOptions();
			Reporter.log("size of the list is : " +allOptions.size(), true);
			Assert.assertEquals(allOptions.size(), expectedSize, "size is not matching as expected");
		}

		public void getSelectedOptions(WebDriver driver,List<WebElement> elements, WebElement element, int expectedSize)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			Select select=new Select(element);
			List<WebElement> allSelectedOptions=select.getAllSelectedOptions();
			Reporter.log("size of the list is : " +allSelectedOptions.size(), true);
			Assert.assertEquals(allSelectedOptions.size(), expectedSize, "size is not matching as expected");
		}

		public void getFirstSelectedOption(WebElement element, String expectedFirstSelected)
		{
			Select select=new Select(element);
			WebElement firstSelectedOption=select.getFirstSelectedOption();
			Reporter.log("first selected option is : " +firstSelectedOption.getText());
			Assert.assertEquals(firstSelectedOption.getText(), expectedFirstSelected, "text is not matching as expected");
		}

		//Actions Class --- completed
		public void clickOnElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.moveToElement(element).click().perform();
		}

		public void doubleclickOnElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.moveToElement(element).doubleClick().perform();
		}

		public void contextclickOnElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.moveToElement(element).contextClick().perform();
		}

		public void moveToElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.moveToElement(element).perform();
		}

		public void scrollToElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.scrollToElement(element).perform();
		}

		public void clickHoldElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.clickAndHold(element).perform();
		}

		public void releaseElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.release(element).perform();
		}

		public void enterDataElement(WebDriver driver, WebElement element, String value)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.sendKeys(value).pause(Duration.ofSeconds(2)).perform();;
		}

		public void dragDropElement(WebDriver driver, WebElement sourceElement, WebElement targetElement)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(sourceElement));
			wait.until(ExpectedConditions.visibilityOf(targetElement));
			Actions actions=new Actions(driver);
			actions.dragAndDrop(sourceElement, targetElement).perform();
		}

		public void dragDropSlider(WebDriver driver, WebElement element, int x, int y)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions actions=new Actions(driver);
			actions.dragAndDropBy(element, x, y).perform();;
		}

		//ChromeOptions Class --- completed
		public void chromeHeadless()
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
		}

		public void chromeStartMaximized()
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("start-maximized");
		}

		public void chromeBlockNotification()
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("disable-notifications");
		}

		public void chromeIncognito()
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("incognito");
		}

		public void chromeInsecureWebsiteHandle()
		{
			ChromeOptions options=new ChromeOptions();
			options.setAcceptInsecureCerts(true);
		}

		public void chromeAddExtension(String extensionPath)
		{
			ChromeOptions options=new ChromeOptions();
			options.addExtensions(new File(extensionPath));
		}

		//Robot Class
		public void robotEnter() throws AWTException
		{
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		//WebdriverWait Class
		public void waitTitleIs(WebDriver driver, String title)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(title));
		}

		public void waitTitleContains(WebDriver driver, String partialTitle)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleContains(partialTitle));
		}

		public void waitUrlMatches(WebDriver driver, String url)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlMatches(url));
		}

		public void waitUrlContains(WebDriver driver, String partialUrl)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains(partialUrl));
		}

		//Alert Interface
		public void alertAccept(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
			Reporter.log("text of alert is : "+driver.switchTo().alert().getText(), true);
			driver.switchTo().alert().accept();
		}

		public void alertDismiss(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
			Reporter.log("text of alert is : "+driver.switchTo().alert().getText(), true);
			driver.switchTo().alert().dismiss();
		}

		public void alertEnter(WebDriver driver, String text)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.alertIsPresent());
			Reporter.log("text of alert is : "+driver.switchTo().alert().getText(), true);
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(text);
			alert.accept();
		}

		//Handling Multiple Windows
		public void parentWindow(WebDriver driver, String partialTitle, String expectedTitle)
		{
			String parentWindow=driver.getWindowHandle();
			driver.switchTo().window(parentWindow);
			Assert.assertEquals(driver.getTitle().contains(partialTitle), expectedTitle, "both titles are not matching");
		}

		public void allWindows(WebDriver driver, String partialTitle, String expectedTitle)
		{
			Set<String> allWindows=driver.getWindowHandles();
			List<String> al=new ArrayList(allWindows);
			for(int i=0;i<al.size();i++)
			{
				driver.switchTo().window(al.get(i));
				Assert.assertEquals(driver.getTitle().contains(partialTitle), expectedTitle, "titles are not matching");
			}
		}

		//JavasriptExecutor Interface --- completed
		public void javascriptClick(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", element);
		}

		public void javascriptEnter(WebDriver driver, WebElement element, String value)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(value, element);
		}

		public void javascriptHighlightElement(WebDriver driver, WebElement element) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style', 'background:green')", element);
			Thread.sleep(2000);
			js.executeScript("arguments[0].setAttribute('style', 'background:white')", element);
		}

		public void javascriptRefresh(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("history.go(0)");
		}

		public void javascriptScrollElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			int x=element.getLocation().getX();
			int y=element.getLocation().getY();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+x+","+y+")");
		}

		public void javascriptScrollPageEnd(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}

		public void javascriptScrollView(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}

		public void javascriptGetTitle(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			System.out.println(js.executeScript("return document.title"));
		}

		public void javascriptGetCurrentUrl(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			System.out.println(js.executeScript("return document.URL"));
		}

		public void javascriptCreateAlertPopup(WebDriver driver, String alerttext)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(alerttext);
		}

		public void javascriptCreateConfirmPopup(WebDriver driver, String confirmtext)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(confirmtext);
		}

		public void javascriptCreatePromptPopup(WebDriver driver, String prompttext)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(prompttext);
		}
}