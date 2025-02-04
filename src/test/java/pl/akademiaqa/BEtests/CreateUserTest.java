package pl.akademiaqa.BEtests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BEtests.response.user.GetUserResponse;

import java.util.HashMap;
import java.util.Map;

class CreateUserTest extends BaseApiTest {

    @Test
    void should_create_new_user_from_text_payload_test() {

        String payload = """
                {
                  "username": "Jerzy Jurek",
                  "email": "lucky@gmail.com",
                  "address": {
                    "street": "Osiedle Pokoju",
                    "suite": "8",
                    "city": "Radom",
                    "zipcode": "26-600",
                    "geo": {
                      "lat": "-38.2386",
                      "lng": "57.2232"
                    }
                  },
                  "phone": "543-777-532",
                  "website": "website.net",
                  "company": {
                    "name": "Lucky",
                    "catchPhrase": "Firma ubezpieczeniowa",
                    "bs": "target test E2E"
                  }
                }
                """;

        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(payload));
        PlaywrightAssertions.assertThat(apiResponse).isOK(); // asercja Playwright
        Assertions.assertThat(apiResponse.status()).isEqualTo(201); //assertJ ale zostańmy przy Playwright

        log.info("Created user: " + apiResponse.text()); // tu pamietac zeby apiResponse zamienic na text

    }

    @Test
    void should_create_new_user_from_map_payload_test(){

        //GEO
        Map<String, Object> geo = new HashMap<>();
        geo.put("lat", "-37.3169");
        geo.put("lng", "81.1496");

        //ADDRESS
        Map<String, Object> address = new HashMap<>();
        address.put("street", "Brneńska");
        address.put("suite", "777 88");
        address.put("city", "Lublin");
        address.put("zipcode", "Szkolna");
        address.put("geo", geo);

        //COMPANY
        Map<String, Object> company = new HashMap<>();
        company.put("name", "Lucky Corp");
        company.put("catchPhrase", "Magiczne rzeczy");
        company.put("bs", "Lucky Corp Industries");

        //USER
        Map<String, Object> user = new HashMap<>();
        user.put("username", "Lukasz Gajda");
        user.put("email", "mailtestowy34@gmail.com");
        user.put("address", address);
        user.put("phone", "543-777-777");
        user.put("website", "webistetestowy.net");
        user.put("company", company);

        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info("Created user: " + apiResponse.text());
    }

    @Test
    void should_create_new_user_from_json_object_payload_test(){

    }
}
