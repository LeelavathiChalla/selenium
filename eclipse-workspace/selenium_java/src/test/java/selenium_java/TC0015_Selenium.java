package selenium_java;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TC0015_Selenium {
    WebDriver driver;
    Properties prop;

    // Locators for Registration
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(linkText = "Register")
    WebElement registerOption;

    @FindBy(xpath = "//h1[text()='Register Account']")
    WebElement registerHeading;

    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;

    @FindBy(name = "agree")
    WebElement agreeCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement successMessage;

    // Utility method to read CSV file
    public String[] readCSVRow(int rowIndex) throws IOException {
        String line;
        int currentRow = 0;
        String csvFile = "UserDetails.csv";   // Make sure file is in project root folder
        BufferedReader br = new BufferedReader(new FileReader(csvFile));

        // Skip header line
        br.readLine();

        while ((line = br.readLine()) != null) {
            if (currentRow == rowIndex) {
                br.close();
                return line.split(",");
            }
            currentRow++;
        }
        br.close();
        return null;
    }

    @Test
    public void registerNewUser() throws Exception {
        // Verify Title
        String title = driver.getTitle();
        System.out.println("The Title is: " + title);
        Assert.assertEquals(title, "Your Store");

        // Click My Account -> Register
        myAccount.click();
        registerOption.click();

        // Verify Register Account heading
        Assert.assertTrue(registerHeading.isDisplayed(), "Register Account heading not found");

        // Read user details from CSV file (row 0 → first user)
        String[] userData = readCSVRow(0);
        String firstName = userData[0];
        String lastName = userData[1];
        String email = userData[2];
        String telephone = userData[3];
        String password = userData[4];
        String confirmPassword = userData[5];

        // Fill Registration form
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        telephoneField.sendKeys(telephone);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        agreeCheckbox.click();
        continueButton.click();

        // Verify success message
        Assert.assertTrue(successMessage.isDisplayed(), "Account creation failed!");
        System.out.println("✅ Test Passed - Account Created Successfully");
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {
        System.out.println("Before method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Config file for URL
        prop = new Properties();
        prop.setProperty("url", "https://tutorialsninja.com/demo/"); // Example "Your Store" site

        driver.get(prop.getProperty("url"));

        PageFactory.initElements(driver, this);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
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

