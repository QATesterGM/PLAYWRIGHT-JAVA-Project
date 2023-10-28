package pl.akademiaqa.dto;

import com.microsoft.playwright.Locator;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class ProductDTO {

    private Locator thumbnail;
    private String name;
    private double price;

}
