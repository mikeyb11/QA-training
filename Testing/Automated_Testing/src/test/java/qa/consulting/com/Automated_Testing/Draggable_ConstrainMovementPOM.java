package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Draggable_ConstrainMovementPOM {

	@FindBy(id="menu-item-140")
	WebElement mDraggableLink;
	
	@FindBy(id="ui-id-2")
	WebElement mConstrainMovement;
	
	@FindBy(id="draggabl")
	WebElement mVerticallyDrag;
	
	@FindBy(id="draggabl2")
	WebElement mHorizontallyDrag;
	
	@FindBy(id="draggabl5")
	WebElement mWithInParentDrag;
	
	@FindBy(id="draggabl3")
	WebElement mWithInBoxDrag;
	
	public WebElement getVerticallyDrag() { return mVerticallyDrag; }
	public WebElement getHorizontallyDrag() { return mHorizontallyDrag; }
	public WebElement getWithInParentDrag() { return mWithInParentDrag; }
	public WebElement getWithInBoxDrag() { return mWithInBoxDrag; }
	
	public void clickConstrainMovement()
	{
		mConstrainMovement.click();
	}
	
	public void clickDraggableLink()
	{
		mDraggableLink.click();
	}
}
