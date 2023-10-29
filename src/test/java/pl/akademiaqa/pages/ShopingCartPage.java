package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.shopingCartPage.SummarySection;
import pl.akademiaqa.utils.PageUtils;
@Getter
public class ShopingCartPage {

    private SummarySection summarySection;

    public ShopingCartPage(Page page) {
        PageUtils.waitForPageToLoad(page);
        this.summarySection = new SummarySection(page);
    }
}
