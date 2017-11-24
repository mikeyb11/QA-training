import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Customer 
{
	private String mName;
	private ArrayList<Item> mCheckoutItems = new ArrayList<Item>();
	
	private int mIDLength = 5;
	private String mID;
	
	public Customer(String name) 
	{
		mName = name;
		
		CreateID();
	}
	
	private void CreateID()
	{
		mID = mName.substring(0, (int) ((int) mName.length() * 0.5f));
		Random num = new Random();
		
		for(int i = 0; i < mIDLength; i++)
		{
			int h = num.nextInt(10);
			mID +=  Integer.toString(h);
		}

		mID += mID = mName.substring((int) ((int) mName.length() * 0.5f), mName.length());
	}
	
	public void addItem(Item item)
	{
		mCheckoutItems.add(item);
	}
	
	public void removeItem(String name)
	{
		if(mCheckoutItems.isEmpty())
		{
			System.out.println("There are no Items in the Inventory");
			return;
		}
		else
		{
			Iterator<Item> i = mCheckoutItems.iterator();
			while (i.hasNext()) {
			   Object o = i.next();
			   	if(((Item) o).getName().equals(name))
				{
			   		// check for overdue charges
					i.remove();
				}
			}
		}
	}
	
	public String getName() { return mName; }
	
	public String getID() { return mID; }
	
	public void printDetails()
	{
		System.out.println(" Customer details ; Name : " + mName + " ID : " + mID);
	}

}
