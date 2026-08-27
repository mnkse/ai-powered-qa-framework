package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class LoginApiTest {

    @Test
    public void loginUserShouldReturnToken() {

        String requestBody = """
                {
                  "email": "eve.holt@reqres.in",
                  "password": "cityslicka"
                }
                """;

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://reqres.in/api/login");

        Assert.assertEquals(200, response.statusCode());

        String token = response.jsonPath().getString("token");

        Assert.assertNotNull(token);
        Assert.assertFalse(token.isEmpty());
    }
}