import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationNegativeScenarioTest extends BaseTest {

    @Test
    public void checkTheRedHighlight() {

        MainPage mainPage = new MainPage();

        String validationFieldHighlight =
                mainPage.goToFrame()
                        .clickOnSignInButton()
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

        assertThat(validationFieldHighlight)
                .as("The highlighted color of the frame is not red")
                .isEqualTo("rgba(255, 76, 76, 1)");

    }


    @Test
    public void registrationWithInvalidData() {

        MainPage mainPage = new MainPage();

        String validationMessageText =
                mainPage.goToFrame()
                        .clickOnSignInButton()
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

        assertThat(validationMessageText)
                .as("The pop-up error message doesn't match with expected")
                .isEqualTo("Invalid format.");

    }
}
