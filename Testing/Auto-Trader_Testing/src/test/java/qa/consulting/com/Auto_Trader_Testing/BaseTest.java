package qa.consulting.com.Auto_Trader_Testing;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public abstract class BaseTest 
{
	protected SearchLookUps mLookUp = new SearchLookUps();	
	
	public BaseTest() 
	{

	}
	
	abstract boolean runTest(WebDriver driver, ExtentReports report, ExtentTest test);
}
