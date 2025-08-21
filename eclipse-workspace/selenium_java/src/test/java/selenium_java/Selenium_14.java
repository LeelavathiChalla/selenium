package selenium_java;

import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Selenium_14 {
	WebDriver driver;
	//String projectpath=System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f(String firstName, String lastName, String email, 
			String telephone, String password, String confirmPassword) {
		
		
	  String regHeader = driver.findElement(By.xpath("//h1")).getText();
		//Assert.assertEquals(regHeader, "Register Account", "Register Account header mismatch");

		
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

		
		driver.findElement(By.name("agree")).click();

		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	    WebElement successHeader = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))
	    );

		
		String successMsg = driver.findElement(By.xpath("//h1")).getText();
		//Assert.assertEquals(successMsg, "Your Account Has Been Created!", "Account creation failed");
	}
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		System.out.println("Website launched");
		
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
  }


  @DataProvider
  public Object[][] dp() throws Exception {
	    FileInputStream fis = new FileInputStream("UserDetails.xls.xlsx");
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(0);

	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getLastCellNum();

	    
	    java.util.List<Object[]> dataList = new java.util.ArrayList<>();

	    for (int i = 1; i < rowCount; i++) { 
	        Row row = sheet.getRow(i);

	        if (row == null) continue; 

	        Object[] rowData = new Object[colCount];
	        boolean isEmptyRow = true;

	        for (int j = 0; j < colCount; j++) {
	            Cell cell = row.getCell(j);
	            String cellValue = (cell != null) ? cell.toString().trim() : "";
	            rowData[j] = cellValue;

	            if (!cellValue.isEmpty()) {
	                isEmptyRow = false; 
	            }
	        }

	        if (!isEmptyRow) { 
	            dataList.add(rowData);
	        }
	    }

	    //wb.close();
	    //fis.close();

	    
	    return dataList.toArray(new Object[0][0]);
	}
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");
  }

}