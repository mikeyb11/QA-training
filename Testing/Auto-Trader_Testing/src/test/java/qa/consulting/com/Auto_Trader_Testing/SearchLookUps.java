package qa.consulting.com.Auto_Trader_Testing;

public class SearchLookUps 
{
	private String mPostCode, 
	mDistance, 
	mMake, 
	mModel,
	mMinPrice, 
	mMaxPrice;
	// need to include the more options list

	private String mNumberforSearches;
	
	private String mLookUpList = "lookups.xlsx";
	
	private SpreadSheetReader mReader;
	
	public SearchLookUps()
	{
		
		mReader = new SpreadSheetReader(mLookUpList);
		
		mPostCode 		= mReader.readCell(0, 1, "Sheet1");
		mDistance  		= mReader.readCell(1, 1, "Sheet1"); 
		mMake	 		= mReader.readCell(2, 1, "Sheet1");
		mModel			= mReader.readCell(3, 1, "Sheet1");
		mMinPrice		= mReader.readCell(4, 1, "Sheet1");
		mMaxPrice		= mReader.readCell(5, 1, "Sheet1");
		mNumberforSearches = mReader.readCell(6, 1, "Sheet1");
	}
	
	public String getPostCode() 	{ return mPostCode; }
	public String getDistance() 	{ return mDistance; }
	public String getMake() 		{ return mMake; }
	public String getModel() 		{ return mModel; }
	public String getMinPrice() 	{ return mMinPrice; }
	public String getMaxPrice() 	{ return mMaxPrice; }
	public String getNumberOfSearches() 	{ return mNumberforSearches; }
}
