package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class ConfirmationPage extends BasePage{

    public ConfirmationPage(Page page) {
        super(page);
    }
}
