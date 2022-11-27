package eco_service.Eco.mappers;

import eco_service.Eco.dtos.EcoServiceAddDTO;
import eco_service.Eco.models.EcoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EcoServiceAddMapper implements BaseMapper<EcoService, EcoServiceAddDTO> {
    @Override
    public EcoServiceAddDTO toDTO(EcoService ecoService) {
        return EcoServiceAddDTO.builder()
                .name(ecoService.getName())
                .email(ecoService.getEmail())
                .password(ecoService.getPassword())
                .address(ecoService.getAddress())
                .workHours(ecoService.getWorkHours())
                .phoneNumber(ecoService.getPhoneNumber())
                .isFree(ecoService.isFree())
                .isDelivery(ecoService.isDelivery())
                .photo(ecoService.getPhoto())
                .country(ecoService.getCountry())
                .city(ecoService.getCity())
                .build();
    }

    @Override
    public List<EcoServiceAddDTO> toDTO(List<EcoService> e) {
        return e.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public EcoService toEntity(EcoServiceAddDTO ecoServiceDTO) {
        return EcoService.builder()
                .name(ecoServiceDTO.getName())
                .email(ecoServiceDTO.getEmail())
                .password(ecoServiceDTO.getPassword())
                .address(ecoServiceDTO.getAddress())
                .phoneNumber(ecoServiceDTO.getPhoneNumber())
                .workHours(ecoServiceDTO.getWorkHours())
                .isFree(ecoServiceDTO.isFree())
                .isDelivery(ecoServiceDTO.isDelivery())
                .photo(ecoServiceDTO.getPhoto())
                .country(ecoServiceDTO.getCountry())
                .city(ecoServiceDTO.getCity())
                .build();
    }

    @Override
    public List<EcoService> toEntity(List<EcoServiceAddDTO> d) {
        return d.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
