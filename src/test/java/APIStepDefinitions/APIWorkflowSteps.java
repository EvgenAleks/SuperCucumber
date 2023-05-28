package APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIWorkflowSteps {

    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("the request is prepared to create an employee")
    public void request_is_prepared_to_create_an_employee() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", GenerateTokenSteps.token).
                body("{\n" +
                        "  \"emp_firstname\": \"jon\",\n" +
                        "  \"emp_lastname\": \"jovi\",\n" +
                        "  \"emp_middle_name\": \"bon\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2010-05-20\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Songwriter\"\n" +
                        "}");
    }

    @When("the POST call is made to create an employee")
    public void post_call_is_made_to_create_an_employee() {
        response = request.when().post("/createEmployee.php");
    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer int1) {
        // argument/value is coming from feature file
        response.prettyPrint();
        response.then().assertThat().statusCode(int1);
    }

    @Then("the employee contains key {string} and value {string}")
    public void the_employee_contains_key_and_value(String message, String value) {
        response.then().assertThat().body(message, equalTo(value));
    }

    @Then("the employee ID {string} is stored as a global variable to be used for other calls")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_used_for_other_calls(String string) {
        // store the Employee ID in global variable
        // this path of Employee ID cones from feature file
        // the name of parameter can be changed
        employee_id = response.jsonPath().getString(string);
        System.out.println(employee_id);
    }
}
