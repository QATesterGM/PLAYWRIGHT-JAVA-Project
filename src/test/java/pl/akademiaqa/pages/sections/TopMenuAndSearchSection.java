package pl.akademiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akademiaqa.pages.ArtPage;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.SearchResultsPage;

public class TopMenuAndSearchSection extends BasePage {
    private Locator searchInput;
    private Locator artLink;

    public TopMenuAndSearchSection(Page page) {
        super(page);
        this.searchInput = page.locator("input[name=s]");
        //this.artLink = page.locator("#category-9");
        this.artLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art").setExact(true));
    }

    public SearchResultsPage searchForProducts(String productName) {
        searchInput.fill(productName);
        page.keyboard().press("Enter");
        return new SearchResultsPage(page);
    }

    public ArtPage clickArtLink() {
        artLink.click();
        return new ArtPage(page);
    }
}
