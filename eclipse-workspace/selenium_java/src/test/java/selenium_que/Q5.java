package selenium_que;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q5 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void handleAlertTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        String result = driver.findElement(By.id("result")).getText();
        System.out.println("Result: " + result);
        Assert.assertEquals(result, "You successfully clicked an alert");
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
