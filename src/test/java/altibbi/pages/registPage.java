package altibbi.pages;

import altibbi.base.BasePage;
import altibbi.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registPage extends BasePage {

    public  registPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[id=\"membersignupform-first_name\"]")
    private WebElement firstNameInput;

    @FindBy(css = "[id=\"membersignupform-last_name\"]")
    private WebElement lastNameInput;

    @FindBy(css = "[id=\"membersignupform-email\"]")
    private WebElement emailInput;

    @FindBy(css = "[id=\"membersignupform-password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[id=\"date-picker\"]")
    private WebElement datePickerInput;


    @FindBy(css = "[id=\"membersignupform-phone_number\"]")
    private WebElement phoneNumberInput;

    @FindBy(css = "[id=\"membersignupform-mailchimp\"]")
    private WebElement mailchimp;

    @FindBy(css = "[id=\"membersignupform-gender--0\"]")
    private WebElement gender;

    @FindBy(css = "[id=\"membersignupform-verifycode\"]")
    private WebElement verifyCode;

    @FindBy(css = "[data-test-id=\"nav-bar_notification-bill\"]")
    private WebElement notificationBillDisplay;

    @FindBy(css = "[class=\"invalid-feedback\"]")
    private WebElement errorMassageDisplayed;
    public registPage Regist(String firstName,String lastName,String email,String password,String phoneNumber,String date){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        phoneNumberInput.sendKeys(phoneNumber);
        mailchimp.click();
        datePickerInput.sendKeys(date);
        mailchimp.click();
        gender.click();
        verifyCode.submit();

        return new registPage(driver);

    }
    public registPage load() {

        driver.get(ConfigUtils.getInstance().getbaseUrlRegistration());
        return this;
    }



    public boolean isWelcomeMessageDisplayed() {
        return notificationBillDisplay.isDisplayed();
    }
    public boolean isErrorMessageDisplayed() {
        return errorMassageDisplayed.isDisplayed();
    }



}
