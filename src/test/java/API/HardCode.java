package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCode {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUyMjM4OTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTI2NzA5NCwidXNlcklkIjoiNTQyMCJ9.oyEbBqMWNCeLCch-C2iFEIZL0KPT6j5ffNYUscdyoPs";
    static String employee_id;

    @Test
    public void b_getCreatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        // hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        // verify the response
        response.then().assertThat().statusCode(200);

        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);
    }

    @Test
    public void a_createEmployee() {
        // prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"jon\",\n" +
                        "  \"emp_lastname\": \"jovi\",\n" +
                        "  \"emp_middle_name\": \"bon\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2010-05-20\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Songwriter\"\n" +
                        "}");

        // hitting the endpoint / send request
        Response response = preparedRequest.when().post("/createEmployee.php");

        // print output in the console (API only!!!)
        response.prettyPrint();

        // verifying the assertions / get response
        response.then().assertThat().statusCode(201);

        // capture employee id from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        // verify the firstname in the response body
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("jon"));
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("jovi"));

        // verify the response headers
        response.then().assertThat().header("Content-Type", "application/json");

        System.out.println("Test case passed");

    }

    @Test
    public void c_updateEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"james\",\n" +
                        "  \"emp_lastname\": \"smith\",\n" +
                        "  \"emp_middle_name\": \"robert\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-05-20\",\n" +
                        "  \"emp_status\": \"Probation\",\n" +
                        "  \"emp_job_title\": \"CEO\"\n" +
                        "}");

        // hitting the endpoint / send request
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        // verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }

    @Test
    public void d_getUpdatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        // to verify the body of the response use hamcrest matchers

    }

}
