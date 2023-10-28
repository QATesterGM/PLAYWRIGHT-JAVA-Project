package pl.akademiaqa.pages.sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductCustomizationSection {

    private Page page;
    private Locator customMessageInput;
    private Locator submitCustomizationButton;
    private Locator customMessageLebel;

    public ProductCustomizationSection(Page page) {
        this.page = page;
        this.customMessageInput = page.locator("#field-textField1");
        this.submitCustomizationButton = page.locator("button[name=submitCustomizedData]");
        this.customMessageLebel = page.locator(".customization-label");
    }

    public void customizeProduct (String customMessage){
        customMessageInput.fill(customMessage);
        submitCustomizationButton.click();
        page.waitForCondition(() -> customMessageLebel.isVisible());
    }
}
