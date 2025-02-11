package pl.akademiaqa.BEtests.transformers;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.akademiaqa.BEtests.response.user.CreateUpdateUserResponse;
import pl.akademiaqa.BEtests.response.user.GetUserResponse;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTransformers {

    public static GetUserResponse readUserToResponseDTO(APIResponse apiResponse){
        return new Gson().fromJson(apiResponse.text(), GetUserResponse.class);
    }

    public static CreateUpdateUserResponse createUpdateUserToResponseDTO(APIResponse apiResponse){
        return new Gson().fromJson(apiResponse.text(), CreateUpdateUserResponse.class);
    }
}
