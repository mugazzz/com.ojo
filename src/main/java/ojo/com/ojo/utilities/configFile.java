package ojo.com.ojo.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ojo.com.ojo.utilities.AppStrings.*;
import static ojo.com.ojo.utilities.Locators.*;

public class configFile extends Helpers{
	public static WebDriver driver = null;
	 public static WebDriverWait wait;
	 
	//------------BROWSER AND URL SETUP --------------
	 
	public static void setUp() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", classpathRoot+chromepath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 60);
		waitForVisibilityOfElement(USER_NAME);
	}
	
	//------------LOGIN TCRM PROCESS --------------
	
	public static void login_Process() {
		enter_text(USER_NAME, user_name);
		enter_text(USER_PASSWORD, user_password);
		clickOnElement(SUBMIT);
		//waitForProgressBarToDismiss();
		if(elementExists(MAIL_FRAME)){
			driver.switchTo().frame("InlineDialog_Iframe");
			clickOnElement(CLOSE_BTN);
			System.out.println("Warning message appears and handled");
			driver.switchTo().defaultContent();
		}
	}
	
	//------------SELECT SERVICES PROCESS --------------
	
	public void select_Services() throws InterruptedException {
		clickOnElement(SALE_DROP_DOWN);
		clickOnElement(SERVICE);
		clickOnElement(INDIVIDUAL);
		sleep(500);
		waitForVisibilityOfElement(NEW_CUSTOMER);
		clickOnElement(NEW_CUSTOMER);
		waitForVisibilityOfElement(SAVE);
	}
	
	//------------CREATE CUSTOMER ID PROCESS--------------
	
	public void Fill_Cus_Details() {
		driver.switchTo().frame("contentIFrame1");
		System.out.println("Switched to frame work");
		waitForVisibilityOfElement(CUS_DASH);
		clickOnElement(CUS_IDENTIFICATION);
		Select drpiden = new Select(driver.findElement(CUS_IDENTIFICATION_TYPE));
		drpiden.selectByVisibleText(Identification_Type);
		enter_Text(CUS_IDEN_NUMBER, CUS_IDEN_NUMBER_I, Identification_Number);
		enter_Text(CUS_FIRST_NAME, CUS_FIRST_NAME_I, Cus_First_Name);
		enter_Text(CUS_LAST_NAME, CUS_LAST_NAME_I, Cus_Last_Name);
		enter_Text(CUS_MOBILE_N1, CUS_MOBILE_N1_I, Cus_Mobile_1);
		enter_Text(CUS_EMAIL1, CUS_EMAIL1_I, Cus_Email_1);
		//new Actions(driver).moveToElement(driver.findElement(CUS_FULL_NAME)).perform();
		//clickOnElement(CUS_FULL_NAME);
		//clickOnElement(CUS_FULL_NAME_I);
		enter_Text(CUS_FULL_NAME, CUS_FULL_NAME_I, Cus_First_Name+Cus_Last_Name);
//		if(elementExists(CUS_FULL_NAME_CFN)){
//			clickOnElement(CUS_FULL_NAME_CFN);
//		}
		clickOnElement(CUS_ADDRESS_TYPE);
		Select drpaddress = new Select(driver.findElement(CUS_ADDRESS_TYPE_SEL));
		drpaddress.selectByVisibleText(Address_Type);
		enter_Text(CUS_NATIONALITY, CUS_NATIONALITY_I, Cus_City);
		driver.switchTo().defaultContent();
		clickOnElement(SAVE);
		waitForVisibilityOfElement(NEW_ACQUISITION);
	}
	
	//------------CREATE ORDER PROCESS--------------
	
	public static void order_Process() throws InterruptedException {
		clickOnElement(ORDER_MENU);
		sleep(3000);
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		login_Process();
		waitForVisibilityOfElement(ADD_ITEM);
		String order_url = driver.getCurrentUrl();
		String Customer_number = order_url.substring((order_url.length() - 20), order_url.length());
		System.out.println("Account number is: "+Customer_number);
		clickOnElement(ADD_ITEM);
	}
	
	//------------CLOSE DRIVER PROCESS --------------
	
	public static void tearDown() {
		driver.quit();
	}
}
