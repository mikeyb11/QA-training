import java.util.Scanner;


public class Order 
{

	public Order() 
	{
		// TODO Auto-generated constructor stub
	}

	public void processOrder(Item item, Customer customer)
	{
		if(item.getIsCheckedout())
		{
			System.out.println("Unable to check out, this item is on loan");
		}
		else
		{
			System.out.println("Enter the amount of days for the loan: ");
			Scanner input = new Scanner(System.in);
			int duration = input.nextInt();
			
			if(!item.CheckOutitem(duration, customer))
				processOrder(item, customer);
		}
	}
	
	
}
