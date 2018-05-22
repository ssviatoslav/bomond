package mainPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigProperties;

public class MainPage {
    WebDriver driver;
    @FindBy(css = "#header > div > div > div.skip-links > div.headerAccount > a.login")
    WebElement enterHyperlink;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passField;
    @FindBy(id = "send2")
    WebElement submitLoginButton;
    @FindBy(css = "#header > div > div > div.skip-links > div.headerAccount > a.create")
    WebElement registrationHyperlink;
    @FindBy(css = "body > div.mfp-wrap.mfp-close-btn-in.mfp-auto-cursor.mfp-ready > div > div.mfp-content > div > " +
            "div.col2-set.form-login > div.col-1.new-users > div.buttons-set > a")
    WebElement registrationButton;
    @FindBy(css = "html#top.js.no-touch.localstorage.no-ios body.cms-index-index.cms-home div.wrapper div.page " +
            "header#header.page-header div.page-header-container div.header-container-inner-wrapper div.skip-links " +
            "div.headerAccount a.logout-btn")
    WebElement myOffice;
    @FindBy(css = "#nav > ol > li.level0.nav-1.first.parent")
    WebElement aromasDropdown;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/nav/ol/li[1]/menu/div/ul/li[1]/a")
    WebElement giftsAndSetsDropdownCategory;



    public MainPage (WebDriver driver) {
        this.driver = driver;
        driver.get(ConfigProperties.getTestProperty("devUrl"));
    }

    public void login() {
        enterHyperlink.click();
        emailField.click();
        emailField.sendKeys(ConfigProperties.getTestProperty("existingUserEmail"));
        passField.click();
        passField.sendKeys(ConfigProperties.getTestProperty("existingUserPassword"));
        submitLoginButton.click();
    }

    public void goToRegistrationPageFromMain() {
        registrationHyperlink.click();
        registrationButton.click();
    }

    public void enterToMyOffice() {
        myOffice.click();
    }

    public WebElement getMyOffice() {
        return myOffice;
    }

    public WebElement getAromasDropdown() {
        return aromasDropdown;
    }

    public WebElement getGiftsAndSetsDropdownCategory() {
        return giftsAndSetsDropdownCategory;
    }
}
