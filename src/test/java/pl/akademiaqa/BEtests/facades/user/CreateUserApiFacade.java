package pl.akademiaqa.BEtests.facades.user;

import com.google.gson.Gson;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.BEtests.payload.user.CreateUserPayload;
import pl.akademiaqa.BEtests.response.user.CreateUpdateUserResponse;

import static pl.akademiaqa.BEtests.assertions.StatusCodeAssertions.*;

public class CreateUserApiFacade {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CreateUserApiFacade.class);
    public static CreateUpdateUserResponse createUser(APIRequestContext apiContext, CreateUserPayload userPayload){
        log.info("STEP 1 - CREATING NEW USER");
        APIResponse createUserResponse = apiContext.post("users", RequestOptions.create().setData(userPayload));
        assert201(createUserResponse);
        CreateUpdateUserResponse createUserResponseDTO = new Gson().fromJson(createUserResponse.text(), CreateUpdateUserResponse.class);
        Assertions.assertThat(createUserResponseDTO.getId()).isNotNull();
        log.info("Created user: " + createUserResponseDTO);

        return createUserResponseDTO;
    }
}
