package ojo.com.ojo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppStrings {
	
	public static String url = "https://ojodev.ojo-dev.tcrm.jt.jtgroup/";
	public static String chromepath = "\\src\\drivers\\chromedriver.exe";
	public static String excelpath = "\\src\\test_data\\Test_Data.xlsx";
	public static String gecko = "\\src\\drivers\\geckodriver.exe";
	public static final int implicit_wait_time = 30;
	
	//LOGIN SCREEN
	public static String user_name = "jt\\mavericSIT5";
	public static String user_password = "Orange@2019";
	
	//CREATE CUSTOMER
	public static String Account_Number = "1234563";
	public static String Cus_First_Name = "Tester";
	public static String Cus_Last_Name = "Test";
	public static String Cus_Mobile_1 = "0987654321";
	public static String Cus_Email_1 = "tester@test.com";
	public static String Address_Type = "Home";
	public static String Identification_Type = "Passport";
	public static double RIdentification_Number = Math.random();
	public static String Identification_Number = Double.toString(RIdentification_Number);
	public static String Cus_City = "Jordan";
	
	//ORDER CREATION
	public static String Category_Type = "Others";
	public static String Shop_Id = "10000140";
	public static String SIM_NO = "8996277010163546639";
	
	 //Main Directory of the project
    public static final String currentDir = System.getProperty("user.dir");
 
    //Location of Test data excel file
    public static String testDataExcelPath = null;
 
    //Excel WorkBook
    private static XSSFWorkbook excelWBook;
 
    //Excel Sheet
    private static XSSFSheet excelWSheet;
    public static String testDataExcelFileName;
    //Excel cell
    private static XSSFCell cell;
 
    //Excel row
    private static XSSFRow row;
 
    //Row Number
    public static int rowNumber;
 
    //Column Number
    public static int columnNumber;
 
    //Setter and Getters of row and columns
    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }
 
    public static int getRowNumber() {
        return rowNumber;
    }
 
    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }
 
    public static int getColumnNumber() {
        return columnNumber;
    }
 

	public static String getCellData(int RowNum, int ColNum) {
//      try {
		 FileInputStream ExcelFile = null;
		try {
			ExcelFile = new FileInputStream(testDataExcelPath + "Test_Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			excelWBook = new XSSFWorkbook(ExcelFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         excelWSheet = excelWBook.getSheet("test_data");
          cell = excelWSheet.getRow(RowNum).getCell(ColNum);
          DataFormatter formatter = new DataFormatter();
          String cellData = formatter.formatCellValue(cell);
          return cellData;
//      } catch (Exception e) {
//          throw (e);
//      }
  }

}


