

package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class Booking_Room {
	
	WebDriver driver;
	@FindBy(id="ss")
	WebElement place;
	
	@FindBy(xpath="//li[@role='option']")
	WebElement selPlace;
	
	@FindBy(className="bui-calendar__date")
	List<WebElement> selDate;
	
	@FindBy(className="xp__input")
	WebElement details;
	
	@FindBy(className="bui-stepper__add-button")
	List<WebElement> adults;
	
	@FindBy(xpath="//div[@id='xp__guests__inputs-container']/div/div/div[2]/div/div[2]/button[2]/span")
	WebElement children;
	
	@FindBy(name="age")
	WebElement age1;
	
	@FindBy(className="sb-searchbox__button")
	WebElement searchbtn;
	
	@FindBy(xpath="//*[text()='Breakfast Included']")
	WebElement breakfast;
	
	@FindBy(xpath="//*[text()='4 stars']")
	WebElement stars;
	
	@FindBy(xpath="//*[text()='Fitness center']")
	WebElement fitness;
	
	@FindBy(xpath="//*[text()='See availability']")
	WebElement availabiity;
	
	@FindBy(xpath="//*[@id='hp_book_now_button']")
	WebElement Reserve;
	
	@FindBy(className="hprt-nos-select")
	WebElement rooms;
	
	@FindBy(xpath="//*[contains(@class,'js-reservation-button__text')]")
	WebElement wilReserve;
	
	@FindBy(id="firstname")
	WebElement fname;
	
	@FindBy(id="lastname")
	WebElement lname;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="email_confirm")
	WebElement con_email;
	
	@FindBy(name="remarks")
	WebElement remarks;
	
	@FindBy(name="checkin_eta_hour")
	WebElement time;
	
	@FindBy(name="book")
	WebElement bookbtn;
	
	@FindBy(name="cc1")
	WebElement address;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="cc_type")
	WebElement card_type;
	
	
	public Booking_Room(WebDriver driver)
	{
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this);
	}
	
	public void screenshot() throws IOException
	{

		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./image.png"));
	}
	public void scrollBy500()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public WebElement place1()
	{
		return place;
	}
	public WebElement se1Place1()
	{
		return selPlace;
	}
	public void selDate1()
	{
		List<WebElement> dates=selDate;
		for(WebElement travelDate:dates)
		{
			if(travelDate.getText().equals("26") || travelDate.getText().equals("30"))
				travelDate.click();
		}
	
	}
	public WebElement details1()
	{
		return details;
	}
	public List<WebElement> adults1()
	{
		for(int i=1;i<=2;i++)
		{
			driver.findElement(By.className("bui-stepper__add-button")).click();
		}
		return adults;
	}
	
	public WebElement children1()
	{
		return children;
	}
	
	public WebElement age1()
	{
		Select month = new Select(age1);
        month.selectByValue("11");
        return age1;
	}
	
	public WebElement searchbtn1()
	{
		return searchbtn;
	}
	public WebElement breakfast1()
	{
		return breakfast;
	}
	
	public WebElement stars1()
	{
		return stars;
	}
	
	public WebElement fitness1()
	{
		return fitness;
	}
	
	public WebElement availability1()
	{
		return availabiity;
	}
	
	public WebElement reserve1() throws InterruptedException
	{
		
		return Reserve;
	}
	public WebElement rooms1() throws InterruptedException
	{
		Select no_room = new Select(rooms);
		no_room.selectByValue("2");
		Thread.sleep(2000);
		return rooms;
	}
	public WebElement willReserve1()
	{	
		return wilReserve;
	}
	public WebElement fname1()
	{	
		return fname;
	}
	public WebElement lname1()
	{	
		return lname;
	}
	public WebElement email1()
	{	
		return email;
	}
	public WebElement con_email1()
	{	
		return con_email;
	}
	
	public WebElement remarks1()
	{	
		return remarks;
	}
	
	public WebElement checkin1() throws InterruptedException
	{	
		Select checkin = new Select(time);
		checkin.selectByValue("7");
		Thread.sleep(2000);
		return time;
	}
	
	public WebElement book1()
	{	
		return bookbtn;
	}
	
	public WebElement addr()
	{	
		Select cntry = new Select(address);
		cntry.selectByValue("in");
		return address;
	}
	public WebElement phone1()
	{	
		return phone;
	}

	public WebElement card1()
	{	
		Select car_d = new Select(card_type);
		car_d.selectByValue("MasterCard");
		return card_type;
	}




}

