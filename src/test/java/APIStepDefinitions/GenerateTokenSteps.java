package APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;

    @Given("JWT is generated")
    public void jwt_is_generated() {
        RequestSpecification generateTokenRequest =
                given().header("Content-Type", "application/json").
                        body("{\n" +
                                "  \"email\": \"shakeit@icloud.com\",\n" +
                                "  \"password\": \"test123\"\n" +
                                "}");

        // hit the endpoint
        Response response = generateTokenRequest.when().post("/generateToken.php");

        // store the token as global variable
        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);

    }
}
