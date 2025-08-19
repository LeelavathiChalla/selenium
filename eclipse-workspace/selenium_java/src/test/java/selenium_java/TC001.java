package selenium_java;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC001 {
  @Test(priority=3)
  public void test1() {
	  
	  System.out.println("This is test1");
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	/*	if(driver.getTitle().equals("Amazon"))
				{
			System.out.println("titele is matched");
			Assert.assertTrue(true);
				}
		else
		{
			System.out.println("titele is nt matched");
			Assert.assertFalse(true);
			
				} */
  }
  
  
  @Test(priority=1)
  public void test2() {
	  
	  System.out.println("This is test2");
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://yahoo.com/");
  }
  @Test(priority=2)
  public void test3() {
	  
	  System.out.println("This is test3");
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
  }
}
 