package eco_service.Eco.services.impl;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.mappers.RatingMapper;
import eco_service.Eco.models.EcoService;
import eco_service.Eco.models.Rating;
import eco_service.Eco.repositories.RatingRepository;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.RatingService;
import org.springframework.stereotype.Service;

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


}
