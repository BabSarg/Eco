package eco_service.Eco.controllers;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.services.EcoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/goeco/ecoservice/")
public class EcoServiceController {

    @Autowired
    EcoServiceImpl ecoServiceImpl;
    private static final Logger log= LoggerFactory.getLogger(EcoServiceController.class);

    @GetMapping(value="/getAll")
    public List<EcoServiceDTO> getAllEcoServices(){
        return ecoServiceImpl.getAllEcoServices();
    }

    @PostMapping(value="/save")
    public EcoServiceDTO createEcoService(@Valid @RequestBody() EcoServiceDTO ecoServiceDTO){
        return ecoServiceImpl.saveOrUpdateEcoService(ecoServiceDTO);
    }

    @GetMapping(value="/getById/{id}")
    public EcoServiceDTO getByEcoserviceId(@PathVariable("id") Long ecoServiceId){
        return ecoServiceImpl.getEcoServiceById(ecoServiceId);
    }

    @DeleteMapping(value="/deleteById/{id}")
    public void deleteEcoServiceById(@PathVariable("id") Long ecoServiceId){
        ecoServiceImpl.deleteEcoServiceById(ecoServiceId);
    }
}
