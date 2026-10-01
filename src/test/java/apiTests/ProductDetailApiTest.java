package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductDetailApiTest {

    @Test
    public void getAllProductsTest() {

        RestAssured.baseURI = "https://automationexercise.com";

        Response response =
                given()
                        .log().all()
                        .when()
                        .get("/api/productsList");

        // HTTP status assertion
        Assert.assertEquals(200, response.statusCode());

        // API response is wrapped in HTML
        String responseBody = response.asString();

        Assert.assertTrue(responseBody.contains("\"responseCode\": 200"));
        Assert.assertTrue(responseBody.contains("\"products\""));
        Assert.assertTrue(responseBody.contains("\"name\": \"Blue Top\""));
    }
    @Test
    public void verifyBlueTopProductDetailsTest() {

        RestAssured.baseURI = "https://automationexercise.com";

        Response response =
                given()
                        .log().all()
                        .when()
                        .get("/api/productsList");

        Assert.assertEquals(200, response.statusCode());

        String responseBody = response.asString();

        // HTML wrapper'ı temizle
        String jsonBody = responseBody
                .replace("<html>", "")
                .replace("<body>", "")
                .replace("</body>", "")
                .replace("</html>", "")
                .trim();

        JsonPath jsonPath = new JsonPath(jsonBody);

        String productName = jsonPath.getString("products[0].name");
        String productPrice = jsonPath.getString("products[0].price");
        String productBrand = jsonPath.getString("products[0].brand");

        Assert.assertEquals("Blue Top", productName);
        Assert.assertEquals("Rs. 500", productPrice);
        Assert.assertEquals("Polo", productBrand);
    }

}