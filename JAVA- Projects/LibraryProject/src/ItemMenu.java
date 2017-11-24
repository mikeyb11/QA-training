import java.util.Scanner;


public class ItemMenu extends MenuStates
{

	public ItemMenu() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void OnEnter()
	{
		System.out.println("----- Item Menu -----");
		
		System.out.println("Enter the numer of the task you want to do :");
		System.out.println("1 -- Add a new Item to the System");
		System.out.println("2 -- Remove an Item from the System");
		//System.out.println("1 -- Add a new item to the System");
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numer :");
		int number = input.nextInt();
		
		switch(number)
		{
			case 1:
				System.out.println("Adding a new Item to the System");
				addItemToSystem();
			break;
			case 2:
				System.out.println("Remove an Item from the System");
				removeItemFromSystem();
			break;
		}
	}
	
	public void removeItemFromSystem()
	{
		System.out.println("----- Removing Item from the System -----");
		
		System.out.println("What Type of the item do you wish to remove :");
		System.out.println("1 -- Book");
		System.out.println("2 -- Map");
		System.out.println("3 -- Camera");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numer :");
		int number = input.nextInt();
		
		switch(number)
		{
			case 1:
				System.out.println("Removing Book from the system");
				RemoveBook();
			break;
			case 2:
				System.out.println("Removing Map from the system");
				RemoveMap();
			break;
			case 3:
				System.out.println("Removing Camera from the system");
				RemoveCamera();
			break;
		}
	}
	
	public void addItemToSystem()
	{
		System.out.println("----- Adding Item to the System -----");
		
		System.out.println("What Type of the item do you wish to add :");
		System.out.println("1 -- Book");
		System.out.println("2 -- Map");
		System.out.println("3 -- Camera");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numer :");
		int number = input.nextInt();
		
		switch(number)
		{
			case 1:
				System.out.println("Adding a new Book to the System");
				addBookItem();
			break;
			case 2:
				System.out.println("Adding a new Map to the System");
				addMapItem();
			break;
			case 3:
				System.out.println("Adding a new Camera to the System");
				addCameraItem();
			break;
		}
		
	}
	
	private void addBookItem()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("----- Adding Book to the System -----");
		
		System.out.println("Enter the name of the book :");
		String name = input.nextLine();
		
		System.out.println("Enter the author of the book :");
		String author = input.nextLine();

		System.out.println("Enter the numer of pages in the book:");
		int number = input.nextInt();
		
		Item book = new Book(name, author, number);
		
		Inventory.Singleton().addToItemInventory(book);
		
		System.out.println("Added Book to the System");
		
		StateMachine.Singleton().ReturnToMainMenu();
	}
	
	private void RemoveBook()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("----- Removing Book from the System -----");
		
		System.out.println("List of all books on the system");
		Inventory.Singleton().DisplayItemsInInventory(TypeOfItem.BOOK);
		
		System.out.println("Enter the name of the book you wish to remove:");
		String name = input.nextLine();
		
		Inventory.Singleton().removeItemFromInventory(name);
		
		System.out.println("Book removed from the System");
		
		StateMachine.Singleton().ReturnToMainMenu();
	}
	
	private void addMapItem()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("----- Adding Map to the System -----");
		
		System.out.println("Enter the name of the book :");
		String name = input.nextLine();
		
		System.out.println("Enter the description of the Map :");
		String author = input.nextLine();

		System.out.println("Enter the numer of pages in the book:");
		int number = input.nextInt();
		
		Item book = new Map(name, number, author);
		
		Inventory.Singleton().addToItemInventory(book);
		
		System.out.println("Added Book to the System");
		
		StateMachine.Singleton().ReturnToMainMenu();
	}

	private void RemoveMap()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("----- Removing Map from the System -----");
		
		System.out.println("List of all Maps on the system");
		Inventory.Singleton().DisplayItemsInInventory(TypeOfItem.MAP);
		
		System.out.println("Enter the name of the Map you wish to remove:");
		String name = input.nextLine();
		
		Inventory.Singleton().removeItemFromInventory(name);
		
		System.out.println("Map removed from the System");
		
		StateMachine.Singleton().ReturnToMainMenu();
	}

	private void addCameraItem()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("----- Adding Camera to the System -----");
		
		System.out.println("Enter the name of the Camera :");
		String name = input.nextLine();

		System.out.println("Enter the Checkout Cost of the Camera :");
		int number = input.nextInt();
		
		System.out.println("Enter the Damage Cost of the Camera :");
		int damageCost = input.nextInt();
		
		System.out.println("Enter the Mega Pixel of the Camera :");
		int megaPixel = input.nextInt();
		
		Item book = new Camera(name, number, damageCost, megaPixel);
		
		Inventory.Singleton().addToItemInventory(book);
		
		System.out.println("Added Book to the System");
		
		StateMachine.Singleton().ReturnToMainMenu();
	}

	private void RemoveCamera()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("----- Removing Camera from the System -----");
		
		System.out.println("List of all Maps on the system");
		Inventory.Singleton().DisplayItemsInInventory(TypeOfItem.CAMERA);
		
		System.out.println("Enter the name of the Camera you wish to remove:");
		String name = input.nextLine();
		
		Inventory.Singleton().removeItemFromInventory(name);
		
		System.out.println("Camera removed from the System");
		
		StateMachine.Singleton().ReturnToMainMenu();
	}
}
