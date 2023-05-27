Feature: API workflow for HRMS

  Background:
    Given JWT is generated

  @api
  Scenario: Create an employee using API call
    Given Request is prepared to create an employee
    When POST call is made to create an employee
    Then The status code for creating an employee is 201