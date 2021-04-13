import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationPositiveScenarioTest extends BaseTest {

    @Test
    public void registrationWithValidData() {

        MainPage mainPage = new MainPage();

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

        Assert.assertEquals(actualUserName, "Lika Rovinska");


    }
}
