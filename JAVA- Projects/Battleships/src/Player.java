import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player 
{
	private String mPlayerName;
	private int mNumberOfAliveShips;
	
	List<Battleship> mBattleships = new ArrayList<Battleship>();
	
	
	public Player(String name)
	{
		mPlayerName = name;
		mBattleships.add(new Battleship(TypeOfShip.PATROL));
		mBattleships.add(new Battleship(TypeOfShip.SUBMARINE));
	}
	
	// loop for placing all ships the player has
	public void placeBattleShips()
	{
		for(Battleship bs : mBattleships)
		{
			placeShip(bs);
		}
		
		System.out.println("Player has placed all there ships");
	}
	
	public String getName()
	{
		return mPlayerName;
	}
	
	// used to define what ship is being placed, and a recursive function if it needs to be replaced  
	private void placeShip(Battleship ship)
	{
		if(!ship.hasBeenPlaced())
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter Row of the ship (a - c) : " + ship.getType());
			String pos = input.nextLine();
			
			System.out.println("Enter Column of the ship (1 - 3): " + ship.getType());
			int col = input.nextInt();
			
			//input.close();
			
			System.out.println(pos + col);
			
			// is the desired pos on the level
			if(Level.Singleton().isPositionInMap(pos + col))
			{
				// is that position already being used by another ship
				if(!checkPlayerShipPos(pos.charAt(0), col))
				{
					// can the ship be placed at that position, will it fit
					if(ship.setPosition(pos.charAt(0), col))
					{
						ship.placedShip(true);
						System.out.println(ship.getType() + " Ship has been successfully placed on the board");
					}
					else
					{
						System.out.println("This position will not fit the whole ship. Please re enter");
						placeShip(ship);
					}
				}
				else
				{
					System.out.println("This in not a valid location. Please re enter");
					placeShip(ship);
				}
			}
			else
			{
				System.out.println("This in not a valid location. Please re enter");
				placeShip(ship);
			}
		}
	}
	
	// checking that you have not put ship on top of each other.
	private boolean checkPlayerShipPos(char row, int col)
	{
		for(Battleship bs : mBattleships)
		{
			// has the ship been placed and the position is different
			if(bs.hasBeenPlaced())
			{
				// they are on top of each other so return true
				for(int i = 0; i < bs.getPositions().length; i++)
				{
					if(bs.getPositions()[i].getRow() == row && bs.getPositions()[i].getColumn() == col)
					{
						return true;
					}
				}
			}
			else
			{
				return false;
			}
		}
		
		// Safety to return false, in case it is the first ship to be placed
		return false;
	}
	
	public boolean hasHitShip(char row, int col)
	{
		for(Battleship bs : mBattleships)
		{
			if(!bs.isShipDead())
			{
				return bs.didYouHitShip(row, col);
			}
		}
		
		// Safety to return false
		return false;
	}
	
	public boolean haveYouBeenKilled()
	{
		for(Battleship bs : mBattleships)
		{
			if(!bs.isShipDead())
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void resetShips()
	{
		for(Battleship bs : mBattleships)
		{
			bs.placedShip(false);
		}
	}
}
