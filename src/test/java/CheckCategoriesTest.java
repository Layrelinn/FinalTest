import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void CheckClothesCategories() {
        MainPage mainPage = new MainPage();

        boolean actualMenCategoryDisplaying =
                mainPage.goToFrame()
                        .hoverOverClothesLink()
                        .isMenCategoryAppears();

        boolean actualWomenCategoryDisplaying =
                mainPage.hoverOverClothesLink()
                        .isWomenCategoryAppears();

        Assertions.assertThat(actualMenCategoryDisplaying & actualWomenCategoryDisplaying)
                .as("Men and Women sub categories are not displaying!").isTrue();

    }
}
