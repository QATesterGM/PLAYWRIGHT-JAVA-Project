package pl.akademiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddToCartSection {

    private Page page;
    private Locator addToCartGButton;

    public AddToCartSection(Page page) {
        this.page = page;
        this.addToCartGButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
    }
    public void addToCart(){
        addToCartGButton.click();
    }
}
