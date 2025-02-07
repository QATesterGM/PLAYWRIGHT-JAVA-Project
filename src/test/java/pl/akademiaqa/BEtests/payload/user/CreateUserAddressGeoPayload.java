package pl.akademiaqa.BEtests.payload.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserAddressGeoPayload {

    private String lat;
    private String lng;

    protected static CreateUserAddressGeoPayload createDefaultUserAddressGeoPayload(){
        return CreateUserAddressGeoPayload.builder()
                .lat("-37.7575")
                .lng("81.2453")
                .build();
    }
}
