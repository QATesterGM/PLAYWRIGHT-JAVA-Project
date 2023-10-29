package pl.akademiaqa.pages.sections.shopingCartPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

@Getter
public class SummarySection {

    private Locator proceedToCheckOutButton;

    public SummarySection(Page page) {
        this.proceedToCheckOutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    // TODO
    public void clickProceedToCheckoutButton(){
        proceedToCheckOutButton.click();
    }
}
