package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Selectable_DefaultFunctionalityPOM {
	
	@FindBy(id="menu-item-142")
	WebElement mSelectableLink;
	
	@FindBy(id="tabs-1")
	WebElement mSelectableBox;
	
	@FindBy(id="ui-id-1")
	WebElement mDefaultFunctionality;

	public void clickDefaultFunctionality()
	{
		mDefaultFunctionality.click();
	}
	
	public void clickSelectableLink()
	{
		mSelectableLink.click();
	}
	public WebElement getSelectableBox() { return mSelectableBox; }
}
