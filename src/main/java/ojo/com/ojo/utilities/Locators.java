package ojo.com.ojo.utilities;

import org.openqa.selenium.By;

public class Locators {
	
	//LOGIN SCREEN
	public static final By USER_NAME = By.id("userNameInput");
	public static final By USER_PASSWORD = By.id("passwordInput");
	public static final By SUBMIT = By.id("submitButton");
	public static final By LOADER = By.id("DialogLoadingDivImg");
	
	//DASHBOARD SCREEN
	
	public static final By MAIL_FRAME = By.id("InlineDialog_Background");
	public static final By WARN_MSG = By.id("divWarning");
	public static final By CLOSE_BTN = By.id("butBegin");
	public static final By SALE_DROP_DOWN = By.id("TabSFA");
	public static final By SERVICE = By.id("CS");
	public static final By INDIVIDUAL = By.id("nav_contacts");
	public static final By NEW_CUSTOMER = By.id("contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.NewRecord");
	
	//NEW CUSTOMER 
	public static final By CUS_DASH = By.xpath("//*[@id=\"etel_accountnumber\"]/div[1]/span");
	public static final By ACC_NUM_FiELD = By.id("etel_accountnumber");
	public static final By ACC_NUM_LABEL = By.id("etel_accountnumber_c");
	public static final By SAVE = By.id("contact|NoRelationship|Form|Mscrm.Form.contact.Save");
	public static final By CUS_FIRST_NAME = By.id("firstname");
	public static final By CUS_FIRST_NAME_I = By.id("firstname_i");
	public static final By CUS_LAST_NAME = By.id("lastname");
	public static final By CUS_LAST_NAME_I = By.id("lastname_i");
	public static final By CUS_MOBILE_N1 = By.id("mobilephone1");
	public static final By CUS_MOBILE_N1_I = By.id("mobilephone1_i");
	public static final By CUS_EMAIL1 = By.id("emailaddress11");
	public static final By CUS_EMAIL1_I = By.id("emailaddress11_i");
	public static final By CUS_FULL_NAME = By.id("fullname_cl");
	public static final By CUS_TRADE_NAME = By.id("ojo_tradingname_c");
	public static final By CUS_FULL_NAME_I = By.id("fullname_i");
	public static final By CUS_FULL_NAME_CFN = By.className("ui-dialog-buttonset");
	public static final By CUS_ADDRESS_TYPE = By.id("etel_customeraddresstypecode");
	public static final By CUS_ADDRESS_TYPE_SEL = By.id("etel_customeraddresstypecode_i");
	public static final By NEW_ACQUISITION = By.id("contact|NoRelationship|Form|etel.contact.Acquisition.Button");
	public static final By CUS_IDENTIFICATION = By.id("ojo_identificationtype_d");
	public static final By CUS_IDENTIFICATION_TYPE = By.id("ojo_identificationtype_i");
	public static final By CUS_IDEN_NUMBER = By.id("ojo_identificationnumber");
	public static final By CUS_IDEN_NUMBER_I = By.id("ojo_identificationnumber_i");
	public static final By CUS_NATIONALITY = By.id("ojo_nationalityid");
	public static final By CUS_NATIONALITY_I = By.id("ojo_nationalityid_ledit");
	
	//ORDER
	public static final By ORDER_MENU = By.id("contact|NoRelationship|Form|orjo.contact.Button4.Button");
	public static final By ADD_ITEM = By.className("actionButton");
	
	
	
}
