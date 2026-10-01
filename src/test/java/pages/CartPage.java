package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productsButton =
            By.xpath("//a[@href='/products']");

    private final By blueTopProduct =
            By.xpath("//p[text()='Blue Top']");

    private final By blueTopAddToCart =
            By.xpath("//p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]");

    private final By viewCartButton =
            By.xpath("//u[text()='View Cart']");

    private final By cartProductName =
            By.xpath("//td[@class='cart_description']//a");

    private final By cartProductPrice =
            By.xpath("//td[@class='cart_price']/p");

    private final By cartProductQuantity =
            By.xpath("//button[@class='disabled']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://automationexercise.com");
    }

    public void navigateToProductsPage() {
        click(productsButton);
    }

    public void addBlueTopToCart() {
        scrollToElement(blueTopProduct);
        click(blueTopAddToCart);
    }

    public void clickViewCart() {
        click(viewCartButton);
    }

    public String getProductName() {
        return getText(cartProductName);
    }

    public String getProductPrice() {
        return getText(cartProductPrice);
    }

    public String getProductQuantity() {
        return getText(cartProductQuantity);
    }
}