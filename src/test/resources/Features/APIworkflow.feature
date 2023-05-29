Feature: API workflow for HRMS

  Background:
    Given JWT is generated

  @api
  Scenario: Create an employee using API call
    Given the request is prepared to create an employee
    When the POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee ID "Employee.employee_id" is stored as a global variable to be used for other calls


  @apijsonworkflow
  Scenario: Create an employee using API call
    Given the request is prepared to create an employee using json payload
    When the POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee ID "Employee.employee_id" is stored as a global variable to be used for other calls


  @apijsonworkflow
  Scenario: retrieve an employee using API call
    Given the request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code for this employee is 200
    Then the employee data we get having id "employee.employee_id" must match with globally stored employee id
    Then the retrieved data at "employee" object matches with the data of created employee
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status | emp_job_title |
      | jon           | jovi         | bon             | Male       | 2010-05-20   | confirmed  | Songwriter    |


  @dynamic
  Scenario: Create an employee using API call
    Given the request is prepared to create an employee with dynamic data "jon", "jovi", "bon", "M", "2010-05-20", "Confirmed", "Songwriter";
    When the POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee ID "Employee.employee_id" is stored as a global variable to be used for other calls

  @updateemployee
  Scenario: update an employee via API call
    Given the request is prepared to update an employee
    When the PUT call is made to update an employee
    Then the status code of updated employee is 200