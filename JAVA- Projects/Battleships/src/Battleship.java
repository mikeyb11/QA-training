public class Battleship 
//implements ShipPosition
{
	private TypeOfShip mType;
	
	private byte mNumberOfLives = 0, mNumberOfPositions;
	
	private ShipPosition[] mPositions;
	
	private boolean mBeenPlaced = false;
	
	public Battleship(TypeOfShip type) 
	{
		setUpShip(type);
	}
	
	// setting up the amount of lives the ship has
	private void setUpShip(TypeOfShip type)
	{
		mType = type;
		
		switch(type)
		{
		case PATROL:
			mNumberOfLives = 2;
			break;
		case BATTLESHIP:
			mNumberOfLives = 3;
			break;
		case SUBMARINE:
			mNumberOfLives = 3;
			break;
		case DESTORYER:
			mNumberOfLives = 4;
			break;
		case CARRIER:
			mNumberOfLives = 5;
			break;
		default:
			break;
		}
		
		// create the array for the size of the number of lives
		mNumberOfPositions = mNumberOfLives;
		
		mPositions = new ShipPosition[mNumberOfPositions];
		
		for(int i = 0; i < mNumberOfPositions; i++)
			mPositions[i] = new ShipPosition();
		
		//System.out.println(mPositions.length);
	}
	
	public boolean setPosition(char row, int col)
	{
		if(mPositions != null)
		{
			mPositions[0].setPosition(row, col);
			
			for(int i = 1; i < mNumberOfPositions; i++)
			{
				// check that the pos in on the map
				if(Level.Singleton().isPositionInMap(row, col + i))
				{
					//System.out.println(x);
					mPositions[i].setPosition(mPositions[0].getRow(), mPositions[0].getColumn() + i);
				}
				else
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public ShipPosition[] getPositions()
	{
		return mPositions;
	}
	
	public TypeOfShip getType()
	{
		return mType;
	}
	
	public boolean isShipDead()
	{
		return (mNumberOfLives <= 0) ? true : false;
	}
	
	public void hitShip()
	{
		mNumberOfLives--;
		System.out.println(mType + " Has " + mNumberOfLives + " Lives Left");
		
		if(isShipDead())
			System.out.println(mType + " has been destroyed");
	}
	
	public boolean didYouHitShip(char row, int col)
	{
		/*
		 * loop through if the ship positions
		 * Checking if that position has already been hit then early out
		 * else keep checking each position on the ship
		 * if nothing happens then just return false, as you missed
		 */
		for(int i = 0; i < mNumberOfPositions; i++)
		{
			if(!mPositions[i].hasPositionBeenHit())
			{
				if(mPositions[i].getRow() == row && mPositions[i].getColumn() == col)
				{
					mPositions[i].hitPostion(true);
					hitShip();
					return true;
				}
			}
			else
			{
				System.out.println("Already Hit This Position");
			}
		}
		
		return false;
	}
	
	public boolean hasBeenPlaced()
	{
		return mBeenPlaced;
	}
	
	public void placedShip(boolean val)
	{
		mBeenPlaced = val;
	}
}
