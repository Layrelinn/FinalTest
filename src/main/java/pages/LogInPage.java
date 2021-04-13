package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'create_account=1')]")
    private WebElement createAccountLink;

    public LogInPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public CreateAnAccountPage clickOnCreateAccountLink() {
        createAccountLink.click();
        return new CreateAnAccountPage();
    }
}
