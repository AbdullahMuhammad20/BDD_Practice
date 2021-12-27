package com.practice.pages;


import com.practice.base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Base
{
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "email")
    WebElement UserName;

    @FindBy(name = "password")
    WebElement Password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")
    WebElement login_button;

    @FindBy(className = "ui negative message")
    WebElement ui_negative_message;

    @FindBy(xpath = "//a[@href='https://classic.freecrm.com/register/'][contains(.,'Sign Up')]")
    WebElement SignUp_button;

    @FindBy(xpath = "//a[@href='https://ui.cogmento.com/'][contains(.,'Got an account? Log in here')]")
    WebElement login_here_button;

    public void redirections()
    {
        SignUp_button.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        login_here_button.click();
    }

    public void performLogin(String userName, String password)
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        UserName.sendKeys(userName);
        Password.sendKeys(password);
        login_button.click();
    }

    public void CheckErrorMessage()
    {
        Assert.assertTrue(ui_negative_message.isDisplayed());
    }
}
