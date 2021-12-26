package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LoginSteps
{
    WebDriver driver;
    String USER_NAME = "tiliwe5835@swsguide.com";
    public void setup_driver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://classic.freecrm.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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

    }

    @When("The user enter the email and password and click on login button and click on login button")
    public void the_user_enter_the_email_and_password_and_click_on_login_button(DataTable whenData)
    {
        // wait for a few second before enter username and password and click on login button
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        driver.findElement(By.name("email")).sendKeys(whenData.cell(0,0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(whenData.cell(0,1));

        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")).click();
    }

    @Then("The user should navigate to main the home page")
    public void the_user_should_navigate_to_main_the_home_page()
    {
        // wait until the username is show then assert on it
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.xpath("//span[contains(@class,'user-display')]"));
        Assert.assertEquals("TEST BDD",username.getText().toUpperCase());
    }

    @Then("The Current URL is contain home")
    public void the_current_url_is_contain_home()
    {
        // this wait just to see the username using your easy before exit the browser
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }


    // Check the login with different invalid
    @Given("user open the portal and go to login page to try second")
    public void user_open_the_portal_and_go_login_page_to_try_second()
    {
        // call setup function to run the chrome driver
        setup_driver();

        // navigate to signup page and wait for a few second
        driver.findElement(By.xpath("//a[@href='https://classic.freecrm.com/register/'][contains(.,'Sign Up')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // navigate to login page
        driver.findElement(By.xpath("//a[@href='https://ui.cogmento.com/'][contains(.,'Got an account? Log in here')]")).click();

    }

    @When("The user enter the email as {string} and {string} and click on login button and click on login button")
    public void The_user_enter_the_email_as_username_and_password_and_click_on_login_button_and_click_on_login_button(String username, String password)
    {
        // wait for a few second before enter username and password and click on login button
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")).click();
    }
    @Then("Error message should appear")
    public void Error_message_should_appear()
    {
        System.out.println("Error message for invalid login");
        // this wait just to see the username using your easy before exit the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.quit();
    }
}
