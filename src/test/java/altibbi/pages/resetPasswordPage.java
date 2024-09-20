package altibbi.pages;

import altibbi.base.BasePage;
import altibbi.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class resetPasswordPage extends BasePage {
    public resetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[id=\"forgetpasswordform-email\"]")
    private WebElement emailInput;

    @FindBy(css = "[id=\"forgetpasswordform-type--1\"]")
    private WebElement phoneNumberbtn;
    @FindBy(css = "[id=\"forgetpasswordform-type--0\"]")
    private WebElement emailbtn;

    @FindBy(css = "[id=\"forgetpasswordform-phone_number\"]")
    private WebElement phoneNumberInput;
    @FindBy(css = "[id=\"w0-success-0\"]")
    private WebElement MessageDisplay;

    @FindBy(css = "[id=\"id-17-6\"]")
    private WebElement btnDisplay;


    @FindBy(css = "[class=\"invalid-feedback\"]")
    private WebElement errorMassageDisplayed;



    public resetPasswordPage resetPasswordByEmail( String email ) {
        emailbtn.click();
        emailInput.sendKeys(email);
        emailInput.submit();

        return new resetPasswordPage(driver);
    }

    public resetPasswordPage resetPasswordByPhone( String phoneNumber) {
        phoneNumberbtn.click();
        phoneNumberInput.sendKeys(phoneNumber);
        emailInput.submit();


        return new resetPasswordPage(driver);
    }


    public resetPasswordPage load() {

        driver.get(ConfigUtils.getInstance().getBaseUrlForgetPass());
        return this;
    }


    public boolean isDisplay(){
         return MessageDisplay.isDisplayed();

    }
    public boolean btnIsDisplay(){
      return  btnDisplay.isDisplayed();

    }
    public boolean isErrorMessageDisplayed() {
        return errorMassageDisplayed.isDisplayed();
    }

}
