import PageObjects.googleClass;
import Utility.Instance;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class googleTest extends Instance {
    Instance base;
    googleClass google;


    @BeforeClass
    public void setup(){

        base = new Instance();
        base.SetupBrowser("edge","https://www.google.com");
        google = new googleClass();
    }


    @Test(priority = 1)
    public void pageTitleVerification(){
        Assert.assertEquals(base.getPageTitle(),"Google");
        base.extentReporting("today","Scenario1");
        base.logger.log(Status.PASS,"This Page Title must be google and clicking some buttons");
    }

    @Test(priority = 2)
    public void clickGoogleApps(){
        google.clickGoogleApps();
        google.clickSignIn();
        base.extentReporting("now","Testing Google");
        base.logger.log(Status.INFO,"This will click google apps button");

    }

    @AfterMethod
    public void cleanup(){
       // driver.quit();
    }
}

