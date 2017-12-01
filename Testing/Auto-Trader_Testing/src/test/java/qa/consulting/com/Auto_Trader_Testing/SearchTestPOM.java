package qa.consulting.com.Auto_Trader_Testing;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchTestPOM {
	
	@FindBy(id="postcode")
	private WebElement mPostCode;
	@FindBy(id="radius")
	private WebElement mDistance;
	@FindBy(id="searchVehiclesMake")
	private WebElement mMake;
	@FindBy(id="searchVehiclesModel")
	private WebElement mModel;
	@FindBy(id="searchVehiclesPriceFrom")
	private WebElement mMinPrice;
	@FindBy(id="searchVehiclesPriceTo")
	private WebElement mMaxPrice;
	
	@FindBy(id="searchVehiclesCount")
	private WebElement mSearchBtn;
	
	@FindBy(css="#main-content > div.js-search-results > ul")
	private WebElement mSearchResults;
	
	public WebElement getPostCode() 	{ return mPostCode; }
	public WebElement getDistance() 	{ return mDistance; }
	public WebElement getMake() 		{ return mMake; }
	public WebElement getModel() 		{ return mModel; }
	public WebElement getMinPrice() 	{ return mMinPrice; }
	public WebElement getMaxPrice() 	{ return mMaxPrice; }
	public WebElement getSearchBtn() 	{ return mSearchBtn; }
	
	public void clickSearchBth()
	{
		mSearchBtn.click();
	}
	
	public void setPostCode(String txt)
	{
		mPostCode.sendKeys(txt);
	}
	
	public void setDistance(String txt)
	{
		mDistance.sendKeys(txt);
	}
	
	public void setCarMake(String txt)
	{
		mMake.sendKeys(txt);
	}
	
	public void setModel(String txt)
	{
		mModel.sendKeys(txt);
	}
	
	public void setMinPrice(String txt)
	{
		mMinPrice.sendKeys(txt);
	}
	
	public void setMaxPrice(String txt)
	{
		mMaxPrice.sendKeys(txt);
	}
	
	private List<WebElement> getAllSearchResults()
	{
		List<WebElement> links = mSearchResults.findElements(By.className("listing-main-image"));
		
		return links;
	}
	
	public void clickSearchResult(int val)
	{
		getAllSearchResults().get(val).click();
	}
}
