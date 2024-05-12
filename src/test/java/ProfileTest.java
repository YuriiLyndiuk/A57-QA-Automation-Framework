import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        String expectedNewProfileName = "Test";
        loginPage.login("yurii.lyndiuk@testpro.io", "jjbuQe8D");
        homePage.clickOnUserAvatarIcon();
        profilePage.provideCurrentPassword("jjbuQe8D");
        profilePage.provideProfileName(expectedNewProfileName);
        profilePage.clickOnSaveBtn();
        Assert.assertEquals(profilePage.returnProfileName(), expectedNewProfileName);
    }


}
