import java.util.ArrayList;
import java.util.Iterator;


public class Inventory 
{
	// ----------------------------------------------
	// Singleton 
	private static Inventory mSingleton = null;
	
	private Inventory() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static Inventory Singleton()
	{
		if(mSingleton == null)
		{
			mSingleton = new Inventory();
		}
		
		return mSingleton;
	}
	// ----------------------------------------------
	
	private ArrayList<Item> mItemInventory = new ArrayList<Item>();
	
	public void addToItemInventory(Item item)
	{
		mItemInventory.add(item);
	}
	
	public void removeItemFromInventory(String name)
	{
		if(mItemInventory.isEmpty())
		{
			System.out.println("There are no Items in the Inventory");
			return;
		}
		else
		{
			Iterator<Item> i = mItemInventory.iterator();
			while (i.hasNext()) {
			   Object o = i.next();
			   	if(((Item) o).getName().equals(name))
				{
					i.remove();
				}
			}
		}
	}
	
	public void DisplayItemsInInventory()
	{
		if(mItemInventory.size() > 0)
		{
			for(Item item : mItemInventory)
			{
				// also need to add if it is checkedout and who has it
				System.out.println(item.getName());
			}
		}
		else
		{
			System.out.println("There are no items in the Inventory");
		}
	}
	
	public void DisplayItemsInInventory(TypeOfItem type)
	{
		int counter = 0;
		for(Item item : mItemInventory)
		{
			if(item.getItemType() == type)
			{
				System.out.println(item.getName());
				counter++;
			}
		}
		
		if(counter == 0)
		{
			System.out.println("There are no " + type.toString() + " in the Inventory");
			StateMachine.Singleton().ReturnToMainMenu();
		}
	}
	
	public void DisplayCheckedOutitems()
	{
		for(Item item : mItemInventory)
		{
			if(item.getIsCheckedout())
				System.out.println(item.getName());
		}
	}
}
