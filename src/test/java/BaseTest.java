import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.getDriver;

public class BaseTest {

    //String browser = System.getProperty("browser");
    WebDriver driver = null;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser) {
        System.out.println("Current browser is " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://demo.prestashop.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BasePage.setDriverThreadLocal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }

    MainPage mainPage = new MainPage();
    SoftAssertions sa = new SoftAssertions();

}
