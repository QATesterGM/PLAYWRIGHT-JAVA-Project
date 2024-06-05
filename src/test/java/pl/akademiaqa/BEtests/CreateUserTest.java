package pl.akademiaqa.BEtests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateUserTest extends BaseApiTest {

    @Test
    void should_create_new_user_from_text_payload_test() {

        String payload = """
                {
                  "username": "Json Text",
                  "email": "cecylia@gmail.com",
                  "address": {
                    "street": "Brneńska",
                    "suite": "Suite 198",
                    "city": "Poznan",
                    "zipcode": "31428-2261",
                    "geo": {
                      "lat": "-38.2386",
                      "lng": "57.2232"
                    }
                  },
                  "phone": "543-543-532",
                  "website": "ambrose.net",
                  "company": {
                    "name": "Lucky",
                    "catchPhrase": "Centralized empowering task-force",
                    "bs": "target end-to-end models"
                  }
                }
                """;

        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(payload));
        PlaywrightAssertions.assertThat(apiResponse).isOK(); // asercja Playwright
        Assertions.assertThat(apiResponse.status()).isEqualTo(201); //assertJ ale zostańmy przy Playwright

        log.info("Created user: " + apiResponse.text()); // tu pamietac zeby apiResponse zamienic na text

    }
}
