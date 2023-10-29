package pl.akademiaqa.pages.sections.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static pl.akademiaqa.utils.StringUtils.*;

public class ProductsSection extends BasePage {
    //private Locator price;
    private List<Locator> products;
    public ProductsSection(Page page) {
        super(page);
        //this.price = page.locator("span[class=price]");
        this.products = page.locator(".js-product").all();
    }

    private List<String> getProductPricesText(){
        return page.locator(".js-product .price").allInnerTexts();
    }

    public List<Double> getProductsPrices(){
        return getProductPricesText()
                .stream()
                .map(p -> p.replaceAll(StringUtils.toUTF8("zł"), ""))
                .map(Double::parseDouble) //zamieniamy na Double
                .collect(Collectors.toList());
    }

    public long getProductsCount(){
        return getProductPricesText()
                .stream()
                .count();
    }

}
