package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.TopMenuAndSearchSection;
import pl.akademiaqa.pages.sections.TopNavigationSection;

@Getter
public class HomePage extends BasePage{

    private Page page;

    private TopMenuAndSearchSection topMenuAndSearchSection;
    private TopNavigationSection topNavigationSection;

    public HomePage(Page page) {
        super(page);
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }

}
