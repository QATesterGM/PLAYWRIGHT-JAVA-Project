package pl.akademiaqa.BEtests.payload.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserAddressPayload {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private CreateUserAddressGeoPayload geo;

    protected static CreateUserAddressPayload createUserAddressPayload(){
        return CreateUserAddressPayload.builder()
                .street("kaweczynska")
                .suite("43/323")
                .city("Lublin")
                .zipcode("500-322")
                .geo(CreateUserAddressGeoPayload.createDefaultUserAddressGeoPayload())
                .build();
    }
}
