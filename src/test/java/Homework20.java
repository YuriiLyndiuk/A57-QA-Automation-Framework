import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {
        String expectedMsg = "Deleted playlist \"Test.\"";
        //Steps:
        //Navigate and Login
        provideEmail("yurii.lyndiuk@testpro.io");
        providePassword("jjbuQe8D");
        clickLoginBtn();
        //Click the playlist
        clickThePlaylist();
        //Click delete button
        clickDeleteBtn();
        //Assertion
        Assert.assertEquals(deletedPlaylistMsg(),expectedMsg);
    }

    public void clickDeleteBtn() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        // WebElement deletePlaylist = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylist.click();
        //Thread.sleep(Duration.ofMillis(2000));
    }

    public void clickThePlaylist() {
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[@class='playlist playlist'][2]")));
        // WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist'][2]"));
        playList.click();
    }

    public String deletedPlaylistMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        //WebElement notificationMsg = driver.findElement(By.cssSelector(".success.show"));
        return notificationMsg.getText();

    }
}
