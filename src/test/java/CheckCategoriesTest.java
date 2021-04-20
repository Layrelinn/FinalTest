import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void CheckClothesCategories() {
        MainPage mainPage = new MainPage();

        boolean actualMenCategoryIsDisplaying =
                mainPage.goToFrame()
                        .hoverOverClothesLink()
                        .isMenCategoryAppears();

        boolean actualWomenCategoryIsDisplaying =
                mainPage.hoverOverClothesLink()
                        .isWomenCategoryAppears();

        Assertions.assertThat(actualMenCategoryIsDisplaying & actualWomenCategoryIsDisplaying)
                .as("The Men and Women subcategories are not displaying!")
                .isTrue();

    }

    @Test
    public void CheckAccessoriesCategories() {

        MainPage mainPage = new MainPage();

        boolean actualStationeryCategoryIsDisplaying =
                mainPage.goToFrame()
                        .hoverOverAccessoriesMenu()
                        .isStationeryCategoryAppears();

        boolean actualHomeAccessoriesCategoryIsDisplaying =
                mainPage.hoverOverAccessoriesMenu()
                        .isHomeAccessoriesCategoryAppears();

        Assertions.assertThat(actualStationeryCategoryIsDisplaying & actualHomeAccessoriesCategoryIsDisplaying)
                .as("The Stationery and Home Accessories subcategories are not displaying!")
                .isTrue();

    }

    @Test
    public void CheckAnySubCategories() {
        MainPage mainPage = new MainPage();

        boolean actualArtCategoriesIsDisplaying =
                mainPage.goToFrame()
                .hoverOverArtMenu()
                .isAnySubCategoriesAppears();

        Assertions.assertThat(actualArtCategoriesIsDisplaying)
                .as("There are some subcategories under the Art menu!")
                .isFalse();

    }
}
