package selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/");
		String title=driver.getTitle();
		if(title.equals("OpenCart - Open Source Shopping Cart Solution"))
		{
			System.out.println("Title is matched");
			
		}else {
			System.out.println("Title is not matched");
		}
		driver.navigate().to("https://www.yahoo.com/");
		System.out.println("url is:"+driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println("url is:"+driver.getCurrentUrl());
		driver.navigate().forward();
		
		System.out.println("url is:"+driver.getCurrentUrl());
		
	}

}
