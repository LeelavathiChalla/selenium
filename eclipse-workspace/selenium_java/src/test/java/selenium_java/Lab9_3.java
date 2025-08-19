package selenium_java;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab9_3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/");
    }

    @Test
    public void lab3Flow() throws InterruptedException {
        // Desktops > Mac
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        // Sort
        driver.findElement(By.id("input-sort")).sendKeys("Name (A - Z)");

        // Add to Cart
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        Thread.sleep(2000);

        String cart = driver.findElement(By.id("cart-total")).getText();
        Assert.assertTrue(cart.contains("1 item(s)"), "Cart count should be 1 item(s)");
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}