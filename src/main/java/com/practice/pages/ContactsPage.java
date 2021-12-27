package com.practice.pages;

import com.practice.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends Base
{
    public ContactsPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "header item")
    WebElement Contact_button;

    @FindBy(xpath = "//button[@class='ui linkedin button'][contains(.,'Create')]")
    WebElement Create_button;

    @FindBy(name = "first_name")
    WebElement First_name;

    @FindBy(name = "last_name")
    WebElement Last_name;

    @FindBy(xpath = "//button[@class='ui linkedin button'][contains(.,'Save')]")
    WebElement Save_button;

    @FindBy(className = "ui header item mb5 light-black")
    WebElement Contact_Name;
}
