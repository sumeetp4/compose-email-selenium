@GmailTest
Feature: Verify compose email on Gmail

@GmailLogin
Scenario:Verify Gmail Login
    Given I launch browser and navigate to Gmail
    When I enter "username1" in the username field and click on next button
    And I enter "password1" in the password field and click on next button
    Then I should be on the Gmail home page