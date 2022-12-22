package Cucumber5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_Definition {
	
	WebDriver driver;

@When("^I Open OrangeHRM$")
public void OpenorangeHRM()
{
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	
}

@Given("^I Sign in to OrangeHRM$")
public void Login() throws Throwable
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	findElement(By.xpath("//button[@type='submit']")).click();
	
	
}

@And("^Create Nationality Record$")
public void NationalityRecord() throws Throwable
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	findElement(By.linkText("Admin")).click();
	findElement(By.linkText("Nationalities")).click();
	findElement(By.xpath("//button[text()=' Add ']")).click();
	findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Indian143");
	findElement(By.xpath("//button[@type='submit']")).click();
	
}
	
@Then("^I Signout$")
public void Signout() throws Throwable

{
    findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
	
	Thread.sleep(5000);
	findElement(By.xpath("(//a[@role='menuitem'])[4]")).click();
	
}

public  WebElement findElement(By by) throws Exception {
	
    WebElement elem = driver.findElement(by);
    	    
    // draw a border around the found element
    if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
        
  //  TH3.HTMLScreenShot("Screen Shot","Click Here","Pass", HtmlOutputFileName,driver);
        
    }
    return elem;
    
}
	
		
}
