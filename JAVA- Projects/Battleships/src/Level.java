public class Level 
{
	private static Level mSingleton = null;
	
	private int mGridSize = 3; // make this match the multidimensional array size
	private  String[][] mLevelGrid = new String[][] {{	"a1", "b1", "c1"	},
											{	"a2", "b2", "c2"	},
											{	"a3", "b3", "c3"	},
											};

	private Level() 
	{
		
	}
	
	public static Level Singleton()
	{
		if(mSingleton == null)
		{
			mSingleton = new Level();
		}
		
		return mSingleton;
	}
	
	public boolean isPositionInMap(char row, int col)
	{
		String pos = row + Integer.toString(col);
		
		return isPositionInMap(pos);
	}
	
	public boolean isPositionInMap(String pos)
	{
		//System.out.println("mGridSize IS : " + mGridSize);
		
		for(int rowLoop = 0; rowLoop < mGridSize; rowLoop++)
		{
			for(int colLoop = 0; colLoop < mGridSize; colLoop++)
			{
				//System.out.println("Loop AT : " + mLevelGrid[colLoop][rowLoop]);
				
				if(mLevelGrid[colLoop][rowLoop].equals(pos))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	

}
