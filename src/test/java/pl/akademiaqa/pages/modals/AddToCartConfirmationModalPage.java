package pl.akademiaqa.pages.modals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.ShopingCartPage;
import pl.akademiaqa.pages.sections.shopingCartPage.SummarySection;
import pl.akademiaqa.utils.PageUtils;
import pl.akademiaqa.utils.StringUtils;

@Getter
public class AddToCartConfirmationModalPage extends BasePage {

    private Locator confirmationLabel;
    private Locator confirmationButton;

    public AddToCartConfirmationModalPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.confirmationLabel = page.locator("#myModalLabel");
        this.confirmationButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public String getConfirmationMessage(){
        return confirmationLabel.innerText();
    }
    public ShopingCartPage clickProceedToCheckoutButton(){
        confirmationButton.click();
        return new ShopingCartPage(page);
    }
}
