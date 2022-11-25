package eco_service.Eco.mappers;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.models.EcoService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EcoServiceMapper extends BaseMapper<EcoService, EcoServiceDTO> {
}
