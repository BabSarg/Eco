package eco_service.Eco.repositories;

import eco_service.Eco.models.EcoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EcoServiceRepository extends JpaRepository<EcoService, Long> {

    EcoService findByName(String name);

    boolean existsByEmail(String email);

    Optional<EcoService> findByEmail(String email);


}
