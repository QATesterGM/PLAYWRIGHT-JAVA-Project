package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.productDetailsPage.AddToCartSection;
import pl.akademiaqa.pages.sections.productDetailsPage.ProductCustomizationSection;
import pl.akademiaqa.utils.PageUtils;

import static pl.akademiaqa.utils.PageUtils.*;

@Getter
public class ProductDetailsPage extends BasePage{

    private AddToCartSection addToCartSection;
    private ProductCustomizationSection customizationSection;

    public ProductDetailsPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.customizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }
}
