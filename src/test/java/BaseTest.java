import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    //public String url = "https://qa.koel.app/";

    /*@DataProvider(name="NegativeLoginTestData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalidEmail@class.com","invalid"},
                {"demo@class.com","invalid"},
                {"",""},
                {"invalidEmail@class.com","te$t$tudent"},
        };
    }*/

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    /*@BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage();
    }*/

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        //String url = baseURL;
        navigateToPage(baseURL);
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    void clickLoginBtn() {
       WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        // WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    /*public void navigateToPage() {
        driver.get(url);
    }*/

    public void navigateToPage(String url) {
        driver.get(url);
    }
}