package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	@FindBy(css="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")
	WebElement mSignUpLink;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	WebElement mUserNameSignUp;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	WebElement mPasswordSignUp;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	WebElement mSaveButton;
	
	@FindBy(css="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	WebElement mLogInLink;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	WebElement mUserNameLogin;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	WebElement mPasswordLogin;
	
	@FindBy(css="\r\n" + "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	WebElement mLogInBtn;

	
	public void setUserNameSignUp(String userName)
	{
		mUserNameSignUp.sendKeys(userName);		
	}
	
	public void setPasswordSignUp(String pword)
	{
		mPasswordSignUp.sendKeys(pword);
	}
	
	public void setUserNameLogIn(String userName)
	{
		mUserNameLogin.sendKeys(userName);		
	}
	
	public void setPasswordLogIn(String pword)
	{
		mPasswordLogin.sendKeys(pword);
	}
	
	public void clickSignUpLink()
	{
		mSignUpLink.click();
	}
	
	public void clickSaveBtn()
	{
		mSaveButton.click();
	}
	
	public void clickLogInLink()
	{
		mLogInLink.click();
	}

	public void clickLogInBtn()
	{
		mLogInBtn.click();
	}
}
