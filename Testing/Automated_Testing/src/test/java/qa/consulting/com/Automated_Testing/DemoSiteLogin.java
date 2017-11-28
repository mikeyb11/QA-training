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
import org.openqa.selenium.support.PageFactory;

public class DemoSiteLogin {
	private String url = "http://thedemosite.co.uk";
	private WebDriver webDriver;

	private String userNametxt = "mike";
	private String pwordtxt = "mike";
	
	private Homepage mHomePage;// = PageFactory.initElements(webDriver, Homepage.class);
	
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
	public void SignIn()
	{
		mHomePage = PageFactory.initElements(webDriver, Homepage.class);
		
		// the test
		System.out.println( "Test" );
		
		// navs to the specified URL
		webDriver.navigate().to(url);
		
		// add the user
		//---------------------
		// clicks the signup link
		mHomePage.clickSignUpLink();
		
		// fills in the user name
		mHomePage.setUserNameSignUp(userNametxt);
		
		// fills in the Password
		mHomePage.setPasswordSignUp(pwordtxt);
		
		// click the save button
		mHomePage.clickSaveBtn();

		// login as the user
		//---------------------
		// clicks the login link
		mHomePage.clickLogInLink();
		
		// fills in the user name
		mHomePage.setUserNameLogIn(userNametxt);
		
		// fills in the password
		mHomePage.setPasswordLogIn(pwordtxt);
		
		// log the user in
		mHomePage.clickLogInBtn();
		
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "http://thedemosite.co.uk/login.php";
		
		// checks the URL
		Assert.assertEquals(expectedURL, currentURL);
		
		WebElement logInCheck = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		
		String check = logInCheck.getText();
		assertEquals("**Successful Login**", check);
		System.out.println( check );
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
