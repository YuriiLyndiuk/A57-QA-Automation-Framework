import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Test.\"";
        //Steps
        //Navigate to Koel
        navigateToPage();
        Thread.sleep(2000);
        //Login to Koel
        provideEmail("yurii.lyndiuk@testpro.io");
        providePassword("jjbuQe8D");
        clickLoginBtn();
        Thread.sleep(2000);
        //Search for a song
        searchForSong("Dark");
        Thread.sleep(2000);
        //Click "View All"
        clickViewAll();
        Thread.sleep(2000);
        //Click first song
        clickFirstSong();
        Thread.sleep(2000);
        //Click 'Add To...' btn
        clickAddToBtn();
        Thread.sleep(2000);
        //Choose the playlist
        selectPlaylist();
        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
        Thread.sleep(2000);
    }

    public String getAddToPlaylistSuccessMsg() {
      WebElement notification = driver.findElement(By.cssSelector(".success.show"));
      return notification.getText();
    }

    public void selectPlaylist() {
       WebElement addToPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test')]"));
       addToPlaylist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToBtn.click();
    }

    public void clickFirstSong() {
        List<WebElement> firstSong = driver.findElements(By.xpath("//section[@id='songResultsWrapper']//div[@class='item-container']/table[@class='items']/tr"));
        firstSong.get(0).click();
    }

    public void clickViewAll() {
        WebElement btnViewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        btnViewAll.click();
    }

    public void searchForSong(String song) {
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        search.clear();
        search.sendKeys(song);

    }

    public void clickLoginBtn() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }


    public void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
}

