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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC0012_Selenium {
    WebDriver driver;
    Properties prop;

    // ---------------- PageFactory Elements ----------------
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(linkText = "Login")
    WebElement loginOption;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(linkText = "Phones & PDAs")
    WebElement phonesCategory;

    @FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[1]")
    WebElement firstWishlistButton;

    @FindBy(css = ".alert-success")
    WebElement successMessage;

    // ---------------- Test ----------------
    @Test
    public void loginAndAddToWishlist() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("The Title is: " + title);

      
        myAccount.click();
        loginOption.click();
        emailField.sendKeys(prop.getProperty("username"));
        passwordField.sendKeys(prop.getProperty("password"));
        loginButton.click();
        Thread.sleep(2000);

        phonesCategory.click();
        firstWishlistButton.click();
        Thread.sleep(2000);

        // Verification
        String msg = successMessage.getText();
        if (msg.contains("Success")) {
            System.out.println("✅ Test Passed - Wishlist added successfully");
        } else {
            System.out.println("❌ Test Failed");
        }
    }


    @BeforeMethod
    public void beforeMethod() throws IOException {
        System.out.println("Before method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        prop.load(fis);

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
