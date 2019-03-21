package ojo.com.ojo.utilities;

import static ojo.com.ojo.utilities.AppStrings.*;
import static ojo.com.ojo.utilities.Locators.*;
import static ojo.com.ojo.utilities.configFile.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Helpers{
	public static void waitForVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
	
	public static void enter_Text(By Locator1,By Locator2, String text) {
		driver.findElement(Locator1).click();
		waitForVisibilityOfElement(Locator2);
		driver.findElement(Locator2).sendKeys(text);
	}
	
	public static void enter_text(By Locator, String text) {
		waitForVisibilityOfElement(Locator);
		driver.findElement(Locator).sendKeys(text);
	}
	
	public static boolean elementExists(By locator) {
        implicitWait(2);
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
           implicitWait(implicit_wait_time);
        }
	}
	
    public static void implicitWait(long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    
    public static void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }
    
    public void waitForProgressBarToDismiss() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (elementExists(LOADER)) {
            waitForVisibilityOfElement(LOADER);
        }
    }
    
    public static void clickOnElement(By element) {
        waitForVisibilityOfElement(element);
        driver.findElement(element).click();
    }
  
	public static void scroll(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
}
