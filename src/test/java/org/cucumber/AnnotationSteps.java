package org.cucumber;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

public class AnnotationSteps {
	WebDriver driver;
	String login;
	String password;

	@Given("I am a registered user of the pet store")
	public void i_am_a_registered_user_of_the_pet_store() {
	    login = "j2ee";
	    password ="j2ee";

	}

	@Given("I visit the Jpetstore web site")
	public void i_visit_the_Jpetstore_web_site() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", "src/test/resources/squash/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//navigation
		driver.get("https://petstore.octoperf.com/");
		driver.findElement(By.xpath("//a[.='Enter the Store']")).click();
	}

	@When("Sign in with the correct login and password")
	public void sign_in_with_the_correct_login_and_password() {
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		// Rempli les champs login password
		driver.findElement(By.xpath("//input[@name='username']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(login);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		//clic sur le bouton submit
		driver.findElement(By.xpath("//input[@name='signon']")).click();

	}

	@Then("I access the home page")
	public void i_access_the_home_page() {
	    assertEquals(driver.findElement(By.id("WelcomeContent")).getText(),"Welcome ABC!");
	    driver.quit();

	}
}