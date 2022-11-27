package eco_service.Eco.services.impl;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.WasteDTO;
import eco_service.Eco.exceptions.ConflictException;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.exceptions.RecordNotFoundException;
import eco_service.Eco.mappers.WasteMapper;
import eco_service.Eco.models.Waste;
import eco_service.Eco.repositories.WasteRepository;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.WasteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteServiceImpl implements WasteService {

    private final WasteRepository wasteRepository;

    private final WasteMapper wasteMapper;

    public WasteServiceImpl(WasteRepository wasteRepository, WasteMapper wasteMapper) {
        this.wasteRepository = wasteRepository;
        this.wasteMapper = wasteMapper;
    }

    @Override
    public Response<ErrorResponse, List<WasteDTO>> getAll() {
        List<Waste> waste = wasteRepository.findAll();
        return new Response<>(null, wasteMapper.toDTO(waste), WasteDTO.class.getName());
    }

    @Override
    public Response<ErrorResponse, WasteDTO> getById(Long id) {
        Waste waste = wasteRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Waste is not found with id : " + id));
        return new Response<>(null, wasteMapper.toDTO(waste), WasteDTO.class.getName());
    }

    @Override
    public Response<ErrorResponse, WasteDTO> getByEcoServiceId(Long id) {
        Waste waste = wasteRepository.findByEcoServiceId(id).orElseThrow(() -> new RecordNotFoundException("Waste is not found with id : " + id));
        return new Response<>(null, wasteMapper.toDTO(waste), WasteDTO.class.getName());
    }

    @Override
    public Response<ErrorResponse, WasteDTO> add(WasteDTO wasteDTO) {
        if (wasteRepository.existsById(wasteDTO.getId())) {
            throw new ConflictException(wasteDTO.getId() + "Id already exists");
        }
        Waste savedWaste=wasteRepository.save(wasteMapper.toEntity(wasteDTO));
        return new Response<>(null, wasteMapper.toDTO(savedWaste), WasteDTO.class.getSimpleName());

    }
}
