package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.SearchResultsPage;
import pl.akademiaqa.utils.Properties;

class BuyProductE2ETest extends BaseTest{

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_buy_one_selected_product(){
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSection().searchForProducts("Customizable Mug");
        searchResultsPage.getSearchResultsSection().viewProductDetails("Customizable Mug");
    }
}
