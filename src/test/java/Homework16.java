import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public void navigateToRegistrationLink() {

//Pre-Conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Steps
//Step 1 Open Browser
        String url = "https://qa.koel.app/";
        driver.get(url);
//Step 2 Click Registration / Forgot Password link
        WebElement registrationLink = driver.findElement(By.xpath("//a[@href='registration']"));
        registrationLink.click();
//Step 3  Expected result: User should be directed to  Registration / Forgot Password page
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");
//Close the browser
       driver.quit();

      


    }

}
