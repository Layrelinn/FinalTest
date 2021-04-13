import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationNegativeScenarioTest extends BaseTest {

    @Test
    public void checkTheRedHighlight() {

        MainPage mainPage = new MainPage();

        String validationFieldHighlight =
                mainPage.goToFrame()
                        .clickOnSignInButton()
                        .waiter()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterInvalidFirstName()
                        .enterLastName()
                        .enterEmailAddress()
                        .enterPassword()
                        .enterBirthdayDate()
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButtonWithInvalidData()
                        .firstNameBorderHighlight();

        Assert.assertEquals(validationFieldHighlight, "rgba(255, 76, 76, 1)");

    }


    @Test
    public void registrationWithInvalidData() {

        MainPage mainPage = new MainPage();

        String validationMessageText =
                mainPage.goToFrame()
                        .clickOnSignInButton()
                        .waiter()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterInvalidFirstName()
                        .enterLastName()
                        .enterEmailAddress()
                        .enterPassword()
                        .enterBirthdayDate()
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButtonWithInvalidData()
                        .getValidationMessageText();

        Assert.assertEquals(validationMessageText, "Invalid format.");

    }
}
