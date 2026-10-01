package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import utils.DriverFactory;

public class CartSteps {

    private final CartPage cartPage =
            new CartPage(DriverFactory.getDriver());

    @Given("user is on home page for cart test")
    public void userIsOnHomePage() {
        cartPage.navigateToHomePage();
    }

    @When("user navigates to products page for cart")
    public void userNavigatesToProductsPage() {
        cartPage.navigateToProductsPage();
    }

    @When("user adds Blue Top product to cart")
    public void userAddsBlueTopProductToCart() {
        cartPage.addBlueTopToCart();
    }

    @When("user opens shopping cart")
    public void userOpensShoppingCart() {
        cartPage.clickViewCart();
    }

    @Then("Blue Top product should be displayed in cart")
    public void blueTopProductShouldBeDisplayedInCart() {

        Assert.assertEquals(
                "Blue Top",
                cartPage.getProductName()
        );
    }

    @Then("product quantity should be {string}")
    public void productQuantityShouldBe(String expectedQuantity) {

        Assert.assertEquals(
                expectedQuantity,
                cartPage.getProductQuantity()
        );
    }
}