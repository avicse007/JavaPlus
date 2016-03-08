package com.webautomator.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Keywords {
	private WebDriver driver;
	public static Logger log = Logger.getRootLogger();
	public void executeBrowser(String browserName)throws Exception{
		log.info("Opening the browser :"+browserName);
		if(browserName.equals("chrome")){
			System.out.println("browsername is "+browserName);
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("ie")){
			System.setProperty("webdriver.ie.driver", "driver/chromedriver.exe");
			driver=new InternetExplorerDriver();
		}
		else{
			System.out.println("browsername in firefox is "+browserName);
			driver=new FirefoxDriver();
		}
	}
	public void openBaseUrl(String baseUrl)throws Exception{
		log.debug("Executing openBaseUrl with baseUrl as :"+baseUrl);
			driver.get(baseUrl);
			driver.manage().window().maximize();
	}
	
	public void navigate(String data)throws Exception{
		log.debug("Navigating to :"+data);
		driver.navigate().to(data);
	}
	public void click(String xpath)throws Exception{
		Thread.sleep(2000);
		log.debug("Clicking on the element with xpath : "+xpath);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void verifyText(String xpath,String actualText)throws Exception,AssertionError{
		log.debug("Verifying Ui text with actual text: "+actualText+" with xpath : "+xpath);
		String UiText = driver.findElement(By.xpath(xpath)).getText();
		Assert.assertEquals(UiText, actualText, "Expected string does not matched");
	}
	public void verifyTextContains(String xpath,String actualText)throws Exception,AssertionError{
		log.debug("Verifying that an UI test starts with actual text : "+actualText+" and xpath :"+xpath);
		String UiText = driver.findElement(By.xpath(xpath)).getText();
		boolean isTrue=false;
		if(UiText.contains(actualText)){
			isTrue = true;
		}
		Assert.assertTrue(isTrue, "Expected true but got false in method verifyTextContains");
	}
	public void verifyTextStartsWith(String xpath,String actualText)throws Exception,AssertionError{
		log.debug("verifying that an UI text ends with actual text : "+"actualText+ with xpath : "+xpath);
		String UiText = driver.findElement(By.xpath(xpath)).getText();
		boolean isTrue=false;
		if(UiText.startsWith(actualText)){
			isTrue = true;
		}
		Assert.assertTrue(isTrue, "The UI test does not starts with the given test");
	}
	
	public void verifyTextEndWith(String xpath,String actualText)throws Exception,AssertionError{
		log.debug("Executing verifyTextEndWith actual text "+actualText+" and xpath :"+xpath);
		String UiText = driver.findElement(By.xpath(xpath)).getText();
		boolean isTrue=false;
		if(UiText.endsWith(actualText)){
			isTrue = true;
		}
		Assert.assertTrue(isTrue, "The UI test does not end with the given test");
	}
	public void selectValueFromDropDown(String xpath,String value) throws Exception{
		log.debug("Executing selectValueFromDropDown with value :"+value+" and having xpath :"+xpath);
		Select dropdown= new Select(driver.findElement(By.xpath(xpath)));
		dropdown.deselectAll();
		dropdown.selectByVisibleText(value);
	}
	
	public void verifyChecked(String xpath)throws Exception,AssertionError{
		log.debug("Executing verifyChecked with xpath : "+xpath);
		String checked = driver.findElement(By.xpath(xpath)).getAttribute("checked");
		boolean isChecked = false;
		if(checked!=null)
			isChecked = true;
		Assert.assertTrue(isChecked, "The radio button is not selected");
	}
		public void UnCheckChecked(String xpath)throws Exception{
			log.debug("Executing UnCheckChecked");
			String checked = driver.findElement(By.xpath(xpath)).getAttribute("checked");
			if(checked==null){
				 driver.findElement(By.xpath(xpath)).click();
			}
	}
		public void writeInput(String xpath,String text)throws Exception{
			log.debug("Executing writeInput with text :"+text+" having xpath : "+xpath);
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		}
		
		 public  void verifyTextInInput(String xpath,String expectedText)throws Exception,AssertionError{
			 	log.debug("Executing verifyTextInInput with expected text :"+expectedText+" having xpath :"+xpath);
			 	String UiText = driver.findElement(By.xpath(xpath)).getAttribute("value");
			 	Assert.assertEquals(UiText, expectedText, "The expected string does not match with the given one");
		 }
		 
		 public void verifyTitle(String xpath,String expectedText)throws Exception,AssertionError{
			 log.debug("Executing verifyTitle with expected title :"+expectedText+" having xpath :"+xpath);
			 String UiTitle = driver.getTitle();
			 Assert.assertEquals(UiTitle, expectedText, "The expected string does not match with the given one");
		 }
		 
		 public void verifyExists(String xpath)throws Exception,AssertionError{
			log.debug("Executing verifyExists with xpath :"+xpath); 
			boolean isExists=false;
			try{
				 driver.findElement(By.xpath(xpath));
				 isExists = true;
			}
			catch(Exception e){
			 isExists = false;
			}
			Assert.assertTrue(isExists, "The given element does not exists");
		 }
		 
		 public void closeBrowser()throws Exception{
			 log.debug("Executing closeBrowser");
			 driver.close();
		 }
		 
		 public void quitBrowser()throws Exception{
			 log.debug("Executing quitBrowser");
			 driver.quit();
		 }
		 //waitfor an element visibility
		 
		 public void deleteAllCookies()throws Exception{
			 log.debug("Executing deleteAllCookies");
			 driver.manage().deleteAllCookies();
		 }
	
		 //handling popups
		 public void alertAccept()throws Exception{
			 log.debug("Executing alertAccept ");
			 Alert alert =driver.switchTo().alert();
			 alert.accept();
		 }
		 
		 public void alertDismiss()throws Exception{
			 log.debug("Executing alertDismiss ");
			 Alert alert =driver.switchTo().alert();
			 alert.dismiss();
		 }
		 //handling iframe
		 public void switchToIframe()throws Exception{
			 log.debug("Executing switchToIFrame");
			 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			 }
		 
		 public void switchTodefaultContent()throws Exception{
			 log.debug("Executing switchTodefaultContent");
			 driver.switchTo().defaultContent();
		 }
		 //mouseHover
		 //doubleClick
		 public void mouseHover(String xpath)throws Exception{
			 log.debug("Executing mouseHover with xpath : "+xpath);
			 WebElement element = driver.findElement(By.xpath(xpath));
			 Actions action = new Actions(driver);
			 action.moveToElement(element).perform();
		 }
		 
		 public void mouseDouble(String xpath)throws Exception{
			 log.debug("Executing mouseDoble click on xpath : "+xpath);
			 
			 WebElement element = driver.findElement(By.xpath(xpath));
			 Actions action = new Actions(driver);
			 action.moveToElement(element).doubleClick().perform();
		 }
		 
		 public void navigateForward()throws Exception{
			 log.debug("Executing navigateForward ");
			 driver.navigate().forward();
		 }
		 
		 public void navigateBackward()throws Exception{
			 log.debug("Executing navigateBackward ");
			 driver.navigate().back();
		 }
		 
		 public void captureScreenshot(String filename) throws IOException{
			 		log.debug("Executing catpureScreenShots with filename :"+filename);
		            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
		 }
		 
		 public void  explicitWaitByVisibilityOfElement(String xpath,int seconds) throws Exception{
			 log.debug("Executing explicitWaitByVisibilityOfElement with xpath "+xpath+" and Seconds "+seconds);
			 
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				WebElement webelement = driver.findElement(By.xpath(xpath));
				wait.until(ExpectedConditions.visibilityOf(webelement));
		 }

		 
		 
		 /*
		  * Snapdeal Specific methods 
		  * 
		  */
		 
		 public void switchToLoginIFrame()throws Exception{
			 log.debug("Executing App sepecific switchToLoginIFrame method");
				 Thread.sleep(9000);
		        WebElement loginIframeElement = driver.findElement(By.id("loginIframe"));
		        if (loginIframeElement != null){
		            driver.switchTo().frame(loginIframeElement);
		            System.out.println("Tag name "+loginIframeElement.getTagName());
		        }
		        else
		            driver.switchTo().frame(0);
		 }
}
