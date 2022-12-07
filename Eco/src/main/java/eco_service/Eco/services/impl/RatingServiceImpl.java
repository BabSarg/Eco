package eco_service.Eco.services.impl;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.RatingByWasteIdDTO;
import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.dtos.RatingResponseDto;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.mappers.RatingMapper;
import eco_service.Eco.models.Rating;
import eco_service.Eco.repositories.RatingRepository;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public RatingServiceImpl(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }


    @Override
    public Response<ErrorResponse, RatingDTO> add(RatingDTO ratingDTO) {
        Rating savedRating = ratingRepository.save(ratingMapper.toEntity(ratingDTO));
        return new Response<>(null, ratingMapper.toDTO(savedRating), RatingDTO.class.getSimpleName());
    }

    @Override
    public Response<ErrorResponse, RatingResponseDto> getAllByEcoServiceId(Long ecoServiceId) {
        List<Rating> ratings = ratingRepository.findByEcoService_Id(ecoServiceId);
        double sum = ratings.stream().map(Rating::getRating).reduce(Double::sum).orElse(0.0);
        RatingResponseDto ratingResponseDto = RatingResponseDto.builder()
                .ratingDTOList(ratingMapper.toDTO(ratings))
                .average(sum > 0 ? sum / (double) ratings.size() : 0.0)
                .build();
        return new Response<>(null,ratingResponseDto,RatingResponseDto.class.getSimpleName());
    }

    @Override
    public Response<ErrorResponse, RatingResponseDto> getAllRatingsByWasteId(Long wasteId) {
        List<Rating> ratings = ratingRepository.findByWaste_Id(wasteId);
        double sum = ratings.stream().map(Rating::getRating).reduce(Double::sum).orElse(0.0);
        RatingResponseDto ratingResponseDto = RatingResponseDto.builder()
                .ratingDTOList(ratingMapper.toDTO(ratings))
                .average(sum > 0 ? sum / (double) ratings.size() : 0.0)
                .build();
        return new Response<>(null,ratingResponseDto,RatingResponseDto.class.getSimpleName());
    }

}
