package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsDefinitions {
	WebDriver driver;

	@Given("I open the web site")
	public void i_open_the_web_site() {
		// Set up the wWebDriverManager for chrome driver
		WebDriverManager.firefoxdriver().setup();
		// Create the driver object
		driver = new FirefoxDriver();
		// Open the browser
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
	}

	@When("I go to Register Page")
	public void i_go_to_register_page() {

		WebElement registerText = driver.findElement(By.xpath("//td/a[contains(text(),'REGISTER')]"));
		registerText.click();
	}

	@When("I fill the form")
	public void i_fill_the_form() {
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		FirstName.sendKeys("Balkis");
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		LastName.sendKeys("Bouafia");
		WebElement PhoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
		PhoneNumber.sendKeys("123456789");
		WebElement Email = driver.findElement(By.id("userName"));
		Email.sendKeys("balkiss.bouafia@gmail.com");
		WebElement Adress = driver.findElement(By.xpath("//input[@name='address1']"));
		Adress.sendKeys("my adress");
		WebElement City = driver.findElement(By.xpath("//input[@name='city']"));
		City.sendKeys("Porto");
		WebElement State = driver.findElement(By.xpath("//input[@name='state']"));
		State.sendKeys("Braga");
		WebElement CodePostal = driver.findElement(By.xpath("//input[@name='postalCode']"));
		CodePostal.sendKeys("2097");
		WebElement Country = driver.findElement(By.name("country"));
		Country.getAccessibleName();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		WebElement UserName = driver.findElement(By.id("email"));
		UserName.sendKeys("Balkis");
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("password123@");
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		ConfirmPassword.sendKeys("password123@");

	}

	@When("I click on button")
	public void i_click_on_button() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		WebElement SubmitButton = driver.findElement(By.xpath("//input[@name='submit']"));
		SubmitButton.click();
	}

	@Then("a success register shows")
	public void a_success_register_shows() {
		String actualLink = driver.getCurrentUrl();
		String expectedLink ="https://demo.guru99.com/test/newtours/register_sucess.php";
		Assert.assertEquals(actualLink, expectedLink);
		
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
