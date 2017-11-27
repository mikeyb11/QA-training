package qa.consulting.com.Automated_Testing;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {
	
	private String url = "https://www.google.com";
	private WebDriver webDriver;
	
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
		
		// opens chrome
		webDriver = new ChromeDriver();
	}
	
	@Test
	public void test()
	{
		// the test
		System.out.println( "Test" );
		
		// navs to the specified URL
		webDriver.navigate().to(url);
		
		// searches for the search bar
		WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
		searchBar.sendKeys("qa \n");
		
		// selects the link on page
		WebElement link = webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div:nth-child(1) > div > div > h3 > a"));
		link.click();
		
		// URL check 
		String currentURL = webDriver.getCurrentUrl();
		String expectedURL = "https://www.qa.com/";
		
		// checks the URL
		Assert.assertEquals(expectedURL, currentURL);
		
	}
	
	@After
	public void after()
	{
		// runs after every test
		System.out.println( "After" );

		webDriver.quit();
	}
	
	
	@AfterClass
	public static void afterClass()
	{
		// runs last -- after every thing 
		System.out.println( "After Class" );
	}

}
