
public class main 
{

	public static void main(String[] args) 
	{
		//Item mItem = new Book("Java", "mike", 22);
		
		//System.out.println(mItem.getDateAdded().toString());
		
		StateMachine.Singleton().changeState(new MainMenuState());

	}

}
