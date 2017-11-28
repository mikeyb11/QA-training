package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePOM {
	
	@FindBy(id="#draggable")
	WebElement mDragSquare;
	
	@FindBy(id="#ui-id-1")
	WebElement mDefaultFunctionality;
	
	@FindBy(id="#ui-id-2")
	WebElement mConstrainMovement;
	
	
	public WebElement getSquare() { return mDragSquare; }
	
	public void clickDefaultFunctionality()
	{
		mDefaultFunctionality.click();
	}
	
	public void clickConstrainMovement()
	{
		mConstrainMovement.click();
	}

}
