package pl.akademiaqa.BEtests;

import com.microsoft.playwright.APIResponse;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.BEtests.assertions.StatusCodeAssertions;
import pl.akademiaqa.BEtests.facades.user.CreateUserApiFacade;
import pl.akademiaqa.BEtests.payload.user.CreateUserPayload;
import pl.akademiaqa.BEtests.response.user.CreateUpdateUserResponse;

import static pl.akademiaqa.BEtests.assertions.StatusCodeAssertions.*;

public class DeleteUserTest extends BaseApiTest{

    @Test
    void should_delete_existing_user_test(){
        CreateUserPayload user = CreateUserPayload.createDefaultUserPayload();
        CreateUpdateUserResponse createUserDTO = CreateUserApiFacade.createUser(apiContext, user);

        log.info("STEP 2 - DELETING EXISTING USER");
        APIResponse apiResponse = apiContext.delete("users/" + createUserDTO.getId());
        assert200(apiResponse); // 204 no content

        log.info("STEP 3 - READING DELETED USER");
        APIResponse getUserResponse = apiContext.get("users/" + createUserDTO.getId());
        StatusCodeAssertions.assert404(getUserResponse);
    }
}
