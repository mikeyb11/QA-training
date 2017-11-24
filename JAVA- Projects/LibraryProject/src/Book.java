
public class Book extends Item
{
	private int mNumberOfPages;
	private String mAuthor;

	public Book(String name, String author, int numberPages) 
	{
		super(name);
		mAuthor = author;
		mNumberOfPages = numberPages;
		
		mType = TypeOfItem.BOOK;
	}
	
	
	public float CalulateOverdueCharges()
	{
		return mOverdueCharges = mDuration * 0.5f;
	}

}
