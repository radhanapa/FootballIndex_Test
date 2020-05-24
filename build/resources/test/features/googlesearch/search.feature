Feature: Google Search functionality

  Scenario: Google Search scenario
    Given I am on google search page
    When I search for "qwerty" in search box
    Then search should be successfull