package qa.consulting.com.Auto_Trader_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SearchTest extends BaseTest
{
	private SearchTestPOM mPOMPage;

	public SearchTest() {
		super();
	}
	
	public boolean runTest(WebDriver driver, ExtentReports report, ExtentTest test)
	{
		mPOMPage = PageFactory.initElements(driver, SearchTestPOM.class);
		
		test = report.createTest("SearchTest");
		System.out.println( "Start SearchTest" );
		test.log(Status.INFO, "*** Starting SearchTest ***");
		
		try
		{
			test.log(Status.INFO, "Filling in the PostCode");
			mPOMPage.setPostCode(mLookUp.getPostCode());
			mPOMPage.clickSearchBth();
			
			//int x = Integer.valueOf(mLookUp.getNumberOfSearches());
			
			//Thread.sleep(50);

			for(int i = 0; i < 10; i++)
			{
				mPOMPage.clickSearchResult(i);
				driver.navigate().back();
			}			
		}
		catch (Exception e)
		{
			test.log(Status.INFO, "test ee");
			test.log(Status.INFO, e.getMessage());
			
			return false;
		}
		
		return true;
	}

}
