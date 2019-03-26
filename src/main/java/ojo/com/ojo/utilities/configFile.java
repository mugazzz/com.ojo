package ojo.com.ojo.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		wait = new WebDriverWait(driver, 360);
		waitForVisibilityOfElement(USER_NAME);
	}
	
	//------------LOGIN TCRM PROCESS --------------
	
	public static void login_Process() {
		enter_text(USER_NAME, user_name);
		enter_text(USER_PASSWORD, user_password);
		clickOnElement(SUBMIT);
		//waitForProgressBarToDismiss();
//		if(elementExists(MAIL_FRAME)){
//			driver.switchTo().frame("InlineDialog_Iframe");
//			clickOnElement(CLOSE_BTN);
//			System.out.println("Warning message appears and handled");
//			driver.switchTo().defaultContent();
//		}
	}
	
	//------------SELECT SERVICES PROCESS --------------
	
	public void select_Services() throws InterruptedException {
		waitForVisibilityOfElement(SALE_DROP_DOWN);
		clickOnElement(SALE_DROP_DOWN);
		clickOnElement(SERVICE);
		clickOnElement(INDIVIDUAL);
		sleep(2000);
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
		enter_Text(CUS_FULL_NAME, CUS_FULL_NAME_I, Cus_First_Name+" "+Cus_Last_Name);
		if(elementExists(CUS_FULL_NAME_FLY)){
			clickOnElement(CUS_FULL_NAME_CFN);
		}
		else {
			System.out.println("Popup doesn't appear");
		}
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
		
	    //Click Mobile Offers
		clickOnElement(MOBILE_OFFER_DROPDOWN); 
		
	    //Residential
		clickOnElement(RESIDENTAIL_DROPDOWN);

	    //Postpaid
		clickOnElement(POSTPAID_DROPDOWN);

		clickOnElement(ORRANGE_OFF_DROPDOWN);
		sleep(2000);
		clickOnElement(OFFER_NEXT_BUTTON);

		
		//Select Category
		waitForVisibilityOfElement(SELECT_CATEGORY);
        Select drpCategory = new Select(driver.findElement(SELECT_CATEGORY));
        drpCategory.selectByVisibleText(Category_Type);
   
        //Select ShopId
        Select drpshopId = new Select(driver.findElement(SELECT_SHOP_ID));
        drpshopId.selectByVisibleText(Shop_Id);
        clickOnElement(MSISDN_SEARCH);
        waitForProgressBarToDismiss();
        sleep(500);
        clickOnElement(SELECT_MSISDN);
        waitForProgressBarToDismiss();
        clickOnElement(NEXT_SHOP_BTN);
        
        //Select ORANGE_20D
        waitForProgressBarToDismiss();
        sleep(100000);
        //waitForPageToLoad(driver, 180);
        waitForVisibilityOfElement(ORANGE_20D);
        clickOnElement(ORANGE_20D);    
        sleep(3000);
        waitForProgressBarToDismiss();
        
        //Enter Sim card number
        waitForVisibilityOfElement(SIM_Card_NO); 
        enter_text(SIM_Card_NO, SIM_NO);
        clickOnElement(SELECT_MSISDN_INPUTFIELD);
        waitForProgressBarToDismiss();
        sleep(2000);
        
        //Verify the availability of MSISDN number
        waitForVisibilityOfElement(SELECT_MSISDN_INPUTFIELD);
        String MSISDN = driver.findElement(SELECT_MSISDN_INPUTFIELD).getAttribute("value");
        System.out.println("MSISDN Number is: "+ MSISDN);
        assert MSISDN.length() != 0 : "MSISDN Number is empty";
        waitForVisibilityOfElement(NEXT_SHOP_BTN);
        clickOnElement(NEXT_SHOP_BTN);
        
        //Billing Screen
        waitForProgressBarToDismiss();
        sleep(500);
        clickOnElement(NEXT_SHOP_BTN);
        
        //Document verification
        waitForProgressBarToDismiss();
        sleep(3000);
        clickOnElement(IDENT_DOCUMENT_CHECKBOX);
//        waitForProgressBarToDismiss();
        clickOnElement(APPLICATION_FORM_CHECKBOX);
//        waitForProgressBarToDismiss();
        
        //Finalize process
        clickOnElement(FINALIZE_BASKET);
        waitForProgressBarToDismiss();
        sleep(3000);
        
        //Contract upload not needed
        clickOnElement(CONTRACT_UPLOAD);
        waitForProgressBarToDismiss();
        sleep(500);
        
        //Confirm Order
        clickOnElement(CONFIRM_ORDER);
        
        //Home screen
        waitForProgressBarToDismiss();
        waitForVisibilityOfElement(OFFER_INTALLED_TABLE);
        String Order_id = driver.findElement(ORDER_ID).getText();
        System.out.println("ORDER ID is ----->"+Order_id);
        String Order_status;
        do {
			driver.navigate().refresh();
			Order_status = driver.findElement(ORDER_STATUS).getText();
			System.out.println("Order Status is"+ Order_status);
	     }while(!"COMPLETED".equals(Order_status));
        
        System.out.println("Order Status is ---->"+ Order_status);
        
        OCMLogin_Process(Order_id);
        
	}

	//------------	OCM LOGIN	-------------------------
	
    public static void OCMLogin_Process(String Order_ID) throws InterruptedException {
    	
        driver.get("http://10.4.3.127:8090/bss-ocm/accueil");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60);
        
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("maveric");;
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("maveric2018");;
        
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//input[@id='OrderId1']")).sendKeys("OR000000006004");;
        driver.findElement(By.xpath("//input[@name='searchButton']")).click();
        
        //span[@class='showLinkDetail' and text()='OR000000005964']
        
        /*
        * //No.of Columns List col =
        * driver.findElements(By.xpath("//table[@class='dataview']//tbody//tr[1]//th"))
        * ; System.out.println("No of cols are : " +col.size());
        */
		  //No.of rows 
		  List  rows = driver.findElements(By.xpath("//table[@class='dataview']//tbody")); 
		  System.out.println("No of rows are : " + rows.size());
		        
		  for (int i=1;i<=rows.size();i++)
		  {
		       String rowdata =driver.findElement(By.xpath("//table[@class='dataview']//tr["+(i+1)+"]//td[3]")).getText();
		     if (rowdata.equals(Order_ID)) 
		     {
		          String Order_Type=driver.findElement(By.xpath("//table[@class='dataview']//tr["+(i+1)+"]//td[5]")).getText();
		              System.out.println(Order_Type);
		          String Order_status=driver.findElement(By.xpath("//table[@class='dataview']//tr["+(i+1)+"]//td[6]")).getText();
		              System.out.println(Order_status);
		              
		     }
		
		       
		  }
		  
		 }

	
	
	//------------CLOSE DRIVER PROCESS --------------
	
	public static void tearDown() {
		//driver.quit();
	}
}
