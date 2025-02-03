package pl.akademiaqa.BEtests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BEtests.response.user.GetUserResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadSingleUserTest {

    Playwright playwright;
    APIRequest request;
    APIRequestContext apiContext;

    @BeforeEach
    void beforeEach() {
        Map<String, String> headers = new HashMap<>(); //Mapa nagłówków ##II##
        headers.put("Content-Type", "application/json");

        playwright = Playwright.create();
        request = playwright.request();
        apiContext = request.newContext(new APIRequest.NewContextOptions()
                .setBaseURL("http://localhost:3000/")
                .setExtraHTTPHeaders(headers));  //tworzymy mape naglowkow  ##I##
    }

    @Test
    void should_return_single_user_response_test() {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        System.out.println(response.status());
        //System.out.println(response.statusText());
        System.out.println(response.text());
//        System.out.println(response.headers());
//        System.out.println(response.url());
    }

    @Test
    void should_return_single_user_gson_test() {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();
        //GSON - zamiana odpowiedzi na JsonObject
        JsonObject jsonResponse = new Gson().fromJson(response.text(), JsonObject.class);
        System.out.println(jsonResponse);
        //System.out.println(jsonResponse.get("address.city"));
        System.out.println(jsonResponse.get("username"));
        System.out.println(jsonResponse.get("email"));
    }

    @Test
    void should_return_single_user_jackson_test() throws IOException {
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        // JACKSON-DATABIND - zamiana odpowiedzi na JsonNode
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.text());
        System.out.println(jsonNode.toPrettyString());
        System.out.println(jsonNode.get("email"));
    }

    @Test
        // DESERIALIZACJA
    void should_return_single_user_dto_test() {  //Zamiana na object JAVA
        APIResponse response = apiContext.get("users/10");
        PlaywrightAssertions.assertThat(response).isOK();

        GetUserResponse userResponse = new Gson().fromJson(response.text(), GetUserResponse.class);
        System.out.println(userResponse);
        System.out.println(userResponse.getUserName());

    }
}
