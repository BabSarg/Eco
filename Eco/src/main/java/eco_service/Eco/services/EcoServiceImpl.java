package eco_service.Eco.services;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.mappers.EcoServiceMapper;
import eco_service.Eco.models.EcoService;
import eco_service.Eco.repositories.EcoServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcoServiceImpl {

    @Autowired
    EcoServiceRepository ecoServiceRepository;

    @Autowired
    EcoServiceMapper ecoServiceMapper;
    public List<EcoServiceDTO> getAllEcoServices() {
         final var ecoServices=ecoServiceRepository.findAll();
        return ecoServiceMapper.toDTO(ecoServices);
    }

    public EcoServiceDTO saveOrUpdateEcoService(EcoServiceDTO ecoServiceDTO) {
     ecoServiceRepository.save(ecoServiceMapper.toEntity(ecoServiceDTO));
     return ecoServiceDTO;
    }

    public EcoServiceDTO getEcoServiceById(Long ecoServiceId) {
        EcoService ecoService=ecoServiceRepository.getReferenceById(ecoServiceId);
        return ecoServiceMapper.toDTO(ecoService);
    }


    public void deleteEcoServiceById(Long ecoServiceId) {
        ecoServiceRepository.deleteById(ecoServiceId);
    }
}
