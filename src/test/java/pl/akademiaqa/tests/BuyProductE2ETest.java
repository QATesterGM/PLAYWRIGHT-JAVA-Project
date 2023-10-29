package pl.akademiaqa.tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.ProductDetailsPage;
import pl.akademiaqa.pages.SearchResultsPage;
import pl.akademiaqa.pages.ShopingCartPage;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.utils.Properties;

class BuyProductE2ETest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

    @Test
    void should_buy_one_selected_product() {
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSection().searchForProducts("Customizable Mug");
        ProductDetailsPage productDetailsPage = searchResultsPage.getSearchResultsSection().viewProductDetails("Customizable Mug");
        productDetailsPage.getCustomizationSection().customizeProduct("LuckyLuke");
        AddToCartConfirmationModalPage confirmationModal = productDetailsPage.getAddToCartSection().addToCart();
        Assertions.assertThat(confirmationModal.getConfirmationMessage()).contains("Product successfully added to your shopping cart");
        ShopingCartPage shopingCartPage = confirmationModal.clickProceedToCheckoutButton();
        shopingCartPage.getSummarySection().clickProceedToCheckoutButton();

        page.waitForTimeout(3000);
    }
}
