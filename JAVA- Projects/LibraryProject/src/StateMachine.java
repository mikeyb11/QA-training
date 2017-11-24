
public class StateMachine 
{

	// ----------------------------------------------
	// Singleton 
	private static StateMachine mSingleton = null;
	
	private StateMachine() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public static StateMachine Singleton()
	{
		if(mSingleton == null)
		{
			mSingleton = new StateMachine();
		}
		
		return mSingleton;
	}
	// ----------------------------------------------
	
	private MenuStates mStates;
	
	public void changeState(MenuStates state)
	{
		mStates = state;
		mStates.OnEnter();
	}
	
	public void ReturnToMainMenu()
	{
		mStates = new MainMenuState();
		mStates.OnEnter();
	}

}
