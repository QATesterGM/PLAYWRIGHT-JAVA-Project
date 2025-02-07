package pl.akademiaqa.BEtests;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BEtests.facades.user.CreateUserApiFacade;
import pl.akademiaqa.BEtests.payload.user.CreateUserPayload;
import pl.akademiaqa.BEtests.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.BEtests.response.user.GetUserResponse;
import pl.akademiaqa.BEtests.assertions.StatusCodeAssertions;

class UpdateUserTest extends BaseApiTest {
    private String newEmail = "sprzatanieKoduPoRefactoringu@mail.com";

    @Test
    void should_update_entire_user_test() {
        CreateUserPayload user = CreateUserPayload.createDefaultUserPayload();
        CreateUpdateUserResponse createUserDTO = CreateUserApiFacade.createUser(apiContext, user);

        log.info("STEP 2 - UPDATING EXISTING USER");
        user.setEmail(newEmail);

        APIResponse updatedUserResponse = apiContext.put("users/" + createUserDTO.getId(), RequestOptions.create().setData(user));
        StatusCodeAssertions.assert200(updatedUserResponse);

        CreateUpdateUserResponse updatedUserResponseDTO = new Gson().fromJson(updatedUserResponse.text(), CreateUpdateUserResponse.class);
        Assertions.assertThat(updatedUserResponseDTO.getEmail()).isEqualTo(newEmail);
        log.info("Updated user: " + updatedUserResponseDTO);

        log.info("STEP 3 - READING UPDATED USER");
        APIResponse apiResponse = apiContext.get("users/" + createUserDTO.getId());
        StatusCodeAssertions.assert200(apiResponse);

        GetUserResponse getUserResponseDTO = new Gson().fromJson(apiResponse.text(), GetUserResponse.class);
        Assertions.assertThat(getUserResponseDTO.getEmail()).isEqualTo(newEmail);
        log.info("Read user: " + getUserResponseDTO);
    }

}
