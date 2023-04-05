Feature: Add a new employee

  Scenario: Adding a new employee
    Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully