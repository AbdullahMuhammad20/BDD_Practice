package com.practice.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base
{
    public static WebDriver driver;
    public static Properties properties = new Properties();

    public Base()
    {
        try
        {
            File fis = new File("src\\main\\java\\com\\practice\\properties\\config.properties");
            FileInputStream file = new FileInputStream(fis);
            properties.load(file);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            throw new Error("file Not Found Exception");
        }
        catch (IOException ioException)
        {
            throw new Error("IO Exception");
        }


    }

    public void launchBrowser()
    {

        if (properties.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        else if (properties.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }
}
