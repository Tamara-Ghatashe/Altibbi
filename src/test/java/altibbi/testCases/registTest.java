package altibbi.testCases;
import altibbi.utils.ConfigUtils;
import altibbi.base.BaseTest;
import altibbi.pages.registPage;
import altibbi.utils.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class registTest extends BaseTest {
    @Test (description = "Test the Registration functionality")
    public void asbleToRegist(){
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                .load()
                .Regist(UserUtils.generateRandomUser().getFirstName(),
                          UserUtils.generateRandomUser().getLastName(),
                          UserUtils.generateRandomUser().getEmail(),
                          UserUtils.generateRandomUser().getPassword(),
                          UserUtils.generateRandomUser().getPhone(),
                          UserUtils.generateRandomUser().getBdate())
                .isWelcomeMessageDisplayed();


        Assert.assertTrue(isDisplayed);

    }
    @Test(description = "Test registration with missing first name")
    public void shouldNotRegisterWithMissingFirstName() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist("", UserUtils.generateRandomUser().getLastName(),
                                UserUtils.generateRandomUser().getEmail(),
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Test(description = "Test registration with missing first name")
    public void shouldNotRegisterWithMissingLastName() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(), "",
                                UserUtils.generateRandomUser().getEmail(),
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }
    @Test(description = "Test registration with invalid email format")
    public void shouldNotRegisterWithInvalidEmail() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                "raghad.sadayahoo.com",
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }
    @Test(description = "Test registration with invalid email format")
    public void shouldNotRegisterWithInvalidEmailmissigdot() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                "raghad.sada@yahoocom",
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }

    @Test(description = "Test registration with invalid * email format")

    public void shouldNotRegisterWithInvalidEmailchar() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                "*@gmail.com",
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }


    @Test(description = "Test registration with missing email")
    public void shouldNotRegisterWithMissingEmail() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                "",  // Missing email
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }

    @Test(description = "Test registration with missing password")
    public void shouldNotRegisterWithMissingPassword() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                UserUtils.generateRandomUser().getEmail(),
                                "",  // Missing password
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }
    @Test(description = "Test registration with weak password")
    public void shouldNotRegisterWithWeakPassword() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                UserUtils.generateRandomUser().getEmail(),
                                "123",  // Weak password
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }
    @Test(description = "Test registration with missing phone number")
    public void shouldNotRegisterWithMissingPhoneNumber() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                UserUtils.generateRandomUser().getEmail(),
                                UserUtils.generateRandomUser().getPassword(),
                                "",  // Missing phone number
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }
    @Test(description = "Test registration with future birth date")
    public void shouldNotRegisterWithFutureBirthDate() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                UserUtils.generateRandomUser().getEmail(),
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                "2030-01-01")  // Future birth date
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }
    @Test(description = "Test registration with duplicate email")
    public void shouldNotRegisterWithDuplicateEmail() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                ConfigUtils.getInstance().getEmail(),  // Duplicate email
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }


    @Test(description = "Test registration with Miss  phone Unmber")
    public void shouldNotRegistermissPhoneNumber() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                ConfigUtils.getInstance().getEmail(),
                                UserUtils.generateRandomUser().getPassword(),
                                "",
                                UserUtils.generateRandomUser().getBdate())
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }


    @Test(description = "Test registration with Miss  bdate")
    public void shouldNotRegistermissBdate() {
        registPage RegistPage = new registPage(getDriver());
        boolean isDisplayed =
                RegistPage
                        .load()
                        .Regist(UserUtils.generateRandomUser().getFirstName(),
                                UserUtils.generateRandomUser().getLastName(),
                                ConfigUtils.getInstance().getEmail(),
                                UserUtils.generateRandomUser().getPassword(),
                                UserUtils.generateRandomUser().getPhone(),
                                "")
                        .isErrorMessageDisplayed();
        Assert.assertFalse(isDisplayed);
    }






}
