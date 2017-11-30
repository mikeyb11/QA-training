package qa.consulting.com.Automated_Testing;

public class ShoppingTest_LookUps {
	
	private String mFirstName, mLastName, mEmail, mPassword, mAddress, mCity, mState, mZipCode, mMobileNO, mAddressAlias;
	
	private String mLookUpList = "shoppingLookUp.xlsx";
	
	private SpreadSheetReader mReader;
	
	public ShoppingTest_LookUps()
	{
		mReader = new SpreadSheetReader(mLookUpList);
		
		mFirstName 		= mReader.readCell(0, 1, "Sheet1");
		mLastName  		= mReader.readCell(1, 1, "Sheet1"); 
		mEmail	 		= mReader.readCell(2, 1, "Sheet1");
		mPassword		= mReader.readCell(3, 1, "Sheet1");
		mAddress		= mReader.readCell(4, 1, "Sheet1");
		mCity			= mReader.readCell(5, 1, "Sheet1"); 
		mState  		= mReader.readCell(6, 1, "Sheet1"); 
		mZipCode		= mReader.readCell(7, 1, "Sheet1");
		mMobileNO	 	= mReader.readCell(8, 1, "Sheet1");
		mAddressAlias 	= mReader.readCell(9, 1, "Sheet1");
	}
	
	
	public String getFirstName() 	{ return mFirstName; }
	public String getLastName() 	{ return mLastName; }
	public String getEmail() 		{ return mEmail; }
	public String getPassword() 	{ return mPassword; }
	public String getAddress() 		{ return mAddress; }
	public String getCity() 		{ return mCity; }
	public String getState() 		{ return mState; }
	public String getZipCode() 		{ return mZipCode; }
	public String getMobileNO() 	{ return mMobileNO; }
	public String getAddressAlias() { return mAddressAlias; }
	
}
