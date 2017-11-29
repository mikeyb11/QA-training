package qa.consulting.com.Automated_Testing;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Selectable {
	private String url = "http://demoqa.com/";
	private static String reportName = "Selectable Report";
	private WebDriver webDriver;
	
	//private Homepage mDefaultFunctionallyPOM;// = PageFactory.initElements(webDriver, Homepage.class);
	
	private static ExtentReports report;
	private ExtentTest test = report.createTest("reportName");

	private Actions builder;
	
	@BeforeClass
	public static void beforeClass()
	{
		// Runs at the start -- before every thing
		System.out.println( "Before Class" );
		
		// init the report
		report = new ExtentReports();
        String fileName = reportName + ".html";
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
		
		builder = new Actions(webDriver);
	}
	
	@Test
	public void Test() throws IOException
	{
		Selectable_DefaultFunctionalityPOM mDefaultFunctionallyPOM = PageFactory.initElements(webDriver, Selectable_DefaultFunctionalityPOM.class);
		
		// the test
		System.out.println( "Test" );
		
		// navs to the specified URL
		logExtentReport(Status.INFO, "Going to this URL: " + url);
		webDriver.navigate().to(url);
		
		mDefaultFunctionallyPOM.clickSelectableLink();
		mDefaultFunctionallyPOM.clickDefaultFunctionality();

		logExtentReport(Status.INFO, "Screenshot taken to view URL : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "ViewURL")));
		System.out.println( mDefaultFunctionallyPOM.getSelectableBox().getLocation() );
		builder.moveToElement(mDefaultFunctionallyPOM.getSelectableBox()).moveByOffset(0,0).clickAndHold().moveByOffset(10, 200).release().perform();
		
		logExtentReport(Status.INFO, "Screenshot taken to view URL : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "BeforeMove")));
		
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "http://demoqa.com/selectable/";
		
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
		
		report.flush();
	}
	
	private void logExtentReport(Status type, String msg)
	{
		//ExtentTest test = report.createTest("MyFirstTest");
        test.log(type, msg);
	}
}
