package createAccountPageObjects;

import mainPageObjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

public class CreateAccountPage {
    WebDriver driver;
    @FindBy(id = "firstname")
    WebElement firstNameField;
    @FindBy(how = How.ID, using = "lastname")
    WebElement lastNameField;
    @FindBy(id = "email_address")
    WebElement emailField;
    @FindBy(id = "telephone")
    WebElement phoneField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "confirmation")
    WebElement confirmPasswordField;

    public CreateAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    public void openRegistrationPageFromMain() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        mainPage.goToRegistrationPageFromMain();
    }

    public void createAccount () {
        //wait until page load
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));

        //fill registration form
        firstNameField.click();
        firstNameField.sendKeys(ConfigProperties.getTestProperty("username"));
        lastNameField.click();
        lastNameField.sendKeys(ConfigProperties.getTestProperty("lastname"));
        emailField.click();
        emailField.sendKeys(ConfigProperties.getTestProperty("email"));
        phoneField.click();
        phoneField.sendKeys(ConfigProperties.getTestProperty("phone"));
        passwordField.click();
        passwordField.sendKeys(ConfigProperties.getTestProperty("password"));
        confirmPasswordField.click();
        confirmPasswordField.sendKeys(ConfigProperties.getTestProperty("password"));
        confirmPasswordField.submit();
    }
}
