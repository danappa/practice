package com.crm.Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * this is explicit wait condition argument takes as titlecontains
	 * 
	 * @param driver
	 * @param duration
	 * @param titleContains
	 */
	public void explicitWaitTitleContains(WebDriver driver, long duration, String titleContains) {
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.titleContains(titleContains));
	}

	public void webForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element, int pollingTime) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	public void switchToWindow(WebDriver driver, String PartialWindowTitile) {
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if (driver.getTitle().contains(PartialWindowTitile)) {
				break;
			}

		}
	}

	/**
	 * this method is used to accept the alert popup
	 * 
	 * @param driver
	 */
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to switch the frame
	 * 
	 * @param driver
	 * @param id_name_Attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}

	/**
	 * this method is used to select class selectByVisiblityText by list box
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	/**
	 * this method is used to select class selectByIndex by list box
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * this is moveToElement method of action class
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * this is moveByOffset method of action class
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void rightClickOnElement(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}

	public String takeScreenshot(WebDriver driver, String methodName) {
		return null;
	}
}
