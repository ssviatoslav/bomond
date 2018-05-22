package productPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    WebDriver driver;
    @FindBy(css = "#product_addtocart_form > div.product-shop > div.product_shop_header > div.product-name > h1")
    WebElement productNameOnProductPage;
    @FindBy(css = "#super-product-table > tbody > tr > td.add-to-cart.last > div > div > div.add-to-cart-button-wrapper > button")
    WebElement buyButton;
    @FindBy(css = "#popupAdd > div > div.buttons-set > button")
    WebElement checkoutButton;


    public ProductPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductNameOnProductPage() {
        return productNameOnProductPage;
    }

    public WebElement getBuyButton() {
        return buyButton;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

}
