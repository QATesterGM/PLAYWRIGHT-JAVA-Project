package pl.akademiaqa.BEtests;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BEtests.facades.user.CreateUserApiFacade;
import pl.akademiaqa.BEtests.payload.user.CreateUserPayload;
import pl.akademiaqa.BEtests.response.user.CreateUpdateUserResponse;

import static org.assertj.core.api.Assertions.*;
import static pl.akademiaqa.BEtests.assertions.StatusCodeAssertions.*;
import static pl.akademiaqa.BEtests.transformers.UserTransformers.*;

public class PartialUpdateUser extends BaseApiTest{

    @Test
    void should_update_user_email_test(){
        CreateUserPayload user = CreateUserPayload.createDefaultUserPayload();
        CreateUpdateUserResponse createUserDTO = CreateUserApiFacade.createUser(apiContext, user);

        log.info("STEP 2 - UPDATING EXISTING USER");
        JsonObject userUpdate = new JsonObject();
        userUpdate.addProperty("email", "gajdalukasz987654@gmail.com");

        APIResponse updateResponse = apiContext.patch("users/" + createUserDTO.getId(), RequestOptions.create().setData(userUpdate));
        assert200(updateResponse);

        CreateUpdateUserResponse updateUserDTO = createUpdateUserToResponseDTO(updateResponse);
        assertThat(updateUserDTO.getEmail()).isEqualTo("gajdalukasz987654@gmail.com");
    }
}
