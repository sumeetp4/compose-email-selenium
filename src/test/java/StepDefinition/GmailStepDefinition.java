package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GmailStepDefinition {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^I launch browser and navigate to Gmail$")
    public void launch_browser_and_navigate_to_Gmail() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
    }

    @When("I enter {string} in the username field and click on next button")
    public void enterUsernameAndClickOnNextButton(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
    }

    @And("I enter {string} in the password field and click on next button")
    public void enterPasswordAndClickOnNextButton(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
    }

    @Then("I should be on the Gmail home page")
    public void iShouldBeOnTheGmailHomePage() {
        if(wait==null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Compose')]")));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Inbox"));
    }

    @When("I click on compose button and enter {string} in the To field")
    public void cickComposeAndEnterInTheToField(String emailId) {
        driver.findElement((By.xpath("//div[contains(text(),'Compose')]"))).click();
        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(emailId);
    }

    @And("I enter {string} in the subject field")
    public void enterSubjectField(String subject) {
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(subject);
        }

    @And("I enter {string} in the body field")
    public void enterInTheBodyField(String body) {
        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(body);
    }

    @Then("I click on send button")
    public void iClickOnSendButton() {
        driver.findElement(By.xpath("//div[@aria-label='Send (Ctrl-Enter)']")).click();
    }
}
