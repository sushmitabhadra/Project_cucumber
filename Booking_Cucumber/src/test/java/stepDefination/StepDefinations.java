package stepDefination;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Booking_Room;
import utility.ReadExcel;
import utility.initializeDriver;


public class StepDefinations extends initializeDriver{

	WebDriver driver;
	Booking_Room b_room;
	List<String> data;
	
	
	@Before
	public void setup() throws IOException
	{
		//this.getBrowser(); 
		System.setProperty("webdriver.gecko.driver", "C:\\CapgeminiDecember Testing\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		driver= new FirefoxDriver();  
		b_room= new Booking_Room(driver);
		 ReadExcel excelData= new ReadExcel(); 
		 data=excelData.readExcel(); 
	}
	@Given("User is on the website")
	public void user_is_on_the_website() throws IOException, InterruptedException {
		driver.get(getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
	    
	}
	@When("Place entered")
	public void place_entered() throws InterruptedException {
		b_room.place1().sendKeys(data.get(0));
		Thread.sleep(3000);
		b_room.se1Place1().click();
		Thread.sleep(3000);
	}
	

	@When("Selected the  date")
	public void selected_the_date() throws InterruptedException {
		
		b_room.selDate1();
		Thread.sleep(1000);
	
	}

	@When("Selected the customer details")
	public void selected_the_customer_details() throws InterruptedException {
		b_room.details1().click();
		Thread.sleep(1000);	
		
		try{
			b_room.adults1();
			Thread.sleep(1000);
		
			b_room.children1().click();
			Thread.sleep(2000);
		
			b_room.age1().click();
			Thread.sleep(2000);
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@When("Clicked on search button")
	public void clicked_on_search_button() throws InterruptedException {
		b_room.searchbtn1().click();
		Thread.sleep(2000);
	}

	@Then("User should be redirected to propertiesfound page")
	public void user_should_be_redirected_to_propertiesfound_page() throws InterruptedException {
		Thread.sleep(2000);
		b_room.scrollBy500();
		Thread.sleep(2000);
	}
	
	@When("Filters are selected")
	public void filters_are_selected() throws InterruptedException {
		b_room.breakfast1().click();
		Thread.sleep(2000);
		b_room.scrollBy500();
		Thread.sleep(2000);
		
		b_room.stars1().click();
		Thread.sleep(2000);
		b_room.scrollBy500();
		Thread.sleep(1000);
		
		b_room.fitness1().click();
		Thread.sleep(8000);
		b_room.scrollBy500();
		
	}

	@When("Clicked on the see availability")
	public void clicked_on_the_see_availability() throws InterruptedException {
		Thread.sleep(4000);
		b_room.availability1().click();

	}

	@Then("Reserve window should open")
	public void reserve_window_should_open() throws InterruptedException {
		Set<String> windows= driver.getWindowHandles();
		Iterator<String>  iter= windows.iterator();
		String parent = iter.next();
		String child= iter.next();
		driver.switchTo().window(child);
		Thread.sleep(12000);
	}
	
	@When("Clicked on reserve button")
	public void clicked_on_reserve_button() throws InterruptedException {
		b_room.reserve1().click();
		Thread.sleep(2000);


	}

	@When("Selected number of rooms")
	public void selected_number_of_rooms() throws InterruptedException {
		
		b_room.rooms1().click();
		Thread.sleep(2000);
	}
	

	@When("Clicked on I will reserve button")
	public void clicked_on_I_will_reserve_button() {
		b_room.willReserve1().click();
		
	}

	@Then("User should get redirected to fill details page")
	public void user_should_get_redirected_to_fill_details_page() throws InterruptedException {
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
	}
	
	@When("Firstname entered")
	public void firstname_entered() throws InterruptedException {
		b_room.fname1().sendKeys(data.get(1));
		Thread.sleep(2000);
		
	}

	@When("Lastname entered")
	public void lastname_entered() throws InterruptedException {

		b_room.lname1().sendKeys(data.get(2));
		Thread.sleep(2000);
		
	}

	@When("Email entered")
	public void email_entered() throws InterruptedException {
		b_room.email1().sendKeys(data.get(3));
		Thread.sleep(2000);
		
	}

	@When("Confirm email entered")
	public void confirm_email_entered() throws InterruptedException {
		b_room.con_email1().sendKeys(data.get(4));
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1700)");
		Thread.sleep(2000);
	}

	@When("Comments entered")
	public void comments_entered() throws InterruptedException {
		b_room.remarks1().sendKeys(data.get(5));
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		
	}

	@When("Selected arrival time")
	public void selected_arrival_time() throws InterruptedException {

		b_room.checkin1().click();
		Thread.sleep(2000);
		
	}

	@When("Clicked on next")
	public void clicked_on_next() throws InterruptedException {
		b_room.book1().click();
		
	}

	@Then("Last enter details page opens")
	public void last_enter_details_page_opens() throws InterruptedException {
		Thread.sleep(3000);
	}

	@When("Selected country")
	public void selected_country() throws InterruptedException {
		b_room.addr().click();
		Thread.sleep(2000);
		
		b_room.scrollBy500();
		Thread.sleep(2000);
	}

	@When("Entered phoneno")
	public void entered_phoneno() throws InterruptedException {
		b_room.phone1().sendKeys(data.get(6));
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
	}

	@When("Entered card")
	public void entered_card()  {
		b_room.card1().click();
		
	}

	@Then("process completed")
	public void process_completed() throws InterruptedException, IOException {
		Thread.sleep(2000);
		b_room.screenshot();
		Thread.sleep(3000);
	}
	
	
	@After
	public void teardown() {
		//driver.close();
	}



}
