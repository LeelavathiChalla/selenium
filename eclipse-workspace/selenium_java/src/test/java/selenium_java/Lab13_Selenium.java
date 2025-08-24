package selenium_java;




import java.io.File;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab13_Selenium {
    static Document document;

    // Load XML repository once
    public static void loadXML() throws Exception {
        File inputFile = new File("ObjectRepository.xml"); // keep XML in project root
        SAXReader reader = new SAXReader();
        document = reader.read(inputFile);
    }

    // Get locator value
    public static String getLocator(String pageName, String elementName) {
        Node node = document.selectSingleNode(
            "//page[@name='" + pageName + "']/element[@name='" + elementName + "']"
        );
        return node.getText();
    }

    // Get locator type (id, name, xpath, etc.)
    public static String getLocatorType(String pageName, String elementName) {
        Node node = document.selectSingleNode(
            "//page[@name='" + pageName + "']/element[@name='" + elementName + "']/@type"
        );
        return node.getText();
    }

    // Return Selenium By dynamically
    public static By getBy(String page, String element) {
        String type = getLocatorType(page, element);
        String value = getLocator(page, element);

        switch (type.toLowerCase()) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "xpath":
                return By.xpath(value);
            case "css":
                return By.cssSelector(value);
            default:
                throw new RuntimeException("❌ Unknown locator type: " + type);
        }
    }

    public static void main(String[] args) throws Exception {
        // Load XML
        loadXML();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        // Use XML locators
        driver.findElement(getBy("RegisterPage", "myAccount")).click();
        driver.findElement(getBy("RegisterPage", "register")).click();
        driver.findElement(getBy("RegisterPage", "firstName")).sendKeys("Pooja");
        driver.findElement(getBy("RegisterPage", "lastName")).sendKeys("Kvy");
        driver.findElement(getBy("RegisterPage", "email")).sendKeys("test1234@gmail.com");
        driver.findElement(getBy("RegisterPage", "telephone")).sendKeys("9876543210");
        driver.findElement(getBy("RegisterPage", "password")).sendKeys("Abc@123");
        driver.findElement(getBy("RegisterPage", "confirmPassword")).sendKeys("Abc@123");
        driver.findElement(getBy("RegisterPage", "privacyPolicy")).click();
        driver.findElement(getBy("RegisterPage", "continueBtn")).click();

        // Verify success
        WebElement successMsg = driver.findElement(getBy("RegisterPage", "successMsg"));
        if (successMsg.isDisplayed()) {
            System.out.println(" Account Created Successfully!");
        } else {
            System.out.println(" Registration Failed!");
        }

        driver.quit();
    }
}