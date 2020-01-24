Skip to content



Why GitHub?  
Enterprise 
Explore  
Marketplace 
Pricing  
  
Sign in 
Sign up 



formationTF 
/
jpetsore_cucumber 
Watch 
0 
Star 
0 
Fork 
0 
Code 
Issues 0 
Pull requests 0 
Projects 0 
Security 
Insights 
Dismiss 
Join GitHub today
GitHub is home to over 40 million developers working together to host and review code, manage projects, and build software together.
Sign up 
Branch: master 
jpetsore_cucumber/src/test/java/org/cucumber/AnnotationSteps.java 
Find file 
Copy path 
 Quentin Dusser new commit 
ae5aa21 on 6 Aug 2019 
0 contributors 
57 lines (45 sloc) 1.82 KB 
Raw
Blame
History


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

© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help

Contact GitHub
Pricing
API
Training
Blog
About

