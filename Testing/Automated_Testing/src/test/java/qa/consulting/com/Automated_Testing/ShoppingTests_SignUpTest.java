package qa.consulting.com.Automated_Testing;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ShoppingTests_SignUpTest extends ShoppingTest_BaseTests{
	
	private Shopping_TestSignUpTestPOM mPOMPage = new Shopping_TestSignUpTestPOM();
	
	public ShoppingTests_SignUpTest(WebDriver driver) 
	{
		super(driver);
	}
	
	public boolean runTest(WebDriver driver, ExtentReports report, ExtentTest test)
	{
		mPOMPage = PageFactory.initElements(driver, Shopping_TestSignUpTestPOM.class);
		
		test = report.createTest("SignUPTest");
		System.out.println( "Start SignUPTest" );
		test.log(Status.INFO, "*** Starting SignUPTest ***");
		
		if(createAccount(driver, report, test) && fillInDetails(driver, report, test))
			return true;
		else
			return false;
	}
	
	private boolean createAccount(WebDriver driver, ExtentReports report, ExtentTest test)
	{
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*WebElement foo = wait.until(new Function<WebDriver, WebElement>()
				{
					public WebElement apply(WebDriver driver)
					{
						return driver.findElement(By.id(mPOMPage.getEmailCreateTxtField().toString()));
					}
				});*/
		
		mPOMPage.clickSignIn();
		mPOMPage.fillInEmailCreateField(mLookUp.getEmail());
		mPOMPage.clickCreateAccount();
		
		return true;
	}
	
	private boolean fillInDetails(WebDriver driver, ExtentReports report, ExtentTest test)
	{
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		mPOMPage.fillFirstName(mLookUp.getFirstName());
		mPOMPage.fillLastName(mLookUp.getLastName());
		mPOMPage.fillPassword(mLookUp.getPassword());
		mPOMPage.fillAddress(mLookUp.getAddress());
		mPOMPage.fillCity(mLookUp.getCity());
		mPOMPage.fillZipCode(mLookUp.getZipCode());
		mPOMPage.fillMobileNO(mLookUp.getMobileNO());
		mPOMPage.fillState(mLookUp.getState());
		
		mPOMPage.clickRegister();
		
		return true;
	}

}
