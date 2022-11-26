package eco_service.Eco.services;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.WasteDTO;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.response.Response;

import java.util.List;

public interface WasteService {

    Response<ErrorResponse, List<WasteDTO>> getAllWaste();

    Response<ErrorResponse, WasteDTO> getByWasteId(Long id);

    Response<ErrorResponse, WasteDTO> getByEcoServiceId(Long id);

    Response<ErrorResponse, WasteDTO> addWaste(WasteDTO wasteDTO);
}
