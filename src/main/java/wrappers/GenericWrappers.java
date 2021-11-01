package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {
	
	RemoteWebDriver driver;

	public void invokeApp(String browser, String url){
		// TODO Auto-generated method stub
		
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			System.out.println("The browser "+browser+" is launched with the given URL "+url+" successfully");
		} catch (SessionNotCreatedException e) {
			System.err.println("The browser "+browser+" is not launched due to session not created error");
		} catch (WebDriverException e) {
			System.err.println("The browser "+browser+" is not launched due to unkown error");
		} finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The element with id "+idValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			System.err.println("The element with id "+idValue+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with id "+idValue+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id "+idValue+" is not interactable in the application ");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id "+idValue+" is not stable in the application ");
		} catch (WebDriverException e) {
			System.err.println("The element with id "+idValue+" is not entered with data "+data+" due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The element with name "+nameValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			System.err.println("The element with name "+nameValue+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with name "+nameValue+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name "+nameValue+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name "+nameValue+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with name "+nameValue+" is not entered with data "+data+" due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The element with xpath "+xpathValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpathValue+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpathValue+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpathValue+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpathValue+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath "+xpathValue+" is not entered with data "+data+" due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		
		try {
			String actualtext = driver.getTitle();
			 if (actualtext.equals(title)) {
				System.out.println("The title of the page "+actualtext+" is matched with the expected title "+title);
			} else {
				System.err.println("The title of the page "+actualtext+" is not matched with the expected title "+title);
			}
		} catch (WebDriverException e) {
			System.err.println("The title of the page cannot be verified dut to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		
		try {
			String actualtext = driver.findElementById(id).getText();
			if (actualtext.equals(text)) {
			   System.out.println("The element with id "+id+" is having the text "+actualtext+" matched with expected text "+text);
			} else {
				System.err.println("The element with id "+id+" is having the text "+actualtext+" not matched with expected text "+text);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with id "+id+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with id "+id+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id "+id+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id "+id+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with id "+id+" cannot be verified due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			if (actualtext.equals(text)) {
				System.out.println("The element with xpath "+xpath+" is having the text "+actualtext+" matched with expected text "+text);
			} else {
				System.err.println("The element with xpath "+xpath+" is having the text "+actualtext+" not matched with expected text "+text);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpath+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpath+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpath+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpath+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath "+xpath+" cannot be verified due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			if (actualtext.contains(text)) {
				System.out.println("The element with xpath "+xpath+" is having the text  "+actualtext+" that contains the expected text "+text);
			} else {
				System.err.println("The element with xpath "+xpath+" is having the text  "+actualtext+" that doesnot contains the expected text "+text);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpath+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpath+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpath+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpath+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath "+xpath+" cannot be verified due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		 try {
			driver.findElementById(id).click();
			System.out.println("The element with id "+id+" is clicked successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The element with id "+id+" is not clicked as it is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with id "+id+" is not clicked as it is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element with id "+id+" is not clicked as the click was intercepted in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id "+id+" is not clicked as it is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id "+id+" is not clicked as it is not satble in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with id "+id+" is not clicked due to unknown error");
		} finally {
			takeSnap();
		}
		 
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The element with classname "+classVal+" is clicked successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The element with classname "+classVal+" is not clicked as it is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with classname "+classVal+" is not clicked as it is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element with classname "+classVal+" is not clicked as the click was intercepted in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with classname "+classVal+" is not clicked as it is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with classname "+classVal+" is not clicked as it is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with classname "+classVal+" is not clicked due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByName(name).click();
			System.out.println("The element with name "+name+" is clicked successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The element with name "+name+" is not clicked as it is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with name "+name+" is not clicked as it is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element with name "+name+" is not clicked as the click was intercepted in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name "+name+" is not clicked as it is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name "+name+" is not clicked as it is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with name "+name+" is not clicked due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element with linktext "+name+" is clicked successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element with linktext "+name+" is not clicked as the click was intercepted in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with linktext "+name+" is not clicked due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element with linktext "+name+" is clicked successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element with linktext "+name+" is not clicked as the click was intercepted in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with linktext "+name+" is not clicked as it is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with linktext "+name+" is not clicked due to unknown error");
		}
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with xpath "+xpathVal+" is clicked successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as the click was intercepted in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with xpath "+xpathVal+" is clicked successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not visible in the application");
		} catch (ElementClickInterceptedException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as the click was intercepted in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked as it is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath "+xpathVal+" is not clicked due to unknown error");
		}
		
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String actualtext =null;
		try {
			 actualtext = driver.findElementById(idVal).getText();
			System.out.println("The element with id "+idVal+" is having the text "+actualtext);
		} catch (NoSuchElementException e) {
			System.err.println("The element with id "+idVal+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with id "+idVal+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id "+idVal+" is not interactable in the application");
		}catch (StaleElementReferenceException e) {
			System.err.println("The element with id "+idVal+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with id "+idVal+" cannot be returned due to unknown error");
		} finally {
			takeSnap();
		}
		
		return actualtext;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String actualtext = null;
		try {
			actualtext = driver.findElementByXPath(xpathVal).getText();
			System.out.println("The element with xpath "+xpathVal+" is having the text "+actualtext);
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpathVal+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpathVal+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpathVal+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath "+xpathVal+" cannot be returned due to unkonwn error");
		} finally {
			takeSnap();
		}
		return actualtext;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement selecttext = driver.findElementById(id);
			Select st = new Select(selecttext);
			st.selectByVisibleText(value);
			System.out.println("The element with id "+id+" is selected with the value "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with the id "+id+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The Element with the id "+id+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The Element with the id "+id+" is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			System.err.println("The Element with the id "+id+" is not selectable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The Element with the id "+id+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The Element with the id "+id+" cannot be selected due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void selectVisibileTextByClassName1(String classname, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement selecttext = driver.findElementByClassName(classname);
			Select st1 = new Select(selecttext);
			st1.selectByVisibleText(value);
			System.out.println("The element with classname "+classname+" is selected with the value "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with the classname "+classname+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The Element with the classname "+classname+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The Element with the classname "+classname+" is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			System.err.println("The Element with the classname "+classname+" is not selectable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The Element with the classname "+classname+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The Element with the classname "+classname+" cannot be selected due to unknown error");
		} 
	}
	
	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		 try {
			WebElement selectindex = driver.findElementById(id);
			 Select si = new Select(selectindex);
			 si.selectByIndex(value);
			 System.out.println("The element with id "+id+" is selected with the value "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with the id "+id+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The Element with the id "+id+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The Element with the id "+id+" is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			System.err.println("The Element with the id "+id+" is not selectable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The Element with the id "+id+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The Element with the id "+id+" cannot be selected due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		
		try {
			Set<String> allwindowidaferclick = driver.getWindowHandles();
			for(String eachid : allwindowidaferclick) {
				driver.switchTo().window(eachid);
				break;
			}
			System.out.println("The tab is switched to parent window successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The parent window tab is not found in the browser");
		} catch (WebDriverException e) {
			System.err.println("The tab cannot be switched to parent window due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		
		try {
			Set<String> allwindowidaferclick = driver.getWindowHandles();
			for(String eachid : allwindowidaferclick) {
				driver.switchTo().window(eachid);
			}
			System.out.println("The tab is switched to last window successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The last window tab is not found in the browser");
		} catch (WebDriverException e) {
			System.err.println("The tab cannot be switched to last window due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		 try {
			driver.switchTo().alert().accept();
			System.out.println("The alert is accepted successfully");
		} catch (NoAlertPresentException e) {
			System.err.println("The alert is not getting poppedup in the application");
		} catch (UnhandledAlertException e) {
			System.err.println("The alert is not handled in the application");
		} catch (WebDriverException e) {
			System.err.println("The alert is not accepted due to unkonwn error");
		} finally {
			takeSnap();
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("The alert is dismissed successfully");
		} catch (NoAlertPresentException e) {
			System.err.println("The alert is not getting poppedup in the application");
		} catch (UnhandledAlertException e) {
			System.err.println("The alert is not handled in the application");
		} catch (WebDriverException e) {
			System.err.println("The alert is not dismissed due to unkonwn error");
		} finally {
			takeSnap();
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String alerttext = null;
		try {
			alerttext = driver.switchTo().alert().getText();
			System.out.println("The alert text "+alerttext+" is obtained successfully");
		} catch (NoAlertPresentException e) {
			System.err.println("The alert text is not obtained as the alert is not getting poppedup in the application");
		} catch (UnhandledAlertException e) {
			System.err.println("The alert text is not obtained as the alert is not handled in the application");
		} catch (WebDriverException e) {
			System.err.println("The alert text is not obtained due to unknown error");
		} 
		return alerttext;
	}

	public void takeSnap() {
		
		File temp = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/snap1.png");
		
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("The browser is closed successfully");
		} catch (WebDriverException e) {
			System.err.println("The browser is not closed due to unknown error");
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("All browsers are closed successfully");
		} catch (WebDriverException e) {
			System.err.println("All browsers are not closed due to unknown error");
		}
	}
	
	public void waitProperty(long time) {
		
		try {
			Thread.sleep(time);
			System.out.println("Wait time "+time+" is successful");
		} catch (InterruptedException e) {
			System.err.println("Wait time "+time+" is not successful duu to unknown error");
		}
	}

	
	public void pageDown() {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath("//html/body").sendKeys(Keys.PAGE_DOWN);
			System.out.println("Page is scrolled down successfully");
		} catch (WebDriverException e) {
			System.err.println("Page is not scrolled down due to unknown error");
		}
		
	}

	public void TAB() {
		
		try {
			driver.findElementByXPath("//html/body").sendKeys(Keys.TAB);
			System.out.println("TAB is working successfully");
		} catch (WebDriverException e) {
			System.err.println("TAB key is not working due to unknown error");
		}
		
	}

	public void selectVisibileTextByXpath(String xpath, String value) {
		try {
			WebElement selexttext = driver.findElementByXPath(xpath);
			Select st2 =new Select(selexttext);
			st2.selectByVisibleText(value);
			System.out.println("The element with xpath "+xpath+" is selected with the value "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with the xpath "+xpath+" is not found in the DOM");
		}catch (ElementNotVisibleException e) {
			System.err.println("The Element with the xpath "+xpath+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with the xpath "+xpath+" is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			System.err.println("The Element with the xpath "+xpath+" is not selectable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The Element with the xpath "+xpath+" is not stable in the application");
		}catch (WebDriverException e) {
			System.err.println("The Element with the xpath "+xpath+" is not selected due to unknown error");
		}
		
	}

	public void selectVisibileTextByName(String name, String value) {
		try {
			WebElement selecttext = driver.findElementByName(name);
			Select st3 = new Select(selecttext);
			st3.selectByVisibleText(value);
			System.out.println("The element with name "+name+" is selected with the value "+value+" successfully");
		} catch (NoSuchElementException e) {
			System.err.println("The Element with the name "+name+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The Element with the name "+name+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			System.err.println("The Element with the name "+name+" is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			System.err.println("The Element with the name "+name+" is not selectable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The Element with the name "+name+" is not stable in the application");
		}catch (WebDriverException e) {
			System.err.println("The Element with the name "+name+" is not selected due to unknown error");
		}
		
	}

	}

