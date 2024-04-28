import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    String loginURL = "https://qa.koel.app/";
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        loginPage.login("yurii.lyndiuk@testpro.io", "jjbuQe8D");
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginValidEmailPasswordUsingPageFactory() throws InterruptedException {
        loginPage.provideEmailToLogin("yurii.lyndiuk@testpro.io").providePasswordToLogin("jjbuQe8D").clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        loginPage.provideEmail("invalid");
        loginPage.providePassword("jjbuQe8D");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
    }
    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        loginPage.login("yurii.lyndiuk@testpro.io", "");
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
    }
    @Test

    public void negativeLoginTestEmptyFields() throws InterruptedException {
        loginPage.login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), loginURL);
    }



}