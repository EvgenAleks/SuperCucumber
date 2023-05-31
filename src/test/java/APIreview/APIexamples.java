package APIreview;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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

    }

}
