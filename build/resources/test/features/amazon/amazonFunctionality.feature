Feature: Amazon Functionality

  Scenario: Amazon Functionality sample

    Given I am on amazon home page
    When I login into amazon as username "radha.napa@gmail.com" and password "Saibaba1"
    Then Login successfull

    When I search for "books" in amazon search box
    And I click on first book in search results
    Then I should see fiction books page banner
    And I logout of amazon