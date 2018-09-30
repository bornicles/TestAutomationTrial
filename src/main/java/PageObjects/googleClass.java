package PageObjects;


import Utility.Instance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class googleClass extends Instance {


   // WebDriverWait wait = new WebDriverWait(driver, 20);


    @FindBy(css = "#gbwa > div > a.gb_b.gb_fc")
    @CacheLookup
    private WebElement googleApps;

    @FindBy(id = "gb_70")
    @CacheLookup
    private WebElement signin;


   public googleClass() {
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public void clickGoogleApps() {

        //wait.until(ExpectedConditions.elementToBeClickable(googleApps));
        googleApps.click();
    }

    public void clickSignIn(){
       signin.click();
    }
}



