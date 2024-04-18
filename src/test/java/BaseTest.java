import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class BaseTest {

    public static WebDriver driver = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    public WebDriverWait wait = null;
    public Actions actions = null;



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})

    public void launchBrowser(String baseURL) throws MalformedURLException{

        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().get(baseURL);
    }


    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public static WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://DESKTOP-34TCAS6:4444";

        switch (browser) {
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case "cloud":
                return LambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

     public static WebDriver LambdaTest() throws MalformedURLException{
         String hubURL = "@hub.lambdatest.com/wd/hub";
         String userName = "uralinduk";
         String accessKey = "cfq5DhLOGLzuhUByvfjpuAvpV3w50jByUPCVdSTgoBx93dtlTT";
         //Capabilities
         DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability("browserName", "chrome");
         capabilities.setCapability("browserVersion", "123.0");
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("username", "uralinduk");
         ltOptions.put("accessKey", "cfq5DhLOGLzuhUByvfjpuAvpV3w50jByUPCVdSTgoBx93dtlTT");
         ltOptions.put("project", "Untitled");
         ltOptions.put("w3c", true);
         ltOptions.put("plugin", "java-java");

         capabilities.setCapability("LT:Options", ltOptions);
         return driver = new RemoteWebDriver(new URL("https://" +userName + ":" +accessKey + hubURL), capabilities);


    }
}