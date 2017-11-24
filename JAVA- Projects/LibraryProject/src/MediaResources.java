public class MediaResources extends Item
{
	protected int mCheckoutDeposit;
	protected int mDamageCost;
	
	public MediaResources(String name, int checkoutCost, int damageCost) 
	{
		super(name);
		
		mCheckoutDeposit = checkoutCost;
		mDamageCost = damageCost;
	}
	
	public float CalulateOverdueCharges()
	{
		return mOverdueCharges = mDuration * 2.0f;
	}
	
	public int getDamageCost() { return mDamageCost; }
	
	public int getCheckoutDeposite() { return mCheckoutDeposit; }
}