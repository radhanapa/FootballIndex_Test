Feature: Scenarios to test random code generator

  Scenario Outline: Test random date with count as 10
    Given I am on date generator home page
    When I enter date generator properties "<COUNT>" , "<DATEFORMAT>" , "<STARTDATE>" and "<ENDDATE>"
    Then I submit values
    And I verify result
    Examples:
      | COUNT | DATEFORMAT               | STARTDATE           | ENDDATE             |
      | 1     | yyyy-mm-dd-hh-mm-ss      | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | yyyy-mm-dd-hh-mm-ss      | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 1     | yyyy-dd-mm-hh-mm-ss      | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | yyyy-dd-mm-hh-mm-ss      | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 1     | mm-dd-yyyy-hh-mm-ss      | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | mm-dd-yyyy-hh-mm-ss      | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 1     | iso8601                  | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | iso8601                  | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 1     | year-month-date-hh-mm-ss | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | year-month-date-hh-mm-ss | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 1     | year-date-month-hh-mm-ss | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | year-date-month-hh-mm-ss | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 1     | month-date-year-hh-mm-ss | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | month-date-year-hh-mm-ss | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 1     | custom                   | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |
      | 100   | custom                   | 1900-01-01 00:00:00 | 2099-12-31 23:59:59 |


  #Failed scenario - it generates all same dates

  Scenario: Test random date with startdate and enddate as same year without time
    Given I am on date generator home page
    When I enter date generator properties "5" , "iso8601" , "2020" and "2020"
    Then I submit values
    And I verify result and fail

      #Failed scenario - it generates some random words

  Scenario: Test random date with custom date format as combination of alphabets
    Given I am on date generator home page
    When I enter custom format as "abcdef" with date generator properties "5" , "custom" , "1900-01-01 00:00:00" and "2099-12-31 23:59:59"
    Then I submit values
    And I verify result and fail