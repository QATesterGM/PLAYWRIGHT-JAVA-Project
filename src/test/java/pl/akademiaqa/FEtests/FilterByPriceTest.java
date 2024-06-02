package pl.akademiaqa.FEtests;

import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.utils.Properties;

@Getter
public class FilterByPriceTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_return_products_with_price_grater_tan_40_by_UrlTest() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        System.out.println(artPage.getProductsSection().getProductsPrices());

        String newUrl = page.url() + "&q=Price-zł-40-44";
        page.navigate(newUrl);

        Assertions.assertThat(artPage.getProductsSection()
                .getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }

    @Test
    void should_return_products_with_price_grater_tan_40_by_MouseTest() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithMouse(40.00);
    }

    @Test
    void should_return_products_with_price_grater_tan_40_by_KeyboardTest() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithKeyboard(40.00);
        Assertions.assertThat(artPage.getProductsSection()
                .getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();

    }

    @Test
    void should_set_checkbox_and_count_3_roducts_result() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().setCheckboxTrue();
        long productsCount = artPage.getProductsSection().getProductsCount();
        System.out.println(productsCount);

    }
}
