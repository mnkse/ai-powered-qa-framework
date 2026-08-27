Feature: Contact Us Form

  Scenario: User successfully submits the contact form
    Given user is on the Automation Exercise home page
    When user navigates to the Contact Us page
    And user enters valid contact information
    And user submits the contact form
    Then contact form success message should be displayed