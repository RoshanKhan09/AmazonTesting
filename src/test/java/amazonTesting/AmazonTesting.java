package amazonTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AmazonTesting {
	
	 public static void navigateAndPerformActions(WebDriver driver) {
	        // Navigate to Amazon website
	        driver.get("https://www.amazon.com");
	        
	        System.out.println(driver.getTitle());

			WebElement mobiles = driver
					.findElement(By.xpath("//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']"));

			Actions actions = new Actions(driver);

			Action clkOnMobile = actions.click(mobiles).build();

			clkOnMobile.perform();

	    }

	public static void main(String[] args) throws MalformedURLException {

		String gridHubUrl = "http://localhost:4444/wd/hub";
		
		URL url = new URL(gridHubUrl);
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        
        WebDriver driver = new RemoteWebDriver(url, capabilities);

        // Navigate to Amazon website and perform actions
        navigateAndPerformActions(driver);

        // Close the browser
        driver.quit();

    }
	
		

}
