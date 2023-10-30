package pl.akademiaqa.pages.sections.confirmationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class OrderConfirmationDetailsSection extends BasePage {

    private final String orderConfirmationSection = "#content-hook_order_confirmation ";
    private Locator title;

    public OrderConfirmationDetailsSection(Page page) {
        super(page);
        this.title = page.locator(orderConfirmationSection + ".card-title");
    }
}
