import java.util.Scanner;


public class MainMenuState extends MenuStates
{

	public MainMenuState() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void OnEnter()
	{
		System.out.println("----- Main Menu -----");
		
		System.out.println("Enter the numer of the task you want to do :");
		System.out.println("1 -- Items in the System");
		System.out.println("2 -- Customers in the System");
		System.out.println("3 -- Create Order");
		System.out.println("4 -- View Item Inventory");
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numer :");
		int number = input.nextInt();
		
		switch(number)
		{
			case 1:
				System.out.println("Items in the System");
				StateMachine.Singleton().changeState(new ItemMenu());
			break;
			case 2:
				System.out.println("Customers in the System");
				StateMachine.Singleton().changeState(new CustomerMenu());
			break;
			case 3:
				System.out.println("Create Order");
			break;
			case 4:
				System.out.println("View entire Item Inventory");
				Inventory.Singleton().DisplayItemsInInventory();
				StateMachine.Singleton().ReturnToMainMenu();
			break;
			default:
				break;
		}
	}

}
