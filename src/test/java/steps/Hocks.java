package steps;

import com.practice.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hocks extends Base
{

    @Before("@Sanity")
    public void run_Before_Any_Scenario()
    {

    }

    @After("@Sanity")
    public void run_After_Any_Scenario()
    {
        driver.quit();
    }
}
