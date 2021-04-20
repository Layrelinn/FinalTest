import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckLanguagesTest extends BaseTest {

    @Test
    public void CheckLanguages() {

        MainPage mainPage = new MainPage();

        int actualLanguagesCount =
                mainPage.goToFrame()
                        .clickOnLanguagesDropdown()
                        .getAllLanguagesCountFromDropdown();

        assertThat(actualLanguagesCount)
                .as("The count of the languages did nor matched with expected")
                .isEqualTo(44);

    }

    @Test
    public void CheckUkrainianIsPresented() {

        MainPage mainPage = new MainPage();

        List<String> languagesInTheDropdown =
                mainPage.goToFrame()
                        .clickOnLanguagesDropdown()
                        .findLanguages();

        assertThat(languagesInTheDropdown)
                .as("Ukrainian not found!")
                .contains("Українська");

    }

}
