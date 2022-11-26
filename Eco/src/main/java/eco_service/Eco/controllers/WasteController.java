package eco_service.Eco.controllers;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.WasteDTO;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.WasteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/goeco/waste/")
public class WasteController {

    private final WasteService wasteService;
    private static final Logger log = LoggerFactory.getLogger(WasteController.class);

    public WasteController(WasteService wasteService) {
        this.wasteService = wasteService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Response<ErrorResponse, List<WasteDTO>>> getAllWaste() {
        Response<ErrorResponse, List<WasteDTO>> all = wasteService.getAllWaste();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/getByWasteId/{id}")
    public ResponseEntity<Response<ErrorResponse, WasteDTO>> getByWasteId(@PathVariable("id") Long id) {
        Response<ErrorResponse, WasteDTO> byId = wasteService.getByWasteId(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping(value = "/getByEcoServiceId/{id}")
    public ResponseEntity<Response<ErrorResponse, WasteDTO>> getByEcoServiceId(@PathVariable("id") Long id) {
        Response<ErrorResponse, WasteDTO> byId = wasteService.getByEcoServiceId(id);
        return ResponseEntity.ok(byId);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Response<ErrorResponse, WasteDTO>> add(@Valid @RequestBody() WasteDTO wasteDTO) {
        Response<ErrorResponse, WasteDTO> add = wasteService.addWaste(wasteDTO);
        return ResponseEntity.ok(add);
    }

}
