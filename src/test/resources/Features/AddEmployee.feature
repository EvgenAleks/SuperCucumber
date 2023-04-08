Feature: Add a new employee

  @testcase2 @smoke @regression
  Scenario: Adding a new employee
    Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button
    And user enters firstname and middle name and lastname
    #And user clicks on save button