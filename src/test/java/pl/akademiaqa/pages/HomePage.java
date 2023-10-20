package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.TopMenuAndSearchSection;

public class HomePage {

    private Page page;
    @Getter
    private TopMenuAndSearchSection topMenuAndSearchSection;

    public HomePage(Page page) {
        this.page = page;
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
    }

}
