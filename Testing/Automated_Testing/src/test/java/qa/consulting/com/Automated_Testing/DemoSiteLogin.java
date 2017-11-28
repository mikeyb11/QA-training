package qa.consulting.com.Automated_Testing;

import static org.junit.Assert.*;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoSiteLogin {
	private String url = "http://thedemosite.co.uk";
	private WebDriver webDriver;

	private String userNametxt;// = "mike";
	private String pwordtxt;// = "mike";
	
	private Homepage mHomePage;// = PageFactory.initElements(webDriver, Homepage.class);
	
	private static ExtentReports report;
	private ExtentTest test = report.createTest("DemoSiteReports");
		
	private String mLookupDoc = "lookups.xlsx";
	private SpreadSheetReader mReader;// = new SpreadSheetReader(mLookupDoc);
	
	@BeforeClass
	public static void beforeClass()
	{
		// Runs at the start -- before every thing
		System.out.println( "Before Class" );
		
		// init the report
		report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	@Before
	public void before()
	{
		// runs before every test
		System.out.println( "Before" );
		
		// opens chrome
		logExtentReport(Status.INFO, "Opening Chrome");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		logExtentReport(Status.INFO, "Successfully opened Chrome");
		
		//java.util.List<String> mVals = mReader.readRow(0, "Sheet1");
		
		

		mReader = new SpreadSheetReader(mLookupDoc);
		userNametxt = mReader.readCell(0, 1, "Sheet1");
		pwordtxt = mReader.readCell(1, 1, "Sheet1");
		
		logExtentReport(Status.INFO, "Username is : " + userNametxt);
		logExtentReport(Status.INFO, "Password is : " + pwordtxt);
		
	}
	
	@Test
	public void Test()
	{
		mHomePage = PageFactory.initElements(webDriver, Homepage.class);
		
		// the test
		System.out.println( "Test" );
		
		// navs to the specified URL
		logExtentReport(Status.INFO, "Going to this URL: " + url);
		webDriver.navigate().to(url);
		
		try {
			logExtentReport(Status.INFO, "Screenshot taken" + ScreenShot.take(webDriver, "test"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logExtentReport(Status.WARNING, "Unabe to take ScreenShot" + e.getMessage());
		}
		
		// add the user
		//---------------------
		// clicks the signup link
		mHomePage.clickSignUpLink();
		
		// fills in the user name
		mHomePage.setUserNameSignUp(userNametxt);
		
		// fills in the INFOword
		mHomePage.setPasswordSignUp(pwordtxt);
		
		// click the save button
		mHomePage.clickSaveBtn();

		// login as the user
		//---------------------
		// clicks the login link
		mHomePage.clickLogInLink();
		
		// fills in the user name
		mHomePage.setUserNameLogIn(userNametxt);
		
		// fills in the INFOword
		mHomePage.setPasswordLogIn(pwordtxt);
		
		// log the user in
		mHomePage.clickLogInBtn();
		
		try {
			logExtentReport(Status.INFO, "Screenshot taken of login status" + ScreenShot.take(webDriver, "logginIn"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logExtentReport(Status.WARNING, "Unabe to take ScreenShot" + e.getMessage());
		}
				
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "http://thedemosite.co.uk/login.php";
		
		// checks the URL
		Assert.assertEquals(expectedURL, currentURL);
		
		WebElement logInCheck = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		
		String check = logInCheck.getText();
		try {
			assertEquals("**Successful Login**", check);
			logExtentReport(Status.PASS, "User Login status : " + check);
		} catch (Exception e) {
			logExtentReport(Status.ERROR, e.getMessage());
		}
		
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
		
		report.flush();
	}
	
	private void logExtentReport(Status type, String msg)
	{
		//ExtentTest test = report.createTest("MyFirstTest");
        test.log(type, msg);
	}
}
