package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Draggable_ConstrainMovementPOM {

	@FindBy(id="menu-item-140")
	WebElement mDraggableLink;
	
	@FindBy(id="ui-id-2")
	WebElement mConstrainMovement;
	
	public void clickConstrainMovement()
	{
		mConstrainMovement.click();
	}
	
	public void clickDraggableLink()
	{
		mDraggableLink.click();
	}
}
