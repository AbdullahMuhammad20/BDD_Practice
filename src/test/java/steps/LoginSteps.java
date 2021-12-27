package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSteps
{
    WebDriver driver;

    public void setup_driver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://classic.freecrm.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Given("user open the portal and go to login page")
    public void user_open_the_portal_and_go_login_page()
    {
        // call setup function to run the chrome driver
        setup_driver();

        // navigate to signup page and wait for a few second
        driver.findElement(By.xpath("//a[@href='https://classic.freecrm.com/register/'][contains(.,'Sign Up')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // navigate to login page
        driver.findElement(By.xpath("//a[@href='https://ui.cogmento.com/'][contains(.,'Got an account? Log in here')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @When("The user enter the email as {string} and {string} and click on login button")
    public void the_user_enter_the_email_and_password_and_click_on_login_button(String userName,String password)
    {
        // wait for a few second before enter username and password and click on login button
        WebDriverWait wait = new WebDriverWait(driver,5);

        By UserName = By.name("email");
        By Password = By.name("password");
        By login_button =  By.xpath("//div[@class='ui fluid large blue submit button'][contains(.,'Login')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(UserName));
        driver.findElement(UserName).sendKeys(userName);
        driver.findElement(UserName).sendKeys(Keys.TAB);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        driver.findElement(Password).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(login_button));
        driver.findElement(login_button).click();
    }

    @Then("The user should navigate to main the home page")
    public void the_user_should_navigate_to_main_the_home_page()
    {
        // wait until the username is show then assert on it
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("The user navigated to the home page");
        WebElement logo = driver.findElement(By.className("header item"));
        Assert.assertTrue(logo.isDisplayed());
        driver.quit();
    }

    @Then("Error message should appear")
    public void Error_message_should_appear()
    {
        // this wait just to see the username using your easy before exit the browser
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement ui_negative_message = driver.findElement(By.className("ui negative message"));
        Assert.assertTrue(ui_negative_message.isDisplayed());
        driver.quit();
    }

    @When("Clicks on contacts")
    public void Clicks_on_contacts()
    {
        By Contact_button = By.className("users icon");
        driver.findElement(Contact_button).click();
    }

    @Then("Create button should be visible")
    public void Create_button_should_be_visible()
    {
        By Create_button = By.xpath("//button[@class='ui linkedin button'][contains(.,'Create')]");
        Assert.assertTrue(driver.findElement(Create_button).isDisplayed());
    }

    @And("clicks on add new Contact")
    public void clicks_on_add_new_Contact()
    {
        By Create_button = By.xpath("//button[@class='ui linkedin button'][contains(.,'Create')]");
        driver.findElement(Create_button).click();
    }
    @And("Fill the first name and password")
    public void Fill_the_first_name_and_password()
    {
        By First_name = By.name("first_name");
        By Last_name = By.name("last_name");
        By Save_button = By.xpath("//button[@class='ui linkedin button'][contains(.,'Save')]");

        driver.findElement(First_name).sendKeys("Test1");
        driver.findElement(Last_name).sendKeys("BDD");
        driver.findElement(Save_button).click();

    }
    @Then("A new contact should be added")
    public void A_new_contact_should_be_added()
    {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        By Contact_Name = By.className("ui header item mb5 light-black");
        Assert.assertTrue(driver.findElement(Contact_Name).isDisplayed());
    }

}
