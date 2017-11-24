
public class main 
{

	public static void main(String[] args) 
	{
		while(Game.Singleton().isRunning())
			Game.Singleton().update();
		
		System.out.println("GAME ENDS");

	}

}
