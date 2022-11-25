package eco_service.Eco.repositories;

import eco_service.Eco.models.EcoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcoServiceRepository extends JpaRepository<EcoService, Long> {

    List<EcoService> findAll();

    EcoService findByName(String name);

    boolean existsByEmail(String email);

    EcoService save(EcoService ecoService);
}
