package pl.akademiaqa.BEtests;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BEtests.payload.user.CreateUserPayload;
import pl.akademiaqa.utils.Properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    void should_create_new_user_from_map_payload_test() {

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
    void should_create_new_user_from_json_object_payload_test() {

        //GEO
        JsonObject geo = new JsonObject();
        geo.addProperty("lat", "-37.3169");
        geo.addProperty("lng", "81.1496");

        //ADDRESS
        JsonObject address = new JsonObject();
        address.addProperty("street", "Brneńska JsonObject");
        address.addProperty("suite", "777 88");
        address.addProperty("city", "Lublin");
        address.addProperty("zipcode", "Szkolna");
        address.add("geo", geo);

        //COMPANY
        JsonObject company = new JsonObject();
        company.addProperty("name", "Lucky Corp JsonObject");
        company.addProperty("catchPhrase", "Magiczne rzeczy");
        company.addProperty("bs", "Lucky Corp Industries JsonObject");

        //USER
        JsonObject user = new JsonObject();
        user.addProperty("username", "Lukasz Gajda JsonObject");
        user.addProperty("email", "mailtestowy34@gmail.com");
        user.add("address", address);
        user.addProperty("phone", "543-777-777");
        user.addProperty("website", "JsonObject.net");
        user.add("company", company);


        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info("Created user: " + apiResponse.text());
    }

    private byte[] getPayloadFromFile(String fileName) throws IOException {
        return Files.readAllBytes(Path.of(Properties.getProperty("app.json.file.path") + fileName));
    }

    @Test
    void should_create_new_user_from_file_payload_test() throws IOException {
        byte[] user = getPayloadFromFile("user.json");
        APIResponse apiResponse = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(apiResponse).isOK();

        log.info("Created user: " + apiResponse.text());
    }

    @Test
    void should_create_new_user_from_dto_payload_test() {

        CreateUserPayload user = CreateUserPayload.createDefaultUserPayload();
        // serializacja - obiekt na json
        APIResponse response = apiContext.post("users", RequestOptions.create().setData(user));
        PlaywrightAssertions.assertThat(response).isOK();

        log.info("Created user: " + response.text());
    }


}
