package selenium_java;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert salert=driver.switchTo().alert();
		System.out.println("The Message is:"+salert.getText());
		salert.accept();
		driver.findElement(By.id("confirm")).click();
		Alert calert=driver.switchTo().alert();
		System.out.println("confirm alert:"+ calert.getText());
		calert.dismiss();
		driver.findElement(By.id("prompt")).click();
		Alert palert=driver.switchTo().alert();
		System.out.println("prompt alert:"+palert.getText());
		palert.sendKeys("Hiii");
		palert.accept();

	}

}
