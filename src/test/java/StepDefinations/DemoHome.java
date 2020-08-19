package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoHome extends BaseClass {

	private String today;



	@Given("^Input form is displayed\\.$")
	public void input_form_is_displayed() throws IOException, InterruptedException {
		driver= getdriver();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='at-cv-lightbox-button-holder']/a[@href='#']")).click();

		driver.findElement(By.xpath("//a[@class=\"dropdown-toggle\" and contains(text(), 'Input Forms')]")).click();

	}

	@Then("^System display correct data elements in the landing page$")
	public void system_display_correct_data_elements_in_the_landing_page() throws Throwable {
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='navbar-brand-centered']/ul/li")); 

		for (WebElement element: allElements) {
			System.out.println(element.getText());
		}


	}

	@When("^User click on \"([^\"]*)\"$")
	public void user_click_on(String arg1) throws Throwable {

		WebElement submenu= driver.findElement(By.xpath("//div[@id='navbar-brand-centered']/ul[@class='nav navbar-nav']/li[1]/ul[@class='dropdown-menu']//a[@href='./basic-first-form-demo.html']"));
		submenu.click();


	}

	@Then("^System displays the submenu$")
	public void system_displays_the_submenu() throws Throwable {
		String message = "Das Ankita";
		driver.findElement(By.xpath("/html//input[@id='user-message']")).sendKeys(message);


	}

	@Then("^System selects  the input form$")
	public void system_selects_the_input_form() throws Throwable {
		driver.findElement(By.xpath("//form[@id='get-input']/button[@type='button']")).click();
	}

	@Then("^The user is shown the Input form page$")
	public void the_user_is_shown_the_Input_form_page() throws Throwable {
		String message = "Das Ankita";
		String Actualmsg= driver.findElement(By.xpath("//span [@id=\"display\"]")).getText();
		System.out.println(Actualmsg);
		Assert.assertEquals(message,Actualmsg);

		// Date picker
		driver.findElement(By.xpath("//ul[@id='treemenu']/li/ul/li[2]/a[@href='#']")).click();

		driver.findElement(By.linkText("Bootstrap Date Picker")).click();

		//selecting date
		WebElement calendericon = driver.findElement(By.xpath("/html//div[@class='container-fluid text-center']/div[@class='row']/div[@class='col-md-6 text-left']//div[@class='col-xs-4']//i[@class='glyphicon glyphicon-th']"));
		calendericon.click();
		
		driver.findElement(By.xpath("/html/body/script[7]")).click();
		
		Thread.sleep(3000);
		
		String selectedDate= driver.findElement(By.cssSelector(".date .form-control")).getText();
		System.out.println(selectedDate);
		
	}
}



