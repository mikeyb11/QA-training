package qa.consulting.com.Automated_Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSiteLogin {
	private String url = "http://thedemosite.co.uk";
	private WebDriver webDriver;
	
	@BeforeClass
	public static void beforeClass()
	{
		// Runs at the start -- before every thing
		System.out.println( "Before Class" );
	}
	
	@Before
	public void before()
	{
		// runs before every test
		System.out.println( "Before" );
		
		// opens chrome
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		CharSequence userNametxt = "mike";
		CharSequence pwordtxt = "mike";
		
		// the test
		System.out.println( "Test" );
		
		// navs to the specified URL
		webDriver.navigate().to(url);
		
		// add the user
		//---------------------
		// clicks the login link
		WebElement addUserBtn = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		addUserBtn.click();
		
		// fills in the user name
		WebElement userName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		userName.sendKeys(userNametxt);
		
		// fills in the user name
		WebElement password = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		password.sendKeys(pwordtxt);
		
		WebElement signInBtn = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		signInBtn.click();
		
		// login as the user
		//---------------------
		// clicks the login link
		WebElement logInBtn = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
		logInBtn.click();
		
		// fills in the user name
		WebElement userName2 = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		userName2.sendKeys(userNametxt);
		
		// fills in the user name
		WebElement password2 = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		password2.sendKeys(pwordtxt);
		
		WebElement signInBtn2 = webDriver.findElement(By.cssSelector("\r\n" + 
				"body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		signInBtn2.click();
		
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "http://thedemosite.co.uk/login.php";
		
		// checks the URL
		Assert.assertEquals(expectedURL, currentURL);
		
		WebElement logInCheck = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		
		String check = logInCheck.getText();
		assertEquals("**Successful Login**", check);
		
	}
	
	@After
	public void after()
	{
		// runs after every test
		System.out.println( "After" );

		webDriver.quit();
	}
	
	
	@AfterClass
	public static void afterClass()
	{
		// runs last -- after every thing 
		System.out.println( "After Class" );
	}
}
