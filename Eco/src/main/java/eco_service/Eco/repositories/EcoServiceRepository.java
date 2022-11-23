package eco_service.Eco.repositories;

import eco_service.Eco.models.EcoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoServiceRepository extends JpaRepository<EcoService,Long> {
}
