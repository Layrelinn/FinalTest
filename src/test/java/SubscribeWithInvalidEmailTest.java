import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class SubscribeWithInvalidEmailTest extends BaseTest {

    @Test
    public void SubscribeWithInvalidEmail() throws InterruptedException {

        MainPage mainPage = new MainPage();

        String popUpActualText =
                mainPage.goToFrame()
                        .scrollToElement()
                        .clickOnEmailAddressInput()
                        .setEmail("ttt@ttt")
                        .clickOnSubscribeButton()
                        .getTextFromPopUpErrorMessage();

        Assert.assertEquals(popUpActualText, "Invalid email address.");

    }
}
