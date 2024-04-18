import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //navigateToPage();
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
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



}