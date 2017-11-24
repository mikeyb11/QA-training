import java.util.Scanner;


public class OrderMenu extends MainMenuState 
{

	public OrderMenu() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void OnEnter()
	{
		System.out.println("----- Order Menu -----");
		
		System.out.println("Enter the numer of the task you want to do :");
		System.out.println("1 -- Check Out Item");
		System.out.println("2 -- Check in Item");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numer :");
		int number = input.nextInt();
		
		switch(number)
		{
			case 1:
				System.out.println("Check Out Item");
			break;
			case 2:
				System.out.println("Check in Item");
			break;
			default:
				break;
		}
	}
	
	private void Checkoutitem()
	{
		System.out.println("----- Check Out Item -----");
		
		System.out.println("Enter the name of the customer :");
		Scanner input = new Scanner(System.in);
		
		String name = input.nextLine();
		
	}

}
