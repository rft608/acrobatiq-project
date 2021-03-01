package com.acrobatic.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.acrobatic.pageObjects.BaseClass;

public class ToolBox extends BaseClass {

	public static void switchIframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void scrollPageByPixel(String pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")", "");
	}
	
	public static void waitUntilElementVisible(int maxWait,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,maxWait);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitUntilElementInvisible(int maxWait,WebElement element) throws Exception{
		WebDriverWait wait=new WebDriverWait(driver,maxWait);
		wait.until(ExpectedConditions.invisibilityOf(element));
		Thread.sleep(10000);
	}

}
