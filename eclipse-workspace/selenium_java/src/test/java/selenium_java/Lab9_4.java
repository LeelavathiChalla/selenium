package selenium_java;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab9_4 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/");
    }

    @Test
    public void lab4Flow() throws InterruptedException {
        // Verify title
        Assert.assertEquals(driver.getTitle(), "Your Store", "Title mismatch");

        // Desktops > Mac
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        // Verify heading
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Mac");

        // Sort
        driver.findElement(By.id("input-sort")).sendKeys("Name (A - Z)");

        // Add to Cart
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.id("cart-total")).getText().contains("1"));

        // Search for Monitors
        WebElement search = driver.findElement(By.name("search"));
        search.clear();
        search.sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn-default")).click();
        Thread.sleep(2000);

        // Clear & Search in description
        WebElement criteria = driver.findElement(By.id("input-search"));
        criteria.clear();
        driver.findElement(By.name("description")).click();
        driver.findElement(By.id("button-search")).click();

        Assert.assertTrue(driver.getPageSource().contains("Search"));
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}

