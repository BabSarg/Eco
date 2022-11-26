package eco_service.Eco.services;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.response.Response;

public interface RatingService {
    Response<ErrorResponse, RatingDTO> add(RatingDTO ratingDTO);
}
