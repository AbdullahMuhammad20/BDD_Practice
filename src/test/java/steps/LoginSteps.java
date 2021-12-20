package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        setup_driver();
        driver.findElement(By.name("username")).sendKeys("tiliwe5835@swsguide.com");
        driver.findElement(By.name("password")).sendKeys("Aa102030+++");
        driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();

        driver.findElement(By.xpath("//a[@href='https://classic.freecrm.com/register/'][contains(.,'Sign Up')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@href='https://ui.cogmento.com/'][contains(.,'Got an account? Log in here')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);




    }
    @When("The user enter the email and password and click on login button")
    public void the_user_enter_the_email_and_password_and_click_on_login_button()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys(USER_NAME);
        driver.findElement(By.name("password")).sendKeys("Aa102030+++");
        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")).click();
    }

    @Then("The user should navigate to main the home page")
    public void the_user_should_navigate_to_main_the_home_page()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.xpath("//span[contains(@class,'user-display')]"));
        Assert.assertEquals("TEST BDD",username.getText().toUpperCase());

    }

    @Then("The Current URL is contain home")
    public void the_current_url_is_contain_home()
    {
        driver.quit();
    }
}
