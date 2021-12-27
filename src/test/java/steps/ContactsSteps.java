package steps;
import com.practice.base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ContactsSteps extends Base
{



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
