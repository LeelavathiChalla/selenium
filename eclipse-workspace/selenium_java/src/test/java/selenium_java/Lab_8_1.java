package selenium_java;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Lab_8_1 {
  
  WebDriver driver;

  @Parameters("browser")
  @BeforeClass
  public void setup(String browser) {
      Reporter.log("Launching browser: " + browser, true);

      if (browser.equalsIgnoreCase("chrome")) {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
      } 
      else if (browser.equalsIgnoreCase("ie")) {
          WebDriverManager.iedriver().setup();
          driver = new InternetExplorerDriver();
      }
      else if (browser.equalsIgnoreCase("edge")) {
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();
      }

      driver.manage().window().maximize();
      driver.get("https://tutorialsninja.com/demo/");
      Reporter.log("Opened TutorialsNinja Demo site", true);
  }


  @Test(priority = 1)
  public void goToMacAndAddToCart() {
      driver.findElement(By.linkText("Desktops")).click();
      driver.findElement(By.linkText("Mac")).click();
      Reporter.log("Navigated to Mac page", true);

      WebElement heading = driver.findElement(By.tagName("h2"));
      Assert.assertEquals(heading.getText(), "Mac", "Mac page heading mismatch!");

      Select sortBy = new Select(driver.findElement(By.id("input-sort")));
      sortBy.selectByVisibleText("Name (A - Z)");
      Reporter.log("Sorted by Name (A-Z)", true);

      driver.findElement(By.xpath("//button[@data-original-title='Add to Cart']")).click();
      Reporter.log("Clicked Add to Cart", true);

      Assert.assertTrue(driver.getPageSource().contains("Success"), "Add to cart failed!");
  }

  @AfterClass
  public void tearDown() {
      Reporter.log("Closing browser", true);
      if (driver != null) driver.quit();
  }
}
