import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationPositiveScenarioTest extends BaseTest {

    @Test
    public void registrationWithValidData() {

        String actualUserName =
                mainPage.goToFrame()
                        .clickOnSignInButton()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterFirstName()
                        .enterLastName()
                        .enterEmailAddress()
                        .enterPassword()
                        .enterBirthdayDate()
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButton()
                        .getUserName();

        Assertions.assertThat(actualUserName)
                .as("Name of the user is not displaying near card button")
                .isEqualTo("Lika Rovinska");

    }
}
