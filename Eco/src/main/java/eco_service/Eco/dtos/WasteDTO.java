package eco_service.Eco.dtos;

import eco_service.Eco.models.EcoService;
import eco_service.Eco.models.WasteAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WasteDTO {

    private Long id;

    private String type;

    private String description;

    private double longitude;

    private double latitude;

    private EcoServiceDTO ecoService;

    private WasteAddressDTO wasteAddress;

}
