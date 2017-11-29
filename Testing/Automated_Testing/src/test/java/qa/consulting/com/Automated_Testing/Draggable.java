package qa.consulting.com.Automated_Testing;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Draggable {
	
	private String url = "http://demoqa.com/";
	private static String reportName = "Draggable Report";
	private WebDriver webDriver;

	private static ExtentReports report;
	private ExtentTest test;// = report.createTest("reportName");
	
	private Actions builder;// = new Actions(webDriver);

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
		//logExtentReport(Status.INFO, "Opening Chrome");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		//logExtentReport(Status.INFO, "Successfully opened Chrome");
		
		builder = new Actions(webDriver);	
	}
	
	@Test
	public void DefaultFunctionalityTest() throws Exception
	{
		test = report.createTest("DefaultFunctionalityTest");
		// the test
		System.out.println( "Start DefaultFunctionalityTest" );
		logExtentReport(Status.INFO, "*** Starting DefaultFunctionalityTest ***");
		
		Draggable_DefaultFunctionalityPOM mDefaultFunctionalityPOM = PageFactory.initElements(webDriver, Draggable_DefaultFunctionalityPOM.class);
		
		// navs to the specified URL
		logExtentReport(Status.INFO, "Going to this URL: " + url);
		webDriver.navigate().to(url);
			
		mDefaultFunctionalityPOM.clickDraggableLink();
		mDefaultFunctionalityPOM.clickDefaultFunctionality();
		
		Point orgin = mDefaultFunctionalityPOM.getPosition();
		Point moveOne = new Point(200, 200);
		Point moveTwo = new Point(-50, -100);
		
		logExtentReport(Status.INFO, "Screenshot taken to view URL : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "BeforeMove")));
		logExtentReport(Status.INFO, "Pos BEFORE move : " + webDriver.findElement(By.cssSelector("#draggable")).getLocation().toString());
		
		builder.moveToElement(mDefaultFunctionalityPOM.getSquare()).clickAndHold().moveByOffset(moveOne.x, moveOne.y).release().perform();
		
		logExtentReport(Status.INFO, "Screenshot taken to view URL : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "After1STMove")));
		logExtentReport(Status.INFO, "Pos AFTER move : " + webDriver.findElement(By.cssSelector("#draggable")).getLocation().toString());
	
		builder.moveToElement(mDefaultFunctionalityPOM.getSquare()).clickAndHold().moveByOffset(moveTwo.x, moveTwo.y).release().perform();
		
		logExtentReport(Status.INFO, "Screenshot taken to view URL : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "After2NDMove")));
		logExtentReport(Status.INFO, "Pos AFTER move : " + webDriver.findElement(By.cssSelector("#draggable")).getLocation().toString());
		
		Point newPos = new Point(orgin.x + moveOne.x + moveTwo.x, orgin.y + moveOne.y + moveTwo.y);
		
		//if(mDefaultFunctionalityPOM.getPosition() == newPos)
		
		assertEquals(newPos, mDefaultFunctionalityPOM.getPosition());
			
		
		
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "http://demoqa.com/draggable/";
		
		// checks the URL
		if(expectedURL.equalsIgnoreCase(currentURL))
			logExtentReport(Status.INFO, "On the current URL");
		else
			logExtentReport(Status.INFO, "Not one the expected URL");
		
		System.out.println( "End DefaultFunctionalityTest" );
		logExtentReport(Status.INFO, "*** Ending DefaultFunctionalityTest ***");
	}
	
	//@Test
	public void ConstrainMovementTest() throws Exception
	{
		test = report.createTest("ConstrainMovementTest");
		// the test
		System.out.println( "Start ConstrainMovementTest" );
		logExtentReport(Status.INFO, "*** Starting ConstrainMovementTest ***");
		
		Draggable_ConstrainMovementPOM mConstrainMovementPOM = PageFactory.initElements(webDriver, Draggable_ConstrainMovementPOM.class);
		
		// navs to the specified URL
		logExtentReport(Status.INFO, "Going to this URL: " + url);
		webDriver.navigate().to(url);
			
		mConstrainMovementPOM.clickDraggableLink();
		mConstrainMovementPOM.clickConstrainMovement();
		
		logExtentReport(Status.INFO, "Screenshot taken to view URL : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "BeforeAnyMove")));
		
		// moving vert box
		logExtentReport(Status.INFO, "VerticallyDrag Pos BEFORE move : " + mConstrainMovementPOM.getVerticallyDrag().getLocation().toString());
		builder.moveToElement(mConstrainMovementPOM.getVerticallyDrag()).clickAndHold().moveByOffset(0, 200).release().perform();
		logExtentReport(Status.INFO, "VerticallyDrag Pos BEFORE move : " + mConstrainMovementPOM.getVerticallyDrag().getLocation().toString());
		
		// moving hori box
		logExtentReport(Status.INFO, "HorizontallyDrag Pos BEFORE move : " + mConstrainMovementPOM.getHorizontallyDrag().getLocation().toString());
		builder.moveToElement(mConstrainMovementPOM.getHorizontallyDrag()).clickAndHold().moveByOffset(200, 0).release().perform();
		logExtentReport(Status.INFO, "HorizontallyDrag Pos BEFORE move : " + mConstrainMovementPOM.getHorizontallyDrag().getLocation().toString());

		// moving withinparent box
		logExtentReport(Status.INFO, "WithInParentDrag Pos BEFORE move : " + mConstrainMovementPOM.getWithInParentDrag().getLocation().toString());
		builder.moveToElement(mConstrainMovementPOM.getWithInParentDrag()).clickAndHold().moveByOffset(200, 200).release().perform();
		logExtentReport(Status.INFO, "WithInParentDrag Pos BEFORE move : " + mConstrainMovementPOM.getWithInParentDrag().getLocation().toString());
	
		// moving within box
		logExtentReport(Status.INFO, "WithInBoxDrag Pos BEFORE move : " + mConstrainMovementPOM.getWithInBoxDrag().getLocation().toString());
		builder.moveToElement(mConstrainMovementPOM.getWithInBoxDrag()).clickAndHold().moveByOffset(200, 200).release().perform();
		logExtentReport(Status.INFO, "WithInBoxDrag Pos BEFORE move : " + mConstrainMovementPOM.getWithInBoxDrag().getLocation().toString());
		builder.moveToElement(mConstrainMovementPOM.getWithInBoxDrag()).clickAndHold().moveByOffset(-400000, 0).release().perform();
		logExtentReport(Status.INFO, "WithInBoxDrag Pos BEFORE move : " + mConstrainMovementPOM.getWithInBoxDrag().getLocation().toString());
		
		logExtentReport(Status.INFO, "Screenshot taken to view URL : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "AfterALLMoves")));
		
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "http://demoqa.com/draggable/";
				
		// checks the URL
		if(expectedURL.equalsIgnoreCase(currentURL))
			logExtentReport(Status.PASS, "On the current URL");
		else
			logExtentReport(Status.FAIL, "Not one the expected URL");
		
		System.out.println( "End ConstrainMovementTest" );
		logExtentReport(Status.INFO, "*** Ending ConstrainMovementTest ***");
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
