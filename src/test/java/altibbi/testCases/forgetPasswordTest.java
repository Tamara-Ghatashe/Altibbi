package altibbi.testCases;

import altibbi.base.BaseTest;
import altibbi.object.User;
import altibbi.pages.registPage;
import altibbi.pages.resetPasswordPage;
import altibbi.utils.ConfigUtils;
import altibbi.utils.UserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class forgetPasswordTest extends BaseTest {

    @Test(description = "able to rest the password by email")
    public void restPasswordEmail(){
        resetPasswordPage ResetPasswordPage = new resetPasswordPage(getDriver());
        boolean isDisplayed =
                ResetPasswordPage
                        .load()
                        .resetPasswordByEmail(ConfigUtils.getInstance().getEmail())
                        .isDisplay();

        Assert.assertTrue(isDisplayed);



    }

    @Test(description = "able to rest the password by phone")
    public void restPasswordPhone(){
        resetPasswordPage ResetPasswordPage = new resetPasswordPage(getDriver());
        boolean isDisplayed =
                ResetPasswordPage
                        .load()
                        .resetPasswordByPhone(ConfigUtils.getInstance().getPhoneNumber())
                        .btnIsDisplay();

        Assert.assertTrue(isDisplayed);




    }

    @Test(description = "unregistered email address for password reset")
    public void resetPasswordUnregisteredEmail() {
        resetPasswordPage ResetPasswordPage = new resetPasswordPage(getDriver());
        boolean errorMessage =
                ResetPasswordPage
                        .load()
                        .resetPasswordByEmail(UserUtils.generateRandomUser().getEmail())
                        .isErrorMessageDisplayed();

        Assert.assertFalse(errorMessage);
    }
    @Test(description = "invalid phone number for password reset")
    public void resetPasswordInvalidPhone() {
        resetPasswordPage ResetPasswordPage = new resetPasswordPage(getDriver());
        boolean errorMessage =
                ResetPasswordPage
                        .load()
                        .resetPasswordByPhone("12345")
                        .isErrorMessageDisplayed();

        Assert.assertFalse(errorMessage);
    }

    @Test(description = "unregistered phone number for password reset")
    public void resetPasswordUnregisteredPhone() {
        resetPasswordPage ResetPasswordPage = new resetPasswordPage(getDriver());
        boolean errorMessage =
                ResetPasswordPage
                        .load()
                        .resetPasswordByPhone(UserUtils.generateRandomUser().getPhone())
                        .isErrorMessageDisplayed();

        Assert.assertFalse(errorMessage);
    }





}































