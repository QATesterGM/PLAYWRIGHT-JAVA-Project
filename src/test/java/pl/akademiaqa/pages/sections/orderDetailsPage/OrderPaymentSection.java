package pl.akademiaqa.pages.sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akademiaqa.pages.BasePage;

public class OrderPaymentSection extends BasePage {
    private final String paymentSection = "#checkout-payment-step ";
    private Locator payByCashOnDeliveryInput;
    private Locator agreeCheckbox;
    private Locator placeOrderButton;
    public OrderPaymentSection(Page page) {
        super(page);
        this.payByCashOnDeliveryInput = page.locator(paymentSection + "#payment-option-2");
        this.agreeCheckbox = page.locator(paymentSection + "input[name='conditions_to_approve[terms-and-conditions]']");
        this.placeOrderButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place order"));
    }

    public void fillPaymentMethod(){
        payByCashOnDeliveryInput.check();
        agreeCheckbox.check();
        placeOrderButton.click();
    }
}
