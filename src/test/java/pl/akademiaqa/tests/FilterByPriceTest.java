package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.utils.Properties;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FilterByPriceTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_return_products_with_price_grater_tan_40() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        System.out.println(artPage.getProductsSection().getProductsPrices());

        String newUrl = page.url() + "&q=Price-zł-40-44";
        page.navigate(newUrl);

        Assertions.assertThat(artPage.getProductsSection()
                .getProductsPrices().stream().allMatch(p -> p > 40)).isTrue();
    }

    @Test
    void should_return_products_with_price_grater_tan_40_By_Mouse() {
        ArtPage artPage = homePage.getTopMenuAndSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceWithMouse(40);
        
    }
}
