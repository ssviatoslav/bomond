package smoke.test;

import categoryPageObjects.ProductsCategoryPage;
import checkoutPageObjects.CheckoutPage;
import createAccountPageObjects.CreateAccountPage;
import customerAccountPageObjects.CustomerAccountPage;
import helper.test.HelperTestClass;
import mainPageObjects.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import productPageObjects.ProductPage;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmokeTest extends HelperTestClass {

    //TC registration of new user:
    @Test
    public void registrationTest() {
        CreateAccountPage registrationPage = PageFactory.initElements(driver, CreateAccountPage.class);
        CustomerAccountPage accountPage = PageFactory.initElements(driver, CustomerAccountPage.class);

        registrationPage.openRegistrationPageFromMain();
        registrationPage.createAccount();
        wait.until(ExpectedConditions.urlContains("/customer/account/index/"));
        wait.until(ExpectedConditions.visibilityOf(accountPage.getSuccessRegAllert()));
        assertEquals("На указанную Вами почту отправлено письмо подтверждение регистрации – убедитесь, что " +
                "Вы указали верный имейл и получили наше письмо", accountPage.getSuccessRegText());
    }

    //TC login of existing user:
    @Test
    public void loginTest() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        CustomerAccountPage accountPage = PageFactory.initElements(driver, CustomerAccountPage.class);
        mainPage.login();
        wait.until(ExpectedConditions.visibilityOf(mainPage.getMyOffice()));
        mainPage.enterToMyOffice();
        wait.until(ExpectedConditions.textToBePresentInElementValue(accountPage.getEmailField(),
                "sshliakhovyi@gmail.com"));
    }

    //TC purchase under guest:
    @Test
    public void purchaseUnderGuestTest() throws InterruptedException {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        ProductsCategoryPage categoryPage = PageFactory.initElements(driver, ProductsCategoryPage.class);
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        Actions action = new Actions(driver);
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);


        action.moveToElement(mainPage.getAromasDropdown())
                .moveToElement(mainPage.getGiftsAndSetsDropdownCategory())
                .click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(categoryPage.getProduct10190()));
        categoryPage.getProduct10190().click();
        wait.until(ExpectedConditions.urlContains("/dia-woman-parfjumirovannyj-nabor-137457.html"));
        assertEquals("Dia Woman Парфюмированный набор", productPage.getProductNameOnProductPage().getText());
        productPage.getBuyButton().click();
        wait.until(ExpectedConditions.visibilityOf(productPage.getCheckoutButton()));
        productPage.getCheckoutButton().click();
        wait.until(ExpectedConditions.urlContains("/checkout/cart"));
        assertEquals("Dia Woman Парфюмированный набор", checkoutPage.getProductName().getText());
        checkoutPage.getCheckoutButton().click();
        wait.until(ExpectedConditions.urlContains("/checkout/onepage/"));
        checkoutPage.getContinueStep1Button().click();
        checkoutPage.fillYourselfInformation();
        checkoutPage.getContinueStep2Button().click();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getNPShippingMethodCheckbox()));
        checkoutPage.getNPShippingMethodCheckbox().click();
        Thread.sleep(5000);
        /*checkoutPage.getNPCityDropdown().click();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getNPCityKyiv()));
        checkoutPage.getNPCityKyiv().click();*/
        /*action.click(checkoutPage.getNPCityDropdown())
                .click(checkoutPage.getNPCityKyiv())
                .build().perform();
        action.click(checkoutPage.getNPStorehouseDropdown())
                .click(checkoutPage.getNPStorehouseAddress())
                .build().perform();*/
        checkoutPage.getNPCityDropdown().click();
        Thread.sleep(5000);
        List<WebElement> element = driver.findElements(By.cssSelector("html.js.no-touch.localstorage.no-ios body.checkout-onepage-index span.select2-container.select2-container--default.select2-container--open span.select2-dropdown.select2-dropdown--above span.select2-results"));
        for (int i = 0; i < element.size(); i++) {
            String temp = element.get(i).getText();
            if (temp.equals("1")) {
                element.get(i).click();
                break;
            }
        }
        checkoutPage.getContinueStep3Button().click();
        checkoutPage.getPaymentOnDeliveryCheckbox().click();
        checkoutPage.getConfirmPurchaseButton().click();
    }
}