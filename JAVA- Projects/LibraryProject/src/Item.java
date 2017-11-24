import java.util.Date;

public abstract class Item 
{
	protected String mName;
	protected boolean mIsCheckedOut;
	protected int mDuration;
	protected float mOverdueCharges;
	protected int mDaysOverdue;
	
	protected Date mAddedtoLibaray;
	
	protected Customer mAssignedCustomer;
	
	protected TypeOfItem mType;
	
	// add a customer object with get and sets for who currently has it

	public Item(String name) 
	{
		mName = name;
		
		mAddedtoLibaray = new Date();
	}
	
	public abstract float CalulateOverdueCharges();
	
	public TypeOfItem getItemType() { return mType; }
	
	public String getName() { return mName; }
	
	public void setName(String name) { mName = name; }
	
	public boolean getIsCheckedout() { return mIsCheckedOut; }
	
	public void setIsCheckedout(boolean checkout) { mIsCheckedOut = checkout; }
	
	public int getCheckoutDuration() { return mDuration; }
	
	public void setCheckoutDuration(int duration) { mDuration = duration; }
	
	// Doesn't get the time added but the time now
	public Date getDateAdded() { return mAddedtoLibaray; }
	
	public boolean CheckOutitem(int duration, Customer customer)
	{
		if(duration > 0 && customer != null)
		{
			System.out.println(customer.getName() + " You have checked out : " + mName);
			setCheckoutDuration(duration);
			setIsCheckedout(true);
			
			mAssignedCustomer = customer;
			
			return true;
		}
		else
		{
			System.out.println("Unable to check out, please set right check out duration");
		}
	
		return false;
	}

}
