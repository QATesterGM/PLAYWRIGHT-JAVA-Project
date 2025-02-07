package pl.akademiaqa.BEtests.payload.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserCompanyPayload {

    private String name;
    private String catchPhrase;
    private String bs;

    protected static CreateUserCompanyPayload createUserCompanyPayload(){
        return CreateUserCompanyPayload.builder()
                .name("Zabka")
                .catchPhrase("Udane zakupy")
                .bs("z jakim sosem")
                .build();
    }
}
