package pl.akademiaqa.BEtests.payload.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserPayload {

    private String name;
    @SerializedName("username")
    private String userName;
    private String phone;
    private String email;
    private CreateUserAddressPayload addres;
    private String website;
    private CreateUserCompanyPayload company;



    public static CreateUserPayload createDefaultUserPayload(){
        return CreateUserPayload.builder()
                .name("Lukasz Dto")
                .userName("Lukasz z json DTO")
                .email("mailatestowyZPayloadu@mail.com")
                .addres(CreateUserAddressPayload.createUserAddressPayload())
                .phone("543987312")
                .website("stronaDTO.pl")
                .company(CreateUserCompanyPayload.createUserCompanyPayload())
                .build();
    }
}
