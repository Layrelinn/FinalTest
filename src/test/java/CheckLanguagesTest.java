import org.testng.annotations.Test;

import java.util.List;


public class CheckLanguagesTest extends BaseTest {

    @Test
    public void CheckLanguages() {

        int actualLanguagesCount =
                mainPage.goToFrame()
                        .clickOnLanguagesDropdown()
                        .getAllLanguagesCountFromDropdown();

        sa.assertThat(actualLanguagesCount)
                .as("The count of the languages did not matched with expected")
                .isEqualTo(44);

        List<String> languagesInTheDropdown =
                mainPage.findLanguages();

        sa.assertThat(languagesInTheDropdown)
                .as("Ukrainian not found!")
                .contains("Українська");

        sa.assertAll();

    }

}
