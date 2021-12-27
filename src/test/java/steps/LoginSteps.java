package steps;
import com.practice.base.Base;
import com.practice.pages.HomePage;
import com.practice.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends Base
{

    LoginPage loginPage;
    HomePage homePage;
    @Given("user open the portal and go to login page")
    public void user_open_the_portal_and_go_login_page()
    {
        // call setup function to run the chrome driver
        launchBrowser();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage =  new LoginPage();
        loginPage.redirections();
    }

    @When("The user enter the email as {string} and {string} and click on login button")
    public void the_user_enter_the_email_and_password_and_click_on_login_button(String userName,String password)
    {
        // wait for a few second before enter username and password and click on login button
        WebDriverWait wait = new WebDriverWait(driver,5);
        loginPage =  new LoginPage();
        loginPage.performLogin(userName,password);
    }

    @Then("The user should navigate to main the home page")
    public void the_user_should_navigate_to_main_the_home_page()
    {
        // wait until the username is show then assert on it
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.isLogoDisplayed();

    }

    @Then("Error message should appear")
    public void Error_message_should_appear()
    {
        // this wait just to see the username using your easy before exit the browser
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.CheckErrorMessage();

    }



}
