package selenium_java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lab16_Selenium {

    WebDriver driver;
    String projectpath = System.getProperty("user.dir");

    @Test(dataProvider = "dp")
    public void registerUser(String firstName, String lastName, String email, String phone, String pwd, String confirmPwd) throws InterruptedException {
        System.out.println("Executing test with data: " + firstName + " " + lastName);

     // Verify Title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        //Assert.assertTrue(title.contains("Account Login"), "Page title mismatch!");

        // Navigate to Register page
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Verify heading
        String headerText = driver.findElement(By.xpath("//h1")).getText();
       // Assert.assertEquals(headerText, "Register Account");

        // Fill form
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);

        // ✅ Make email unique
        String uniqueEmail = email.split("@")[0] + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.id("input-email")).sendKeys(uniqueEmail);

        driver.findElement(By.id("input-telephone")).sendKeys(phone);
        driver.findElement(By.id("input-password")).sendKeys(pwd);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPwd);

        // Accept Privacy Policy
        driver.findElement(By.name("agree")).click();

        // Submit form
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Validate success message
        String successMsg = driver.findElement(By.xpath("//h1")).getText();
        //Assert.assertTrue(successMsg.contains("Your Account Has Been Created"), "Registration Failed!");

    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method - launching browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method - closing browser");
        driver.quit();
    }

    // 🔹 DataProvider - Reads Excel (UserDetails.xlsx)
    @DataProvider
    public Object[][] dp() throws IOException {
    	File file = new File(projectpath + "\\UserDetails.xls.xlsx"); 
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        // Use dynamic list (so we can skip blank rows)
        java.util.List<Object[]> dataList = new java.util.ArrayList<>();

        for (int i = 1; i < rowCount; i++) { // skip header
            boolean isRowEmpty = true;
            Object[] rowData = new Object[colCount];

            for (int j = 0; j < colCount; j++) {
                if (sheet.getRow(i) != null && sheet.getRow(i).getCell(j) != null) {
                    sheet.getRow(i).getCell(j).setCellType(org.apache.poi.ss.usermodel.CellType.STRING);
                    String cellValue = sheet.getRow(i).getCell(j).getStringCellValue().trim();
                    rowData[j] = cellValue;
                    if (!cellValue.isEmpty()) {
                        isRowEmpty = false; // row has some data
                    }
                } else {
                    rowData[j] = "";
                }
            }

            if (!isRowEmpty) { // add only if row has data
                dataList.add(rowData);
            }
        }

        workbook.close();
        fis.close();

        return dataList.toArray(new Object[0][]);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}