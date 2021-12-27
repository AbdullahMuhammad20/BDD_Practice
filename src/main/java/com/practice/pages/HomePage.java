package com.practice.pages;

import com.practice.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;
public class HomePage extends Base
{

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "header item")
    WebElement logo;

    public void isLogoDisplayed()
    {
        Assert.assertTrue(logo.isDisplayed());
    }
}
