package apiTests;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.ApiClient;

@Epic("API Tests")
@Feature("Product API")
public class ProductApiTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify users list API")
    public void getUsersTest() {

        Response response =
                ApiClient.get("/api/users?page=2");

        Allure.addAttachment(
                "Get Users API Response",
                response.asPrettyString()
        );

        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                200,
                response.statusCode()
        );

        Assert.assertTrue(
                response.jsonPath()
                        .getList("data")
                        .size() > 0
        );
    }
    @Test
    public void getProductShouldValidateResponseBody() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://fakestoreapi.com/products/1");

        // Status
        Assert.assertEquals(200, response.statusCode());

        // Content-Type
        Assert.assertTrue(
                response.contentType().contains("application/json")
        );

        // Response body
        int id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        double price = response.jsonPath().getDouble("price");
        String description = response.jsonPath().getString("description");
        String category = response.jsonPath().getString("category");
        String image = response.jsonPath().getString("image");

        // Data validations
        Assert.assertEquals(1, id);

        Assert.assertNotNull(title);
        Assert.assertFalse(title.isEmpty());

        Assert.assertTrue(price > 0);

        Assert.assertNotNull(description);
        Assert.assertFalse(description.isEmpty());

        Assert.assertNotNull(category);
        Assert.assertFalse(category.isEmpty());

        Assert.assertNotNull(image);
        Assert.assertTrue(image.startsWith("http"));

        // Rating validations
        double rating = response.jsonPath().getDouble("rating.rate");
        int ratingCount = response.jsonPath().getInt("rating.count");

        Assert.assertTrue(rating >= 0 && rating <= 5);
        Assert.assertTrue(ratingCount >= 0);

        // Response time
        Assert.assertTrue(response.time() < 5000);
    }
}