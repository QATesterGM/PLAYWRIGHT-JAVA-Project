package pl.akademiaqa.FEtests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.pages.sections.orderDetailsPage.OrderAddressSection;
import pl.akademiaqa.pages.sections.orderDetailsPage.OrderPaymentSection;
import pl.akademiaqa.pages.sections.orderDetailsPage.OrderShippingMethodSection;
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
        AddToCartConfirmationModalPage confirmationModal = productDetailsPage.getAddToCartSection().addProductToCart();
        Assertions.assertThat(confirmationModal.getConfirmationMessage()).contains("Product successfully added to your shopping cart");

        ShopingCartPage shopingCartPage = confirmationModal.clickProceedToCheckoutButton();
        OrderDetailsPage orderDetailsPage = shopingCartPage.getSummarySection().clickProceedToCheckoutButton();

        OrderAddressSection addressSection = orderDetailsPage.getPersonalInformation().enterPersonalInformation();
        OrderShippingMethodSection shippingMethodSection = addressSection.enterAddress();
        OrderPaymentSection paymentSection = shippingMethodSection.checkMyCarrierShippingMethod();
        paymentSection.fillPaymentMethod();

        page.waitForTimeout(3000);
    }

    @Test
    void should_buy_one_selected_product_V2() {
        homePage.getTopMenuAndSearchSection().searchForProducts("Customizable Mug");
    }
}
