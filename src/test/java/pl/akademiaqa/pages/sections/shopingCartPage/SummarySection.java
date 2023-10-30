package pl.akademiaqa.pages.sections.shopingCartPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.OrderDetailsPage;

@Getter
public class SummarySection extends BasePage {

    private Locator proceedToCheckOutButton;

    public SummarySection(Page page) {
        super(page);
        this.proceedToCheckOutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public OrderDetailsPage clickProceedToCheckoutButton(){
        proceedToCheckOutButton.click();
        return new OrderDetailsPage(page);
    }
}
