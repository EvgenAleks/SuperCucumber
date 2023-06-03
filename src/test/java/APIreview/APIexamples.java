package APIreview;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class APIexamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODU1NzUwNTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTYxODI1NiwidXNlcklkIjoiNTUwOSJ9.J-Ui2vj-tLiY42QPmuPVyTxaTx_aUO5kpk4WT_vi-zY";

    @Test
    public void createAnEmployee() {

        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"Elvis\",\n" +
                        "  \"emp_lastname\": \"Presley\",\n" +
                        "  \"emp_middle_name\": \"Aaron\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1935-01-08\",\n" +
                        "  \"emp_status\": \"King\",\n" +
                        "  \"emp_job_title\": \"Rock-n-roll\"\n" +
                        "}");

        // act as a send key
        // prepared request ---> attached all the data for the request
        Response response = preparedRequest.when().post("/createEmployee.php");
        response.prettyPrint();


        // verification
        response.then().assertThat().statusCode(201);

        // verify the body or the data
        // in order to verify that the value of the key "Message" is "Employee_created"
        // actualvalue=coming from the response
        String expectedValue = "Employee Created";

        // get the actual value out of the response ---> This is the only task that is tough
        String actualValue = response.jsonPath().getString("Message");
        System.out.println(actualValue);

        // verify
        Assert.assertEquals(actualValue, expectedValue);

        // verify that emp_job_title is Rock-n-roll
        String expected = "Rock-n-roll";
        String actual = response.jsonPath().getString("Employee.emp_job_title");
        Assert.assertEquals(expected, actual);

        // response.then().assertThat().body("Employee.emp_job_title", equalTo("Rock-n-roll"));
    }

}
