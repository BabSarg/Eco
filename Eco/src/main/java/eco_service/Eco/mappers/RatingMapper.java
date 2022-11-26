package eco_service.Eco.mappers;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.models.EcoService;
import eco_service.Eco.models.Rating;

import java.util.List;

public class RatingMapper implements BaseMapper<Rating, RatingDTO> {
    @Override
    public RatingDTO toDTO(Rating rating) {
        return RatingDTO.builder()
                .id(rating.getId())
                .rating(rating.getRating())
                .comment(rating.getComment())
                .ecoService(rating.getEcoService())
                .build();
    }

    @Override
    public List<RatingDTO> toDTO(List<Rating> e) {
        return null;
    }

    @Override
    public Rating toEntity(RatingDTO ratingDTO) {
        return Rating.builder()
                .id(ratingDTO.getId())
                .rating(ratingDTO.getRating())
                .comment(ratingDTO.getComment())
                .ecoService(ratingDTO.getEcoService())
                .build();
    }

    @Override
    public List<Rating> toEntity(List<RatingDTO> d) {
        return null;
    }
}
