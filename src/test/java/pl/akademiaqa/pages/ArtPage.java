package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.products.FilterBySection;
import pl.akademiaqa.pages.sections.products.ProductsSection;

import static pl.akademiaqa.utils.PageUtils.*;

@Getter
public class ArtPage extends BasePage {

    private FilterBySection filterBySection;
    private ProductsSection productsSection;

    public ArtPage(Page page) {
        super(page);
        waitForPageToLoad(page);
        this.filterBySection = new FilterBySection(page);
        this.productsSection = new ProductsSection(page);
    }
}
