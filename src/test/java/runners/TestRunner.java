package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/features",glue = "steps",plugin = {"pretty","html:target/reports/reports.html"},dryRun = true)
@CucumberOptions(features = "src/test/java/features",glue = "steps",tags = "@Sanity",plugin = {"pretty"})
public class TestRunner
{

}
