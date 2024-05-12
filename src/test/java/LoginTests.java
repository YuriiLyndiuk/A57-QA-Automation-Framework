import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    String loginURL = "https://qa.koel.app/";

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //navigateToPage();
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login("yurii.lyndiuk@testpro.io", "jjbuQe8D");
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginValidEmailPasswordUsingPageFactory() throws InterruptedException {
        //navigateToPage();
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmailToLogin("yurii.lyndiuk@testpro.io").providePasswordToLogin("jjbuQe8D").clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("invalid");
        loginPage.providePassword("jjbuQe8D");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("yurii.lyndiuk@testpro.io", "");
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
    }

    @Test

    public void negativeLoginTestEmptyFields() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
    }


}