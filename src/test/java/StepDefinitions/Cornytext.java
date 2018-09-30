package StepDefinitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cornytext {
    WebDriver driver;

    @Given("^I am at this page$")
    public void i_am_at_this_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Bornicles\\Desktop\\drivers\\chromedriver-v2.40.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @When("^I input something in searchbox$")
    public void i_input_something_in_searchbox() throws Throwable {
         driver.manage().timeouts().wait();
        WebElement textbox = driver.findElement(By.id("lst-ib"));

        textbox.sendKeys("wew");
        throw new PendingException();
    }




    @And("^I click on SearchButton$")
    public void i_click_on_SearchButton() throws Throwable {

    WebElement btn = driver.findElement(By.name("btnK"));
        btn.click();

    }


}

