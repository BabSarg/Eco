package eco_service.Eco.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EcoServiceDTO {

    private Long id;

    private String name;

    private String email;

    private String password;

    private boolean isDelivery;

    private String address;

    private String phoneNumber;

    private String workHours;

    private boolean isFree;

}
