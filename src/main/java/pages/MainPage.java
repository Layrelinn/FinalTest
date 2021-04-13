package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPage extends BasePage {


    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//input[contains(@class,'hidden-xs-down')]")
    private WebElement subscribeButton;

    @FindBy(xpath = "//p[contains(@class,'block_newsletter_alert')]")
    private WebElement popUpErrorMessage;

    @FindBy(xpath = "//div[@id='_desktop_language_selector']//i")
    private WebElement expandLanguagesDropdownButton;

    @FindBy(xpath = "//ul[contains(@class,'hidden-sm-down')]//li")
    private List<WebElement> listOfLanguagesInDropdown;

    @FindBy(xpath = "//a[contains(@title,'Log in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='_desktop_user_info']//span[@class='hidden-sm-down']")
    private WebElement userName;


    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage scrollToElement() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailAddressInput);
        Thread.sleep(500);
        return this;
    }

    public MainPage goToFrame() {
        getDriver().switchTo().frame("framelive");
        return this;
    }

    public MainPage clickOnEmailAddressInput() {
        emailAddressInput.click();
        return this;
    }

    public MainPage setEmail(String email) {
        emailAddressInput.sendKeys(email);
        return this;
    }

    public MainPage clickOnSubscribeButton() {
        subscribeButton.click();
        return this;
    }

    public String getTextFromPopUpErrorMessage() {
        return popUpErrorMessage.getText();

    }

    public MainPage clickOnLanguagesDropdown() {
        expandLanguagesDropdownButton.click();
        return this;
    }

    public Integer getAllLanguagesCountFromDropdown() {
        return listOfLanguagesInDropdown.size();

    }

    //public String getLanguagesText() {
    //}

    // not working properly
    public Boolean findUkrainianLanguage() {
        for (WebElement language : listOfLanguagesInDropdown)
            return language.getText().contains("Українська");
        //return listOfLanguagesInDropdown.contains("Українська");
        return false;

    }

    public LogInPage clickOnSignInButton() {
        signInButton.click();
        return new LogInPage();
    }

    public String getUserName() {
        return userName.getText();
    }

}
