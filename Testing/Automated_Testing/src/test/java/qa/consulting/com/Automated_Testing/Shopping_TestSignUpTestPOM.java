package qa.consulting.com.Automated_Testing;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Shopping_TestSignUpTestPOM {
	
	// txt fields
	@FindBy(id="email_create")
	WebElement mEmailCreateTxtField;
	
	@FindBy(id="customer_firstname")
	WebElement mFirstNameTxtField;
	
	@FindBy(id="customer_lastname")
	WebElement mLastNameTxtField;
	
	@FindBy(id="email")
	WebElement mEmailTxtField;
	
	@FindBy(id="passwd")
	WebElement mPasswordTxtField;
	
	@FindBy(id="address1")
	WebElement mAddressTxtField;
	
	@FindBy(id="city")
	WebElement mCityTxtField;
	
	@FindBy(css="#id_state")
	WebElement mStateTxtField;
	
	@FindBy(css="#postcode")
	WebElement mZipCodeTxtField;
	
	@FindBy(css="#phone_mobile")
	WebElement mMobileNOTxtField;
	
	@FindBy(id="alias")
	WebElement mAddressAliasTxtField;
	
	// buttons / links
	@FindBy(css="#header > div.nav > div > div > nav > div.header_user_info > a")
	WebElement mSignIn;
	
	@FindBy(id="SubmitCreate")
	WebElement mCreateAccount;
	
	@FindBy(id="submitAccount")
	WebElement mRegister;
	
	// get for wait timers
	public WebElement getEmailCreateTxtField() { return mEmailCreateTxtField; }
	public WebElement getFirstName() { return mFirstNameTxtField; }
	
	
	// clicks buttons
	public void clickSignIn() { mSignIn.click(); }
	public void clickRegister() { mRegister.click(); }
	public void clickCreateAccount() { mCreateAccount.click(); }
	
	// fill in txt fields
	public void fillInEmailCreateField(String txt) { mEmailCreateTxtField.sendKeys(txt); }
	public void fillFirstName(String txt) { mFirstNameTxtField.sendKeys(txt); }
	public void fillLastName(String txt) { mLastNameTxtField.sendKeys(txt); }
	public void fillEmail(String txt) { mEmailTxtField.sendKeys(txt); }
	public void fillPassword(String txt) { mPasswordTxtField.sendKeys(txt); }
	public void fillAddress(String txt) { mAddressTxtField.sendKeys(txt); }
	public void fillCity(String txt) { mCityTxtField.sendKeys(txt); }
	//public void fillZipCode(String txt) { mZipCodeTxtField.sendKeys(txt.substring(0, 5)); }
	public void fillZipCode(String txt) { mZipCodeTxtField.sendKeys(txt); }
	public void fillMobileNO(String txt) { mMobileNOTxtField.sendKeys(txt); }
	public void fillAddressAlias(String txt) { mAddressAliasTxtField.sendKeys(txt); }
	
	public void fillState(String txt) 
	{ 
		System.out.println(txt);
		
		Select select = new Select(mStateTxtField);
		mStateTxtField.click();
		select.selectByVisibleText(txt);
	}
}
