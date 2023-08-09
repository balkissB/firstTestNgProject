package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {
	public String BaseUrl="https://demo.guru99.com/test/newtours/";
	String driverPath = "drivers\\chromedriver.exe";
	public WebDriver driver;
	
	@Test
	public void verifyHomePage(){
		//System.getProperty("webdriver.chrome.driver",driverPath);
	    //driver = new ChromeDriver();
		FirefoxOptions options = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();	   
		driver = new FirefoxDriver(options);
		driver.get(BaseUrl);
	    WebElement checkText = driver.findElement(By.xpath("//a[normalize-space()='Testing']"));
	    System.out.println(checkText.getText());
	    Assert.assertEquals(checkText.getText(), "Testing");
	    driver.close();
	}
}
