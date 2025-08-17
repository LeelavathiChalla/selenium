package selenium_java;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_4 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		if(driver.findElement(By.id("email_create")).isDisplayed()) {
			System.out.println("email  create is displayed");
			driver.findElement(By.id("email_create")).clear();
			driver.findElement(By.id("email_create")).sendKeys("dfhjgahujf@gmail.com");
			driver.findElement(By.id("email_create")).sendKeys(Keys.TAB);
			driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);			
		}
		else {
			System.out.println("email create is not displayed");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("id_gender1")).isSelected();
		Thread.sleep(3000);
		driver.findElement(By.id("customer_firstname")).click();
		driver.findElement(By.id("customer_lastname")).isDisplayed();
		driver.findElement(By.id("customer_firstname")).clear();
		driver.findElement(By.id("customer_firstname")).sendKeys("Dhjhdbcd");
		driver.findElement(By.id("customer_firstname")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("customer_firstname")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("customer_lastname")).click();
		driver.findElement(By.id("customer_lastname")).isDisplayed();
		driver.findElement(By.id("customer_lastname")).clear();
		driver.findElement(By.id("customer_lastname")).sendKeys("Dxhgsh");
		driver.findElement(By.id("customer_lastname")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("customer_lastname")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("passwd")).click();
		driver.findElement(By.id("passwd")).isDisplayed();
		driver.findElement(By.id("passwd")).clear();
		driver.findElement(By.id("passwd")).sendKeys("Abc@123");
		driver.findElement(By.id("passwd")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("Passed")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("days")).click();
		driver.findElement(By.id("days")).sendKeys("14");
		driver.findElement(By.id("days")).sendKeys(Keys.TAB);
		driver.findElement(By.id("months")).click();
		driver.findElement(By.id("months")).sendKeys("November");
		driver.findElement(By.id("months")).sendKeys (Keys.TAB);
		driver.findElement(By.id("years")).click();
		driver.findElement(By.id("years")).sendKeys("2024");
		driver.findElement(By.id("newsletter")).sendKeys(Keys.TAB);
		driver.findElement(By.id("newsletter")).click();	
		driver.findElement(By.xpath("//*[@id=\"submitAccount\")/span")).click();
	}
	
}
