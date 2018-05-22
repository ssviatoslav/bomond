package checkoutPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.ConfigProperties;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(css = "div.cart-product-name > span > a")
    WebElement productName;
    @FindBy(css = "#checkout-cart-wrapper > div > div.action_button.buttons-set > ul > li > button")
    WebElement checkoutButton;
    @FindBy(id = "onepage-guest-register-button")
    WebElement continueStep1Button;
    @FindBy(id = "firstname")
    WebElement firstNameField;
    @FindBy(id = "lastname")
    WebElement lastNameField;
    @FindBy(xpath = "(//input[@id=\"email\"])[2]")
    WebElement emailField;
    @FindBy(id = "telephone")
    WebElement phoneField;
    @FindBy(css = "#account-buttons-container > button")
    WebElement continueStep2Button;
    @FindBy(css = "#checkout-shipping-method-load > dl > dd > ul > li:nth-child(1) > label")
    WebElement NPShippingMethodCheckbox;
    @FindBy(css = "#form_content > div > div.novaposhta-container.novaposhta-dropdown-container.novaposhta-cities-container > span > span.selection > span")
    WebElement NPCityDropdown;
    @FindBy(css = "#select2-novaposhta_cities-result-xn12-Київ")
    WebElement NPCityKyiv;
    @FindBy(css = "html.js.no-touch.localstorage.no-ios body.checkout-onepage-index span.select2-container.select2-container--default.select2-container--open span.select2-dropdown.select2-dropdown--above span.select2-results ul#select2-novaposhta_cities-results.select2-results__options li#select2-novaposhta_cities-result-9385-Зачепилівка.select2-results__option")
    WebElement NPStorehouseDropdown;
    @FindBy(css = "#select2-novaposhta_warehouses-result-hd3q-Відділення\\20 №2\\3a \\20 вул\\2e \\20 Бережанська\\2c \\20 9\\20 \\28 Оболонь\\20 Лугова\\29")
    WebElement NPStorehouseAddress;
    @FindBy(css = "#shipping-method-buttons-container > button")
    WebElement continueStep3Button;
    @FindBy(css = "#dt_method_checkmo > label")
    WebElement paymentOnDeliveryCheckbox;
    @FindBy(css = "#payment-buttons-container > button")
    WebElement confirmPurchaseButton;
    @FindBy(css = "body > span > span")
    WebElement dropdownNPCity;


    public CheckoutPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getContinueStep1Button() {
        return continueStep1Button;
    }

    public void fillYourselfInformation () {
        firstNameField.click();
        firstNameField.sendKeys(ConfigProperties.getTestProperty("username"));
        lastNameField.click();
        lastNameField.sendKeys(ConfigProperties.getTestProperty("lastname"));
        phoneField.click();
        phoneField.sendKeys(ConfigProperties.getTestProperty("phone"));
        emailField.click();
        emailField.sendKeys(ConfigProperties.getTestProperty("email"));
    }

    public WebElement getContinueStep2Button() {
        return continueStep2Button;
    }

    public WebElement getNPShippingMethodCheckbox() {
        return NPShippingMethodCheckbox;
    }

    public WebElement getNPCityDropdown() {
        return NPCityDropdown;
    }

    public WebElement getNPCityKyiv() {
        return NPCityKyiv;
    }

    public WebElement getNPStorehouseDropdown() {
        return NPStorehouseDropdown;
    }

    public WebElement getNPStorehouseAddress() {
        return NPStorehouseAddress;
    }

    public WebElement getContinueStep3Button() {
        return continueStep3Button;
    }

    public WebElement getPaymentOnDeliveryCheckbox() {
        return paymentOnDeliveryCheckbox;
    }

    public WebElement getConfirmPurchaseButton() {
        return confirmPurchaseButton;
    }

    public WebElement getDropdownNPCity() {
        return dropdownNPCity;
    }
}
