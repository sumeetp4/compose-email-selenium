package StepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import PageObject.Gmail;
import Utilities.ConfigReader;
import Utilities.Driver;
import static org.junit.Assert.assertTrue;
import java.util.Properties;

public class GmailStepDefinition {

    Driver driver;
    Gmail gmail;
    Properties config = ConfigReader.loadConfigProperies();

    public GmailStepDefinition() {
        driver = new Driver();
        driver.setDriver();
        gmail = new Gmail(driver);
    }

    @Given("I navigate to Gmail")
    public void launch_browser_and_navigate_to_Gmail() {
        driver.get(config.getProperty("appUrl"));
    }

    @When("I enter the username field and click on next button")
    public void enterUsernameAndClickOnNextButton() {
        String username = System.getProperty("user") != null ? System.getProperty("user") : config.getProperty("username");
        gmail.enterUser(username);
    }

    @And("I enter the password field and click on next button")
    public void enterPasswordAndClickOnNextButton() {
        String password = System.getProperty("pass") != null ? System.getProperty("pass") : config.getProperty("password");
        gmail.enterPass(password);
    }

    @Then("I should be on the Gmail home page")
    public void iShouldBeOnTheGmailHomePage() {
        if (gmail.isloginSuccessful()) {
            String title = driver.getTitle();
            Assert.assertTrue(title.contains("Inbox"));
        } else
            Assert.assertTrue("Login failed", false);
    }

    @When("I click on compose button and enter {string} in the To field")
    public void cickComposeAndEnterInTheToField(String to) {
        gmail.composeAndEnterTo(to);
    }

    @And("I enter {string} in the subject field")
    public void enterSubjectField(String subject) {
        gmail.enterSubject(subject);
    }

    @And("I enter {string} in the body field")
    public void enterInTheBodyField(String body) {
        gmail.enterBody(body);
    }

    @Then("I click on send button")
    public void iClickOnSendButton() {
        gmail.sendMail();
    }

    @Then("Verify mail sent successfully")
    public void mailSendSuccessful() {
        assertTrue("Mail not sent", gmail.isMailSentSuccessful());
    }

    @Then("Close browser")
    public void closeBrowser() {
        driver.close();
    }


}
