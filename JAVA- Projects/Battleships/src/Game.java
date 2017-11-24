import java.io.Console;
import java.util.Scanner;

public class Game 
{
	private static Game mSingleton = null;
	
	private boolean mRunning = false;
	
	public enum GameStates
	{
		SHIPPLACEMENT,
		PLAYER1,
		PLAYER2,
		ENDOFGAME,
		
		NUMBEROFSTATES
	}
	
	GameStates mCurrentState;
	
	public Player mPlayer1 = new Player("Player 1");
	public Player mPlayer2 = new Player("Player 2");

	private Game() 
	{
		mCurrentState = GameStates.SHIPPLACEMENT;
		
		mRunning = true;
	}
	
	public static Game Singleton()
	{
		if(mSingleton == null)
		{
			mSingleton = new Game();
		}
		
		return mSingleton;
	}
	
	public void update()
	{
		switch(mCurrentState)
		{
		case SHIPPLACEMENT:
			shipPlacement();
			break;
		case PLAYER1:
			playerAttacks(mPlayer1, mPlayer2);
			break;
		case PLAYER2:
			playerAttacks(mPlayer2, mPlayer1);
			break;
		case ENDOFGAME:
			printWhiteSpace(10);
			System.out.println("END OF GAME");
			rematch();
			break;
		}
	}
	
	public void shipPlacement()
	{
		System.out.println("Player One Place Your Ships");
		mPlayer1.placeBattleShips();
		
		System.out.println("Player Two Place Your Ships");
		mPlayer2.placeBattleShips();
				
		System.out.println("All Ships have been placed BEGIN");
		
		mCurrentState = GameStates.PLAYER1;
	}
	
	public boolean isRunning()
	{
		return mRunning;
	}
	
	public void playerAttacks(Player attacking, Player defending)
	{
		printWhiteSpace(7);
				
		System.out.println(attacking.getName() + " Your Turn");
		System.out.println("Choose your attack position on : " + defending.getName());
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Row (a - c) : ");
		String pos = input.nextLine();
		System.out.println("Enter Column (1 - 3): ");
		int col = input.nextInt();
		
		//input.close();
		
		if(defending.hasHitShip(pos.charAt(0), col))
		{
			if(defending.haveYouBeenKilled())
			{
				System.out.println(attacking.getName() + " Has Won the game ");
				mCurrentState = GameStates.ENDOFGAME;
				return;
			}
			System.out.println("You have hit a ship, Have another go");
			playerAttacks(attacking, defending);
		}
		else
		{
			System.out.println("You have Missed");
			
			switch(mCurrentState)
			{
			case PLAYER1:
				mCurrentState = GameStates.PLAYER2;
				break;
			case PLAYER2:
				mCurrentState = GameStates.PLAYER1;
				break;
			default:
				break;
			}
		}	
	}
	
	public void printWhiteSpace(int numlines)
	{
		for(int i = 0; i < numlines; i++)
			System.out.println();
	}
	
	public void rematch()
	{
		System.out.println("Do you want to play Again ? ");
		System.out.println("type y if you do, or n if you do not ");
		
		Scanner input = new Scanner(System.in);
		String value = input.nextLine();
		
		if(value.equals("y"))
		{
			mPlayer1.resetShips();
			mPlayer2.resetShips();
			mCurrentState = GameStates.SHIPPLACEMENT;
		}
		else
		{
			mRunning = false;
		}
	}

}
