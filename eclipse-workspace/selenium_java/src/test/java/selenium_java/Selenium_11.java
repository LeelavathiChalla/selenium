package selenium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_11 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		Thread.sleep(3000);
		driver.findElement(By.id("input-firstname")).click();
		driver.findElement(By.id("input-firstname")).isDisplayed();
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys("ffcggvjh");
		driver.findElement(By.id("input-firstname")).sendKeys(Keys.TAB);
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-lastname")).click();
		driver.findElement(By.id("input-lastname")).isDisplayed();
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys("cgfvg");
		driver.findElement(By.id("input-lastname")).sendKeys(Keys.TAB);
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).click();
		driver.findElement(By.id("input-email")).isDisplayed();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("vggcfchvb@gmail.com");
		driver.findElement(By.id("input-email")).sendKeys(Keys.TAB);
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-telephone")).click();
		driver.findElement(By.id("input-telephone")).isDisplayed();
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys("8657774679");
		driver.findElement(By.id("input-telephone")).sendKeys(Keys.TAB);
		
		
		driver.findElement(By.id("input-password")).click();
		driver.findElement(By.id("input-password")).isDisplayed();
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("fgfftd@123");
		driver.findElement(By.id("input-password")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("input-confirm")).click();
		driver.findElement(By.id("input-confirm")).isDisplayed();
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys("fgfftd@123");
		driver.findElement(By.id("input-confirm")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();

		boolean isYesSelected = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).isSelected();
		System.out.println("Newsletter Yes selected: " + isYesSelected);

		
		driver.findElement(By.xpath("//[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.id("checkbox")).sendKeys(Keys.TAB);
		driver.findElement(By.id("checkbox")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 driver.findElement(By.linkText("Components")).click();
	        driver.findElement(By.linkText("Monitors (2)")).click();
	        Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
	        showDropdown.selectByVisibleText("25");
	        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a")).click();
	        WebElement specTab = driver.findElement(By.id("tab-specification"));
	        if (specTab.isDisplayed()) {
	            System.out.println("Specification tab verified.");
	        }
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
	        
	        
	        WebElement successMsg = driver.findElement(By.cssSelector(".alert-success"));
	        if (successMsg.getText().contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
	            System.out.println("Wish list message verified.");
	        }
	        
	        driver.findElement(By.name("search")).sendKeys("Mobile");
	        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

	       
	        driver.findElement(By.id("description")).click();
	        driver.findElement(By.id("button-search")).click();

	        
	        driver.findElement(By.linkText("HTC Touch HD")).click();

	        
	        WebElement qtyBox = driver.findElement(By.id("input-quantity"));
	        qtyBox.clear();
	        qtyBox.sendKeys("3");

	        
	        driver.findElement(By.id("button-cart")).click();
	        
	        driver.findElement(By.linkText("Phones & PDAs")).click();
	        driver.findElement(By.linkText("HTC Touch HD")).click();
	        driver.findElement(By.id("button-cart")).click();

	       
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement successCart = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success"))
	        );

	        
	        if (successCart.getText().contains("Success: You have added HTC Touch HD to your shopping cart!")) {
	            System.out.println("Cart success message verified ");
	        } else {
	            System.out.println("Success message not found ");
	        }
	        WebElement cartIcon = driver.findElement(By.id("cart"));
	        cartIcon.click();

	        
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement viewCart = wait2.until(
	            ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart"))
	        );

	        
	        viewCart.click();

	        System.out.println("Navigated to View Cart page ");
	        if (driver.findElement(By.linkText("HTC Touch HD")).isDisplayed()) {
	            System.out.println("HTC Touch HD verified in cart.");
	        }

	       
	        driver.findElement(By.linkText("Checkout")).click();

	       
	        driver.findElement(By.linkText("My Account")).click();
	        driver.findElement(By.linkText("Logout")).click();

	        
	        String logoutMsg = driver.findElement(By.id("content")).getText();
	        if (logoutMsg.contains("Account Logout")) {
	            System.out.println("Logout successful!");
	        } else {
	            System.out.println("Logout failed!");
	        }

	        
	        driver.findElement(By.linkText("Continue")).click();
	        driver.quit();


	}

}
