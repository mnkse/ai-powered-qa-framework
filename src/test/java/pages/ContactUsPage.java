package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import org.junit.Assert;


public class ContactUsPage {

    private final WebDriver driver;

    private final By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");
    private final By nameInput = By.name("name");
    private final By emailInput = By.name("email");
    private final By subjectInput = By.name("subject");
    private final By messageInput = By.name("message");
    private final By submitButton = By.name("submit");

    private final By successMessage =
            By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]");

    public ContactUsPage() {
        this.driver = DriverFactory.getDriver();
    }

    public void openHomePage() {
        driver.get("https://automationexercise.com/");
    }

    public void openContactUsPage() {
        driver.findElement(contactUsLink).click();
    }

    public void fillContactForm() {
        driver.findElement(nameInput).sendKeys("Test User");
        driver.findElement(emailInput).sendKeys("testuser@example.com");
        driver.findElement(subjectInput).sendKeys("Automation Test");
        driver.findElement(messageInput)
                .sendKeys("This message was submitted by an automated UI test.");
    }

    public void submitContactForm() {
        driver.findElement(submitButton).click();
    }

    public void verifySuccessMessage() {
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
    }
}