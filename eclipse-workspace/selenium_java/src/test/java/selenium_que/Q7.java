package selenium_que;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q7 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void extractWebTableData() {
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        System.out.println("All Names from Table 1:");
        for (WebElement name : names) {
            System.out.println(name.getText());
        }
        String email = driver.findElement(By.xpath("//table[@id='table1']//td[text()='Jason']/following-sibling::td[1]")).getText();
        System.out.println("\nEmail of Jason: " + email);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
