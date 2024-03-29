import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        //Steps
        //Navigate to page and login
        provideEmail("yurii.lyndiuk@testpro.io");
        providePassword("jjbuQe8D");
        clickLoginBtn();
        //Click Play Btn
        clickPlayBtn();
        Thread.sleep(Duration.ofMillis(2000));
        // Validate that a song is playing
        findSoundBar();
        Assert.assertTrue(findSoundBar());
    }

    public boolean findSoundBar() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@class='bars']"));
        return soundBar.isDisplayed();

    }

    public void clickPlayBtn() {
        WebElement nextSong = driver.findElement(By.cssSelector("i.fa-step-forward"));
        nextSong.click();
        WebElement playSong = driver.findElement(By.xpath("//span[@class='play']//i[@class='fa fa-play']"));
        playSong.click();

    }
}
