package eco_service.Eco.controllers;

import eco_service.Eco.dtos.ChangePasswordEcoServiceDto;
import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.EcoServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/goeco/ecoservice/")
public class EcoServiceController {

    private final EcoServiceService ecoServiceService;
    private static final Logger log = LoggerFactory.getLogger(EcoServiceController.class);

    public EcoServiceController(EcoServiceService ecoServiceService) {
        this.ecoServiceService = ecoServiceService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Response<ErrorResponse, List<EcoServiceDTO>>> getAll() {
        Response<ErrorResponse, List<EcoServiceDTO>> all = ecoServiceService.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("{id}")
    public ResponseEntity<Response<ErrorResponse, EcoServiceDTO>> update(@PathVariable Long id, @RequestBody EcoServiceDTO ecoServiceDTO) {
        Response<ErrorResponse, EcoServiceDTO> updateEcoService = ecoServiceService.update(id, ecoServiceDTO);
        return ResponseEntity.ok(updateEcoService);
    }

@PatchMapping("{id}")
public ResponseEntity<Response<ErrorResponse,EcoServiceDTO>> changePassword(@PathVariable Long id, @RequestBody ChangePasswordEcoServiceDto ecoServiceDto){
    Response<ErrorResponse, EcoServiceDTO> changedPassword = ecoServiceService.changePassword(id, ecoServiceDto);
    return ResponseEntity.ok(changedPassword);
}

    @PostMapping(value = "/save")
    public ResponseEntity<Response<ErrorResponse, EcoServiceDTO>> add(@Valid @RequestBody() EcoServiceDTO ecoServiceDTO) {
        Response<ErrorResponse, EcoServiceDTO> add = ecoServiceService.add(ecoServiceDTO);
        return ResponseEntity.ok(add);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Response<ErrorResponse, EcoServiceDTO>> getById(@PathVariable("id") Long id) {
        Response<ErrorResponse, EcoServiceDTO> byId = ecoServiceService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        ecoServiceService.delete(id);
        return ResponseEntity.ok().build();
    }

}

