package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.ContactUsPage;

public class ContactUsSteps {

    private final ContactUsPage contactUsPage = new ContactUsPage();

    @Given("user is on the Automation Exercise home page")
    public void userIsOnTheAutomationExerciseHomePage() {
        contactUsPage.openHomePage();
    }

    @When("user navigates to the Contact Us page")
    public void userNavigatesToTheContactUsPage() {
        contactUsPage.openContactUsPage();
    }

    @When("user enters valid contact information")
    public void userEntersValidContactInformation() {
        contactUsPage.fillContactForm();
    }

    @When("user submits the contact form")
    public void userSubmitsTheContactForm() {
        contactUsPage.submitContactForm();
    }

    @Then("contact form success message should be displayed")
    public void contactFormSuccessMessageShouldBeDisplayed() {
        contactUsPage.verifySuccessMessage();
    }
}