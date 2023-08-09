Feature: Register

  Scenario: Register
    Given I open the web site
    When I go to Register Page
    And I fill the form
    And I click on button
    Then a success register shows
