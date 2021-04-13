import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckLanguagesTest extends BaseTest {

    @Test
    public void CheckLanguages() {

        MainPage mainPage = new MainPage();

        int actualLanguagesCount =
                mainPage.goToFrame()
                        .clickOnLanguagesDropdown()
                        .getAllLanguagesCountFromDropdown();

        Assert.assertEquals(actualLanguagesCount, 44);

    }

    @Test
    public void CheckUkrainianIsPresented() {

        MainPage mainPage = new MainPage();

        boolean ukrainianIsPresented =
                mainPage.goToFrame()
                        .clickOnLanguagesDropdown()
                        .findUkrainianLanguage();

        Assert.assertTrue(ukrainianIsPresented);

    }

}
