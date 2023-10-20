package pl.akademiaqa.pages.sections.searchResultPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

public class SearchResultsSection {

    @Getter
    private List <Locator> products;

    public SearchResultsSection(Page page) {
        this.products = page.locator(".js-product").all();
    }
}
