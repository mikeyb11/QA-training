package qa.consulting.com.Automated_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
    private static WebDriver mDriver;
	
	public static WebDriver Driver() throws Exception
    {
        if(mDriver == null)
            throw new Exception("The WebDriver browser instance was not initialized. You should first call the method InitBrowser.");
        return mDriver;

    }
	
	public static void InitBrowser(String browserName)
    {          
        switch (browserName.toLowerCase())
        {
            case "firefox":
                if (mDriver == null)
                {
                    mDriver = new FirefoxDriver();
                }
                break;

            case "ie":
                if (mDriver == null)
                {
                    mDriver = new InternetExplorerDriver();
                }
                break;

            case "chrome":
                if (mDriver == null)
                {
                	mDriver = new ChromeDriver();
                }
                break;
                
             default:
                	System.out.println("Unkown browser type, defaulting to Chrome");
                	mDriver = new ChromeDriver();
            	 break;
        }            
    }

    public static void LoadApplication(String url)
    {
        mDriver.navigate().to(url);
    }

    public static void CloseDrivers()
    {
        mDriver.quit();
    }

}
