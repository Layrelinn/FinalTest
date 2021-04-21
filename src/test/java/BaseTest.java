import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.getDriver;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.prestashop.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        BasePage.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        getDriver().quit();
    }



}
