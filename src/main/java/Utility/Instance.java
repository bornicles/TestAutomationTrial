package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Instance {


    public static WebDriver driver;
    public AjaxElementLocatorFactory ajaxElementLocatorFactory;
    public WebDriverWait wait;
    private static ExtentHtmlReporter reporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    private static String _browser;
    private static String _url = null;

    public void SetupBrowser(String browser, String url){
        _url = url;
        _browser = browser;

            getInstance();

        driver.manage().window().maximize();

        if (_url != null) {
            goTo(_url);
        }
        System.out.println("Test is running in "+ _browser);

    }

    private static WebDriver getInstance() {

        if(_browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bornicles\\Desktop\\testingGravity\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(_browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Bornicles\\Desktop\\testingGravity\\drivers\\chromedriver-v2.40.exe");
            driver = new ChromeDriver();
        }
        else if(_browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver","C:\\Users\\Bornicles\\Desktop\\testingGravity\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if(_browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","C:\\Users\\Bornicles\\Desktop\\testingGravity\\drivers\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }
            return driver;

    }




    private void goTo(String url) {
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public String getPageTitle(){
        return  driver.getTitle();
    }

    public void CleanUp(){
        driver.close();
    }


    public void extentReporting(String ReportName, String ScenarioName){
        reporter = new ExtentHtmlReporter("ExtentReports/"+ReportName+".html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        logger = extent.createTest(ScenarioName);
        /*logger.log(Status.INFO,"testing");
        logger.log(Status.PASS,"test Success");
        logger.log(Status.FAIL,"test Failed");*/
        extent.flush();
    }



}

