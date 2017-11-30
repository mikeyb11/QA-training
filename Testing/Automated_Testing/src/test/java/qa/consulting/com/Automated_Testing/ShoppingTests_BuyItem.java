package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ShoppingTests_BuyItem extends ShoppingTest_BaseTests{
	
	
	public ShoppingTests_BuyItem(WebDriver driver) 
	{
		super(driver);
	}
	
	public boolean runTest(WebDriver driver, ExtentReports report, ExtentTest test)
	{
		test = report.createTest("BuyItemTest");
		System.out.println( "Start BuyItemTest" );
		test.log(Status.INFO, "*** Starting BuyItemTest ***");
		
		//System.out.println(mLookUp.getFirstName());
		return true;
	}
}