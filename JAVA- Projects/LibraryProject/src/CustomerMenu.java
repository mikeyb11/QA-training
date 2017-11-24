import java.util.Scanner;


public class CustomerMenu extends MenuStates
{

	public CustomerMenu() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void OnEnter()
	{
		System.out.println("----- Customer Menu -----");
		
		System.out.println("Enter the numer of the task you want to do :");
		System.out.println("1 -- Add a new Customer to the System");
		System.out.println("2 -- Remove an Customer from the System");
		//System.out.println("1 -- Add a new item to the System");
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numer :");
		int number = input.nextInt();
		
		switch(number)
		{
			case 1:
				System.out.println("Add a new Customer to the System");
				addCustomerToSystem();
			break;
			case 2:
				System.out.println("Remove an Customer from the System");
				removeCustomerFromSystem();
			break;
		}
	}
	
	public void addCustomerToSystem()
	{
		System.out.println("----- Adding Customer to the System -----");
		
		System.out.println("Enter the name of the new Customer :");
		
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		
		Customer newCust = new Customer(name);
		
		CustomerManager.Singleton().addCustomer(newCust);
		
		newCust.printDetails();
		
		StateMachine.Singleton().ReturnToMainMenu();
	}
	
	public void removeCustomerFromSystem()
	{
		
	}

}
