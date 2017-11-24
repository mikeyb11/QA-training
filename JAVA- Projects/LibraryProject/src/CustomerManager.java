import java.util.ArrayList;
import java.util.Iterator;
	
public class CustomerManager 
{
	// ----------------------------------------------
	// Singleton 
	private static CustomerManager mSingleton = null;
	
	private CustomerManager() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerManager Singleton()
	{
		if(mSingleton == null)
		{
			mSingleton = new CustomerManager();
		}
		
		return mSingleton;
	}
	// ----------------------------------------------
	
	private ArrayList<Customer> mCustomers = new ArrayList<Customer>();
	
	public void addCustomer(Customer item)
	{
		mCustomers.add(item);
	}
	
	public void removeCustomer(String name)
	{
		if(mCustomers.isEmpty())
		{
			System.out.println("There are no Customer in the Database, with that name : " + name);
			return;
		}
		else
		{
			Iterator<Customer> i = mCustomers.iterator();
			while (i.hasNext()) {
			   Object o = i.next();
			   	if(((Item) o).getName().equals(name))
				{
					i.remove();
					System.out.println(name + " removed from Database");
				}
			}
		}
	}
	
	public void DisplayAllCustomers()
	{
		if(mCustomers.size() > 0)
		{
			for(Customer item : mCustomers)
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
	
	public void DisplayCustomerDetails(String name)
	{
		int counter = 0;
		for(Customer item : mCustomers)
		{
			if(item.getName().equals(name))
			{
				System.out.println(item.getName());
				counter++;
			}
		}
		
		if(counter == 0)
		{
			System.out.println("There are no Customer by the name  " + name + "  in the System");
			StateMachine.Singleton().ReturnToMainMenu();
		}
	}
}