package pl.akademiaqa.pages.sections.searchResultPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.dto.ProductDTO;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.ProductDetailsPage;
import pl.akademiaqa.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SearchResultsSection extends BasePage {

    private Page page;
    private List<Locator> products;

    public SearchResultsSection(Page page) {
        super(page);
        this.products = page.locator(".js-product").all();
    }

    public List<ProductDTO> productsToDTO() {
        return products.stream()
                .map(p -> ProductDTO.builder()
                        .thumbnail(p.locator(".thumbnail-top"))
                        .name(p.locator(".product-title").innerText())
                        .price(Double.parseDouble(p.locator(".price").innerText().replaceAll(StringUtils.toUTF8("zł"), "")))
                        .build())
                .collect(Collectors.toList());
    }

    public ProductDetailsPage viewProductDetails(String productName) {
        ProductDTO productDTO = productsToDTO().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Can not find product with name " + productName));

        productDTO.getThumbnail().click();

        return new ProductDetailsPage(page);
    }

}
