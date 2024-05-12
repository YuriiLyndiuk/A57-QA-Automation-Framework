package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class ProfilePage extends BasePage {

    //Locators
    By currentPasswordField = By.cssSelector("[name='current_password']");
    By profileNameField = By.cssSelector("[name='name']");
    By saveBtn = By.cssSelector("button.btn-submit");
    By actualProfileName = By.cssSelector("a.view-profile>span");
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Method

    public String generateRandomName() {
        return  UUID.randomUUID().toString().replace("-", "");
    }

    public void provideCurrentPassword(String currentPassword) {
        findElement(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys(currentPassword);
    }

    public void provideProfileName(String NewProfileName) {
        findElement(profileNameField).clear();
        findElement(profileNameField).sendKeys(NewProfileName);
    }

    public void clickOnSaveBtn() {
        findElement(saveBtn).click();
    }

    public String returnProfileName() {
        return findElement(actualProfileName).getText();
    }


}
