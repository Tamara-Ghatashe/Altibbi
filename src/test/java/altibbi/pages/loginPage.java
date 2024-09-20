package altibbi.pages;

import altibbi.base.BasePage;
import altibbi.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

    public  loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-test-id=\"login-btn\"]")
    private WebElement loginBtn;
    @FindBy(css = "[data-test-id=\"login-form_email-or-phone\"]")
    private WebElement emailInput;
    @FindBy(css = "[data-test-id=\"login-form_password\"]")
    private WebElement passwordInput;
    @FindBy(css = "[data-test-id=\"nav-bar_notification-bill\"]")
    private WebElement notificationBillDisplay;

    @FindBy(css = "[class=\"invalid-feedback\"]")
    private WebElement errorMassageDisplayed;





    public boolean isWelcomeMessageDisplayed() {

        return notificationBillDisplay.isDisplayed();
    }

    public loginPage login (String email, String password){
        loginBtn.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordInput.submit();
        return new loginPage(driver);
    }

    public loginPage load() {

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
 public boolean  ErrorMessageDisplayed(){
     return errorMassageDisplayed.isDisplayed();

 }


}
