@GmailTest
Feature: Verify compose email on Gmail

  @GmailLogin
  Scenario: Verify Gmail Login
    Given I navigate to Gmail
    When I enter the username field and click on next button
    And I enter the password field and click on next button
    Then I should be on the Gmail home page
    When I click on compose button and enter "incubytetest@gmail.com" in the To field
    And I enter "Incubyte" in the subject field
    And I enter "Automation QA test for Incubyte" in the body field
    Then I click on send button
    Then Verify mail sent successfully
    Then Close browser
