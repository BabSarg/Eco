package eco_service.Eco.controllers;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.RatingDTO;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/goeco/rating/")
public class RatingController {

    private final RatingService ratingService;
    private static final Logger log = LoggerFactory.getLogger(EcoServiceController.class);

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Response<ErrorResponse, RatingDTO>> add(@Valid @RequestBody() RatingDTO ratingDTO) {
        Response<ErrorResponse, RatingDTO> add = ratingService.add(ratingDTO);
        return ResponseEntity.ok(add);
    }

}
