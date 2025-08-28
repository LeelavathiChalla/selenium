package selenium_que;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q6 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void handleCheckboxesTest() throws InterruptedException {
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        Thread.sleep(2000);
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 is NOT selected!");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 is NOT selected!");

        System.out.println("Both checkboxes are selected");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
