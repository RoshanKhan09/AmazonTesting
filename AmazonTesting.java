package amazonTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonTesting {
	
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
	

		String baseurl = "https://www.amazon.in/";

			URL url = new URL("http://192.168.1.69:5555/wd/hub");

			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setBrowserName("chrome");

			capabilities.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(url, capabilities);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(baseurl);

			System.out.println(driver.getTitle());

			WebElement mobiles = driver
					.findElement(By.xpath("//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']"));

			Actions actions = new Actions(driver);

			Action clkOnMobile = actions.click(mobiles).build();

			clkOnMobile.perform();

			driver.quit();

	}

}
