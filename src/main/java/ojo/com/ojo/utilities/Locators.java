package ojo.com.ojo.utilities;

import org.openqa.selenium.By;

public class Locators {
	
	//LOGIN SCREEN
	public static final By USER_NAME = By.id("userNameInput");
	public static final By USER_PASSWORD = By.id("passwordInput");
	public static final By SUBMIT = By.id("submitButton");
	public static final By LOADER = By.id("DialogLoadingDivImg");
	public static final By LOADER_PANEL = By.id("loading-indicator");
	
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
	public static final By CUS_FULL_NAME_FLY = By.id("fullname_compositionLinkControl_flyoutLoadingArea");
	public static final By CUS_FULL_NAME_CFN = By.className("ui-button-text");
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
	public static final By MOBILE_OFFER_DROPDOWN = By.xpath("//div[2]/div[2]/div/div/a");
	public static final By RESIDENTAIL_DROPDOWN = By.xpath("//div[2]/div/div[2]/div[2]/div/a");
	public static final By POSTPAID_DROPDOWN = By.xpath("//div[2]/div[2]/div[2]/div/div/a");	
	public static final By ORRANGE_OFF_DROPDOWN = By.xpath("//div[8]/div/span/div/table/tbody/tr/td/a/span/span");
	public static final By OFFER_NEXT_BUTTON =By.xpath("//span[contains(.,'next')]");
	public static final By SELECT_CATEGORY =By.name("category");
	public static final By SELECT_SHOP_ID =By.name("shopId");
	public static final By NEXT_SHOP_BTN = By.xpath("//span[contains(.,'next')]");
	//public static final By ORANGE_20D = By.xpath("//tr[3]/td/table/tbody/tr/td/form/div[2]/div/div/div/div/span/input");
	public static final By ORANGE_20D = By.xpath("//span[text()='Orange20 D']");
	public static final By SIM_Card_NO = By.xpath("//tr[2]/td/table/tbody/tr/td/form/div[2]/div/div/div[3]/div/div/div/input");
	public static final By MSISDN  = By.xpath("//span[5]/span/table/tbody/tr[3]/td/table/tbody/tr/td/form/div[2]/div/div/div[3]/div/div/div/input");
	public static final By MSISDN_SEARCH =By.xpath("//*[@class='buttonLink' and text()='search']");
	public static final By SELECT_MSISDN = By.xpath("//table[@class='GFJVEQUBCB']//td[1]//span");
	public static final By SELECT_MSISDN_INPUTFIELD = By.xpath("//span[5]/span/table/tbody/tr[3]/td/table/tbody/tr/td/form/div[2]/div/div/div[3]/div/div/div/input");
	
	public static final By IDENT_DOCUMENT_CHECKBOX= By.xpath("//div[2]/input");
	public static final By APPLICATION_FORM_CHECKBOX= By.xpath("//div[3]/input");
	public static final By FINALIZE_BASKET= By.xpath("//span[contains(.,'Finalize basket')]");
	public static final By CONTRACT_UPLOAD= By.name("lettersPanel:clientSignature");
	public static final By CONFIRM_ORDER= By.xpath("//span[contains(.,'confirm order')]");
	
	//CONFIRMATION HOME SCREEN
	public static final By OFFER_INTALLED_TABLE= By.id("installedOfferSelection");
	public static final By ORDER_ID = By.xpath("//div[8]/div/div/table/tbody/tr/td[2]/span");
	public static final By ORDER_STATUS = By.xpath("//div[8]/div/div/table/tbody/tr/td[4]/span");
	
	
	
}