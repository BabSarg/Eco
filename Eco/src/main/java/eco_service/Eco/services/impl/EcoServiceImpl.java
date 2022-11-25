package eco_service.Eco.services.impl;

import eco_service.Eco.dtos.ChangePasswordEcoServiceDto;
import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.exceptions.ConflictException;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.exceptions.RecordNotFoundException;
import eco_service.Eco.mappers.EcoServiceMapper;
import eco_service.Eco.models.EcoService;
import eco_service.Eco.repositories.EcoServiceRepository;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.EcoServiceService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcoServiceImpl implements EcoServiceService {

    private final EcoServiceRepository ecoServiceRepository;
    private final EcoServiceMapper ecoServiceMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public EcoServiceImpl(EcoServiceRepository ecoServiceRepository, EcoServiceMapper ecoServiceMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.ecoServiceRepository = ecoServiceRepository;
        this.ecoServiceMapper = ecoServiceMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Response<ErrorResponse, List<EcoServiceDTO>> getAll() {
        List<EcoService> ecoServices = ecoServiceRepository.findAll();
        return new Response<>(null, ecoServiceMapper.toDTO(ecoServices), EcoServiceDTO.class.getName());
    }

    @Override
    public Response<ErrorResponse, EcoServiceDTO> getById(Long id) {
        EcoService ecoService = ecoServiceRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("EcoService is not found with id : " + id));
        return new Response<>(null, ecoServiceMapper.toDTO(ecoService), EcoServiceDTO.class.getName());
    }

    @Override
    public Response<ErrorResponse, EcoServiceDTO> add(EcoServiceDTO ecoServiceDTO) {
        if (ecoServiceRepository.existsByEmail(ecoServiceDTO.getEmail())) {
            throw new ConflictException(ecoServiceDTO.getEmail() + "Email already exists");
        }
        EcoService savedEcoService = ecoServiceRepository.save(ecoServiceMapper.toEntity(ecoServiceDTO));
        return new Response<>(null, ecoServiceMapper.toDTO(savedEcoService), EcoServiceDTO.class.getSimpleName());
    }

    @Override
    public Response<ErrorResponse, EcoServiceDTO> update(Long id, EcoServiceDTO ecoServiceDTO) {
        EcoService ecoService = ecoServiceRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("EcoService is not found with id:" + id));
        if (ecoServiceRepository.existsByEmail(ecoServiceDTO.getEmail()) && !(ecoService.getEmail().equals(ecoServiceDTO.getEmail()))) {
            throw new ConflictException("Email : " + ecoServiceDTO.getEmail() + " already exists");
        }
        EcoService updateEcoService = ecoServiceRepository.save(ecoServiceMapper.toEntity(ecoServiceDTO));
        return new Response<>(null, ecoServiceMapper.toDTO(updateEcoService), EcoServiceDTO.class.getSimpleName());
    }

    @Override
    public void delete(Long id) {
        ecoServiceRepository.deleteById(id);
    }

    @Override
    public Response<ErrorResponse, EcoServiceDTO> changePassword(Long id, ChangePasswordEcoServiceDto ecoServiceDto) {

        EcoService ecoService = ecoServiceRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("EcoService is not found with id: " + id));
        if (!ecoServiceDto.getNewPassword().equals(ecoServiceDto.getConfirmPassword())) {
            throw new ConflictException("password and confirm is different");
        }
        if (!bCryptPasswordEncoder.matches(ecoServiceDto.getOldPassword(), ecoService.getPassword())) {
            throw new ConflictException("old password is not correct");
        }

        ecoService.setPassword(bCryptPasswordEncoder.encode(ecoServiceDto.getNewPassword()));
        EcoService saveEcoService = ecoServiceRepository.save(ecoService);
        EcoServiceDTO savedEcoServiceDTO = ecoServiceMapper.toDTO(saveEcoService);

        return new Response<>(null,savedEcoServiceDTO,EcoServiceDTO.class.getSimpleName());
    }
}
