package pl.akademiaqa.pages.sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class OrderAddressSection extends BasePage {

    private final String addressSection = "#checkout-addresses-step ";

    private Locator addressInput;
    private Locator zipCode;
    private Locator city;
    private Locator continueButton;

    public OrderAddressSection(Page page) {
        super(page);
        this.addressInput = page.locator("#field-address1");
        this.zipCode = page.locator("#field-postcode");
        this.city = page.locator("#field-city");
        this.continueButton = page.locator("button[name=confirm-addresses]");
    }

    public OrderShippingMethodSection enterAddress(){
        addressInput.fill("Brnenska 9");
        zipCode.fill("26-900");
        city.fill("Kozienice");
        continueButton.click();
        return new OrderShippingMethodSection(page);
    }
}
