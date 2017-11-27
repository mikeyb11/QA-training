package qa.consulting.com.Automated_Testing;

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

public class LogInTest {
	
	private String url = "https://github.com/";
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
		// the test
		System.out.println( "Test" );
		
		// navs to the specified URL
		webDriver.navigate().to(url);
		
		// clicks the login link
		WebElement logInLink = webDriver.findElement(By.cssSelector("body > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu.HeaderMenu--bright.d-lg-flex.flex-justify-between.flex-auto > div > span > div > a:nth-child(1)"));
		logInLink.click();
		
		// fills in the user name
		WebElement userName = webDriver.findElement(By.cssSelector("#login_field"));
		userName.sendKeys("mikeyb11");
		
		// fills in the user name
		WebElement password = webDriver.findElement(By.cssSelector("#password"));
		password.sendKeys("Thejoker11");
		
		WebElement signInBtn = webDriver.findElement(By.cssSelector("#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block"));
		signInBtn.click();
		
		
		// selects the link on page
		WebElement link = webDriver.findElement(By.cssSelector("#your_repos > div > div.boxed-group-inner > ul > li:nth-child(1) > a > span > span"));
		link.click();
		
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "https://github.com/mikeyb11/QA-training";
		
		// checks the URL
		Assert.assertEquals(expectedURL, currentURL);
		
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
