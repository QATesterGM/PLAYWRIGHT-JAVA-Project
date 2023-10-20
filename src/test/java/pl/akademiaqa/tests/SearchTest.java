package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.SearchResultsPage;

import static org.assertj.core.api.Assertions.*;

class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
    }

    @Test
    void should_return_products_by_search_name_mug() {
        page.navigate("https://skleptestera.pl/");
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSection().searchForProducts("mug");
        assertThat(searchResultsPage.getSearchResultsSection().getProducts().size()).isEqualTo(5);

    }
}
