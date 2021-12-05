import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {
                "StepDefinition",
        },
        plugin = {
                "pretty",
                "json:target/cucumberReports/cucumber-json.json"},
        publish = true)

public class RunCucumberTest {

}