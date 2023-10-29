package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.SearchResultsPage;

import java.util.Arrays;

public class FilterBySection extends BasePage {
    private Locator leftSlider;
    private Locator priceLebel;
    private Locator mattPaperCheckbox;

    public FilterBySection(Page page) {
        super(page);
        this.leftSlider = page.locator(".ui-slider-handle").first();
        this.priceLebel = page.locator("#search_filters li p");
        this.mattPaperCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions()
                .setName("Matt paper"));
    }

    public void showLeftSlider() {
        System.out.println(leftSlider.boundingBox().x);
        System.out.println(leftSlider.boundingBox().y);
        System.out.println(leftSlider.boundingBox().height);
        System.out.println(leftSlider.boundingBox().width);
    }

    public void filterProductsByPriceWithMouse(double fromPrice) {

        while (fromPrice != getFromPrice()) {
            double x = leftSlider.boundingBox().x;
            double y = leftSlider.boundingBox().y;

            double middleX = x + leftSlider.boundingBox().width / 2;
            double middleY = y + leftSlider.boundingBox().height / 2;

            leftSlider.scrollIntoViewIfNeeded();
            page.mouse().move(middleX, middleY);
            page.mouse().down();
            page.mouse().move(x + 7.00, y);
            page.mouse().up();
            page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
        }
    }

    public void filterProductsByPriceWithKeyboard(double fromPrice) {
        while (fromPrice != getFromPrice()) {
            leftSlider.press("ArrowRight");
            page.waitForCondition(() -> page.locator(".overlay__inner").isHidden());
        }
    }

    private double getFromPrice(){
        return Arrays.asList(page.locator("#search_filters li p").innerText().split(" "))
                .stream()
                .map(p -> p.replaceAll("zł", ""))
                .map(Double::parseDouble)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Invalid price format"));
    }
    public SearchResultsPage setCheckboxTrue(){
        mattPaperCheckbox.scrollIntoViewIfNeeded();
        mattPaperCheckbox.click();

        return new SearchResultsPage(page);
    }


}
