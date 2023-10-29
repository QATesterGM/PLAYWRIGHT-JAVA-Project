package pl.akademiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class TopNavigationSection extends BasePage {

    private Locator languageSelector;
    private Locator english;
    private Locator selectedLanguage;

    public TopNavigationSection(Page page) {
        super(page);
        this.languageSelector = page.locator("#_desktop_language_selector");
        this.english = page.locator("a[data-iso-code=en]");
        this.selectedLanguage = page.locator("a[data-iso-code=en]");
    }

    public void setPageLanguageToEn() {
        if (selectedLanguage.innerText().equalsIgnoreCase("english")) {
            languageSelector.click();
            english.click();
        }
    }
}
