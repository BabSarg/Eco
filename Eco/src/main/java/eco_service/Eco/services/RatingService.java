package eco_service.Eco.services;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.RatingByWasteIdDTO;
import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.dtos.RatingResponseDto;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingService {
    Response<ErrorResponse, RatingDTO> add(RatingDTO ratingDTO);

    Response<ErrorResponse, RatingResponseDto> getAllByEcoServiceId(Long ecoServiceId);
    Response<ErrorResponse, RatingResponseDto> getAllRatingsByWasteId(Long wasteId);

}
