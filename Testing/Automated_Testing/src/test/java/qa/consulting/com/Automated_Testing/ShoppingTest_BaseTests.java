package qa.consulting.com.Automated_Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public abstract class ShoppingTest_BaseTests {

	protected ShoppingTest_LookUps mLookUp = new ShoppingTest_LookUps();	
	
	public ShoppingTest_BaseTests(WebDriver driver) 
	{

	}
	
	abstract boolean runTest(WebDriver driver, ExtentReports report, ExtentTest test);
}
