package eco_service.Eco.mappers;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.models.EcoService;
import org.mapstruct.Mapper;

import java.util.List;

//@Mapper(componentModel = "spring")
public class EcoServiceMapper implements BaseMapper<EcoService, EcoServiceDTO> {
    @Override
    public EcoServiceDTO toDTO(EcoService ecoService) {
        return EcoServiceDTO.builder()
                .name(ecoService.getName())
                .email(ecoService.getEmail())
                .password(ecoService.getPassword())
                .address(ecoService.getAddress())
                .workHours(ecoService.getWorkHours())
                .phoneNumber(ecoService.getPhoneNumber())
                .isFree(ecoService.isFree())
                .isDelivery(ecoService.isDelivery())
                .build();
    }

    @Override
    public List<EcoServiceDTO> toDTO(List<EcoService> e) {
        return null;
    }

    @Override
    public EcoService toEntity(EcoServiceDTO ecoServiceDTO) {
        return EcoService.builder()
                .name(ecoServiceDTO.getName())
                .email(ecoServiceDTO.getEmail())
                .password(ecoServiceDTO.getPassword())
                .address(ecoServiceDTO.getAddress())
                .phoneNumber(ecoServiceDTO.getPhoneNumber())
                .workHours(ecoServiceDTO.getWorkHours())
                .isFree(ecoServiceDTO.isFree())
                .isDelivery(ecoServiceDTO.isDelivery())
                .build();
    }

    @Override
    public List<EcoService> toEntity(List<EcoServiceDTO> d) {
        return null;
    }
}
