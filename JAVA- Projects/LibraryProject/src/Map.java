
public class Map extends Item
{
	private int mMapScale;
	private String mDescription;

	public Map(String name, int mapScale, String description) 
	{
		super(name);
		
		mMapScale = mapScale;
		mDescription = description;
		
		mType = TypeOfItem.MAP;
	}

	public float CalulateOverdueCharges()
	{
		return mOverdueCharges = mDuration * 1.5f;
	}
	
	public int getMapSclae() { return mMapScale; }
	
	public String getDescription() { return mDescription; }
}
