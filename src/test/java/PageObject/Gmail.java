package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Driver;

public class Gmail {

    @FindBy(id = "identifierId")
    WebElement username;

    @FindBy(id = "identifierNext")
    WebElement nextBtn;

    @FindBy(xpath = "//*[@id='password']//input")
    WebElement password;

    @FindBy(id = "passwordNext")
    WebElement passNextBtn;

    @FindBy(xpath = "//*[text()='Compose']")
    WebElement composeBtn;

    @FindBy(name = "to")
    WebElement to;

    @FindBy(name = "subjectbox")
    WebElement subject;

    @FindBy(xpath = "//*[@aria-label='Message Body' and @role='textbox']")
    WebElement body;

    @FindBy(xpath = "//*[contains(@aria-label,'Send') and @data-tooltip]")
    WebElement send;

    @FindBy(xpath = "//*[text()='Message sent']")
    WebElement msgSent;

    Driver driver;

    public Gmail(Driver drive) {
        PageFactory.initElements(drive.driver, this);
        this.driver = drive;
    }

    public void enterUser(String user) {
        try {
            driver.waitTillElementIsVisible(username);
            username.sendKeys(user);
            nextBtn.click();
        } catch (Exception e) {
        }
    }

    public void enterPass(String pass) {
        driver.waitTillElementIsVisible(password);
        password.sendKeys(pass);
        passNextBtn.click();
    }

    public boolean isloginSuccessful() {
        boolean flag = true;
        if (driver.waitTillElementIsVisible(composeBtn)) {
            System.out.println("Log in successful");
        } else {
            System.out.println("Login failed");
            flag = false;
        }
        return flag;
    }

    public void composeAndEnterTo(String To) {
        composeBtn.click();
        driver.waitTillElementIsVisible(to);
        to.sendKeys(To);
    }

    public void enterSubject(String Subject) {
        subject.sendKeys(Subject);
    }

    public void enterBody(String Body) {
        body.sendKeys(Body);
    }

    public void sendMail() {
        send.click();
    }

    public boolean isMailSentSuccessful() {
        return driver.waitTillElementIsVisible(msgSent);
    }

}
