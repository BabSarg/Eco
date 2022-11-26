package eco_service.Eco.mappers;

import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.dtos.WasteDTO;
import eco_service.Eco.models.Rating;
import eco_service.Eco.models.Waste;

import java.util.List;
import java.util.stream.Collectors;

public class WasteMapper implements BaseMapper<Waste, WasteDTO> {
    @Override
    public WasteDTO toDTO(Waste waste) {

        return WasteDTO.builder()
                .id(waste.getId())
                .description(waste.getDescription())
                .type(waste.getType())
                .latitude(waste.isLatitude())
                .ecoService(waste.getEcoService())
                .wasteAddress(waste.getWasteAddress())
                .longitude(waste.getLongitude())
                .build();
    }

    @Override
    public List<WasteDTO> toDTO(List<Waste> e) {
        return e.stream().map(
                waste->
                        WasteDTO.builder()
                                .id(waste.getId())
                                .description(waste.getDescription())
                                .type(waste.getType())
                                .latitude(waste.isLatitude())
                                .ecoService(waste.getEcoService())
                                .wasteAddress(waste.getWasteAddress())
                                .longitude(waste.getLongitude())
                                .build()).collect(Collectors.toUnmodifiableList());

    }

    @Override
    public Waste toEntity(WasteDTO waste) {

        return Waste.builder()
                .id(waste.getId())
                .description(waste.getDescription())
                .type(waste.getType())
                .latitude(waste.isLatitude())
                .ecoService(waste.getEcoService())
                .wasteAddress(waste.getWasteAddress())
                .longitude(waste.getLongitude())
                .build();
    }

    @Override
    public List<Waste> toEntity(List<WasteDTO> d) {
        return d.stream().map(
                waste->
                        Waste.builder()
                                .id(waste.getId())
                                .description(waste.getDescription())
                                .type(waste.getType())
                                .latitude(waste.isLatitude())
                                .ecoService(waste.getEcoService())
                                .wasteAddress(waste.getWasteAddress())
                                .longitude(waste.getLongitude())
                                .build()).collect(Collectors.toUnmodifiableList());
    }
}
