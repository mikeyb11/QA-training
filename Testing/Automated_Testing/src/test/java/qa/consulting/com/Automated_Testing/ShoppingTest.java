package qa.consulting.com.Automated_Testing;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ShoppingTest {
	
	WebDriver mWebDriver;
	
	private String mURL = "http://automationpractice.com/index.php";
	private static String mReportName = "ShoppingTestsReport";

	private static ExtentReports mReport;
	private ExtentTest mTest;
	
	private ShoppingTest_BaseTests mTestOne;
	private ShoppingTest_BaseTests mTestTwo;
	
	@BeforeClass
	public static void BeforeClass()
	{
		// Runs at the start -- before every thing
		System.out.println( "Before Class" );
		
		// init the report
		mReport = new ExtentReports();
        String fileName = mReportName + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        mReport.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	@Before
	public void Before()
	{
		// runs before every test
		System.out.println( "Before" );
		
		// opens browser		
		BrowserFactory.InitBrowser("chrome");
		BrowserFactory.LoadApplication(mURL);
				
		//try {
			//mBuilder = new Actions(BrowserFactory.Driver());
		//} //catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		//}
		
		JavascriptExecutor js = null;
		try {
			if (BrowserFactory.Driver() instanceof JavascriptExecutor) {
			    js = (JavascriptExecutor)BrowserFactory.Driver();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript(
		        "var theText = document.getElementsByTagName('p');" +
		        "for(var i = 0; i < theText.length; i++) { " +
		        "    theText[i].style.color = \"red\";" +
		        "	 theText[i].style.border = \"thick solid #0000FF\";" +
		        "}"				
				);
		
		try {
			mTestOne = new ShoppingTests_SignUpTest(BrowserFactory.Driver());
			mTestTwo = new ShoppingTests_SignUpTest(BrowserFactory.Driver());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test()
	{
		try {
			Assert.assertTrue(mTestOne.runTest(BrowserFactory.Driver(), mReport, mTest));
			Assert.assertTrue(mTestTwo.runTest(BrowserFactory.Driver(), mReport, mTest));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	@After
	public void After()
	{
		// runs after every test
		System.out.println( "After" );

		//mWebDriver.quit();
		BrowserFactory.CloseDrivers();
	}
	
	@AfterClass
	public static void AfterClass()
	{
		// runs last -- after every thing 
		System.out.println( "After Class" );
		
		mReport.flush();
	}

}
