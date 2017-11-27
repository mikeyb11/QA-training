package qa.consulting.com.Automated_Testing;
import org.junit.*;

public class MyClass {
	
	@BeforeClass
	public static void beforeClass()
	{
		// Runs at the start -- before every thing
		System.out.println( "Before Class" );
	}
	
	@Before
	public void before()
	{
		// runs before every test
		System.out.println( "Before" );
	}
	
	@Test
	public void test()
	{
		// the test
		System.out.println( "Test" );
	}
	
	@Test
	public void hello()
	{
		// the test
		System.out.println( "Hello World!" );
	}
	
	@After
	public void after()
	{
		// runs after every test
		System.out.println( "After" );
	}
	
	
	@AfterClass
	public static void afterClass()
	{
		// runs last -- after every thing 
		System.out.println( "After Class" );
	}

}
