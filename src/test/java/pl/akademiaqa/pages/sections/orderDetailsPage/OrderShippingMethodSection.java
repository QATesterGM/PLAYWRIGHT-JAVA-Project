package pl.akademiaqa.pages.sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class OrderShippingMethodSection extends BasePage {
    private static String shippingMethodSection = "#checkout-delivery-step ";
    private Locator myCarirer;
    private Locator continueButton;
    public OrderShippingMethodSection(Page page) {
        super(page);
        this.myCarirer = page.locator(shippingMethodSection + "#delivery_option_2");
        this.continueButton = page.locator(shippingMethodSection + "button[name=confirmDeliveryOption]");
    }

    public OrderPaymentSection checkMyCarrierShippingMethod(){
        myCarirer.click();
        continueButton.click();
        return new OrderPaymentSection(page);
    }
}
