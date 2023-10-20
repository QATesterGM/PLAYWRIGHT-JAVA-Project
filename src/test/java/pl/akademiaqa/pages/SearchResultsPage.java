package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.searchResultPage.SearchResultsSection;

public class SearchResultsPage {

    @Getter
    private SearchResultsSection searchResultsSection;

    public SearchResultsPage(Page page) {
        this.searchResultsSection = new SearchResultsSection(page);
    }
}
