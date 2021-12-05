package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailStepDefinition {

    @Given("^I launch browser and navigate to Gmail$")
    public void launch_browser_and_navigate_to_Gmail() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
    }

    @When("I enter {string} in the username field and click on next button")
    public void enterUsernameAndClickOnNextButton(String username) {

    }
}
