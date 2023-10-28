package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultPage.SearchResultsSection;

import static pl.akademiaqa.utils.PageUtils.waitForPageToLoad;

public class SearchResultsPage {

    @Getter
    private SearchResultsSection searchResultsSection;

    public SearchResultsPage(Page page) {
        waitForPageToLoad(page);
        this.searchResultsSection = new SearchResultsSection(page);
    }
}
