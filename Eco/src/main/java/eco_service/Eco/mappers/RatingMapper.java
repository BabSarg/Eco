package eco_service.Eco.mappers;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.models.EcoService;
import eco_service.Eco.models.Rating;
import eco_service.Eco.models.Waste;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RatingMapper implements BaseMapper<Rating, RatingDTO> {

    private final EcoServiceMapper ecoServiceMapper;

    public RatingMapper(EcoServiceMapper ecoServiceMapper) {
        this.ecoServiceMapper = ecoServiceMapper;
    }

    @Override
    public RatingDTO toDTO(Rating rating) {
        return RatingDTO.builder()
                .id(rating.getId())
                .rating(rating.getRating())
                .comment(rating.getComment())
                .ecoServiceId(rating.getEcoService().getId())
                .wasteId(rating.getWaste().getId())
                .build();
    }

    @Override
    public List<RatingDTO> toDTO(List<Rating> e) {

        return e.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Rating toEntity(RatingDTO ratingDTO) {
        return Rating.builder()
                .id(ratingDTO.getId())
                .rating(ratingDTO.getRating())
                .comment(ratingDTO.getComment())
                .ecoService(EcoService.builder().id(ratingDTO.getEcoServiceId()).build())
                .waste(Waste.builder().id(ratingDTO.getWasteId()).build())
                .build();
    }

    @Override
    public List<Rating> toEntity(List<RatingDTO> d) {

        return d.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
