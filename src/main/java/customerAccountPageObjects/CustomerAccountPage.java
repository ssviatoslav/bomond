package customerAccountPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerAccountPage {
    WebDriver driver;
    @FindBy(css = "div.dashboard > ul:nth-child(1) > li:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)")
    WebElement successRegAllert;
    @FindBy(css = "li.fields:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
    WebElement emailField;

    public CustomerAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessRegText() {
        return successRegAllert.getText();
    }

    public WebElement getSuccessRegAllert() {
        return successRegAllert;
    }

    public WebElement getEmailField() {
        return emailField;
    }
}
