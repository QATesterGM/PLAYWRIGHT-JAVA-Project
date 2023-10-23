package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.products.FilterBySection;
import pl.akademiaqa.pages.sections.products.ProductsSection;

import static pl.akademiaqa.utils.PageUtils.*;

@Getter
public class ArtPage {

    private FilterBySection filterBySection;
    private ProductsSection productsSection;

    public ArtPage(Page page) {
        waitForPageToLoad(page);
        this.filterBySection = new FilterBySection(page);
        this.productsSection = new ProductsSection(page);
    }
}
