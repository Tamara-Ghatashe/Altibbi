package altibbi.testCases;

import altibbi.base.BaseTest;
import altibbi.pages.loginPage;
import altibbi.utils.ConfigUtils;
import altibbi.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {
    @Test (description = "Test the login functionality")
    public void ShouldBeAbleToLoginWithEmailAndPassword(){
        loginPage LoginPage = new loginPage(getDriver());

        boolean isDisplayed =
            LoginPage
                    .load()
                    .login(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
                    .isWelcomeMessageDisplayed();
        Assert.assertTrue(isDisplayed);

    }
    @Test (description = "Test the login functionality with phone number")
    public void ShouldBeAbleToLoginWithPhoneNumberAndPassword(){
        loginPage LoginPage = new loginPage(getDriver());

        boolean isDisplayed =
                LoginPage
                        .load()
                        .login(ConfigUtils.getInstance().getPhoneNumber(),ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();
        Assert.assertTrue(isDisplayed);

    }
    @Test (description = "Test empty Email And Password")
    public void invalidEmailAndPassword(){
        loginPage LoginPage = new loginPage(getDriver());
        boolean isDisplayed =
                LoginPage
                        .load()
                        .login("","")
                        .ErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);

    }

    @Test (description = "TestLogin with wrong password")
    public void WrongPasswordPassword(){
        loginPage LoginPage = new loginPage(getDriver());
        boolean isDisplayed =
                LoginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), UserUtils.generateRandomUser().getPassword())
                        .ErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);

    }
    @Test (description = "TestLogin with UnRegiest Email")
    public void loginWithUnRegiestEmail(){
        loginPage LoginPage = new loginPage(getDriver());
        boolean isDisplayed =
                LoginPage
                        .load()
                        .login(UserUtils.generateRandomUser().getEmail(), UserUtils.generateRandomUser().getPassword())
                        .ErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);

    }
    @Test (description = "TestLogin with UnRegiest phoneNumber")
    public void loginWithUnRegiestPhoneNumber(){
        loginPage LoginPage = new loginPage(getDriver());
        boolean isDisplayed =
                LoginPage
                        .load()
                        .login(UserUtils.generateRandomUser().getPhone(), UserUtils.generateRandomUser().getPassword())
                        .ErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);

    }

    @Test(description = "Test login with invalid email format")
    public void ShouldNotLoginWithInvalidEmailFormat() {
        loginPage LoginPage = new loginPage(getDriver());
        boolean isDisplayed =
                LoginPage
                        .load()
                        .login("raghad.sadayahoo.com", ConfigUtils.getInstance().getPassword())
                        .ErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }
    @Test(description = "Test login with empty phone number")
    public void ShouldNotLoginWithEmptyPhoneNumber() {
        loginPage LoginPage = new loginPage(getDriver());
        boolean isDisplayed =
                LoginPage
                        .load()
                        .login("", ConfigUtils.getInstance().getPassword())
                        .ErrorMessageDisplayed();

        Assert.assertTrue(isDisplayed);
    }




}
