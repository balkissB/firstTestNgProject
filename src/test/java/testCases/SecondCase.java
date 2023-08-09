package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondCase {
	public String BaseUrl = "https://demo.guru99.com/test/newtours/";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		FirefoxOptions options = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options);
		driver.get(BaseUrl);
	}

	@Test
	public void checkTextTesting() {
		WebElement checkText = driver.findElement(By.xpath("//a[normalize-space()='Testing']"));
		System.out.println(checkText.getText());
		Assert.assertEquals(checkText.getText(), "Testing");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}
}
