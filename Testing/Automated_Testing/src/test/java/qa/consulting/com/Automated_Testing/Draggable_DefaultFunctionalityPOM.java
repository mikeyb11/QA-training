package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Draggable_DefaultFunctionalityPOM {
	
	@FindBy(id="menu-item-140")
	WebElement mDraggableLink;
	
	@FindBy(id="draggable")
	WebElement mDragSquare;
	
	@FindBy(id="ui-id-1")
	WebElement mDefaultFunctionality;
	
	
	public WebElement getSquare() { return mDragSquare; }
	
	public void clickDraggableLink()
	{
		mDraggableLink.click();
	}
	
	public void clickDefaultFunctionality()
	{
		mDefaultFunctionality.click();
	}
	
	public Point getPosition() { return (Point) mDragSquare.getLocation(); }
	
}
