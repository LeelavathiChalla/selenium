package selenium_que;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q4 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void handleDropdownTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Selected option: " + selectedOption);
        Assert.assertEquals(selectedOption, "Two");
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

