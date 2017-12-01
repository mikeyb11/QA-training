package qa.consulting.com.Auto_Trader_Testing;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AutoTrader 
{
	private String mURL = "https://www.autotrader.co.uk";
	private static String mReportName = "AutoTraderTestsReport";

	private static ExtentReports mReport;
	private ExtentTest mTest;
	
	private SearchTest mTestOne;
	//private ShoppingTest_BaseTests mTestTwo;
	
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
		
		mTestOne = new SearchTest();

	}
	
	@Test
	public void Test()
	{
		try {
			Assert.assertTrue(mTestOne.runTest(BrowserFactory.Driver(), mReport, mTest));
			//Assert.assertTrue(mTestTwo.runTest(BrowserFactory.Driver(), mReport, mTest));
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
