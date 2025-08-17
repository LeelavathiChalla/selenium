package selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Title:"+driver.getTitle());
		WebElement search=driver.findElement(By.id("APjFqb"));
		search.sendKeys("Automation Testing tools");
		search.sendKeys(Keys.ENTER);
		
		
		
		search.submit();
		System.out.println("Title:"+driver.getTitle());
		
		

	}

}
