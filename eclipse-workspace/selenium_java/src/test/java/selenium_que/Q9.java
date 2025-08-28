package selenium_que;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q9 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void captureScreenshot() throws IOException {
        driver.get("https://www.wikipedia.org/");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);        File destination = new File("homepage.png");
        FileHandler.copy(screenshot, destination);

        System.out.println("Screenshot saved.png");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
