import org.testng.annotations.Test;

public class RegistrationNegativeScenarioTest extends BaseTest {

    @Test
    public void registrationNegativeScenario() {

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

        sa.assertThat(validationFieldHighlight)
                .as("The highlighted color of the frame is not red")
                .isEqualTo("rgba(255, 76, 76, 1)");


        String validationMessageText =
                mainPage.clickOnSignInButton()
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

        sa.assertThat(validationMessageText)
                .as("The pop-up error message doesn't match with expected")
                .isEqualTo("Invalid format.");

    }
}
