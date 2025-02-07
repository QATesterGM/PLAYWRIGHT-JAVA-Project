package pl.akademiaqa.BEtests.response.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CreateUpdateUserResponse {

    private int id;
    private String name;
    @SerializedName("username")
    private String username;
    private String email;
    private String website;
}
