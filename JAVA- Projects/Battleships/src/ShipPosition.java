
public class ShipPosition 
{
	private char mRow;
	private int mColumn;
	
	private boolean mBeenHit = false;
	
	public ShipPosition()
	{
		mRow = 'a';
		mColumn = 1;
	}
	
	// error check that it is inside the map
	public void setPosition(char row, int col)
	{
		mRow = row;
		mColumn = col;
	}
	
	public int getColumn()
	{
		return mColumn;
	}
	
	public char getRow()
	{
		return mRow;
	}
	
	public boolean hasPositionBeenHit()
	{
		return mBeenHit;
	}
	
	public void hitPostion(boolean hit)
	{
		mBeenHit = hit;
	}
}
