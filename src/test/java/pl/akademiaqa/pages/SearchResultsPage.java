package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultPage.SearchResultsSection;
import pl.akademiaqa.utils.PageUtils;

import static pl.akademiaqa.utils.PageUtils.*;

public class SearchResultsPage {

    @Getter
    private SearchResultsSection searchResultsSection;

    public SearchResultsPage(Page page) {
        waitForPageToLoad(page);
        this.searchResultsSection = new SearchResultsSection(page);
    }
}